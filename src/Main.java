import java.util.*;

public class Main {

    static Map<Integer, Student> studentMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ADD STUDENT
    public static void addStudent() {
        System.out.println("Choose Type: 1-Regular 2-Scholarship 3-Exchange");
        int type = sc.nextInt();

        Student s;

        if (type == 1) {
            s = new RegularStudent();
        } else if (type == 2) {
            s = new ScholarshipStudent();
        } else {
            s = new ExchangeStudent();
        }

        System.out.print("Enter ID: ");
        s.setStudentId(sc.nextInt());

        System.out.print("Enter Name: ");
        s.setName(sc.next());

        System.out.print("Enter Course: ");
        s.setCourse(sc.next());

        System.out.print("Enter Base Fee: ");
        s.setBaseFee(sc.nextDouble());

        studentMap.put(s.getStudentId(), s);
        System.out.println("Student Added Successfully!");
    }

    // DISPLAY
    public static void displayStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        for (Student s : studentMap.values()) {
            System.out.println("\nID: " + s.getStudentId());
            System.out.println("Name: " + s.getName());
            System.out.println("Course: " + s.getCourse());
            System.out.println("Final Fee: " + s.calculateFee());
        }
    }

    // SEARCH
    public static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        Student s = studentMap.get(id);

        if (s != null) {
            System.out.println("Name: " + s.getName());
            System.out.println("Fee: " + s.calculateFee());
        } else {
            System.out.println("Student not found!");
        }
    }

    // UPDATE
    public static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();

        Student s = studentMap.get(id);

        if (s != null) {
            System.out.print("Enter new name: ");
            s.setName(sc.next());

            System.out.print("Enter new course: ");
            s.setCourse(sc.next());

            System.out.println("Updated Successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // DELETE
    public static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        if (studentMap.remove(id) != null) {
            System.out.println("Deleted Successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}