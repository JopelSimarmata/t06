package academic.model;

/**
 * @author 12S22044 Jufourlisa Sirait
 */

public class Course {

    private String code;
    private String matkul;
    private int credit;
    private String passingGrade;
    private String initial;

    public Course(String code, String matkul, int credit, String passingGrade, String initial) {
        this.code = code;
        this.matkul = matkul;
        this.credit = credit;
        this.passingGrade = passingGrade;
        this.initial = initial;
    }

    public String getcode() {
        return this.code;
    }
    
    public String getmatkul() {
        return this.matkul;
    }

    public int getCredit() {
        return this.credit;
    }   

    public String getPassingGrade() {
        return this.passingGrade;
    }

    public String getInitial() {
        return this.initial;
    }

    public void setNim(String code) {
        this.code = code;
    }

    public void setCourse(String matkul) {
        this.matkul = matkul;
    }
    
    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setPassingGrade(String passingGrade) {
        this.passingGrade = passingGrade;
    }   

    public void setInitial(String initial) {
        this.initial = initial;
    }

}