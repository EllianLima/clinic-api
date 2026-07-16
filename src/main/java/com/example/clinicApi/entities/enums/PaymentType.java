package com.example.clinicApi.entities.enums;

public enum PaymentType {
    PRIVATE(1),
    INSURANCE(2);

    private int code;

    private PaymentType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public PaymentType valueOf(int code){
        for(PaymentType value: PaymentType.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid PaymentType Code!");
    }
}
