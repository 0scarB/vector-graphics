package geometry;

import org.junit.Test;
import static org.junit.Assert.*;
import utils.Utils;

public class PointMatrixTest {

  @Test public void addPoint_AppendsPoint() {
    PointMatrix matrix = new PointMatrix();
    double x = 1;
    double y = 2;
    matrix.addPoint(x, y);
    assertEquals(matrix.xValues.get(0), x, Utils.DOUBLE_ASSERT_EQUALS_PERCISION);
    assertEquals(matrix.yValues.get(0), y, Utils.DOUBLE_ASSERT_EQUALS_PERCISION);
  }

  @Test public void addPoint_IncrementsLength() {
    PointMatrix matrix = new PointMatrix();
    assertEquals(matrix.length, 0);

    double x = 1;
    double y = 2;
    matrix.addPoint(x, y);
    assertEquals(matrix.length, 1);

    matrix.addPoint(x, y);
    assertEquals(matrix.length, 2);

    matrix.addPoint(x, y);
    assertEquals(matrix.length, 3);
  }

  @Test public void addPoint_ReturnsCorrectReferenceIndex() {
    PointMatrix matrix = new PointMatrix();

    double[] expectedXValues = new double[]{1, 2, 3};
    double[] expectedYValues = new double[]{4, 5, 6};
    for (
      int expectedReferenceIndex = 0;
      expectedReferenceIndex < expectedXValues.length;
      expectedReferenceIndex++
    ) {
      double x = expectedXValues[expectedReferenceIndex];
      double y = expectedYValues[expectedReferenceIndex];
      int referenceIndex = matrix.addPoint(x, y);
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

  @Test public void addPoint_ReturnsOverwriteablePoint() {
    PointMatrix matrix = new PointMatrix();

    matrix.addPoint(1, 2);
    matrix.addPoint(3, 4);
    matrix.addPoint(5, 6);

    int expectedReferenceIndex = 1;
    matrix.overwriteablePoints.add(expectedReferenceIndex);

    double x = 7;
    double y = 8;
    int referenceIndex = matrix.addPoint(x, y);
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

  @Test public void addPoint_RemovesOverwriteablePoint() {
    PointMatrix matrix = new PointMatrix();

    matrix.addPoint(1, 2);
    matrix.addPoint(3, 4);
    matrix.addPoint(5, 6);

    int expectedReferenceIndex = 1;
    matrix.overwriteablePoints.add(expectedReferenceIndex);

    int referenceIndex = matrix.addPoint(0, 0);

    assertTrue(matrix.overwriteablePoints.isEmpty());
  }

  @Test public void removePoint_AddsToOverwriteablePoints() {
    PointMatrix matrix = new PointMatrix();

    matrix.addPoint(1, 2);
    matrix.removePoint(0);
    assertEquals((int) matrix.overwriteablePoints.get(0), 0);
  }

  @Test public void removePoint_ThrowsIndexOutOfBoundsException() {
    PointMatrix matrix = new PointMatrix();

    try {
      matrix.removePoint(0);
      fail();
    } catch(IndexOutOfBoundsException err) {}

    matrix.addPoint(1, 2);
    matrix.addPoint(3, 4);
    matrix.addPoint(5, 6);

    try {
      matrix.removePoint(3);
      fail();
    } catch(IndexOutOfBoundsException err) {}
  }
}
