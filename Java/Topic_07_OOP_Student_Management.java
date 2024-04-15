public class Topic_07_OOP_Student_Management {
   private int MSSV;
    private String name;
    private Float theory_score;
    private Float practical_score;

    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getTheory_score() {
        return theory_score;
    }

    public void setTheory_score(Float theory_score) {
        this.theory_score = theory_score;
    }

    public Float getPractical_score() {
        return practical_score;
    }

    public void setPractical_score(Float practical_score) {
        this.practical_score = practical_score;
    }
    private Float getAverageScore(){
        return (this.theory_score + this.practical_score*2)/3;
    }
    private void showStudentInfor(){
        System.out.println("student id: " +getMSSV());
        System.out.println("students Name: " +getName());
        System.out.println("students Practical Score: " +getPractical_score());
        System.out.println("Students theory Score: " +getTheory_score());
        System.out.println("Students averageScore: " +getAverageScore());

    }

    public Topic_07_OOP_Student_Management() {

    }

    public static void main(String[] args) {
        TC_01_Student1();
        TC_02_Student2();
        TC_03_Student3();

    }
    public static void TC_01_Student1(){
        Topic_07_OOP_Student_Management student1 = new Topic_07_OOP_Student_Management();
        student1.setMSSV(2345);
        student1.setName("Rati");
        student1.setTheory_score(8f);
        student1.setPractical_score(5f);
        student1.showStudentInfor();
    }
    public static void TC_02_Student2() {
        Topic_07_OOP_Student_Management student1 = new Topic_07_OOP_Student_Management();
        student1.setMSSV(900);
        student1.setName("ROTA");
        student1.setTheory_score(2f);
        student1.setPractical_score(5f);
        student1.showStudentInfor();

    }
    public static void TC_03_Student3() {
        Topic_07_OOP_Student_Management student3 = new Topic_07_OOP_Student_Management();
        student3.setMSSV(1234);
        student3.setName("rOD");
        student3.setTheory_score(6F);
        student3.setPractical_score(5f);
        student3.showStudentInfor();

    }

}