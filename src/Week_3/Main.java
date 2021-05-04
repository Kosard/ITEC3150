package Week_3;

import java.io.*;
import java.util.ArrayList;

/**
 * Class: Main
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Written: February 2, 2021
 * <p>
 * This class holds the main method that initializes an Arraylist. It
 * also contains two other similar methods that read and write binary files.
 * <p>
 * Purpose: Methods needed to create an ArrayList of Person objects. Writes attributes to a .dat file and reads the same
 * file while also printing it to the console.
 */
public class Main {
    /**
     * This method is the starting point of the program. It contains an initialized ArrayList and adds 3 Person objects
     * to it. Then it calls two similar methods that write the attributes of all 3 Person objects to a people.dat file,
     * reads them, and prints it out to the console.
     *
     * @param args
     * @throws IOException Both methods handle I/O operations, so there is a possibility of this kind of exception to
     *                     happen.
     */
    public static void main(String[] args) throws IOException {
        //Create an ArrayList of Person objects
        ArrayList<PersonObject> list = new ArrayList<>();

        //Add objects with unique attributes to the list
        list.add(new PersonObject("Devin", "Bass", 1001, "Alpharetta"));
        list.add(new PersonObject("Mark", "Buford", 1002, "Redan"));
        list.add(new PersonObject("Sebastien", "Louis", 1003, "Lilburn"));

        //Method call using DataStream
        writeReadPeopleWithData(list);

        //Method call using ObjectStream
        writeReadPeopleWithObject(list);
    }

    /**
     * Method: writeReadPeopleWithData(ArrayList<Person> ppl)
     * This method iterates through the list and writes all their attributes to a file using DataOutputStream. Then it
     * reads the file using DataInputStream and prints what it reads to the console.
     *
     * @param ppl the ArrayList of Person objects to iterate through
     * @throws IOException type of exception encountered when using DataStream
     */
    public static void writeReadPeopleWithData(ArrayList<PersonObject> ppl) throws IOException {
        System.out.println("Using Data I/O Stream");

        //Write using Data I/O Stream
        //try-with-resources statement = automatic closing of resources (as per the book)
        try (
                DataOutputStream output = new DataOutputStream(new FileOutputStream("people.dat"));
        ) {
            //Go through the list
            for (PersonObject person : ppl) {
                //Write attributes to a file
                output.writeUTF(person.getFirstName());
                output.writeUTF(person.getLastName());
                output.write(person.getIdNum());
                output.writeUTF(person.getCity());
            }
        }

        //Read using Data I/O Stream
        //try-with-resources statement = automatic closing of resources (as per the book)
        try (
                DataInputStream inputStream = new DataInputStream(new FileInputStream("people.dat"))
        ) {
            //Go through the list
            for (int i = 0; i < ppl.size(); i++){
                //Create a temporary Person object by reading the attributes from the file
                PersonObject temp = new PersonObject(inputStream.readUTF(), inputStream.readUTF(), inputStream.read(), inputStream.readUTF());
                //Implicitly call the toString method to print to console
                System.out.println(temp);
            }
        }
//        try {
//            DataInputStream inputStream = new DataInputStream(new FileInputStream("people.dat"));
//            try{
//                while (true){
//                    //Create a temporary Person object by reading the attributes from the file
//                    PersonObject temp = new PersonObject(inputStream.readUTF(), inputStream.readUTF(), inputStream.read(), inputStream.readUTF());
//                    //Implicitly call the toString method to print to console
//                    System.out.println(temp);
//                }
//            } catch (EOFException e){
//                System.out.print("");
//            }
//            inputStream.close();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
    }

    /**
     * Method: writeReadPeopleWithObject(ArrayList<Person> ppl)
     * This method iterates through the list and writes all their attributes to a file using ObjectOutputStream. Then it
     * reads the file using ObjectInputStream and prints what it reads to the console.
     *
     * @param ppl the ArrayList of Person objects to iterate through
     * @throws IOException type of exception encountered when using DataStream
     */
    public static void writeReadPeopleWithObject(ArrayList<PersonObject> ppl) throws IOException {
        System.out.println("\nUsing Object I/O Stream");

        //Write using Object I/O Stream
        //try-with-resources statement = automatic closing of resources (as per the book)
        try (
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("people.dat"))
        ) {
            //Go through list
            for (PersonObject person : ppl) {
                //Write Person object to file
                outputStream.writeObject(person);
            }
        }

        //Read using Object I/O Stream
        //try-with-resources statement = automatic closing of resources (as per the book)
        try (
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("people.dat"))
        ) {
            try{
                while (true) {
                    //Read Person object from file and print to console
                    System.out.println(inputStream.readObject());
                }
            } catch (EOFException e){
                System.out.print("");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
