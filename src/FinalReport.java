<<<<<<< HEAD
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FinalReport extends ReportGenerator {
    private String content;

    public FinalReport(String content) {
        this.content = content;
    }

    @Override
    public void generateReport() {
        String fileName = "water_waste_report.txt"; // File name
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content); // Write content to file
            System.out.println("\nThe report has been successfully saved to " + fileName + " in the current directory.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing the report to a file: " + e.getMessage());
        }
    }
}
=======
public class FinalReport extends ReportGenerator{

    @Override
    public void generateReport() {
        
    }
}
>>>>>>> 59f8f0c00d4adae0f9654c9a1ccf22f7ea27d8e1
