package Task3;

/*
    Касс сортировки методом пузырька
* */
public class PersonBubbleSort {
    private static void swap(Person[] array, int ind1, int ind2) {
        Person tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    public void bubbleSortPerson(Person[] array) throws CoincidenceException {
        //Время начала сортировки
        long start = System.nanoTime();
        //Сортировка по полу
        boolean shouldSort = true;
        while(shouldSort){
            shouldSort = false;
            for(int i = 1; i < array.length; i++){
                if(array[i].getSex().getSex().equals("MAN") && array[i-1].getSex().getSex().equals("WOMAN")){
                    swap(array, i, i-1);
                    shouldSort = true;
                }
            }
        }
        //Сортировка по возрасту
        shouldSort = true;
        while(shouldSort) {
            shouldSort = false;
            for(int i = 1; i < array.length; i++){
                if(array[i].getAge() > array[i-1].getAge() && array[i].getSex().getSex().equals(array[i-1].getSex().getSex())){
                    swap(array, i, i-1);
                    shouldSort = true;
                }
            }
        }
        //Сортировка по алфавиту
        shouldSort = true;
        while(shouldSort) {
            shouldSort = false;
            for(int i = 1; i < array.length; i++){
                try {
                    if (array[i].getName().compareTo(array[i-1].getName()) == 0 && array[i].getAge() >= array[i - 1].getAge() && array[i].getSex().getSex().equals(array[i - 1].getSex().getSex())) {
                        throw new CoincidenceException(array[i], "Совпадение имён");
                    }
                    if (array[i].getName().compareTo(array[i-1].getName()) < 0 && array[i].getAge() >= array[i - 1].getAge() && array[i].getSex().getSex().equals(array[i - 1].getSex().getSex())) {
                        swap(array, i, i - 1);
                        shouldSort = true;
                    }
                } catch (CoincidenceException e) {
                    throw e;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Bubble sort, time: ");
        System.out.println(end - start);
        for(int i = 0; i < array.length; i++) {
            array[i].printInfo();
        }
    }
}
