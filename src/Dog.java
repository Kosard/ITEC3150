/**
 * Class: Dog
 *
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150,
 * <p>
 * <p>
 * This class � This class describes a subclass of Pet called Dog
 * <p>
 * Purpose: � Contains the attributes specific to a type ofPet called
 * Dog.
 */
public class Dog extends Pet {

    private String breed;
    private String hairColor;

    public Dog(String type, String name, String ownerName, int age,
               String breed, String hairColor) {
        super(type, name, ownerName, age);
        this.breed = breed;
        this.hairColor = hairColor;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Dog [breed=" + breed + ", hairColor="
                + hairColor + "]";
    }

    public String getBreed() {
        return breed;
    }

    public String getHairColor() {
        return hairColor;
    }


}
