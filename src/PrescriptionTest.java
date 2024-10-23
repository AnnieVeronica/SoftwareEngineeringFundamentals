import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;

public class PrescriptionTest {

    @Test
    public void testValidRemark() throws IOException {
        Prescription p = new Prescription("John", "Smith",
                "1234 Maple Street, Dallas, TX 75001, USA",
                0.00, -2.00, 90, "12/10/22", "Dr. Anderson");
        assertTrue(p.addRemark("This prescription is accurate and complete.", "client"));
    }

    @Test
    public void testInvalidRemarkTooShort() throws IOException {
        Prescription p = new Prescription("John", "Smith",
                "1234 Maple Street, Dallas, TX 75001, USA",
                0.00, -2.00, 90, "12/10/22", "Dr. Anderson");
        assertFalse(p.addRemark("Very clear.", "optometrist"));
    }

    @Test
    public void testInvalidRemarkTooLong() throws IOException {
        Prescription p = new Prescription("John", "Smith",
                "1234 Maple Street, Dallas, TX 75001, USA",
                0.00, -2.00, 90, "12/10/22", "Dr. Anderson");
        assertFalse(p.addRemark("The prescription is very detailed and provides a clear understanding of the corrective measures needed.", "client"));
    }

    @Test
    public void testInvalidRemarkFirstWord() throws IOException {
        Prescription p = new Prescription("John", "Smith",
                "1234 Maple Street, Dallas, TX 75001, USA",
                0.00, -2.00, 90, "12/10/22", "Dr. Anderson");
        assertFalse(p.addRemark("this prescription is correct.", "client"));
    }

    @Test
    public void testInvalidCategory() throws IOException {
        Prescription p = new Prescription("John", "Smith",
                "1234 Maple Street, Dallas, TX 75001, USA",
                0.00, -2.00, 90, "12/10/22", "Dr. Anderson");
        assertFalse(p.addRemark("This prescription is good.", "patient"));
    }

    @Test
    public void testExceedRemarkLimit() throws IOException {
        Prescription p = new Prescription("John", "Smith",
                "1234 Maple Street, Dallas, TX 75001, USA",
                0.00, -2.00, 90, "12/10/22", "Dr. Anderson");
        // Assume two remarks already exist
        assertFalse(p.addRemark("This prescription needs review.", "optometrist"));
    }
    @Test
    public void testValidPrescription() throws IOException {
        Prescription p = new Prescription("John", "Smith",
                "1234 Maple Street, Dallas, TX 75001, USA",
                0.00, -2.00, 90, "12/10/22", "Dr. Anderson");
        assertTrue(p.addPrescription());
    }

    @Test
    public void testInvalidFirstName() throws IOException {
        Prescription p = new Prescription("Jo", "Smith",
                "1234 Maple Street, Dallas, TX 75001, USA",
                -5.50, -1.25, 120, "02/07/23", "Dr. Brown");
        assertFalse(p.addPrescription());
    }

    @Test
    public void testInvalidAddress() throws IOException {
        Prescription p = new Prescription("Maria", "Lopez",
                "123 Elm St.", +3.25, -1.00, 150, "01/03/24", "Dr. Miller");
        assertFalse(p.addPrescription());
    }

    @Test
    public void testInvalidSphereValue() throws IOException {
        Prescription p = new Prescription("Alexis", "Reed",
                "456 Oak Lane, San Diego, CA 92101, USA",
                -22.50, +1.00, 80, "15/04/23", "Dr. O'Brien");
        assertFalse(p.addPrescription());
    }

    @Test
    public void testInvalidExamDate() throws IOException {
        Prescription p = new Prescription("Lisa", "Jordan",
                "5677 Cherry Drive, Miami, FL 33101, USA",
                -2.75, -0.50, 45, "2023/05/30", "Dr. Patel");
        assertFalse(p.addPrescription());
    }

    @Test
    public void testInvalidOptometristName() throws IOException {
        Prescription p = new Prescription("James", "Turner",
                "782 Birch Road, Houston, TX 77002, USA",
                +1.50, 0.00, 10, "30/11/22", "Pat");
        assertFalse(p.addPrescription());
    }

}
