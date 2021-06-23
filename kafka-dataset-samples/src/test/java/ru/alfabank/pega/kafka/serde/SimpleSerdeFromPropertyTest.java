package ru.alfabank.pega.kafka.serde;

import com.pega.pegarules.pub.clipboard.ClipboardPage;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleSerdeFromPropertyTest {
    @Test
    public void testSampleKeysSerialization() {
        SimpleSerdeFromProperty simpleSerdeFromProperty = new SimpleSerdeFromProperty();

        Map<String, String> config = new HashMap<>();
        config.put("propertyName", "pyDescription");

        simpleSerdeFromProperty.configure(null, config);

        ClipboardPage clipboardPage = mock(ClipboardPage.class);
        when(clipboardPage.getString("pyDescription")).thenReturn("test");

        byte[] actual = simpleSerdeFromProperty.serialize(null, clipboardPage);
        assertEquals("test".getBytes(StandardCharsets.UTF_8), actual);
    }
}
