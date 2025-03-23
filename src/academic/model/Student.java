package academic.model;

/**
 * @author 12S22044 Jufourlisa Sirait
 */

 public class Student extends Person {
    private String nim;
    private int year;

    public Student(String nim, String name, int year, String prodi) {
        super(name, prodi); // Email not used for students
        this.nim = nim;
        this.year = year;
    }

    public String getNim() {
        return this.nim;
    }

    public String getName() {
        return super.getName();
    }

    public int getYear() {
        return this.year;
    }


    public void setNim(String _nim) {
        this.nim = _nim;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setYear(int year) {
        this.year = year;
    }


 }