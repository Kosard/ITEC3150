package Homework1;

public class MathCourse extends Course {
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
                "isSTEM=" + isSTEM +
                ", Instruction Type=" + instructionType +
                '}';
    }
}
