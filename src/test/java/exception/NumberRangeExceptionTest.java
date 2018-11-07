package exception;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberRangeExceptionTest {

  @Test public void NumberRangeException_CorrectStackTraceStringIntInt() {
    IllegalArgumentException numberRangeException = new NumberRangeException(
      "x", 1, 2
    );
    String expectedExceptionMessage = (
      "exception.NumberRangeException: "
      + "The value of \"x\" must be in the range \"1 <= x <= 2\"!"
    );

    try {
      throw numberRangeException;
    } catch(IllegalArgumentException e) {
      assertEquals(e.toString(), expectedExceptionMessage);
    }
    try {
      throw numberRangeException;
    } catch(NumberRangeException e) {
      assertEquals(e.toString(), expectedExceptionMessage);
    }
  }

  @Test public void NumberRangeException_CorrectStackTraceStringDoubleDouble() {
    IllegalArgumentException numberRangeException = new NumberRangeException(
      "x", 1.1, 2.1
    );
    String expectedExceptionMessage = (
      "exception.NumberRangeException: "
      + "The value of \"x\" must be in the range \"1.1 <= x <= 2.1\"!"
    );

    try {
      throw numberRangeException;
    } catch(IllegalArgumentException e) {
      assertEquals(e.toString(), expectedExceptionMessage);
    }
    try {
      throw numberRangeException;
    } catch(NumberRangeException e) {
      assertEquals(e.toString(), expectedExceptionMessage);
    }
  }
}
