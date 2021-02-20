package Week_5;

class Outer {
    public static void main(String[] args) {
        Outer.StaticNestedClass staticNestedObject = new Outer.StaticNestedClass();
        staticNestedObject.my_method();
    }

    static class StaticNestedClass {
        public void my_method() {
            System.out.println("This is my static nested class");
        }
    }
}
