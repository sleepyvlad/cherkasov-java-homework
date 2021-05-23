package part01.lesson03.task01;

import java.util.Comparator;

/*
    Класс домшнего животного с полями айди, кличка , владелец и вес
* */
public class Pet implements Comparable<Pet>{
    private int id;
    private String nickname;
    private Person owner;
    private int weight;

    public Pet(int id, String nickname, Person owner, int weight) {
        this.id = id;
        this.nickname = nickname;
        this.owner = owner;
        this.weight = weight;
    }

    // Метод изменения информации о животном
    public void changeInfo(String nickname, Person owner, int weight) {
        this.nickname = nickname;
        this.owner = owner;
        this.weight = weight;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getId() {
        return this.id;
    }

    public Person getOwner() {
        return this.owner;
    }

    public int getWeight() {
        return this.weight;
    }

    public int compareTo(Pet anotherPet) {
        if (this.owner.compareTo(anotherPet.getOwner()) == 0) {
            if (this.nickname.compareTo(anotherPet.nickname) == 0) {
                if (this.weight == anotherPet.getWeight()) {
                    return 0;
                } else if (this.weight < anotherPet.getWeight()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.nickname.compareTo(anotherPet.nickname) < 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.owner.compareTo(anotherPet.getOwner()) < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", owner=" + owner +
                ", weight=" + weight + "kg" +
                '}';
    }
}
