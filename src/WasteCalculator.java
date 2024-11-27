class WasteCalculator extends WasteComparator {
    @Override
    public double compareWaste(double personWaste, double industrialWaste) throws ComparisonException {
        if (industrialWaste == 0) {
            throw new ComparisonException("Industrial waste cannot be zero for comparison.");
        }
        return (personWaste / industrialWaste) * 100;
    }

    @Override
    public String toString() {
        return "WasteCalculator: Compares individual and industrial waste to find percentage contribution.";
    }
}