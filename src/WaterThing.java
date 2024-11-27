abstract class WaterThing {
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