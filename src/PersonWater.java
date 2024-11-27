import java.util.ArrayList;
import java.util.List;

class PersonWater extends WaterThing implements Calculate, Addable, Clearable {
    private List<Double> wasteList;

    public PersonWater(double waterAmount) {
        super(waterAmount);
        this.wasteList = new ArrayList<>();
    }

    @Override
    public void addWaste(double waste) {
        wasteList.add(waste);
    }

    public void addWaste(String wasteName, double wasteAmount) {
        System.out.println("Adding " + wasteName + " with an amount of " + wasteAmount + " liters.");
        wasteList.add(wasteAmount);
    }

    @Override
    public void clearWaste() {
        wasteList.clear();
        setWaterAmount(0);
    }

    @Override
    public double calculateWaste() throws InvalidWasteException {
        double total = wasteList.stream().mapToDouble(Double::doubleValue).sum();
        if (total <= 0) {
            throw new InvalidWasteException("Total waste cannot be zero or negative.");
        }
        setWaterAmount(total);
        return total;
    }

    @Override
    public String getType() {
        return "Individual";
    }

    @Override
    public String toString() {
        return super.toString() + ", Daily Waste Records: " + wasteList;
    }
}
