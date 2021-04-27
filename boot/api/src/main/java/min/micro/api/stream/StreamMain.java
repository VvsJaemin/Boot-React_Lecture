package min.micro.api.stream;


import java.util.*;
import java.util.stream.Stream;

import static min.micro.api.stream.RefUtil.*;

class Student implements Comparable<Student> {

    private String name;
    private String userName; //id
    public int score;
    private int grade;


    public Student(String name, String userName, int grade, int score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
        this.userName = userName;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }


    public String getUserName() {
        return this.userName;
    }

    public String getName() {
        return this.name;
    }

    public int getGrade() {
        return this.grade;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d, %s]", name, grade, score, userName);
    }

    @Override
    public int compareTo(Student o) {
        return o.score - this.score;
    }

}

public class StreamMain {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("메뉴 : 0.EXIT 1.성적 오름 차순 2. 성적내림차순 3.이름오름차순 4.ID오름차순");
            switch (scanner.nextInt()) {
                case 0:
                    return;
                case 1:
                    ascGrade().forEach(System.out::println);
                    break;
                case 2:
                    descScore().forEach(System.out::println);
                    break;
                case 3:
                    ascName().forEach(System.out::println);
                    break;
                case 4:
                    ascUsername().forEach(System.out::println);
                    break;
            }
        }
    }

    public static Stream<Student> makeStream() {
        DummyGenerator dum = new DummyGenerator();
        return Stream.of(
                new Student(dum.makeName(), dum.makeUsername(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(0, 100)),
                new Student(dum.makeName(), dum.makeUsername(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(0, 100)),
                new Student(dum.makeName(), dum.makeUsername(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(0, 100)));

    }

    public static Stream<Student> ascGrade() {
        return makeStream().sorted(Comparator.comparing((Student::getGrade)).thenComparing(Comparator.naturalOrder()));
    }

    public static Stream<Student> descScore() {
        return makeStream().sorted(Comparator.comparing((Student::getScore)).thenComparing(Comparator.reverseOrder()));
    }

    public static Stream<Student> ascName() {
        return makeStream().sorted(Comparator.comparing((Student::getName)).thenComparing(Comparator.naturalOrder()));
    }


    public static Stream<Student> ascUsername() {

        return makeStream().map(student->{
            student.setUserName(student.getUserName().toLowerCase());
            return student;
        }).distinct().sorted(Comparator.comparing((Student::getUserName)).thenComparing(Comparator.naturalOrder()));
    }
//        StreamUtil util = new StreamUtil();
//        util.arrayToList(new String [] {"a", "a"}).stream().sorted().collect(Collectors.toList());
//        new StreamUtil().arrayToList(new String[]{"a"}).stream().sorted().collect(Collectors.toList());
//        System.out.println(RefUtil.strToInt.apply("1"));
//        System.out.println(RefUtil.value.apply("23"));
//        System.out.println(RefUtil.equals.apply("2", "20"));
//        RefUtil.print.accept("r");

}




