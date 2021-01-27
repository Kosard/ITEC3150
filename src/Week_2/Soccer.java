package Week_2;

public class Soccer extends Sports {
    public static void main(String[] args) {
        Soccer socc = new Soccer();
        socc.getNumberOfTeamMembers();
    }

    @Override
    void getNumberOfTeamMembers() {
        System.out.println("Each team has " + 11 + " players in " + getName());
    }
}
