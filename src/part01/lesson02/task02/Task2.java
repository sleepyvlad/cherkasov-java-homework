package part01.lesson02.task02;

public class Task2 {
    public static void main(String[] args) {
        class SomeObj {
            int someInt;
            String someString;

            SomeObj(int someInt, String someString) {
                this.someInt = someInt;
                this.someString = someString;
            }

            @Override
            public String toString(){
                return new String("int: " + this.someInt + " String: " + this.someString);
            }
        }
        ObjectBox objs = new ObjectBox();
        SomeObj a = new SomeObj(10, "Desyat");
        SomeObj b = new SomeObj(5, "Pyat");
        SomeObj c = new SomeObj(3, "Tri");
        objs.addObject(a);
        objs.addObject(b);
        objs.addObject(c);
        objs.deleteObject(a);
        objs.dump();
    }
}
