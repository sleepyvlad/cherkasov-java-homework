package part01.lesson02.task03;

public class Task3 {
    public static void main(String[] args) throws ObjectToMathBoxException{
        Number[] a = new Number[] {1, 2, 3, 4, 2, 5};
        Number[] aCopy = new Number[] {1, 2, 3, 4, 5};
        MathBox b = new MathBox(a);
        MathBox bCopy = new MathBox(aCopy);

        System.out.println(b.equals(bCopy));
        b.deleteIntegerFromCollection(2);
        b.dump();
        b.splitter(3);
        System.out.println(b);
    }
}
