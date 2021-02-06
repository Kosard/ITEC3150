package Week_3;

import java.io.Serializable;

/**
 * Class: Main
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Written: February 2, 2021
 * <p>
 * This class describes the attributes of the Person class. It also contains constructors, getter, and setter methods.
 * <p>
 * Purpose: Constructors needed to create Person objects in the Main class. Attributes needs to reference for reading
 * and writing to files.
 */
public class PersonObject implements Serializable {
    public String firstName;
    public String lastName;
    public int idNum;
    public String city;

    /**
     * Default constructor used to create empty attributes
     */
    public PersonObject() {
        firstName = "";
        lastName = "";
        idNum = 0;
        city = "";
    }

    /**
     * @param firstName
     * @param lastName
     * @param idNum
     * @param city
     */
    public PersonObject(String firstName, String lastName, int idNum, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNum = idNum;
        this.city = city;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName
                + ", idNum=" + idNum + ", city=" + city + "]";
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the idNum
     */
    public int getIdNum() {
        return idNum;
    }

    /**
     * @param idNum the idNum to set
     */
    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

}
