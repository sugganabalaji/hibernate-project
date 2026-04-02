package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public class Configurations {

    private String processor;
    @Column(name = "ram_size")
    private String ramSize;       // in GB
    @Column(name = "storage_size")
    private int storageSize;   // in GB
    private String os;
    @Column(name = "os_build")
    private String osBuild;
    @Column(name = "device_id")
    private String deviceId;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "system_type")
    private String systemType;
    @Column(name = "pen_and_touch")
    private String penAndTouch;
    private String version;
    @Column(name = "installed_on")
    private Date installedOn;
    @Column(name = "serial_number")
    private String serialNumber;
    private String experience;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsBuild() {
        return osBuild;
    }

    public void setOsBuild(String osBuild) {
        this.osBuild = osBuild;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {

        this.deviceId = deviceId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getPenAndTouch() {
        return penAndTouch;
    }

    public void setPenAndTouch(String penAndTouch) {
        this.penAndTouch = penAndTouch;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getInstalledOn() {
        return installedOn;
    }

    public void setInstalledOn(Date installedOn) {
        this.installedOn = installedOn;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Configurations{" +
                "processor='" + processor + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", storageSize=" + storageSize +
                ", os='" + os + '\'' +
                ", osBuild='" + osBuild + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", productId='" + productId + '\'' +
                ", systemType='" + systemType + '\'' +
                ", penAndTouch='" + penAndTouch + '\'' +
                ", version='" + version + '\'' +
                ", installedOn=" + installedOn +
                ", serialNumber='" + serialNumber + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
