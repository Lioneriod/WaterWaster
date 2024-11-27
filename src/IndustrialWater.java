<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;

class IndustrialWater extends WaterThing implements Calculate, Addable, Clearable {
    private Set<Double> industrialSet;

    public IndustrialWater(double waterAmount) {
        super(waterAmount);
        this.industrialSet = new HashSet<>();
    }

    @Override
    public void addWaste(double waste) {
        industrialSet.add(waste);
    }

    public void addWaste(String wasteName, double wasteAmount) {
        System.out.println("Adding " + wasteName + " with an amount of " + wasteAmount + " liters.");
        industrialSet.add(wasteAmount);
    }

    @Override
    public void clearWaste() {
        industrialSet.clear();
        setWaterAmount(0);
    }

    @Override
    public double calculateWaste() throws InvalidWasteException {
        double total = industrialSet.stream().mapToDouble(Double::doubleValue).sum();
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
        return super.toString() + ", Industrial Processes Waste: " + industrialSet;
    }
}
=======
import java.util.HashSet;
import java.util.Set;

class IndustrialWater extends WaterThing implements Calculate, Addable, Clearable {
    private Set<Double> industrialSet;

    public IndustrialWater(double waterAmount) {
        super(waterAmount);
        this.industrialSet = new HashSet<>();
    }

    @Override
    public void addWaste(double waste) {
        industrialSet.add(waste);
    }

    public void addWaste(String wasteName, double wasteAmount) {
        System.out.println("Adding " + wasteName + " with an amount of " + wasteAmount + " liters.");
        industrialSet.add(wasteAmount);
    }

    @Override
    public void clearWaste() {
        industrialSet.clear();
        setWaterAmount(0);
    }

    @Override
    public double calculateWaste() throws InvalidWasteException {
        double total = industrialSet.stream().mapToDouble(Double::doubleValue).sum();
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
        return super.toString() + ", Industrial Processes Waste: " + industrialSet;
    }
}
>>>>>>> 59f8f0c00d4adae0f9654c9a1ccf22f7ea27d8e1
