class InvalidWasteException extends Exception {
  // Gonna use this one on both "normal" classes, in case the user ends up putting some weird shit
  public InvalidWasteException(String message) {
    super(message);
  }

  @Override
  public String toString() {
    return "InvalidWasteException: " + getMessage();
  }
}