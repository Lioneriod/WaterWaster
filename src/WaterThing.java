abstract class WaterThing {
    // The main abstract class with things we will on both our "normal" classes
    private double waterAmount;

    public WaterThing(double waterAmount) {
        this.waterAmount = waterAmount;
    }

    public double getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(double waterAmount) {
        this.waterAmount = waterAmount;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Type: " + getType() + ", Water Amount: " + waterAmount + " liters";
    }
}