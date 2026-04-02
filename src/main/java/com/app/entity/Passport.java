package com.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passportId;

    @Column(name = "passport_number", length = 10, nullable = false)
    private String passportNumber;

    public int getPassportId() {
        return passportId;
    }
    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }
    public String getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" + "passportId=" + passportId + ", passportNumber=" + passportNumber + '}';
    }

}
