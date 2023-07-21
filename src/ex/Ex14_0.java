package ex;

import java.io.FilenameFilter;

public class Ex14_0 {
    public static void main(String[] args) {
        Object obj = new Object() {
            int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        MyFunction myFunction = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        int max = myFunction.max(3, 5);
        System.out.println("max = " + max);

        MyFunction f = (a, b) -> a > b ? a : b;
        int max1 = f.max(124, 412421);
        System.out.println("max1 = " + max1);
    }
}

@FunctionalInterface
interface MyFunction {
    public abstract int max(int a, int b);
}
