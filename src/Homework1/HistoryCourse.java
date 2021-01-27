package Homework1;

public class HistoryCourse extends Course {
    private boolean areaE_Eligible;
    private String courseType;

    public boolean isAreaE_Eligible() {
        return areaE_Eligible;
    }

    public String getCourseType() {
        return courseType;
    }

    public HistoryCourse(int crn, String name, String category, boolean eligible,
                         String type) {
        super(crn, name, category);
        this.areaE_Eligible = eligible;
        this.courseType = type;
    }

    @Override
    public String toString() {
        return super.toString() + " HistoryCourse {" +
                "areaE_Eligible=" + areaE_Eligible +
                ", courseType=" + courseType +
                '}';
    }
}
