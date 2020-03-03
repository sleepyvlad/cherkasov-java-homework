package part01.lesson01.task01;
/*
* Модулирование исключения NullPointerException
* */
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String someStr = null;
        boolean a = someStr.equals("asda");
        System.out.println("Hello World");
    }
}
