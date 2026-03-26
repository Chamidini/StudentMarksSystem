import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static String[] studentIds = new String[100];
    static String[] studentNames = new String[100];
    static int[] prfMarks = new int[100];
    static int[] dbmsMarks = new int[100];

    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("\n===== WELCOME TO GDSE MARKS MANAGEMENT SYSTEM =====");
        System.out.println("[1]. Add New Student");
        System.out.println("[2]. Add New Student with Marks");
        System.out.println("[3]. Add Marks");
        System.out.println("[4]. Update Student Details");
        System.out.println("[5]. Update Marks");
        System.out.println("[6]. Delete Student");
        System.out.println("[7]. Print Student Details");
        System.out.println("[8]. Print Student Ranks");
        System.out.println("[9]. Best in Programming Fundamentals");
        System.out.println("[10]. Best in Database Management System");

        System.out.print("Enter an option to continue: ");
        int option = input.nextInt();

        switch(option) {
            case 1: addStudent(); break;
            case 2: addStudentWithMarks(); break;
            case 3: addMarks(); break;
            case 4: updateStudent(); break;
            case 5: updateMarks(); break;
            case 6: deleteStudent(); break;
            case 7: printStudent(); break;
            case 8: printRanks(); break;
            case 9: bestProgramming(); break;
            case 10: bestDBMS(); break;
        }
    }

    // 1
    // public static void addStudent() {
    //     System.out.println("\n===== ADD NEW STUDENT =====");
    //     System.out.print("Enter Student ID: ");
    //     String id = input.next();

    //     for (int i = 0; i < count; i++) {
    //         if (studentIds[i].equals(id)) {
    //             System.out.println("Student ID already exists!");
    //             return;
    //         }
    //     }

    //     System.out.print("Enter Student Name: ");
    //     String name = input.next();

    //     studentIds[count] = id;
    //     studentNames[count] = name;
    //     prfMarks[count] = -1;
    //     dbmsMarks[count] = -1;

    //     count++;
    //     System.out.println("Student has been added successfully!");
    // }

    public static void addStudent() {

    char choice; //user choice variable

    do {
        System.out.println("\n===== ADD NEW STUDENT =====");

        System.out.print("Enter Student ID: ");
        String id = input.next();

        boolean exists = false; // duplicate check flag

        for (int i = 0; i < count; i++) {
            if (studentIds[i].equals(id)) {
                System.out.println("Student ID already exists!");
                exists = true;
                break;
            }
        }

        if (!exists) {
            System.out.print("Enter Student Name: ");
            String name = input.next();

            studentIds[count] = id;
            studentNames[count] = name;
            prfMarks[count] = -1;
            dbmsMarks[count] = -1;

            count++;

            System.out.println("Student has been added successfully!");
        }

        //ask user to continue
        System.out.print("Do you want to add a new student (Y/n): ");
        choice = input.next().charAt(0);

    } while (choice == 'Y' || choice == 'y'); // loop if Y

}

    // 2
    // public static void addStudentWithMarks() {
    //     System.out.println("\n===== ADD NEW STUDENT WITH MARKS =====");
    //     System.out.print("Enter Student ID: ");
    //     String id = input.next();

    //     for (int i = 0; i < count; i++) {
    //         if (studentIds[i].equals(id)) {
    //             System.out.println("Student ID already exists!");
    //             return;
    //         }
    //     }

    //     System.out.print("Enter Student Name: ");
    //     String name = input.next();

    //     int prf, dbms;

    //     do {
    //         System.out.print("Enter Programming Marks (0-100): ");
    //         prf = input.nextInt();

    //         if (prf < 0 || prf > 100) {
    //             System.out.println("Invalid marks, please enter correct marks.");
    //         }

    //     } while (prf < 0 || prf > 100);

    //     do {
    //         System.out.print("Enter DBMS Marks (0-100): ");
    //         dbms = input.nextInt();

    //         if (dbms < 0 || dbms > 100) {
    //             System.out.println("Invalid marks, please enter correct marks.");
    //         }

    //     } while (dbms < 0 || dbms > 100);

    //     studentIds[count] = id;
    //     studentNames[count] = name;
    //     prfMarks[count] = prf;
    //     dbmsMarks[count] = dbms;

    //     count++;
    //     System.out.println("Student Added with Marks!");
    // }

    public static void addStudentWithMarks() {

    char choice; 

    do {
        System.out.println("\n===== ADD NEW STUDENT WITH MARKS =====");

        System.out.print("Enter Student ID: ");
        String id = input.next();

        boolean exists = false; 

        for (int i = 0; i < count; i++) {
            if (studentIds[i].equals(id)) {
                System.out.println("Student ID already exists!");
                exists = true;
                break;
            }
        }

        if (!exists) {

            System.out.print("Enter Student Name: ");
            String name = input.next();

            int prf, dbms;

            do {
                System.out.print("Enter Programming Marks (0-100): ");
                prf = input.nextInt();

                if (prf < 0 || prf > 100) {
                    System.out.println("Invalid marks, please enter correct marks.");
                }

            } while (prf < 0 || prf > 100);

            do {
                System.out.print("Enter Database Management System Marks (0-100): ");
                dbms = input.nextInt();

                if (dbms < 0 || dbms > 100) {
                    System.out.println("Invalid marks, please enter correct marks.");
                }

            } while (dbms < 0 || dbms > 100);

            studentIds[count] = id;
            studentNames[count] = name;
            prfMarks[count] = prf;
            dbmsMarks[count] = dbms;

            count++;

            System.out.println("Student has been added successfully!");
        }

        // ✅ NEW: ask user
        System.out.print("Do you want to add a new student (Y/n): ");
        choice = input.next().charAt(0);

    } while (choice == 'Y' || choice == 'y'); 

}

    // 3
    // public static void addMarks() {
    //     System.out.print("Enter Student ID: ");
    //     String id = input.next();

    //     int index = findStudent(id);
    //     if (index == -1) {
    //         System.out.println("Student not found!");
    //         return;
    //     }

    //     if (prfMarks[index] != -1) {
    //         System.out.println("Marks already added!");
    //         return;
    //     }

    //     int prf, dbms;

    //     do {
    //         System.out.print("Enter Programming Marks: ");
    //         prf = input.nextInt();
    //     } while (prf < 0 || prf > 100);

    //     do {
    //         System.out.print("Enter DBMS Marks: ");
    //         dbms = input.nextInt();
    //     } while (dbms < 0 || dbms > 100);

    //     prfMarks[index] = prf;
    //     dbmsMarks[index] = dbms;

    //     System.out.println("Marks Added!");
    // }

    public static void addMarks() {

    char searchChoice; // for invalid ID loop
    char continueChoice; // for repeat adding marks

    do {
        System.out.println("\n===== ADD MARKS =====");
        int index = -1;
        String id;

        // SEARCH LOOP (invalid ID handling)
        do {
            System.out.print("\nEnter Student ID: ");
            id = input.next();

            index = findStudent(id);

            if (index == -1) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
                searchChoice = input.next().charAt(0);

                if (searchChoice == 'n' || searchChoice == 'N') {
                    return; // go back to main menu
                }

            } else {
                break; // valid ID found
            }

        } while (true);

        // CHECK IF MARKS ALREADY ADDED
        if (prfMarks[index] != -1) {
            System.out.println("This student's marks have been already added.");
            System.out.println("If you want to update the marks, please use [5] Update Marks option.");
        } else {

            // SHOW NAME
            System.out.println("Student Name: " + studentNames[index]);

            int prf, dbms;

            // VALIDATION WITH MESSAGE
            do {
                System.out.print("Enter Programming Marks (0-100): ");
                prf = input.nextInt();

                if (prf < 0 || prf > 100) {
                    System.out.println("Invalid marks, please enter correct marks.");
                }

            } while (prf < 0 || prf > 100);

            do {
                System.out.print("Enter Database Management System Marks (0-100): ");
                dbms = input.nextInt();

                if (dbms < 0 || dbms > 100) {
                    System.out.println("Invalid marks, please enter correct marks.");
                }

            } while (dbms < 0 || dbms > 100);

            prfMarks[index] = prf;
            dbmsMarks[index] = dbms;

            System.out.println("Marks have been added successfully!");
        }

        // ASK TO CONTINUE
        System.out.print("Do you want to add marks for another student (Y/n): ");
        continueChoice = input.next().charAt(0);

    } while (continueChoice == 'Y' || continueChoice == 'y');

}

    // 4
    // public static void updateStudent() {
    //     System.out.print("Enter Student ID: ");
    //     String id = input.next();

    //     int index = findStudent(id);
    //     if (index == -1) {
    //         System.out.println("Student not found!");
    //         return;
    //     }

    //     System.out.print("Enter New Name: ");
    //     studentNames[index] = input.next();

    //     System.out.println("Student Updated!");
    // }

    public static void updateStudent() {

    char searchChoice;     // for invalid ID loop
    char continueChoice;   // for repeat update

    do {
        System.out.println("\n===== UPDATE STUDENT DETAILS =====");
        int index = -1;
        String id;

        // SEARCH LOOP (handle invalid ID like previous)
        do {
            System.out.print("\nEnter Student ID: ");
            id = input.next();

            index = findStudent(id);

            if (index == -1) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
                searchChoice = input.next().charAt(0);

                if (searchChoice == 'n' || searchChoice == 'N') {
                    return; // back to main menu
                }

            } else {
                break; // valid ID found
            }

        } while (true);

        // SHOW CURRENT NAME
        System.out.println("Current Name: " + studentNames[index]);

        // GET NEW NAME
        System.out.print("Enter New Name: ");
        studentNames[index] = input.next();

        System.out.println("Student details have been updated successfully!");

        // ASK TO CONTINUE
        System.out.print("Do you want to update another student details (Y/n): ");
        continueChoice = input.next().charAt(0);

    } while (continueChoice == 'Y' || continueChoice == 'y');

}

    // 5
    // public static void updateMarks() {
    //     System.out.print("Enter Student ID: ");
    //     String id = input.next();

    //     int index = findStudent(id);
    //     if (index == -1) {
    //         System.out.println("Student not found!");
    //         return;
    //     }

    //     if (prfMarks[index] == -1) {
    //         System.out.println("Marks not added yet!");
    //         return;
    //     }

    //     int prf, dbms;

    //     do {
    //         System.out.print("Enter New Programming Marks: ");
    //         prf = input.nextInt();
    //     } while (prf < 0 || prf > 100);

    //     do {
    //         System.out.print("Enter New DBMS Marks: ");
    //         dbms = input.nextInt();
    //     } while (dbms < 0 || dbms > 100);

    //     prfMarks[index] = prf;
    //     dbmsMarks[index] = dbms;

    //     System.out.println("Marks Updated!");
    // }

    public static void updateMarks() {

    char searchChoice;     // for invalid ID loop
    char continueChoice;   // for repeat update

    do {
        System.out.println("\n===== UPDATE MARKS =====");
        int index = -1;
        String id;

        // SEARCH LOOP (invalid ID handling)
        do {
            System.out.print("\nEnter Student ID: ");
            id = input.next();

            index = findStudent(id);

            if (index == -1) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
                searchChoice = input.next().charAt(0);

                if (searchChoice == 'n' || searchChoice == 'N') {
                    return; // back to main menu
                }

            } else {
                break; // valid ID found
            }

        } while (true);

        // CHECK IF MARKS EXIST
        if (prfMarks[index] == -1) {
            System.out.println("This student's marks yet to be added.");
        } else {

            // SHOW CURRENT DETAILS
            System.out.println("Student Name: " + studentNames[index]);
            System.out.println("Programming Marks: " + prfMarks[index]);
            System.out.println("DBMS Marks: " + dbmsMarks[index]);

            int prf, dbms;

            // VALIDATION WITH MESSAGE
            do {
                System.out.print("Enter new Programming Fundamentals Marks : ");
                prf = input.nextInt();

                if (prf < 0 || prf > 100) {
                    System.out.println("Invalid marks, please enter correct marks.");
                }

            } while (prf < 0 || prf > 100);

            do {
                System.out.print("Enter new Database Management System Marks : ");
                dbms = input.nextInt();

                if (dbms < 0 || dbms > 100) {
                    System.out.println("Invalid marks, please enter correct marks.");
                }

            } while (dbms < 0 || dbms > 100);

            prfMarks[index] = prf;
            dbmsMarks[index] = dbms;

            System.out.println("Marks have been updated successfully!");
        }

        // ASK TO CONTINUE
        System.out.print("Do you want to update marks for another student (Y/n): ");
        continueChoice = input.next().charAt(0);

    } while (continueChoice == 'Y' || continueChoice == 'y');
}

    // 6
    public static void deleteStudent() {
        System.out.println("\n===== DELETE STUDENT =====");
        System.out.print("Enter Student ID: ");
        String id = input.next();

        int index = findStudent(id);
        if (index == -1) {
            System.out.println("Student not found!");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            studentIds[i] = studentIds[i+1];
            studentNames[i] = studentNames[i+1];
            prfMarks[i] = prfMarks[i+1];
            dbmsMarks[i] = dbmsMarks[i+1];
        }

        count--;
        System.out.println("Student Deleted!");
    }

    // 7
    public static void printStudent() {
        System.out.print("Enter Student ID: ");
        String id = input.next();

        int i = findStudent(id);
        if (i == -1) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Name: " + studentNames[i]);

        if (prfMarks[i] == -1) {
            System.out.println("Marks not added yet!");
            return;
        }

        int total = prfMarks[i] + dbmsMarks[i];
        double avg = total / 2.0;

        System.out.println("Programming: " + prfMarks[i]);
        System.out.println("DBMS: " + dbmsMarks[i]);
        System.out.println("Total: " + total);
        System.out.println("Average: " + avg);
    }

    // 8
    public static void printRanks() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                int total1 = prfMarks[j] + dbmsMarks[j];
                int total2 = prfMarks[j+1] + dbmsMarks[j+1];

                if (total1 < total2) {
                    swap(j, j+1);
                }
            }
        }

        System.out.println("\n--- RANKS ---");
        for (int i = 0; i < count; i++) {
            if (prfMarks[i] != -1) {
                int total = prfMarks[i] + dbmsMarks[i];
                System.out.println((i+1) + ". " + studentNames[i] + " - " + total);
            }
        }
    }

    // 9
    public static void bestProgramming() {
        int max = -1, index = -1;

        for (int i = 0; i < count; i++) {
            if (prfMarks[i] > max) {
                max = prfMarks[i];
                index = i;
            }
        }

        if (index != -1)
            System.out.println("Best in Programming: " + studentNames[index]);
    }

    // 10
    public static void bestDBMS() {
        int max = -1, index = -1;

        for (int i = 0; i < count; i++) {
            if (dbmsMarks[i] > max) {
                max = dbmsMarks[i];
                index = i;
            }
        }

        if (index != -1)
            System.out.println("Best in Database Management System : " + studentNames[index]);
    }

    // helper
    public static int findStudent(String id) {
        for (int i = 0; i < count; i++) {
            if (studentIds[i].equals(id)) return i;
        }
        return -1;
    }

    public static void swap(int i, int j) {
        String tempId = studentIds[i];
        studentIds[i] = studentIds[j];
        studentIds[j] = tempId;

        String tempName = studentNames[i];
        studentNames[i] = studentNames[j];
        studentNames[j] = tempName;

        int temp = prfMarks[i];
        prfMarks[i] = prfMarks[j];
        prfMarks[j] = temp;

        temp = dbmsMarks[i];
        dbmsMarks[i] = dbmsMarks[j];
        dbmsMarks[j] = temp;
    }
}