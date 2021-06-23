package ru.alfabank.pega.kafka.serde;

import com.pega.pegarules.pub.clipboard.ClipboardPage;
import com.pega.pegarules.pub.runtime.PublicAPI;
import com.pega.platform.kafka.serde.PegaSerde;

import java.util.Map;

/**
 * Sample Kafka custom keys SerDe implementation
 * Takes value of the property and puts its value into Kafka message
 */
public class SimpleSerdeFromProperty implements PegaSerde {
    private String propertyName;

    @Override
    public void configure(PublicAPI tools, Map<String, ?> configs) {
        this.propertyName = configs.get("propertyName").toString();
    }

    @Override
    public byte[] serialize(PublicAPI tools, ClipboardPage clipboardPage) {
        String value = clipboardPage.getString(this.propertyName);
        return value.getBytes();
    }

    @Override
    public ClipboardPage deserialize(PublicAPI tools, byte[] data) {
        //deserialization is not needed
        return null;
    }
}
