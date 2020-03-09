package part01.lesson02.task03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/*
    Класс коллекция объектов Object
* */
public class ObjectBox {
    private HashSet<Object> objects = new HashSet<Object>();

    // Конструктор ObjectBox получает на вход массив и раскладывает на коллекцию HashSet
    public ObjectBox(Object[] obj) {
        this.objects = new HashSet<Object>(Arrays.asList(obj));
    }

    // Добавляет объект в коллекцию
    public void addObject (Object obj) throws ObjectToMathBoxException {
        this.objects.add(obj);
    }

    // Удаляет объект из коллекции
    public void deleteObject (Object obj) {
        if(this.objects.contains(obj)) {
            this.objects.remove(obj);
        }
    }

    // Выводит в строку объекты коллекции
    public void dump () {
        Iterator<Object> it = this.objects.iterator();
        String allObjects = "";
        while (it.hasNext()) {
            allObjects = allObjects.concat(it.next().toString() + "\n");
        }

        System.out.println(allObjects);
    }

}
