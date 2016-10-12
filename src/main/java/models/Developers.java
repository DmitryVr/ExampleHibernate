package models;

/**
 * Created by root on 07.10.16.
 */
public class Developers {
    private int id;
    private String name;
    private String specialty;
    private int salary;

    public Developers() {
    }

    public Developers(int id, String name, String specialty, int salary) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developers that = (Developers) o;

        if (id != that.id) return false;
        if (salary != that.salary) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (specialty != null ? !specialty.equals(that.specialty) : that.specialty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", salary=" + salary +
                '}';
    }
}
