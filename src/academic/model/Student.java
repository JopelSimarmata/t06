package academic.model;
import java.util.ArrayList;
import java.util.Locale;
/**
 * @author 12S23036 Jopel Simarmata
 * @author 12S23024 Eska Silaen
 */
public class Student extends Person{
    String nim;
    String angkatan;
    String prodi;
    Double ip = 0.0;
    Integer jumlah_sks = 0;
    Boolean cek = false;

    ArrayList <Enrollment> daftarEnrollment;
    ArrayList <Course> daftarCourse;


    public Student(String nim, String nama, String angkatan, String prodi){
        super(nama);
        this.nim = nim;
        this.angkatan = angkatan;
        this.prodi = prodi;
        this.daftarEnrollment = new ArrayList<>();
        this.daftarCourse = new ArrayList<>();
        
    }



    public String getNim(){
        return this.nim;
    }

    public String getAngkatan(){
        return this.angkatan;
    }

    public String getProdi(){
        return this.prodi;
    }

    public void setEnrollment(Enrollment enrollment){
        for(int i = 0; i < daftarEnrollment.size(); i++){
            if(daftarEnrollment.get(i).getCodeCourse().equals(enrollment.getCodeCourse())){
                this.daftarEnrollment.set(i,enrollment);
                return;
            }
        }
        this.daftarEnrollment.add(enrollment);

    }

    public void tambahCourse(Course course){
        for( int i = 0; i < daftarCourse.size(); i++){
            if(daftarCourse.get(i).getCodeCourse().equals(course.getCodeCourse())){
                this.daftarCourse.set(i,course);
                return;
            }
        }
        this.daftarCourse.add(course);
    }

    public ArrayList<Course> getDaftarCourse(){
        return this.daftarCourse;
    }



    public void DisplayStudent(){
        System.out.println(this.nim+"|"+this.name + "|" + this.angkatan + "|" + this.prodi);
    }

    public void DetailDisplay(){ 
        System.out.print(this.nim+"|"+this.name + "|" + this.angkatan + "|" + this.prodi );

        this.jumlah_sks =  getSks();
        System.out.printf(Locale.US,"|%.2f|", getIP());
        for(int i = 0; i < this.daftarEnrollment.size(); i++){
            if(this.daftarEnrollment.get(i).getGrade().equals("None")){
                System.out.println("0");
                break;
            } else {
                System.out.println(this.jumlah_sks);
                break;
                
            }
        }

    }

    //cek apakah ada course yang sama
    public Boolean cekCourse(String codeCourse){
        for(int i = 0; i < this.daftarCourse.size(); i++){
            if(this.daftarCourse.get(i).getCodeCourse().equals(codeCourse)){
                return true;
            }
        }
        return false;
    }

    public Double getIP(){
        this.ip = 0.0;
        for(int i = 0 ; i < daftarEnrollment.size(); i++){
            for(int j = 0; j < daftarCourse.size(); j++){
                if(daftarEnrollment.get(i).getCodeCourse().equals(daftarCourse.get(j).getCodeCourse())){
                    this.ip = this.ip + (Double.parseDouble(daftarCourse.get(j).getSks()) * daftarEnrollment.get(i).getIP());
                }
            }
        }
        return (this.jumlah_sks > 0) ? this.ip / this.jumlah_sks : 0.0;

    }



    public Integer getSks(){
        Integer jumlah_sks = 0;
        for( int i = 0 ; i < this.daftarCourse.size(); i++){
            jumlah_sks = jumlah_sks + Integer.parseInt(daftarCourse.get(i).getSks());
        }
        return jumlah_sks;
    }
    






}

