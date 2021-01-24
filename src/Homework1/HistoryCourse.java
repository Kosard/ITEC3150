package Homework1;

public class HistoryCourse extends Course {
    private boolean areaE_Eligible;
    private String courseType;

    public HistoryCourse(int crn, String name, String category, boolean eligible,
                         String type) {
        super(crn, name, category);
        this.areaE_Eligible = eligible;
        this.courseType = type;
    }
}
