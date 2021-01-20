/**
 * Class: Cat
 *
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150,
 * <p>
 * <p>
 * This class � This class describes a subclass of Pet called Cat
 * <p>
 * Purpose: � Contains the attributes specific to a type ofPet called
 * Cat.
 */
public class Cat extends Pet {
    private boolean longHair;
    private boolean clawed;
    private String hairColor;

    public Cat(String type, String name, String ownerName, int age,
               boolean longHair, boolean clawed, String hairColor) {
        super(type, name, ownerName, age);
        this.longHair = longHair;
        this.clawed = clawed;
        this.hairColor = hairColor;
    }

    @Override
    public String toString() {
        return super.toString() + " Cat [longHair=" + longHair + ", clawed=" + clawed
                + ", hairColor=" + hairColor + "]";
    }

    public boolean isLongHair() {
        return longHair;
    }

    public boolean isClawed() {
        return clawed;
    }

    public String getHairColor() {
        return hairColor;
    }

}
