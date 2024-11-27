import java.util.HashSet;
import java.util.Set;

class IndustrialWater extends WaterThing implements Calculate, Addable, Clearable {
    private Set<Double> industrialProcesses;

    public IndustrialWater(double waterAmount) {
        super(waterAmount);
        this.industrialProcesses = new HashSet<>();
    }

    @Override
    public void addWaste(double waste) {
        industrialProcesses.add(waste);
    }

    @Override
    public void addWaste(double... wastes) { // Overloaded method
        for (double waste : wastes) {
            industrialProcesses.add(waste);
        }
    }

    @Override
    public void clearWaste() {
        industrialProcesses.clear();
        setWaterAmount(0);
    }

    @Override
    public double calculateWaste() throws InvalidWasteException {
        double total = industrialProcesses.stream().mapToDouble(Double::doubleValue).sum();
        if (total <= 0) {
            throw new InvalidWasteException("Industrial waste cannot be zero or negative.");
        }
        setWaterAmount(total);
        return total;
    }

    @Override
    public String getType() {
        return "Industrial";
    }

    @Override
    public String toString() {
        return super.toString() + ", Industrial Processes Waste: " + industrialProcesses;
    }
}
