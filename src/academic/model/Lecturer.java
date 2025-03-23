package academic.model;

/**
 * @author 12S22044 Jufourlisa Sirait
 */

 public class Lecturer extends Person {
    private String nidn;
    private String initial;
    private String email;

    public Lecturer(String nidn, String name, String initial, String email, String prodi) {
        super(name, prodi);
        this.nidn = nidn;
        this.initial = initial;
        this.email = email;

    }

    public String getNidn() {
        return this.nidn;
    }

    public String getName() {
        return super.getName();
    }

    public String getInitial() {
        return this.initial;
    }

    public String getEmail() {
        return this.email;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}