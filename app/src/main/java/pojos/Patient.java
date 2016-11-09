package pojos;

import android.content.Intent;

/**
 * Created by a_b on 09-11-2016.
 */
public class Patient {

    private String fname;
    private String lname;
    private String department;
    private int doctoId;
    private int roomNo;
    private int temperature;
    private int bplValue;
    private int bphValue;

    public Patient(){}

    public Patient(String fname, String lname, String department, int doctoId, int roomNo, int temperature, int bplValue, int bphValue) {
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.doctoId = doctoId;
        this.roomNo = roomNo;
        this.temperature = temperature;
        this.bplValue = bplValue;
        this.bphValue = bphValue;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDoctoId() {
        return doctoId;
    }

    public void setDoctoId(int doctoId) {
        this.doctoId = doctoId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getBplValue() {
        return bplValue;
    }

    public void setBplValue(int bplValue) {
        this.bplValue = bplValue;
    }

    public int getBphValue() {
        return bphValue;
    }

    public void setBphValue(int bphValue) {
        this.bphValue = bphValue;
    }
}
