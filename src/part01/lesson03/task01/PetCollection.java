package part01.lesson03.task01;

import java.util.*;
/*
 Класс картотеки животных
* */
public class PetCollection {
    private TreeSet<Pet> petCollection = new TreeSet<Pet>();

    // Конструктор по умолч.
    public PetCollection() {
        this.petCollection = new TreeSet<Pet>();
    }

    // Сортировка по айди для эффективной выборки животного для изменения информации о нём по айди
    private void sortPetsById() {
        List<Pet> list = new ArrayList<>();
        Collections.sort(list, (o1, o2) -> {
             if(o1.getId() == o2.getId()) {
                 return 0;
             } else if (o1.getId() < o2.getId()) {
                 return -1;
             } else {
                 return 1;
             }
        });
    }

    // Конструктор
    public PetCollection(Pet[] pets) {
        for(int i = 0; i < pets.length; i++) {
            this.petCollection.add(pets[i]);
        }
    }

    // Добавление животного в коллекцию
    public void addPetToCollection(Pet pet) throws PetAlreadyInCollectionException{
        try {
            if(this.petCollection.contains(pet)) {
                throw new PetAlreadyInCollectionException(pet, "Животное уже в коллекции");
            } else {
                this.petCollection.add(pet);
            }
        } catch (PetAlreadyInCollectionException e) {
            throw e;
        }
    }

    // Двоичный поиск животного по кличке
    public Pet findPetInCollection(String nicknameToSearch) throws NoPetInCollectionException {
        int firstIndex = 0;
        int lastIndex = this.petCollection.size() - 1;
        Pet[] petArray = this.petCollection.toArray(new Pet[this.petCollection.size()]);

        // условие прекращения (элемент не представлен)
        try {
            while (firstIndex <= lastIndex) {
                int middleIndex = (firstIndex + lastIndex) / 2;

                if (petArray[middleIndex].getNickname().equals(nicknameToSearch)) {
                    return petArray[middleIndex];
                } else if (petArray[middleIndex].getNickname().compareTo(nicknameToSearch) < 0)
                    firstIndex = middleIndex + 1;

                else if (petArray[middleIndex].getNickname().compareTo(nicknameToSearch) > 0)
                    lastIndex = middleIndex - 1;

            }

            throw new NoPetInCollectionException(nicknameToSearch, "Такого животного нет в коллекции");
        } catch (NoPetInCollectionException e) {
            throw e;
        }

    }

    // Изменение инфы о животном по айди
    public void changePetInfo(int idToChange, String newName, Person newOwner, int newWeight) throws NoPetInCollectionException {
        sortPetsById();
        int firstIndex = 0;
        int lastIndex = this.petCollection.size() - 1;
        boolean shouldThrowException = true;
        Pet[] petArray = this.petCollection.toArray(new Pet[this.petCollection.size()]);

        // условие прекращения (элемент не представлен)
        try {
            while (firstIndex <= lastIndex) {
                int middleIndex = (firstIndex + lastIndex) / 2;

                if (petArray[middleIndex].getId() == idToChange) {
                    petArray[middleIndex].changeInfo(newName, newOwner, newWeight);
                    shouldThrowException = false;
                    break;
                } else if (petArray[middleIndex].getId() < idToChange)
                    firstIndex = middleIndex + 1;

                else if (petArray[middleIndex].getId() > idToChange)
                    lastIndex = middleIndex - 1;

            }

            if(shouldThrowException) {
                throw new NoPetInCollectionException(idToChange, "Такого животного нет в коллекции");
            }
        } catch (NoPetInCollectionException e) {
            throw e;
        }
    }

    // Вывод отсортированной коллекции
    public void printCollection() {
        ArrayList<Pet> reversed = new ArrayList<>();
        Iterator<Pet> i = petCollection.iterator();
        while (i.hasNext()) {
            reversed.add(i.next());
        }

        // Переворачиваем коллекцию
        Collections.reverse(reversed);
        Iterator<Pet> petIterator = reversed.iterator();
        while (petIterator.hasNext()) {
            System.out.println(petIterator.next());;
        }
    }

}

// Исключение при добавлении уже существуещего животного в коллекцию
class PetAlreadyInCollectionException extends Exception {
    private Pet pet;
    private String message;

    public Pet getPet() {
        return this.pet;
    }

    public PetAlreadyInCollectionException(Pet pet, String message) {
        super(message);
        this.pet = pet;
    }
}

// Исключение при попытке выбора несуществуещего животного из коллекции
class NoPetInCollectionException extends Exception {
    private String nickname;
    private int id;
    private String message;

    public String getNickname() {
        return this.nickname;
    }

    public NoPetInCollectionException(String nickname, String message) {
        super(message);
        this.nickname = nickname;
    }

    public NoPetInCollectionException(int id, String message) {
        super(message);
        this.id = id;
    }
}