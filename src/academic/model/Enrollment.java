package academic.model;

/**
 * @author 12S23036 Jopel Simarmata
 * @author 12S23024 Eska Silaen
 */
public class Enrollment {
    String Nim;
    String CodeCourse;
    String TahunAjaran;
    String Semester;
    String grade = "None";
    String gradeBefore = "";
    Boolean cek_s = false;
    Boolean cek_c = false;
    Double Ip = 0.0;
    int remedialCount = 0;


    Student student;
    Course course;

    public Enrollment(String CodeCourse, String Nim, String TahunAjaran, String Semester){
        this.Nim = Nim;
        this.CodeCourse = CodeCourse;
        this.TahunAjaran = TahunAjaran;
        this.Semester = Semester;
    }

    public int getRemedialCount() {
        return remedialCount;
    }

    public void incrementRemedial() {
        remedialCount++;
    }

    public void setGradeBefore(String gradeBefore){
        this.gradeBefore = gradeBefore;
    }

    public String getGradeBefore(){
        return this.gradeBefore;
    }

    public String getNim(){
        return this.Nim;
    }

    public String getCodeCourse(){
        return this.CodeCourse;
    }

    public String getTahunAjaran(){
        return this.TahunAjaran;
    }

    public String getSemester(){
        return this.Semester;
    }

    public void setStudent(Student student){
        this.student = student;
    }
    

    public void setValidCourse(Boolean cek){
        this.cek_c = cek;
    }

    public void setValidStudent(Boolean cek){
        this.cek_s = cek;
    }

    public Boolean getValidCourse(){
        return this.cek_c;
    }

    public Boolean getValidStudent(){
        return this.cek_s;
    }

    public void DisplayEnrollment(){
        if (this.remedialCount == 0){
            System.out.println(this.CodeCourse+"|"+this.Nim + "|" + this.TahunAjaran + "|" + this.Semester + "|" + this.grade );
        } else {
            System.out.println(this.CodeCourse+"|"+this.Nim + "|" + this.TahunAjaran + "|" + this.Semester + "|" + this.grade + "("+ this.gradeBefore +")" );

        }
    }

    public void setStudents(Student student){
        this.student = student;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public String getGrade(){
        return this.grade;
    }

    
    public Double getIP(){
        return this.Ip;
    }


    public Double ConvertGPA(String grade){    
        switch(grade.toUpperCase()){
            case "A": return 4.0;
            case "AB": return 3.5;
            case "B": return 3.0;
            case "BC": return 2.5;
            case "C": return 2.0;
            case "D": return 1.0;
            default: return 0.0;
        } 
    }

    public void setIP(Double Ip){
        this.Ip = Ip;
    }










    // class definition

}