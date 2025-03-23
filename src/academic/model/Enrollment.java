package academic.model;

/**
 * @author 12S22044 Jufourlisa Sirait
 */

public class Enrollment {

    private String id;
    private String _nim;
    private String thauncourse;    
    private String semester;
    private String grade;

    public Enrollment(String id, String _nim, String thauncourse, String semester, String grade) {
        this.id = id;
        this._nim = _nim;
        this.thauncourse = thauncourse;
        this.semester = semester;
        this.grade = grade;
        
    }

    public String getId() {
        return this.id;
    }
    

    public String get_nim() {
        return this._nim;
    }

    public String getThauncourse() {
        return this.thauncourse;
    }

    public String getSemester() {
        return this.semester;
    }

    public String getGrade() {
        return this.grade;
    }
    

    public void setId(String id) {
        this.id = id;
    }

    public void set_nim(String _nim) {
        this._nim = _nim;
    }

    public void setThauncourse(String thauncourse) {
        this.thauncourse = thauncourse;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


}