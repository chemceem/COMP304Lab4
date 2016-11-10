package pojos;

/**
 * Created by Chemcee. M. C on 09-11-2016.
 */
public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String department;

    public static final String TABLE = "doctor";
    public static final String TAG = Doctor.class.getSimpleName();

    public Doctor() {
    }

    public Doctor(int doctorId, String firstName, String lastName, String department) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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
