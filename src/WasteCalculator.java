class WasteCalculator extends WasteComparator {
    @Override
    public double compareWaste(double individualWaste, double industrialWaste) throws ComparisonException {
        if (industrialWaste == 0) {
            throw new ComparisonException("Industrial waste cannot be zero for comparison.");
        }
        return (individualWaste / industrialWaste) * 100;
    }

    @Override
    public String toString() {
        return "WasteCalculator: Compares individual and industrial waste to find percentage contribution.";
    }
}