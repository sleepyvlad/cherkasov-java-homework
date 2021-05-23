package part01.lesson03.task01;
/*
    Класс человека с полями age - вораст, sex - пол, name - имя
* */
public class Person {
    private int age;
    private Sex sex;
    private String name;

    public Person() throws UnknownSexException{
        this.age = 0;
        this.sex.setSex("MAN");
        this.name = "Noname";
    }

    public Person( int age, Sex sex, String name){
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void printInfo() {
        String info = "age: " + this.age + ", sex: " + this.sex.getSex() + ", name: " + this.name;
        System.out.println(info);
    }

    public int compareTo(Person anotherPerson) {
        if (this.sex.compareTo(anotherPerson.getSex()) == 0) {
            if (this.age == anotherPerson.getAge()) {
                if (this.name.compareTo(anotherPerson.getName()) == 0) {
                    return 0;
                } else if (this.name.compareTo(anotherPerson.getName()) < 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if(this.age < anotherPerson.getAge()) {
                return -1;
            } else {
                return 1;
            }

        } else if (this.sex.compareTo(anotherPerson.getSex()) < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }
}
