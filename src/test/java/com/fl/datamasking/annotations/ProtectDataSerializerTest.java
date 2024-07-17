package com.fl.datamasking.annotations;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;


public class ProtectDataSerializerTest {

    private ProtectDataSerializer protectDataSerializer;
    private JsonGenerator jsonGeneratorMock;
    private SerializerProvider serializerProviderMock;
    private JsonStreamContext jsonStreamContextMock;

    @Before
    public void setUp() {
        protectDataSerializer = new ProtectDataSerializer();

        jsonGeneratorMock = mock(JsonGenerator.class);
        serializerProviderMock = mock(SerializerProvider.class);
        jsonStreamContextMock = mock(JsonStreamContext.class);
        when(jsonGeneratorMock.getOutputContext()).thenReturn(jsonStreamContextMock);
    }

    @Test
    public void testSerializePassword() throws IOException {
        when(jsonStreamContextMock.getCurrentName()).thenReturn("password");

        String input = "my!Password12345";
        protectDataSerializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString("*".repeat(input.length()));
    }

    @Test
    public void testSerializeCardNumber() throws IOException {
        when(jsonStreamContextMock.getCurrentName()).thenReturn("cardNumber");

        String input = "1234-5678-9012-3456";
        protectDataSerializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString("1234-5678-****-****");
    }

    @Test
    public void testSerializeOtherField() throws IOException {
        when(jsonStreamContextMock.getCurrentName()).thenReturn("otherField");

        String input = "11222333444555";
        protectDataSerializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString("************55");
    }
}