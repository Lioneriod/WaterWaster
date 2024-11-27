import java.util.ArrayList;
import java.util.List;

class PersonWater extends WaterThing implements Calculate, Addable, Clearable {
    private List<Double> dailyWaste;

    public PersonWater(double waterAmount) {
        super(waterAmount);
        this.dailyWaste = new ArrayList<>();
    }

    @Override
    public void addWaste(double waste) {
        dailyWaste.add(waste);
    }

    @Override
    public void addWaste(double... wastes) { // Overloaded method
        for (double waste : wastes) {
            dailyWaste.add(waste);
        }
    }

    @Override
    public void clearWaste() {
        dailyWaste.clear();
        setWaterAmount(0);
    }

    @Override
    public double calculateWaste() throws InvalidWasteException {
        double total = dailyWaste.stream().mapToDouble(Double::doubleValue).sum();
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
        return super.toString() + ", Daily Waste Records: " + dailyWaste;
    }
}
