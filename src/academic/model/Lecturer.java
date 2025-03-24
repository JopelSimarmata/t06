package academic.model;

public class Lecturer extends Person{
    String nidn;
    String intial;
    String email;
    String mk;

    public Lecturer(String nidn, String nama, String intial, String email, String mk){
        super(nama);
        this.nidn = nidn;
        this.intial = intial;
        this.email = email;
        this.mk = mk;
    }

    public String getEmail() {
        return email;
    }

    public String getIntial() {
        return intial;
    }

    public String getMk() {
        return mk;
    }

    public String getNama() {
        return name;
    }

    public String getNidn() {
        return nidn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIntial(String intial) {
        this.intial = intial;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }


    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    @Override
    public String toString(){
        return this.nidn + "|" + this.name + "|" + this.intial + "|" + this.email + "|" + this.mk;
    }

    public void DisplayLecturer(){
        System.out.println(this.nidn + "|" + this.name + "|" + this.intial + "|" + this.email + "|" + this.mk);
    }
}