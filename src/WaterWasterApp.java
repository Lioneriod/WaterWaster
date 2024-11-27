import java.util.Scanner;
public class WaterWasterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            PersonWater person = new PersonWater(0);

            System.out.println("Answer the following questions about your daily water usage:");
            System.out.println("1. Do you usually take 5-minute showers? (yes/no)");
            String shower = scanner.nextLine().trim().toLowerCase();
            if (shower.equals("yes")) {
                person.addWaste("showering for 5 minutes", 90);
            } else if (shower.equals("no")) {
                person.addWaste("showering for more than 5 minutes", 130);
            }

            System.out.println("2. Do you flush the toilet once? (yes/no)");
            String flush = scanner.nextLine().trim().toLowerCase();
            if (flush.equals("yes")) {
                person.addWaste("one toilet flush", 9);
            } else if (flush.equals("no")) {
                person.addWaste("more than one toilet flush", 18);
            }

            System.out.println("3. Do you leave the tap running while brushing your teeth? (yes/no)");
            String brushing = scanner.nextLine().trim().toLowerCase();
            if (brushing.equals("yes")) {
                person.addWaste("Tap running while brushing teeth", 24);
            } else if (brushing.equals("no")) {
                person.addWaste("Tap not running while brushing teeth", 3);
            }

            System.out.println("4. Do you wash your dishes under a running tap? (yes/no)");
            String dishes = scanner.nextLine().trim().toLowerCase();
            if (dishes.equals("yes")) {
                person.addWaste("Washing dishes under running tap", 100);
            } else if (dishes.equals("no")) {
                person.addWaste("Washing dishes not under running tap/Dishwasher", 30);
            }

            System.out.println("5. Do you water your garden/lawn? (yes/no)");
            String garden = scanner.nextLine().trim().toLowerCase();
            if (garden.equals("yes")) {
                person.addWaste("Watering garden", 100);
            } else if (garden.equals("no")) {
                person.addWaste("Not watering garden/No garden", 0);
            }

            person.calculateWaste();

            IndustrialWater industrial = new IndustrialWater(0);
            industrial.addWaste("Sample of use", 1);
            industrial.addWaste("Industrial global value", 19178082191.0 - 1);
            industrial.calculateWaste();

            WasteCalculator calculator = new WasteCalculator();
            double percentage = calculator.compareWaste(person.getWaterAmount(), industrial.getWaterAmount());

            // Prepare report
            Yappers yappers = new Yappers();
            yappers.addSection(person.toString());
            yappers.addSection(industrial.toString());
            yappers.addSection("Your waste makes up " + String.format("%.2f", percentage) + "% of the daily total waste.");
            yappers.addEducationalSection(); // Add the educational information

            // Generate file
            FinalReport finalReport = new FinalReport(yappers.getReportContent());
            finalReport.generateReport();

            // Print to console
            yappers.generateReport();

            person.clearWaste();
            industrial.clearWaste();

            System.out.println("Reset Test!\nIndustrial: " + industrial + "\nPerson: " + person);
        } catch (InvalidWasteException e) {
            System.err.println("\nValidation Error: " + e.getMessage());
        } catch (ComparisonException e) {
            System.err.println("\nComparison Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
