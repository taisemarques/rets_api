package com.example.rets_api.entity;

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
        LAUNDRY
    }

    public enum LenghWidthUnit {
        FEET,
        METERS,
        ACRES,
        HECTARES
    }

    public enum AreaUnit {
        SQ_FEET,
        SQ_METERS,
        ACRES,
        HECTARES
    }

    public enum WeightUnit {
        LBS,
        KILO
    }

    public enum AreaType {
        INTEGER,
        FLOAT,
        TEXT
    }

    public enum Indicator {
        UNKNOWN,
        YES,
        NO
    }

    public enum BathSize {
        FULL,
        HALF,
        THREE_QUARTER
    }

    public enum NumberType {
        INTEGER,
        FLOAT
    }

    public enum RentalPeriod {
        DAY,
        WEEK,
        MONTH,
        YEAR
    }

    public enum Operator {
        GREATER_THEN,
        LESS_THEN
    }

}
