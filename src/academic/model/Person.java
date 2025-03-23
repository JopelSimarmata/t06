package academic.model;

public class Person {
    private String name;
    private String prodi;

    public Person(String name, String prodi) {
        this.name = name;
        this.prodi = prodi;
    }

    public String getName() {
        return this.name;
    }

    public String getProdi() {
        return this.prodi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    
}
