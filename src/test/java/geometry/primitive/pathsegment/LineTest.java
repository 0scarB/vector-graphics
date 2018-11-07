package geometry.primitive.pathsegment;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import utils.TestingUtil;
import exception.NumberRangeException;
import geometry.PointMatrix;
import geometry.primitive.Point;

public class LineTest {

  @Test public void Line_ConstructorP1P2() {
    PointMatrix matrix = new PointMatrix();
    Point p1 = new Point(matrix, 1, 2);
    Point p2 = new Point(matrix, 3, 4);
    Line line = new Line(p1, p2);

    assertSame(p1, line.p1);
    assertSame(p2, line.p2);
  }

  @Test public void Line_ConstructorMatrixX1Y1X2Y2() {
    double x1 = 1;
    double y1 = 2;
    double x2 = 3;
    double y2 = 4;
    PointMatrix matrix = new PointMatrix();
    Line line = new Line(matrix, x1, y1, x2, y2);

    assertEquals(
      x1, line.p1.getX(), TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      y1, line.p1.getY(), TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      x2, line.p2.getX(), TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      y2, line.p2.getY(), TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void remove_CallsP1removeAndP2remove() {
    Point p1 = mock(Point.class);
    Point p2 = mock(Point.class);
    Line line = new Line(p1, p2);

    line.remove();

    verify(p1, times(1)).remove();
    verify(p2, times(1)).remove();
  }

  @Test public void size_ReturnsDistanceBetweenP1AndP2() {
    PointMatrix matrix = new PointMatrix();
    // (3, 4, 5) Pythagorean triple
    Line line1 = new Line(matrix, 0, 0, 3, 4);

    assertEquals(5, line1.size(), TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION);

    // (20, 21, 29) Pythagoream triple
    Line line2 = new Line(matrix, -7, 3, -28, -17);

    assertEquals(29, line2.size(), TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION);
  }

  @Test public void interpolate_ThrowsNumberRangeExceptionIfFracSmaller0() {
    PointMatrix matrix = new PointMatrix();
    Line line = new Line(matrix, 1, 2, 3, 4);

    try {
      line.interpolate(-0.1);
      fail();
    } catch(NumberRangeException e) {
      assertEquals(
        e.toString(),
        "exception.NumberRangeException: " +
        "The value of \"frac\" must be in the range \"0 <= frac <= 1\"!"
      );
    }
  }

  @Test public void interpolate_ThrowsNumberRangeExceptionIfFracGreater1() {
    PointMatrix matrix = new PointMatrix();
    Line line = new Line(matrix, 1, 2, 3, 4);

    try {
      line.interpolate(1.1);
      fail();
    } catch(NumberRangeException e) {
      assertEquals(
        e.toString(),
        "exception.NumberRangeException: " +
        "The value of \"frac\" must be in the range \"0 <= frac <= 1\"!"
      );
    }
  }

  @Test public void interpolate_ReturnsCorrectVector() {
    PointMatrix matrix = new PointMatrix();
    Line line1 = new Line(matrix, 0, 0, 5, 6);

    double[] expectedVector1 = new double[]{0, 0};
    assertArrayEquals(
      expectedVector1,
      line1.interpolate(0),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    double[] expectedVector2 = new double[]{1.25, 1.5};
    assertArrayEquals(
      expectedVector2,
      line1.interpolate(0.25),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    double[] expectedVector3 = new double[]{2.5, 3};
    assertArrayEquals(
      expectedVector3,
      line1.interpolate(0.5),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    double[] expectedVector4 = new double[]{3.75, 4.5};
    assertArrayEquals(
      expectedVector4,
      line1.interpolate(0.75),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    double[] expectedVector5 = new double[]{5, 6};
    assertArrayEquals(
      expectedVector5,
      line1.interpolate(1),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    Line line2 = new Line(matrix, 1.3, 2.8, -5.7, -5.8);

    double[] expectedVector6 = new double[]{1.3, 2.8};
    assertArrayEquals(
      expectedVector6,
      line2.interpolate(0),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    double[] expectedVector7 = new double[]{-0.45, 0.65};
    assertArrayEquals(
      expectedVector7,
      line2.interpolate(0.25),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    double[] expectedVector8 = new double[]{-2.2, -1.5};
    assertArrayEquals(
      expectedVector8,
      line2.interpolate(0.5),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    double[] expectedVector9 = new double[]{-3.95, -3.65};
    assertArrayEquals(
      expectedVector9,
      line2.interpolate(0.75),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    double[] expectedVector10 = new double[]{-5.7, -5.8};
    assertArrayEquals(
      expectedVector10,
      line2.interpolate(1),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }
}
