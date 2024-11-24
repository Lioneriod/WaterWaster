import java.util.Scanner;

public class WaterWasterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // We are going for an interactive quiz mode boys!!
        try { // Hoping to god this shit works this time (ignore the yellow line lol)
            PersonWater person = new PersonWater(0); // To keep adding liters with each answer

            System.out.println("Answer the following questions about your daily water usage:");
            // Quiz questions and water waste amounts
            System.out.println("1. Do you take a 5-minute shower? (yes/no)");
            String shower = scanner.nextLine().trim().toLowerCase();
            if (shower.equals("yes")) {
                person.addDailyWaste(90); // 90 liters for a 5min shower
            } else if (shower.equals("no")) {
                person.addDailyWaste(130); // 130 liters for a +5min shower
            }

            System.out.println("2. Do you flush the toilet once? (yes/no)");
            String flush = scanner.nextLine().trim().toLowerCase();
            if (flush.equals("yes")) {
                person.addDailyWaste(9); // 9 liters per flush
            } else if (flush.equals("no")) {
                person.addDailyWaste(18); // Let's go for 2 flushes in this case
            }

            System.out.println("3. Do you leave the tap running while brushing your teeth? (yes/no)");
            String brushing = scanner.nextLine().trim().toLowerCase();
            if (brushing.equals("yes")) {
                person.addDailyWaste(24); // Usually if you leave, it is 6 litters per min, so 24 litters at least
            } else if (brushing.equals("no")) {
                person.addDailyWaste(3); // Not sure on how much to put here lmao
            }

            System.out.println("4. Do you wash your dishes under a running tap? (yes/no)");
            String dishes = scanner.nextLine().trim().toLowerCase();
            if (dishes.equals("yes")) {
                person.addDailyWaste(100); // The average is about 100 liters per washing session
            } else if (dishes.equals("no")) {
                person.addDailyWaste(30); // In this case, let's go for dishwasher numbers!
            }

            System.out.println("5. Do you water your garden/lawn? (yes/no)");
            String garden = scanner.nextLine().trim().toLowerCase();
            if (garden.equals("yes")) {
                person.addDailyWaste(100); // Approx 100 liters per watering session
            } else if (garden.equals("no")) {
                person.addDailyWaste(0); // Yeah... No other option on this one for wasting lol
            }

            person.calculateWaste();

            // Industrial Waste Data: After some searches on Google, I settled for these values
            IndustrialWater industrial = new IndustrialWater(0); // Now I can just add value to it
            industrial.addProcessWaste(1); // Example of it working
            industrial.addProcessWaste(19178082191.0-1);  // Actual value this time lmao (minus 1 just in case)
            industrial.calculateWaste();

            // Comparison made using the gets on a calculator and addressing it to each percentage.
            WasteCalculator calculator = new WasteCalculator();
            double percentage = calculator.compareWaste(person.getWaterAmount(), industrial.getWaterAmount());
            // Reporting...
            System.out.println("\n--- Waste Report ---");
            System.out.println(person);
            System.out.println(industrial);
            System.out.println("Your waste makes up " + String.format("%.2f", percentage) + "% of the daily total waste.");
            // It's yapping time lol
            System.out.println("\n\nWorldwide, agriculture alone consumes 70% of the world's freshwater, while households account for around 10%");
            System.out.println("\nIn Brazil alone, we use up to 7 trillion liters annually, 19 billions per day on agriculture");
            System.out.println("\nCan you even imagine how much water is that? Here in Brazil, half of the water consumption is for the population, the other half is the industry.");
            System.out.println("\nSure, we use that to make food. But have you ever considered how much is wasted?");
            System.out.println("\nCassava(Mandioca)? 216% goes to the trash. Corn? 109%. Soy? That one that they burn our forest for? 150%");
            System.out.println("\nAll this food, that could be used to save people on the street, going into the trash for not being pretty enough");
            System.out.println("\nAnd we didn't even talk about half of the water used being wasted by lack of maintenance on pipes and water supplies.");
            System.out.println("\nAnd as an extra, now that water is full of poisonous fluids. And it's going back to you...");
            System.out.println("\nTaking that 5 min bath ain't gonna do shit. Get up and support some actual causes before it's over");
        } catch (InvalidWasteException e) {
            System.err.println("\nValidation Error: " + e.getMessage());
        } catch (ComparisonException e) {
            System.err.println("\nComparison Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
