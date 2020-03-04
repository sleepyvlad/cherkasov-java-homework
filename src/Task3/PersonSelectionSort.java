package Task3;
/*
    Класс сортировки вставками
* */
public class PersonSelectionSort {
    private static void swap(Person[] array, int ind1, int ind2) {
        Person tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    public void selectionSortPerson(Person[] array) throws CoincidenceException {
        //Время начала сортировки
        long start = System.nanoTime();
        //Сортировка по полу
        for(int i = 1; i < array.length; i++) {
            int minInd = i;
            for(int j = i; j < array.length; j++) {
                if (array[j].getSex().getSex().equals("MAN") && array[minInd].getSex().getSex().equals("WOMAN")) {
                    minInd = j;
                }
                swap(array, i, minInd);
            }
        }
        //Сортировка по возрасту
        for(int i = 1; i < array.length; i++) {
            int minInd = i;
            for(int j = i; j < array.length; j++) {
                if(array[i].getAge() > array[i-1].getAge() && array[i].getSex().getSex().equals(array[i-1].getSex().getSex())) {
                    minInd = j;
                }
                swap(array, i, minInd);
            }
        }
        //Сортировка по алфавиту
        for(int i = 1; i < array.length; i++) {
            int minInd = i;
            for(int j = i; j < array.length; j++) {
                try {
                    if (array[i].getName().compareTo(array[i-1].getName()) == 0 && array[i].getAge() >= array[i - 1].getAge() && array[i].getSex().getSex().equals(array[i - 1].getSex().getSex())) {
                        throw new CoincidenceException(array[i], "Совпадение имён");
                    }
                    if (array[i].getName().compareTo(array[i-1].getName()) < 0 && array[i].getAge() >= array[i - 1].getAge() && array[i].getSex().getSex().equals(array[i - 1].getSex().getSex())) {
                        minInd = j;
                    }
                } catch (CoincidenceException e) {
                    throw e;
                }
                swap(array, i, minInd);
            }
        }
        long end = System.nanoTime();
        System.out.println("Select sort, time: ");
        System.out.println(end - start);
        for(int i = 0; i < array.length; i++) {
            array[i].printInfo();
        }
    }
}
