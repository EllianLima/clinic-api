package com.example.clinicApi.entities;

import com.example.clinicApi.entities.enums.PaymentType;
import com.example.clinicApi.entities.enums.Status;

import java.io.Serializable;
import java.util.Objects;

public class Appointment implements Serializable {
    private static final long serialversionUID = 1L;

    private Long id;
    private Doctor doctor;
    private Patient patient;

    private Status status;
    private PaymentType paymentType;

    public Appointment(){}

    public Appointment(Long id, Doctor doctor, Patient patient, Status status, PaymentType paymentType) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        setStatus(status);
        setPaymentType(paymentType);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
