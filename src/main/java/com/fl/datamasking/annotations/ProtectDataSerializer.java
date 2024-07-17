package com.fl.datamasking.annotations;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.regex.Pattern;

public class ProtectDataSerializer extends JsonSerializer<Object> {

    private final String CARD_NUMBER_REGEX = "(\\d{4})-(\\d{4})-(\\d{4})-(\\d{4})";
    private final String ALL_CHARACTERS_REGEX = ".";
    private final String ALL_CHARACTERS_EXCEPT_LAST_TWO_REGEX = "\\w(?=\\w{2})";

    @Override
    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String maskedValue;

        if (isPassword(jsonGenerator)) {
            maskedValue = maskAllCharacters(value.toString());
            jsonGenerator.writeString(maskedValue);
            return;
        }

        if (isCardNumberPattern(value)) {
            maskedValue = maskCardNumber(value.toString());
            jsonGenerator.writeString(maskedValue);
            return;
        }

        maskedValue = maskAllCharactersExceptLastTwo(value.toString());
        jsonGenerator.writeString(maskedValue);
    }

    private boolean isCardNumberPattern(Object value) {
        return Pattern.compile(CARD_NUMBER_REGEX).matcher(value.toString()).matches();
    }

    private boolean isPassword(JsonGenerator jsonGenerator) {
        return "password".equals(jsonGenerator.getOutputContext().getCurrentName());
    }

    private String maskAllCharacters(String input) {
        return input.replaceAll(ALL_CHARACTERS_REGEX, "*");
    }

    private String maskCardNumber(String input) {
        return input.replaceAll(CARD_NUMBER_REGEX, "$1-$2-****-****");
    }

    private String maskAllCharactersExceptLastTwo(String input) {
        return input.replaceAll(ALL_CHARACTERS_EXCEPT_LAST_TWO_REGEX, "*");
    }
}