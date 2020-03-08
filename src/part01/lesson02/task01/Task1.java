package part01.lesson02.task01;

public class Task1 {
    public static void main(String[] args) {
        Number[] a = new Number[] {1, 2, 2, 1, 3, 4 ,5, 7};
        MathBox b = new MathBox(a);
        Number[] c = new Number[] {1, 2, 2, 1, 3, 4 ,5, 7};
        MathBox d = new MathBox(c);
        d.deleteIntegerFromCollection(2);
        System.out.println("Sum of b is " + b.summator());
        System.out.println(b);
        d.splitter(2);
        System.out.println(d);
        System.out.println(b.equals(d));
    }
}
