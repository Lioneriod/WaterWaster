class ComparisonException extends Exception {
  public ComparisonException(String message) {
    super(message);
  }

  @Override
  public String toString() {
    return "ComparisonException: " + getMessage();
  }
}