import java.util.*;

public class Main {

    static Map<Integer, Student> studentMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n<---- Student Management System --->");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            int choice = getValidInt("Enter choice: ");

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

    public static int getValidInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
            }
        }
    }

    public static double getValidDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.next());
                if (value < 0) {
                    System.out.println("Fee cannot be negative!");
                } else {
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a valid number.");
            }
        }
    }

    public static String getValidString(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.next();
            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty!");
            } else {
                return input;
            }
        }
    }

    public static void addStudent() {

        System.out.println("Choose Type: 1-Regular 2-Scholarship 3-Exchange");
        int type = getValidInt("Enter type: ");

        Student s;

        if (type == 1) {
            s = new RegularStudent();
        } else if (type == 2) {
            s = new ScholarshipStudent();
        } else {
            s = new ExchangeStudent();
        }

        int id = getValidInt("Enter ID: ");

        if (studentMap.containsKey(id)) {
            System.out.println("ID already exists!");
            return;
        }

        s.setStudentId(id);
        s.setName(getValidString("Enter Name: "));
        s.setCourse(getValidString("Enter Course: "));
        s.setBaseFee(getValidDouble("Enter Base Fee: "));

        studentMap.put(id, s);

        System.out.println("Student Added Successfully!");
    }

    public static void displayStudents() {

        if (studentMap.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n--------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-10s %-15s %-10s\n",
                "ID", "Name", "Course", "Type", "Fee");
        System.out.println("--------------------------------------------------------------");

        for (Student s : studentMap.values()) {

            String type;

            if (s instanceof RegularStudent) {
                type = "Regular";
            } else if (s instanceof ScholarshipStudent) {
                type = "Scholarship";
            } else {
                type = "Exchange";
            }

            System.out.printf("%-5d %-10s %-10s %-15s %-10.2f\n",
                    s.getStudentId(),
                    s.getName(),
                    s.getCourse(),
                    type,
                    s.calculateFee());
        }

        System.out.println("--------------------------------------------------------------");
    }

    public static void searchStudent() {
        int id = getValidInt("Enter ID to search: ");

        Student s = studentMap.get(id);

        if (s != null) {
            System.out.println("Name: " + s.getName());
            System.out.println("Course: " + s.getCourse());
            System.out.println("Fee: " + s.calculateFee());
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void updateStudent() {
        int id = getValidInt("Enter ID to update: ");

        Student s = studentMap.get(id);

        if (s != null) {
            s.setName(getValidString("Enter new name: "));
            s.setCourse(getValidString("Enter new course: "));
            System.out.println("Updated Successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void deleteStudent() {
        int id = getValidInt("Enter ID to delete: ");

        if (studentMap.remove(id) != null) {
            System.out.println("Deleted Successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}