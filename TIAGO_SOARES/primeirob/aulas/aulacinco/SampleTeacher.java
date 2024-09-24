package primeirob.aulas.aulacinco;

public class SampleTeacher {

    public static void main(String[] args) {
        Teacher teacherOne = new Teacher();
        
        teacherOne.name = "John Acme";
        teacherOne.qualification = "Software Engineer";
        teacherOne.matter = "P.O";
        teacherOne.goodTeacher = true;

        teacherOne.introduceYourself();
    }

}
