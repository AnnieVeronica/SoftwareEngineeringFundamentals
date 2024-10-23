import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create a new prescription instance
        Prescription prescription = new Prescription(1, "John", "Doe", "123 Main St",
                1.50f, 90.0f, -0.50f,
                new Date(), "Dr. Smith");

        // Add the prescription to the file
        if (prescription.addPrescription()) {
            System.out.println("Prescription added successfully.");
        } else {
            System.out.println("Failed to add prescription.");
        }

        // Add a valid remark
        if (prescription.addRemark("Patient is improving.", "Client")) {
            System.out.println("Remark added successfully.");
        } else {
            System.out.println("Failed to add remark.");
        }

        // Add an invalid remark type
        if (prescription.addRemark("Wrong remark type", "Unknown")) {
            System.out.println("Remark added successfully.");
        } else {
            System.out.println("Failed to add remark due to invalid type.");
        }
    }
}
