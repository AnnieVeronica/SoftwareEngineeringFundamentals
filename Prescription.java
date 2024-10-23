import java.util.ArrayList;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;
    private ArrayList<String> postRemarks;

    // Constructor
    public Prescription(int prescID, String firstName, String lastName, String address,
                        float sphere, float axis, float cylinder, Date examinationDate,
                        String optometrist) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.axis = axis;
        this.cylinder = cylinder;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
        this.postRemarks = new ArrayList<>();
    }

    // Method to add a prescription to a TXT file
    public boolean addPrescription() {
        try {
            FileWriter writer = new FileWriter("presc.txt", true);
            writer.write("Prescription ID: " + prescID + "\n");
            writer.write("Name: " + firstName + " " + lastName + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Sphere: " + sphere + "\n");
            writer.write("Axis: " + axis + "\n");
            writer.write("Cylinder: " + cylinder + "\n");
            writer.write("Examination Date: " + examinationDate + "\n");
            writer.write("Optometrist: " + optometrist + "\n\n");
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to add remarks to the prescription
    public boolean addRemark(String remark, String type) {
        // Only allow "Client" or "Optometrist" remark types
        if (!type.equals("Client") && !type.equals("Optometrist")) {
            return false;
        }
        postRemarks.add(remark);

        try {
            FileWriter writer = new FileWriter("remark.txt", true);
            writer.write("Remark Type: " + type + "\n");
            writer.write("Remark: " + remark + "\n\n");
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
