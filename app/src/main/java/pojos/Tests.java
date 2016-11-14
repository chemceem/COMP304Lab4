package pojos;

/**
 * Created by Chemcee. M. C on 10-11-2016.
 */
public class Tests {

    private int testId;
    private int patientId;
    private float BPL;
    private float BPH;
    private float temperature;

    public static final String TABLE = "tests";
    public static final String TAG = Tests.class.getSimpleName();

    public Tests(int testId, int patientId, float BPL, float BPH, float temperature) {
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

    public float getBPL() {
        return BPL;
    }

    public void setBPL(float BPL) {
        this.BPL = BPL;
    }

    public float getBPH() {
        return BPH;
    }

    public void setBPH(float BPH) {
        this.BPH = BPH;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
