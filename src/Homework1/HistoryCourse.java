package Homework1;

public class HistoryCourse extends Course {
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
        return super.toString() + " HistoryCourse {" +
                "Area E Eligible=" + areaE_Eligible +
                ", Instruction Type=" + instructionType +
                '}';
    }
}
