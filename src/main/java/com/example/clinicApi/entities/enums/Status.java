package com.example.clinicApi.entities.enums;

public enum Status {
    SCHEDULED(1),
    COMPLETED(2),
    CANCELLED(3);

    private int code;

    private Status(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Status valueOf(int code){
        for (Status value : Status.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status code!");
    }
}
