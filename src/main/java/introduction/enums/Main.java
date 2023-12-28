package introduction.enums;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, String> fucntion = String::valueOf;
        fucntion.apply(5);
        Printing<Integer, Integer, Integer, String> printing = (integer, integer2, s) -> integer + integer2 + Integer.parseInt(s);
        System.out.println(printing.print(1,2,fucntion.apply(10)));
        String string = "ads";
        Car car = Car.BMW;
        if (!(car == Car.BMW)) {
            System.out.println(1111);
        } else {
            System.out.println(2222);
        }

        print(new Plane(5, 10) {
            @Override
            public void test1() {
                System.out.println(5);
            }

            @Override
            public void test2() {
                System.out.println(10);
            }
        });
    }

    public static void print (Plane p) {
        System.out.println(p.x);
        p.test1();
        p.test2();
    }

    static abstract class Plane {
        private int x;
        private int y;

        public Plane(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public abstract void test1();
        public abstract void test2();
    }
}

