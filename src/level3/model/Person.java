package level3.model;

public class Person {
    private String idNumber;
    private String name;
    private String surnames;

    public Person(String idNumber, String name, String lastName) {
        this.idNumber = idNumber;
        this.name = name;
        this.surnames = lastName;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getSurnames() {
        return this.surnames;
    }

    @Override
    public String toString() {
        return this.idNumber + " " + this.name + " " + this.surnames;
    }

}
