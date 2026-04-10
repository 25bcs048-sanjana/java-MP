import java.io.*;
import java.util.*;

class Patient {
    int id;
    String name;
    int age;

    Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + " " + name + " " + age;
    }
}

public class PersonalHealthSystem {

    static Scanner sc = new Scanner(System.in);

    static void addPatient() throws IOException {
        FileWriter fw = new FileWriter("patients.txt", true);

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        Patient p = new Patient(id, name, age);
        fw.write(p.toString() + "\n");

        fw.close();
        System.out.println("Patient Saved Successfully!");
    }

    static void viewPatients() throws IOException {
        File file = new File("patients.txt");

        if (!file.exists()) {
            System.out.println("No records found.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    static void addHealthRecord() throws IOException {
        FileWriter fw = new FileWriter("records.txt", true);

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        System.out.print("Enter BP: ");
        String bp = sc.nextLine();

        System.out.print("Enter Sugar Level: ");
        String sugar = sc.nextLine();

        fw.write(id + " " + date + " " + bp + " " + sugar + "\n");

        fw.close();
        System.out.println("Health Record Saved!");
    }

    static void viewRecords() throws IOException {
        File file = new File("records.txt");

        if (!file.exists()) {
            System.out.println("No records found.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PERSONAL HEALTH SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Health Record");
            System.out.println("4. View Records");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        viewPatients();
                        break;
                    case 3:
                        addHealthRecord();
                        break;
                    case 4:
                        viewRecords();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Invalid Input!");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 5);
    }
}