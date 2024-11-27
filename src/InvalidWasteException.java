class InvalidWasteException extends Exception {
  public InvalidWasteException(String message) {
    super(message);
  }

  @Override
  public String toString() {
    return "InvalidWasteException: " + getMessage();
  }
}