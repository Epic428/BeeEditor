package com.teamresourceful.editorbackend.lib.enums;

public enum LightLevel {
    DAY,
    NIGHT,
    ANY;

    //TODO determine if the converter is necessary for our use.
    /*@javax.persistence.Converter(autoApply = true)
    public static class Converter implements AttributeConverter<LightLevel, String> {

        @Override
        public String convertToDatabaseColumn(LightLevel attribute) {
            return attribute == null ? null : attribute.toString(); //return ANY instead of null??
        }

        @Override
        public LightLevel convertToEntityAttribute(String dbData) {
            return dbData == null ? null : LightLevel.valueOf(dbData);
        }
    }*/
}
