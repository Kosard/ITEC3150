package MidtermReview;

interface Age {
    int x = 21;

    void getAge();
}

/**
 * Class:
 *
 * @author
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written:
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class AnonymousClassDemo {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.getAge();

        //Myclass is a hidden inner class of the Age interface
        //whose name is not written but an object to it is created
        Age oj1 = new Age() {
            @Override
            public void getAge() {
                System.out.println("Age is " + x);
            }
        };
        oj1.getAge();

        //Using Anon inner class that extends Thread class
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("Child Thread");
            }
        };
        t.start();
        System.out.println("Main Thread");

        //Using anon inner class that implements Runnable interface
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Child Thread");
            }
        };
        Thread h = new Thread(r);
        h.start();
        System.out.println("Main Thread");

        //Using anon inner class defined by constructor argument (can use lambda)
        Thread d = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Child Thread");
            }
        });

        d.start();

        System.out.println("Main Thread");
    }
}

//Regular class creation
class MyClass implements Age {
    @Override
    public void getAge() {
        System.out.println("Age is " + x);
    }
}
