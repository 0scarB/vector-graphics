package geometry.primitive;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import utils.TestingUtil;
import geometry.PointMatrix;

public class PointTest {

  @Test public void Point_AssignsMatrix() {
    PointMatrix matrix = new PointMatrix();
    Point p = new Point(matrix, 1, 2);

    assertSame(p.matrix, matrix);
  }

  @Test public void Point_AssignsReferenceIndexToMatrixaddPointReturnValue() {
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
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      matrix.yValues.get(p.refIndex),
      2,
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    p.update(3, 4);

    assertEquals(
      matrix.xValues.get(p.refIndex),
      3,
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      matrix.yValues.get(p.refIndex),
      4,
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void remove_CallsPointMatrixremovePointWithReferenceIndex() {
    PointMatrix mockMatrix = mock(PointMatrix.class);
    Point p = new Point(mockMatrix, 1, 2);

    p.remove();

    verify(mockMatrix, times(1)).removePoint(p.refIndex);
  }

  @Ignore @Test public void remove_IsCalledOnGarbageCollection() {
    PointMatrix matrix = new PointMatrix();
    double x1 = 1;
    double y1 = 2;
    Point p1 = new Point(matrix, x1, y1);

    assertEquals(
      x1,
      matrix.xValues.get(0),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      y1,
      matrix.yValues.get(0),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    p1 = null;
    System.gc();
    System.runFinalization();

    double x2 = 3;
    double y2 = 4;
    Point p2 = new Point(matrix, x2, y2);

    assertEquals(1, matrix.xValues.size());
    assertEquals(1, matrix.yValues.size());
    assertEquals(
      x2,
      matrix.xValues.get(0),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      y2,
      matrix.yValues.get(0),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void getX_ReturnsMatrixXValueAtReferenceIndex() {
    PointMatrix matrix = new PointMatrix();
    Point p = new Point(matrix, 1, 2);

    assertEquals(
      p.getX(),
      matrix.xValues.get(p.refIndex),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void getY_ReturnsMatrixYValueAtReferenceIndex() {
    PointMatrix matrix = new PointMatrix();
    Point p = new Point(matrix, 1, 2);

    assertEquals(
      p.getY(),
      matrix.yValues.get(p.refIndex),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }
}
