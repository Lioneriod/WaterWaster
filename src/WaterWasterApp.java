import java.util.Scanner;

public class WaterWasterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            PersonWater person = new PersonWater(0);

            System.out.println("Answer the following questions about your daily water usage:");
            System.out.println("1. Do you take a 5-minute shower? (yes/no)");
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

            System.out.println("\n--- Waste Report ---");
            System.out.println(person);
            System.out.println(industrial);
            System.out.println("Your waste makes up " + String.format("%.2f", percentage) + "% of the daily total waste.");
            System.out.println("\n\nWorldwide, agriculture alone consumes 70% of the world's freshwater, while households account for around 10%");
            System.out.println("\nIn Brazil alone, we use up to 7 trillion liters annually, 19 billion per day on agriculture");
            System.out.println("\nCan you even imagine how much is that? Here in Brazil, half of the water consumption is for the population, the other half is the industry.");
            System.out.println("\nSure, we use that to make food. But have you ever considered how much is wasted?");
            System.out.println("\nCassava(Mandioca)? 216% goes to the trash. Corn? 109%. Soy? That one that they burn our forest for? 150%");
            System.out.println("\nAll this food, that could be used to save people on the street, going into the trash for not being pretty enough");
            System.out.println("\nAnd we didn't even talk about half of the water used being wasted by lack of maintenance on pipes and water supplies.");
            System.out.println("\nAnd as an extra, now that water is full of poisonous fluids. And it's going back to you...");
            System.out.println("\nTaking that 5 min bath ain't gonna do shit. Get up and support some actual causes before it's over\n\n");
            person.clearWaste();
            industrial.clearWaste();
            System.out.println("And here's the reset test!\nIndustrial: " + industrial + "\nPerson: " + person);
        } catch (InvalidWasteException e) {
            System.err.println("\nValidation Error: " + e.getMessage());
        } catch (ComparisonException e) {
            System.err.println("\nComparison Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
