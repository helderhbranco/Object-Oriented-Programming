/*
* Nome: <Hélder Henrique Sousa Dias Branco>
* Número: <8200302>
* Turma: <LEI12T3>
*
* Nome: <Ian Costa>
* Número: <8220005>
* Turma: <LEI12T4>
 */
package Menus;

import CBL.Task;
import StakeHolders.Contact;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserInput {

    /**
     * Receives an User Input for a String, if the input is empyt, null or
     * blank, it will throw and IOException
     *
     * @return
     * @throws IOException
     */
    public static String getString() throws IOException {
        String string;
        Scanner scanner = new Scanner(System.in);
        string = scanner.nextLine();
        if (string == null || string.isEmpty() || string.isBlank()) {
            throw new IOException("String can't be Null, Empty or Blank");
        }
        return string;
    }

    /**
     * Receives an User Input for an int number.
     *
     * @return
     */
    public static int getInt() {
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        return num;
    }

    /**
     * Receives an User Input for the local date value in the default format, if
     * the format is wrong, an exception is caught and a message is sent.
     *
     * @return
     */
    public static LocalDate getLocalDate() {
        LocalDate localDate = null;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            localDate = LocalDate.parse(input);
        } catch (Exception e) {
            System.err.println("Invalid date format. Please enter a date in the format YYYY-MM-DD.");
        }
        return localDate;
    }

    /**
     * Receives the many inputs for the Contact class builder, those inputs are
     * using methods from this very class, and each time it is asked for, it
     * will repeat until the input is correct.
     *
     * @return
     */
    public static Contact getContact() {
        Scanner scanner = new Scanner(System.in);
        String city, state, country, street, zipCode, phone;
        int nDoor;

        do {
            try {
                System.out.println("Enter the city's name:\n");
                city = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                city = null;
            }
        } while (city == null);

        do {
            try {
                System.out.println("Enter the state's name:\n");
                state = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                state = null;
            }
        } while (state == null);

        do {
            try {
                System.out.println("Enter the country's name:\n");
                country = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                country = null;
            }
        } while (country == null);

        do {
            try {
                System.out.println("Enter the street's name:\n");
                street = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                street = null;
            }
        } while (street == null);

        do {
            try {
                System.out.println("Enter the Zip Code:\n");
                zipCode = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                zipCode = null;
            }
        } while (zipCode == null);

        do {
            try {
                System.out.println("Enter the Door's number:\n");
                nDoor = getInt();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                nDoor = -1;
            }
        } while (nDoor == -1);

        do {
            try {
                System.out.println("Enter the Phone number:\n");
                phone = getString();
                if (!phone.matches("[0-9]+")) {
                    System.err.println("Phone number cannot contain letters.");
                    throw new IOException();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                phone = null;
            }
        } while (phone == null);

        Contact contact = new Contact(city, state, country, street, zipCode, nDoor, phone);
        return contact;
    }

    /**
     * Receives the many inputs for the Task class builder, those inputs are
     * using methods from this very class, and each time it is asked for, it
     * will repeat until the input is correct.
     *
     * @return
     */
    public static Task getTask() {
        String title, description;
        LocalDate start, end;
        int duration, extendedDeadLine;

        do {
            try {
                System.out.println("Enter the Task title:\n");
                title = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                title = null;
            }
        } while (title == null);

        do {
            try {
                System.out.println("Enter the Task description:\n");
                description = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                description = null;
            }
        } while (description == null);

        do {
            System.out.println("Enter the starting date of the Task: "
                    + "(YYYY-MM-DD)\n");
            try {
                start = UserInput.getLocalDate();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                start = null;
            }
        } while (start == null);

        do {
            System.out.println("Enter the finishing date of the Task: "
                    + "(YYYY-MM-DD)\n");
            try {
                end = UserInput.getLocalDate();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                end = null;
            }
        } while (end == null);

        do {
            try {
                System.out.println("Enter the Task extended dead line:\n");
                duration = getInt();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                duration = -1;
            }
        } while (duration == -1);

        do {
            try {
                System.out.println("Enter the Task duration:\n");
                extendedDeadLine = getInt();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                extendedDeadLine = -1;
            }
        } while (extendedDeadLine == -1);

        Task task = new Task(title, description, start, end, duration, extendedDeadLine);
        return task;
    }
}
