package com.example.rets_api.resource;

public class Enums {

    public enum RoomType {
        MAIN_FLOOR_BEDROOM,
        MASTER_BEDROOM,
        LIVING_ROOM,
        KITCHEN,
        MAIN_FLOOR_BATHROOM,
        DEN,
        OFFICE,
        GAME,
        LAUNDRY,
        DEFAULT_ENUM_VALUE
    }

    public enum LengthWidthUnit {
        FEET,
        METERS,
        ACRES,
        HECTARES,
        DEFAULT_ENUM_VALUE
    }

    public enum AreaUnit {
        SQ_FEET,
        SQ_METERS,
        ACRES,
        HECTARES,
        DEFAULT_ENUM_VALUE
    }

    public enum WeightUnit {
        LBS,
        KILO,
        DEFAULT_ENUM_VALUE
    }

    public enum AreaType {
        INTEGER,
        FLOAT,
        TEXT,
        DEFAULT_ENUM_VALUE
    }

    public enum Indicator {
        UNKNOWN,
        YES,
        NO,
        DEFAULT_ENUM_VALUE
    }

    public enum BathSize {
        FULL,
        HALF,
        THREE_QUARTER,
        DEFAULT_ENUM_VALUE
    }

    public enum NumberType {
        INTEGER,
        FLOAT,
        DEFAULT_ENUM_VALUE
    }

    public enum RentalPeriod {
        DAY,
        WEEK,
        MONTH,
        YEAR,
        DEFAULT_ENUM_VALUE
    }

    public enum Operator {
        GREATER_THEN,
        LESS_THEN,
        DEFAULT_ENUM_VALUE
    }
}
