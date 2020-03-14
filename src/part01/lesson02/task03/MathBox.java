package part01.lesson02.task03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
/*
    Класс MathBox хранящий коллекцию чисел
* */
public class MathBox<T> extends ObjectBox {
    private HashSet<T> numbers;

    // Конструктор получает на вход массив Number и раскладывает его на HashSet
    public MathBox (T[] numbers) {
        super(numbers);
        this.numbers = new HashSet<T>(Arrays.asList(numbers));
    }

    // Функция складывающая все элементы MathBox
    public Number summator () {
        double sum = 0;
        Iterator<Number> i = (Iterator<Number>) this.numbers.iterator();
        while (i.hasNext()){
            sum += i.next().doubleValue();
        }

        return sum;
    }

    // Функция делит все элементы на заданное число
    public void splitter (Number divider) {
        Iterator<Number> i = (Iterator<Number>) this.numbers.iterator();
        HashSet<Number> newNumbers = new HashSet<Number>();
        while (i.hasNext()) {
            double newValue = i.next().doubleValue() / divider.doubleValue();
            newNumbers.add(newValue);
        }
        this.numbers = (HashSet<T>) newNumbers;
    }

    // Удаляет элемент из MathBox если он там есть
    public void deleteIntegerFromCollection(int a) {
        deleteObject(a);
        if(this.numbers.contains(a)) {
            this.numbers.remove(a);
        }
    }

    public HashSet<T> getNumbers() {
        return numbers;
    }

    // Переопределение стандартных методов
    @Override
    public String toString(){
        String returningValue = new String();
        Iterator<T> i = this.numbers.iterator();
        int index = 1;
        while(i.hasNext()){
            returningValue = returningValue.concat("Element №" + index + " Value: " + i.next() + "\n");
            index++;
        }
        return returningValue;
    }

    public boolean equals(MathBox a) {
        boolean equal = false;
        if(a.getNumbers().size() == this.numbers.size()) {
            Iterator<T> i = this.numbers.iterator();
            Iterator<T> j = a.getNumbers().iterator();

            while(i.hasNext()) {
                if(i.next().equals(j.next())) {
                    equal = true;
                } else {
                    equal = false;
                    break;
                }
            }
        }

        return equal;
    }

    @Override
    public void addObject(Object obj) throws ObjectToMathBoxException {
        try {
            throw new ObjectToMathBoxException("Нельзя положить объект в MathBox", obj);
        } catch (ObjectToMathBoxException e) {
            throw e;
        }
    }

    @Override
    public int hashCode() {
       return summator().intValue() * 31;
    }

    @Override
    public void dump() {
        Iterator<T> it = this.numbers.iterator();
        String allNumbers = "";
        while (it.hasNext()) {
            allNumbers = allNumbers.concat(it.next().toString() + " ");
        }

        System.out.println(allNumbers);
    }
}

// Исключение при попытке положить Object в MathBox
class ObjectToMathBoxException extends Exception{
    private Object obj;
    public Object getObj() { return obj; }
    public ObjectToMathBoxException(String message, Object obj) {
        super(message);
        this.obj = obj;
    }
}