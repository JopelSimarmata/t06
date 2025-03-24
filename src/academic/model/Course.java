package academic.model;

import java.util.ArrayList;

/**
 * @author 12S23036 Jopel Simarmata
 * @author 12S23024 Eska Silaen
 */
public class Course {
    String codeCourse;
    String namaMK;
    String sks;
    String grade;
    String dosen;
    
    ArrayList<Lecturer> daftarlecturer;

    public Course(String codeCourse, String namaMK, String sks, String grade ){
        this.codeCourse = codeCourse;
        this.namaMK = namaMK;
        this.sks = sks;
        this.grade = grade;
        this.daftarlecturer = new ArrayList<>();
        
    }

    public String getNamaMK(){
        return this.namaMK;
    }

    public String getCodeCourse(){
        return this.codeCourse;
    }

    public String getSks(){
        return this.sks;
    }

    public String getGrade(){
        return this.grade;
    }


    public void tambahDosen(Lecturer lecturer){
        this.daftarlecturer.add(lecturer);
    }
    
    public void DisplayCourse(){
        System.out.printf(this.codeCourse+"|"+this.namaMK + "|" + this.sks + "|" + this.grade + "|" );
        for (int i = 0; i < this.daftarlecturer.size(); i++){
            System.out.printf(this.daftarlecturer.get(i).getIntial() + " " + "(" + this.daftarlecturer.get(i).getEmail() + ")");
            if(i != this.daftarlecturer.size()-1){
                System.out.printf(";");
            }
        }
        System.out.printf("\n");
    }













    // class definition

}