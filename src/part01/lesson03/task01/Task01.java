package part01.lesson03.task01;

public class Task01 {
    public static void main(String[] args) throws UnknownSexException, PetAlreadyInCollectionException, NoPetInCollectionException {
        Person[] a = new Person[] {
                new Person(22, new Sex("WOMAN"), "Nastya"),
                new Person(21, new Sex("MAN"), "Vlad"),
                new Person(21, new Sex("MAN"), "Sasha"),
                new Person(33, new Sex("WOMAN"), "Lena"),
        };

        Pet[] b = new Pet[] {
                new Pet(1, "Dusya", a[0], 5),
                new Pet(2, "Ulyana", a[0], 8),
                new Pet(3, "Bulka", a[1], 3),
                new Pet(4, "Tisha", a[2], 6),
                new Pet(5, "Mursya", a[2], 6),
        };

        PetCollection c = new PetCollection(b);
        c.addPetToCollection(new Pet(22, "Rodion", a[3], 60));
        c.changePetInfo(2, "NewUlyana", a[0], 10);
        System.out.println("Find by nickname:" + c.findPetInCollection("Rodion") + "\n");
        c.printCollection();


    }
}
