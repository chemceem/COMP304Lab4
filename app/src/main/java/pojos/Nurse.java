package pojos;

/**
 * Created by Chemcee. M. C on 09-11-2016.
 */
public class Nurse {

    private int nurseId;
    private String firstName;
    private String lastName;
    private String department;

    public Nurse() {
    }

    public Nurse(int nurseId, String firstName, String lastName, String department) {
        this.nurseId = nurseId;
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
}
