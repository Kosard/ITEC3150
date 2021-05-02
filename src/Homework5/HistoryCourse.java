package Homework5;

import java.io.Serializable;

/**
 * Class: HistoryCourse
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Written: January 23, 2021
 * <p>
 * This class describes a subclass of Course called HistoryCourse.
 * <p>
 * Purpose: Contains the attributes specific to a type of Course called HistoryCourse.
 */

public class HistoryCourse extends Course implements Serializable {
    private boolean areaE_Eligible;
    private String instructionType;

    public boolean isAreaE_Eligible() {
        return areaE_Eligible;
    }

    public HistoryCourse(int crn, String name, String category, boolean eligible,
                         String type) {
        super(crn, name, category);
        this.areaE_Eligible = eligible;
        this.instructionType = type;
    }

    public String getInstructionType() {
        return instructionType;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Area E Eligible = " + areaE_Eligible +
                ", Instruction Type = " + instructionType +
                ']';
    }
}
