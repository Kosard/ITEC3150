package Week_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: ClientList
 *
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * <p>
 * <p>
 * This class � This class describes ClientList used to contain the Pet
 * item ClientList. It also contains the main method which starts the
 * program.
 * <p>
 * Purpose: � Methods and attributes needed to create a ClientList of
 * Pet class items. Print them, read them from a file,search for a
 * particular id and add a new item.
 */
public class ClientList {

    // actual ClientList data
    private ArrayList<Pet> clientListItems = new ArrayList<Pet>();

    /**
     * Method:main()
     * <p>
     * This method is the starting point of the program. It contains the initial
     * reading of items from the text file Pet.txt and a menu for allowing user
     * to choose various tasks.
     *
     * @param args
     */
    public static void main(String[] args) {
        // create ClientList by reading in from text file named media.txt
        ClientList myClientList = new ClientList();

        // open text file
        File petFile = new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Week_1\\pets.txt");
        // open a Scanner to read data from File
        Scanner petReader = null;
        try {
            petReader = new Scanner(petFile);
        } catch (FileNotFoundException e) {

            System.out.println("No ClientList Pet found- ClientList is empty");

        }

        // read one person at a time
        while (petReader != null && petReader.hasNext()) {

            String category = petReader.nextLine();
            String name = petReader.nextLine();
            String ownerName = petReader.nextLine();
            String ageString = petReader.nextLine();
            int age = Integer.parseInt(ageString);

            if (category.equalsIgnoreCase("Other")) {
                String temp = petReader.nextLine();
                boolean handling = Boolean.parseBoolean(temp);
                String type = petReader.nextLine();
                Other tp = new Other(category, name, ownerName, age, handling, type);
                myClientList.addItem(tp);

            } else if (category.equalsIgnoreCase("Cat")) {
                String temp = petReader.nextLine();
                boolean declawed = Boolean.parseBoolean(temp);
                temp = petReader.nextLine();
                boolean longHair = Boolean.parseBoolean(temp);
                String color = petReader.nextLine();

                Cat tp = new Cat(category, name, ownerName, age, longHair, declawed, color);
                myClientList.addItem(tp);

            } else if (category.equalsIgnoreCase("Dog")) {
                String breed = petReader.nextLine();
                String color = petReader.nextLine();
                Dog tp = new Dog(category, name, ownerName, age, breed, color);
                myClientList.addItem(tp);
            } else {
                System.out.println("Unknown Pet type " + category);
            }

        }

        Scanner keyboard = new Scanner(System.in);
        Scanner petInfo = new Scanner(System.in);

        System.out.println("Welcome to the Client List");
        boolean done = false;
        while (!done) {
            System.out.println("Would you like to :");
            System.out.println("  1. View contents of Client List");
            System.out.println("  2. Search for a pet");
            System.out.println("  3. Add a pet");
            System.out.println("  4. Remove a pet");
            System.out.println("  5. Exit");
            String tp = keyboard.nextLine();
            int userInput = Integer.parseInt(tp);
            if (userInput == 1) {
                myClientList.printclientListItems();
            } else if (userInput == 2) {
                System.out.println("Please enter pet name");
                String id = keyboard.nextLine();
                Pet item = myClientList.searchByName(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Sorry- item not found");
                }
            } else if (userInput == 3) {
                System.out.println("Please enter pet name");
                String petName = petInfo.nextLine();
                System.out.println("Please enter pet owner's name");
                String petOwner = petInfo.nextLine();
                System.out.println("Please enter pet age");
                int petAge = Integer.parseInt(petInfo.nextLine());
                System.out.println("What kind of pet is it?");
                String petType = petInfo.nextLine();

                if (petType.equalsIgnoreCase("Dog")) {
                    System.out.println("What is the breed?");
                    String dogBreed = petInfo.nextLine();
                    System.out.println("What is their hair color?");
                    String dogColor = petInfo.nextLine();
                    Dog dog = new Dog(petType, petName, petOwner, petAge, dogBreed, dogColor);
                    myClientList.addItem(dog);
                } else if (petType.equalsIgnoreCase("Cat")) {
                    boolean catHair = false;
                    boolean catClaw = false;
                    System.out.println("Do they have long hair?");
                    if (petInfo.nextLine().equalsIgnoreCase("yes")) {
                        catHair = true;
                    }
                    System.out.println("Have they been declawed?");
                    if (petInfo.nextLine().equalsIgnoreCase("no"))
                        catClaw = true;
                    System.out.println("What is their hair color?");
                    String catColor = petInfo.nextLine();
                    Cat cat = new Cat(petType, petName, petOwner, petAge, catHair, catClaw, catColor);
                    myClientList.addItem(cat);
                } else {
                    boolean petHandle = false;
                    System.out.println("Do they require special handling?");
                    if (petInfo.nextLine().equalsIgnoreCase("yes")) {
                        petHandle = true;
                    }
                    Other otherPet = new Other("other", petName, petOwner, petAge, petHandle, petType);
                    myClientList.addItem(otherPet);
                }
            } else if (userInput == 4) {
                System.out.println("Please enter pet name");
                String id3 = keyboard.nextLine();
                myClientList.removeItem(id3);
            } else {
                done = true;
                // write out contents of ClientList back to original file
                PrintWriter out = null;
                // open file for writing
                try {
                    out = new PrintWriter(new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Week_1\\pets.txt"));
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // write contents of each ClientList item to file
                for (Pet g : myClientList.getclientListItems()) {
                    // first write the attributes common to all
                    out.println(g.getType());
                    out.println(g.getName());
                    out.println(g.getOwnerName());
                    out.println(g.getAge());

                    if (g.getType().equalsIgnoreCase("Other")) {
                        // cast to appropriate subclass
                        Other p = (Other) g;
                        out.println(p.isSpecialHandling());
                        out.println(p.getPetType());

                    } else if (g.getType().equalsIgnoreCase("Cat")) {
                        // cast to appropriate subclass
                        Cat c = (Cat) g;
                        // write attributes specific to Cat
                        out.println(c.isClawed());
                        out.println(c.isLongHair());
                        out.println(c.getHairColor());

                    } else if (g.getType().equalsIgnoreCase("Dog")) {
                        Dog m = (Dog) g;
                        out.println(m.getBreed());
                        out.println(m.getHairColor());


                    } else {
                        System.out.println("Unknown Pet type " + g.getType());
                    }

                }
                out.close();

            }

        }

    }

    /**
     * Method:printclientListItems()
     * <p>
     * This method prints the ClientList items contained in the clientListItems
     * Array list. It relies on the toString method of the various Pet types to
     * print the items in a user friendly format.
     */
    public void printclientListItems() {
        for (int i = 0; i < clientListItems.size(); i++) {
            Pet temp = clientListItems.get(i);
            System.out.println(temp);
        }

    }

    /**
     * Method:searchById()
     * <p>
     * This method looks at each item in the clientListItems array list and if
     * its idNumber attribute matches the input parameter id, that item is
     * returned to the caller. It returns null if item is not found.
     *
     * @param name
     * @return Pet
     */
    public Pet searchByName(String name) {
        Pet item = null;
        for (Pet temp : clientListItems) {
            if (temp.getName().equalsIgnoreCase(name)) {
                item = temp;
            }

        }
        return item;
    }

    /**
     * @return the clientListItems
     */
    public ArrayList<Pet> getclientListItems() {
        return clientListItems;
    }

    /**
     * Method:addItem()
     * <p>
     * This method adds the parameter m to the clientListItems array list
     *
     * @param m
     */
    public void addItem(Pet m) {
        clientListItems.add(m);
    }

    /**
     * Method:removeItem()
     * <p>
     * This method removes the item with id from the array list
     *
     * @param
     */
    public void removeItem(String name) {
        Pet g = this.searchByName(name);
        if (g != null) {
            clientListItems.remove(g);
        }
    }
}
