public class Yappers extends ReportGenerator {
    private StringBuilder reportContent;

    public Yappers() {
        this.reportContent = new StringBuilder();
    }

    public void addSection(String section) {
        reportContent.append(section).append("\n");
    }

    public void addEducationalSection() {
        reportContent.append("\n\nWorldwide, agriculture alone consumes 70% of the world's freshwater, while households account for around 10%.\n")
                .append("\nIn Brazil alone, we use up to 7 trillion liters annually, 19 billion per day on agriculture.\n")
                .append("\nCan you even imagine how much is that? Here in Brazil, half of the water consumption is for the population, the other half is the industry.\n")
                .append("\nSure, we use that to make food. But have you ever considered how much is wasted?\n")
                .append("\nCassava (Mandioca)? 216% goes to the trash. Corn? 109%. Soy? That one that they burn our forest for? 150%.\n")
                .append("\nAll this food, that could be used to save people on the street, going into the trash for not being pretty enough.\n")
                .append("\nAnd we didn't even talk about half of the water used being wasted by lack of maintenance on pipes and water supplies.\n")
                .append("\nAnd as an extra, now that water is full of poisonous fluids. And it's going back to you...\n")
                .append("\nTaking that 5 min bath ain't gonna do shit. Get up and support some actual causes before it's over.\n\n");
    }

    public String getReportContent() {
        return reportContent.toString();
    }

    @Override
    public void generateReport() {
        System.out.println("\n--- Final Report ---");
        System.out.println(reportContent);
    }
}
