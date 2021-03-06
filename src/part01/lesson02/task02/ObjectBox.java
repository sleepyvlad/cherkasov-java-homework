package part01.lesson02.task02;

import java.util.HashSet;
import java.util.Iterator;

/*
    Класс коллекция объектов Object
* */
public class ObjectBox<T> {
    private HashSet<T> objects = new HashSet<T>();

    // Добавляет объект в коллекцию
    public void addObject (Object obj) {
        this.objects.add((T) obj);
    }

    // Удаляет объект из коллекции
    public void deleteObject (Object obj) {
        if(this.objects.contains(obj)) {
            this.objects.remove(obj);
        }
    }

    // Выводит в строку объекты коллекции
    public void dump () {
        Iterator<T> it = this.objects.iterator();
        String allObjects = "";
        while (it.hasNext()) {
            allObjects = allObjects.concat(it.next().toString() + " ");
        }

        System.out.println(allObjects);
    }
}
