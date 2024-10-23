import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Prescription {
    private String firstName;
    private String lastName;
    private String address;
    private double sphere;
    private double cylinder;
    private int axis;
    private String examDate;
    private String optometrist;
    List<String> remarks = new ArrayList<>();
    final int MAX_REMARKS = 2;

    // Constructor
    public Prescription(String firstName, String lastName, String address, double sphere,
                        double cylinder, int axis, String examDate, String optometrist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.examDate = examDate;
        this.optometrist = optometrist;
    }

    // Function to validate and add a prescription
    public boolean addPrescription() throws IOException {
        if (!validateName(firstName, lastName)) return false;
        if (!validateAddress(address)) return false;
        if (!validateSphere(sphere) || !validateCylinder(cylinder) || !validateAxis(axis)) return false;
        if (!validateExamDate(examDate)) return false;
        if (!validateOptometrist(optometrist)) return false;

        // Write to TXT file if valid
        try (FileWriter writer = new FileWriter("presc.txt", true)) {
            writer.write(this.toString() + "\n");
            return true;
        }
    }

    // Function to validate and add a remark
    public boolean addRemark(String remark, String category) throws IOException {
        if (!validateRemark(remark)) return false;
        if (!validateCategory(category)) return false;
        if (remarks.size() >= MAX_REMARKS) return false;

        remarks.add(remark);
        try (FileWriter writer = new FileWriter("review.txt", true)) {
            writer.write("Remark: " + remark + " | Category: " + category + "\n");
            return true;
        }
    }

    // Validation functions
    private boolean validateName(String firstName, String lastName) {
        return firstName.length() >= 4 && firstName.length() <= 15 &&
                lastName.length() >= 4 && lastName.length() <= 15;
    }

    private boolean validateAddress(String address) {
        return address.length() >= 20;
    }

    private boolean validateSphere(double sphere) {
        return sphere >= -20.00 && sphere <= 20.00;
    }

    private boolean validateCylinder(double cylinder) {
        return cylinder >= -4.00 && cylinder <= 4.00;
    }

    private boolean validateAxis(int axis) {
        return axis >= 0 && axis <= 180;
    }

    private boolean validateExamDate(String examDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        sdf.setLenient(false);
        try {
            sdf.parse(examDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean validateOptometrist(String optometrist) {
        return optometrist.length() >= 8 && optometrist.length() <= 25;
    }

    private boolean validateRemark(String remark) {
        String[] words = remark.trim().split("\\s+");
        return words.length >= 6 && words.length <= 20 && Character.isUpperCase(remark.charAt(0));
    }

    private boolean validateCategory(String category) {
        return category.equals("client") || category.equals("optometrist");
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", sphere=" + sphere +
                ", cylinder=" + cylinder +
                ", axis=" + axis +
                ", examDate='" + examDate + '\'' +
                ", optometrist='" + optometrist + '\'' +
                '}';
    }
}
