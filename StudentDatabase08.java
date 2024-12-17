import java.io.*;
import java.util.*;

class Student {
    String studentId;
    String name;
    String rollNo;
    String studentClass;
    String marks;
    String address;

    public Student(String studentId, String name, String rollNo, String studentClass, String marks, String address) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.studentClass = studentClass;
        this.marks = marks;
        this.address = address;
    }

    @Override
    public String toString() {
        return studentId + "," + name + "," + rollNo + "," + studentClass + "," + marks + "," + address;
    }
}

public class StudentDatabase08 {
    static final String FILE_NAME = "student_database.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Database Management ---");
            System.out.println("1. Create Database / Add Record");
            System.out.println("2. Display Database");
            System.out.println("3. Delete Record");
            System.out.println("4. Update Record");
            System.out.println("5. Search Record");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addRecord();
                case 2 -> displayDatabase();
                case 3 -> deleteRecord();
                case 4 -> updateRecord();
                case 5 -> searchRecord();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void addRecord() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter Student ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Roll No: ");
            String roll = sc.nextLine();
            System.out.print("Enter Class: ");
            String studentClass = sc.nextLine();
            System.out.print("Enter Marks: ");
            String marks = sc.nextLine();
            System.out.print("Enter Address: ");
            String address = sc.nextLine();

            Student student = new Student(id, name, roll, studentClass, marks, address);
            writer.write(student.toString());
            writer.newLine();
            System.out.println("Record added successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayDatabase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Student Records ---");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("ID: " + data[0] + ", Name: " + data[1] + ", Roll No: " + data[2] + ", Class: "
                        + data[3] + ", Marks: " + data[4] + ", Address: " + data[5]);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteRecord() {
        System.out.print("Enter Student ID to delete: ");
        String targetId = sc.nextLine();
        modifyFile(targetId, null, "delete");
    }

    public static void updateRecord() {
        System.out.print("Enter Student ID to update: ");
        String targetId = sc.nextLine();
        System.out.println("Enter new details:");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        String roll = sc.nextLine();
        System.out.print("Enter Class: ");
        String studentClass = sc.nextLine();
        System.out.print("Enter Marks: ");
        String marks = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        Student updatedStudent = new Student(targetId, name, roll, studentClass, marks, address);
        modifyFile(targetId, updatedStudent.toString(), "update");
    }

    public static void searchRecord() {
        System.out.print("Enter Student ID to search: ");
        String targetId = sc.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(targetId + ",")) {
                    String[] data = line.split(",");
                    System.out.println("Record Found:");
                    System.out.println("ID: " + data[0] + ", Name: " + data[1] + ", Roll No: " + data[2] + ", Class: "
                            + data[3] + ", Marks: " + data[4] + ", Address: " + data[5]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Record not found.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void modifyFile(String targetId, String newRecord, String operation) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(targetId + ",")) {
                    found = true;
                    if (operation.equals("update")) {
                        writer.write(newRecord);
                        writer.newLine();
                    }
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }

            if (!found) {
                System.out.println("Record not found.");
            } else {
                System.out.println("Record " + operation + "d successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        if (!inputFile.delete()) {
            System.out.println("Could not delete original file");
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temporary file");
        }
    }
}
