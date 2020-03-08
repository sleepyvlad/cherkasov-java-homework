package part01.lesson01.task03;

import java.util.Random;
import java.util.Scanner;

public class Task3 {
    // Генератор рандомных "имён"
    public static String randomString(int maxSize) {
        Random random = new Random();
            char[] word = new char[random.nextInt(maxSize) + 1];
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
        return new String(word);
    }
    // Генератор рандомного массива Person
    public static Person[] generatePersonArray(int n) throws UnknownSexException {
        Random rand = new Random();
        Person[] randomGeneratedPersonArray = new Person[n];
        for(int i = 0; i < n; i++){
            int randomAge = rand.nextInt(100);
            Sex randomSex = new Sex(rand.nextBoolean()? "MAN" : "WOMAN");;
            String randomName = randomString(12);
            randomGeneratedPersonArray[i] = new Person(randomAge, randomSex, randomName);
        }
        return randomGeneratedPersonArray;
    }
    public static void main(String[] args) throws UnknownSexException, CoincidenceException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n count of Persons");
        int n = scanner.nextInt();
        Person[] arr = generatePersonArray(n);
        PersonBubbleSort bubbleSorter = new PersonBubbleSort();
        bubbleSorter.bubbleSortPerson(arr);
        PersonSelectionSort selectionSorter = new PersonSelectionSort();
        selectionSorter.selectionSortPerson(arr);
    }
}
