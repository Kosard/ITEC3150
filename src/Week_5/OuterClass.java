package Week_5;

public class OuterClass {
    int outerVariable = 100;

    void run() {
        InnerClass localInner = new InnerClass();
        System.out.println(localInner.getSum(5));
    }

    public class InnerClass {
        int innerVariable = 20;

        int getSum(int parameter) {
            return innerVariable + outerVariable + parameter;
        }
    }
}

class MainDemoInner {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        System.out.println(inner.getSum(3));
        outer.run();
    }
}
