package pojos;

import java.io.Serializable;

/**
 * Created by Chemcee. M. C on 09-11-2016.
 */
public class Nurse implements Serializable{

    private int nurseId;
    private String userName;
    private String firstName;
    private String lastName;
    private String department;
    private String password;

    public static final String TABLE = "nurse";
    public static final String TAG = Nurse.class.getSimpleName();

    public Nurse() {
    }

    public Nurse(int nurseId, String userName, String firstName, String lastName, String department, String password) {
        this.nurseId = nurseId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {return userName; }

    public void setUserName(String userName) { this.userName = userName;    }
}
