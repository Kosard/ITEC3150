/**
 * Class: Pet
 *
 * @author Dr. Johnson
 * @version 1.
 * Course : ITEC 3150,
 * <p>
 * <p>
 * This class � This class describes the common attributes and
 * methods of the Pet being collected into an inventory
 * <p>
 * Purpose: � This class is intended to serve a parent class only for
 * all different types of Pet
 */
public class Pet {
    private String type;
    private String name;
    private String ownerName;
    private int age;

    public Pet(String type, String name, String ownerName, int age) {
        super();
        this.type = type;
        this.name = name;
        this.ownerName = ownerName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet [type=" + type + ", name=" + name + ", ownerName="
                + ownerName + ", age=" + age + "]";
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAge() {
        return age;
    }

}
