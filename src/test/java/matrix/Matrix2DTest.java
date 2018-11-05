package matrix;

import org.junit.Test;
import static org.junit.Assert.*;
import utils.Utils;

public class Matrix2DTest {

  @Test public void addVector_AppendsVector() {
    Matrix2D matrix = new Matrix2D();
    double x = 1;
    double y = 2;
    matrix.addVector(x, y);
    assertEquals(matrix.xValues.get(0), x, Utils.DOUBLE_ASSERT_EQUALS_PERCISION);
    assertEquals(matrix.yValues.get(0), y, Utils.DOUBLE_ASSERT_EQUALS_PERCISION);
  }

  @Test public void addVector_IncrementsLength() {
    Matrix2D matrix = new Matrix2D();
    assertEquals(matrix.length, 0);

    double x = 1;
    double y = 2;
    matrix.addVector(x, y);
    assertEquals(matrix.length, 1);

    matrix.addVector(x, y);
    assertEquals(matrix.length, 2);

    matrix.addVector(x, y);
    assertEquals(matrix.length, 3);
  }

  @Test public void addVector_ReturnsCorrectReferenceIndex() {
    Matrix2D matrix = new Matrix2D();

    double[] expectedXValues = new double[]{1, 2, 3};
    double[] expectedYValues = new double[]{4, 5, 6};
    for (
      int expectedReferenceIndex = 0;
      expectedReferenceIndex < expectedXValues.length;
      expectedReferenceIndex++
    ) {
      double x = expectedXValues[expectedReferenceIndex];
      double y = expectedYValues[expectedReferenceIndex];
      int referenceIndex = matrix.addVector(x, y);
      assertEquals(referenceIndex, expectedReferenceIndex);
      assertEquals(
        matrix.xValues.get(referenceIndex),
        x,
        Utils.DOUBLE_ASSERT_EQUALS_PERCISION
      );
      assertEquals(
        matrix.yValues.get(referenceIndex),
        y,
        Utils.DOUBLE_ASSERT_EQUALS_PERCISION
      );
    }
  }

  @Test public void addVector_ReturnsOverwriteableVector() {
    Matrix2D matrix = new Matrix2D();

    matrix.addVector(1, 2);
    matrix.addVector(3, 4);
    matrix.addVector(5, 6);

    int expectedReferenceIndex = 1;
    matrix.overwriteableVectors.add(expectedReferenceIndex);

    double x = 7;
    double y = 8;
    int referenceIndex = matrix.addVector(x, y);
    assertEquals(referenceIndex, expectedReferenceIndex);
    assertEquals(
      matrix.xValues.get(referenceIndex),
      x,
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      matrix.yValues.get(referenceIndex),
      y,
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void addVector_RemovesOverwriteableVector() {
    Matrix2D matrix = new Matrix2D();

    matrix.addVector(1, 2);
    matrix.addVector(3, 4);
    matrix.addVector(5, 6);

    int expectedReferenceIndex = 1;
    matrix.overwriteableVectors.add(expectedReferenceIndex);

    int referenceIndex = matrix.addVector(0, 0);

    assertTrue(matrix.overwriteableVectors.isEmpty());
  }

  @Test public void removeVector_AddsToOverwriteableVectors() {
    Matrix2D matrix = new Matrix2D();

    matrix.addVector(1, 2);
    matrix.removeVector(0);
    assertEquals((int) matrix.overwriteableVectors.get(0), 0);
  }

  @Test public void removeVector_ThrowsIndexOutOfBoundsException() {
    Matrix2D matrix = new Matrix2D();

    try {
      matrix.removeVector(0);
      fail();
    } catch(IndexOutOfBoundsException err) {}

    matrix.addVector(1, 2);
    matrix.addVector(3, 4);
    matrix.addVector(5, 6);

    try {
      matrix.removeVector(3);
      fail();
    } catch(IndexOutOfBoundsException err) {}
  }
}
