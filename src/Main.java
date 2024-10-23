import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Collecting prescription details from the user
            System.out.println("Enter patient's first name:");
            String firstName = scanner.nextLine();

            System.out.println("Enter patient's last name:");
            String lastName = scanner.nextLine();

            System.out.println("Enter patient's address:");
            String address = scanner.nextLine();

            System.out.println("Enter sphere (between -20.00 and 20.00):");
            double sphere = scanner.nextDouble();

            System.out.println("Enter cylinder (between -4.00 and 4.00):");
            double cylinder = scanner.nextDouble();

            System.out.println("Enter axis (between 0 and 180):");
            int axis = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.println("Enter exam date (dd/MM/yy):");
            String examDate = scanner.nextLine();

            System.out.println("Enter optometrist's name:");
            String optometrist = scanner.nextLine();

            // Create a Prescription object with user input
            Prescription prescription = new Prescription(firstName, lastName, address, sphere, cylinder, axis, examDate, optometrist);

            // Attempt to add the prescription
            if (prescription.addPrescription()) {
                System.out.println("Prescription added successfully.");
            } else {
                System.out.println("Failed to add prescription. Please check your input.");
                return;
            }

            // Asking if the user wants to add remarks
            System.out.println("Would you like to add a remark? (yes/no):");
            String addRemarkResponse = scanner.nextLine();

            while (addRemarkResponse.equalsIgnoreCase("yes")) {
                // Collect remark and category
                System.out.println("Enter your remark (6 to 20 words, start with uppercase):");
                String remark = scanner.nextLine();

                System.out.println("Enter category (client/optometrist):");
                String category = scanner.nextLine();

                // Attempt to add the remark
                if (prescription.addRemark(remark, category)) {
                    System.out.println("Remark added successfully.");
                } else {
                    System.out.println("Failed to add remark. Please check your input.");
                }

                // Ask again if user wants to add another remark (maximum 2)
                if (prescription.remarks.size() >= prescription.MAX_REMARKS) {
                    System.out.println("Maximum number of remarks reached.");
                    break;
                }

                System.out.println("Would you like to add another remark? (yes/no):");
                addRemarkResponse = scanner.nextLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to files: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
