package com.angelalfaro.kinalapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clients")
public class Client {

    @Column(name="dpi_client")
    @Id
    private String DPIClient;
    @Column
    private String nameClient;
    @Column
    private String lastNameClient;
    @Column
    private String direction;
    @Column
    private int state;

    public Client() {
    }

    public Client(String DPIClient, String nameClient, String lastNameClient, String direction, int state) {
        this.DPIClient = DPIClient;
        this.nameClient = nameClient;
        this.lastNameClient = lastNameClient;
        this.direction = direction;
        this.state = state;
    }

    public String getDPIClient() {
        return DPIClient;
    }

    public void setDPIClient(String DPIClient) {
        this.DPIClient = DPIClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
