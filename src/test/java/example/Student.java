package example;

public class Student {
    private int sId;
    private String sName;
    private Double gpa;

    public Student(int sId, String sName, Double gpa) {
        this.sId = sId;
        this.sName = sName;
        this.gpa = gpa;
    }
    public Student( String sName, Double gpa) {
        this.sId = sId;
        this.sName = sName;
        this.gpa = gpa;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
