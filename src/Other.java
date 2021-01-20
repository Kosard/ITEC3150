/**
 * Class: Other
 *
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150,
 * <p>
 * <p>
 * This class � This class describes a subclass of Pet called Other
 * <p>
 * Purpose: � Contains the attributes specific to a type ofPet called
 * Other.
 */
public class Other extends Pet {

    private boolean specialHandling;
    private String petType;

    public Other(String type, String name, String ownerName, int age,
                 boolean specialHandling, String type2) {
        super(type, name, ownerName, age);
        this.specialHandling = specialHandling;
        petType = type2;
    }

    @Override
    public String toString() {
        return super.toString() + " Other [specialHandling=" + specialHandling
                + ", type=" + petType + "]";
    }

    public boolean isSpecialHandling() {
        return specialHandling;
    }

    public String getPetType() {
        return petType;
    }

}
