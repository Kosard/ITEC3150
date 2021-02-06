package Homework1;

import java.io.Serializable;

/**
 * Class: MathCourse
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Written: January 23, 2021
 * <p>
 * This class describes a subclass of Course called MathCourse.
 * <p>
 * Purpose: Contains the attributes specific to a type of Course called MathCourse.
 */

public class MathCourse extends Course implements Serializable {
    private boolean isSTEM;
    private String instructionType;

    public boolean isSTEM() {
        return isSTEM;
    }

    public MathCourse(int crn, String name, String category, boolean stem, String type) {
        super(crn, name, category);
        this.isSTEM = stem;
        this.instructionType = type;
    }

    public String getInstructionType() {
        return instructionType;
    }

    @Override
    public String toString() {
        return super.toString() + " MathCourse {" +
                "isSTEM = " + isSTEM +
                ", Instruction Type = " + instructionType +
                '}';
    }
}
