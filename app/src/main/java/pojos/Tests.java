package pojos;

/**
 * Created by Chemcee. M. C on 10-11-2016.
 */
public class Tests {

    private int testId;
    private int patientId;
    private int BPL;
    private int BPH;
    private int temperature;

    public static final String TABLE = "tests";
    public static final String TAG = Tests.class.getSimpleName();

    public Tests(int testId, int patientId, int BPL, int BPH, int temperature) {
        this.testId = testId;
        this.patientId = patientId;
        this.BPL = BPL;
        this.BPH = BPH;
        this.temperature = temperature;
    }

    public Tests() {
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getBPL() {
        return BPL;
    }

    public void setBPL(int BPL) {
        this.BPL = BPL;
    }

    public int getBPH() {
        return BPH;
    }

    public void setBPH(int BPH) {
        this.BPH = BPH;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
