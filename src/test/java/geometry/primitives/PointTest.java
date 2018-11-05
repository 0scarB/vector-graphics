package geometry.primitives;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import utils.Utils;
import geometry.PointMatrix;

public class PointTest {

  @Test public void Point_AssignsMatrix() {
    PointMatrix matrix = new PointMatrix();
    Point p = new Point(matrix, 1, 2);

    assertSame(p.matrix, matrix);
  }

  @Test public void Point_AssignsReferenceIndexToAddPointReturnValue() {
    int expectedReferenceIndex = 7;
    PointMatrix mockMatrix = mock(PointMatrix.class);
    when(mockMatrix.addPoint(1, 2)).thenReturn(expectedReferenceIndex);

    Point p = new Point(mockMatrix, 1, 2);

    verify(mockMatrix, times(1)).addPoint(1, 2);
    assertEquals(p.refIndex, expectedReferenceIndex);
  }

  @Test public void update_SetsXAndYValuesAtReferenceIndexInMatrix() {
    PointMatrix matrix = new PointMatrix();
    Point p = new Point(matrix, 1, 2);

    assertEquals(
      matrix.xValues.get(p.refIndex),
      1,
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      matrix.yValues.get(p.refIndex),
      2,
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    p.update(3, 4);

    assertEquals(
      matrix.xValues.get(p.refIndex),
      3,
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      matrix.yValues.get(p.refIndex),
      4,
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void remove_CallsPointMatrixremovePointWithReferenceIndex() {
    PointMatrix mockMatrix = mock(PointMatrix.class);
    Point p = new Point(mockMatrix, 1, 2);

    p.remove();

    verify(mockMatrix, times(1)).removePoint(p.refIndex);
  }

  @Test public void getX_ReturnsMatrixXValueAtReferenceIndex() {
    PointMatrix matrix = new PointMatrix();
    Point p = new Point(matrix, 1, 2);

    assertEquals(
      p.getX(),
      matrix.xValues.get(p.refIndex),
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void getY_ReturnsMatrixYValueAtReferenceIndex() {
    PointMatrix matrix = new PointMatrix();
    Point p = new Point(matrix, 1, 2);

    assertEquals(
      p.getY(),
      matrix.yValues.get(p.refIndex),
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }
}
