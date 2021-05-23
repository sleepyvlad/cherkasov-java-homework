package part01.lesson01.task01;
/*
 * Модулирование выбрасывания своего исключения
 * */
public class MyExceptionExample {
    public static void main(String[] args) {
        if(2 < 3) {
            throw new ArithmeticException();
        }
        System.out.println("Hello World");
    }
}
