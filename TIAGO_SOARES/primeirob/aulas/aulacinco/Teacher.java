package primeirob.aulas.aulacinco;

public class Teacher {
    String name;
    String matter;
    Boolean goodTeacher;
    String qualification;

    public void introduceYourself(){
        String msg = "Hello, My name is "
            .concat(name)
            .concat(", I teach ")
            .concat(matter)
            .concat(goodTeacher ? ", I am " : ", I am not ")
            .concat("good Teacher");

        System.out.println(msg);
    }
}
