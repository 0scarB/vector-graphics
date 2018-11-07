package exception;

public class NumberRangeException extends IllegalArgumentException {

  public NumberRangeException(String valueName, int min, int max) {
    super(NumberRangeException.getNumberRangeExceptionMessage(
      valueName, Integer.toString(min), Integer.toString(max)
    ));
  }

  public NumberRangeException(String valueName, double min, double max) {
    super(NumberRangeException.getNumberRangeExceptionMessage(
      valueName, Double.toString(min), Double.toString(max)
    ));
  }

  private static String getNumberRangeExceptionMessage(
    String valueName, String min, String max
  ) {
    return (
      "The value of \"" + valueName + "\" must be in the range \""
      + min + " <= " + valueName + " <= " + max + "\"!"
    );
  }
}
