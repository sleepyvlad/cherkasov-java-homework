package Task3;

public class CoincidenceException extends Exception {
    private String name;
    private int age;

    public CoincidenceException(Person person, String message) {
        super(message);
        this.name = person.getName();
        this.age = person.getAge();
    }
}
