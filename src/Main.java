import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, Student> studentMap = new HashMap<>();


        Student s1 = new RegularStudent();
        s1.setStudentId(1);
        s1.setName("Steve");
        s1.setCourse("IT");
        s1.setBaseFee(50000);

        Student s2 = new ScholarshipStudent();
        s2.setStudentId(2);
        s2.setName("Natasha");
        s2.setCourse("CS");
        s2.setBaseFee(50000);

        Student s3 = new ExchangeStudent();
        s3.setStudentId(3);
        s3.setName("Tony");
        s3.setCourse("AI");
        s3.setBaseFee(50000);

   
        studentMap.put(s1.getStudentId(), s1);
        studentMap.put(s2.getStudentId(), s2);
        studentMap.put(s3.getStudentId(), s3);

  
        for (Student s : studentMap.values()) {
            System.out.println("ID: " + s.getStudentId());
            System.out.println("Name: " + s.getName());
            System.out.println("Course: " + s.getCourse());
            System.out.println("Final Fee: " + s.calculateFee());
            System.out.println("------------------------");
        }
    }
}