package geometry;

import java.lang.Math;
import org.junit.Test;
import static org.junit.Assert.*;
import geometry.primitive.Point;
import utils.TestingUtil;

public class GeometryUtilTest {

  @Test public void dist_ReturnsDistanceBetweenTwoPoints() {
    PointMatrix matrix = new PointMatrix();
    // (3, 4, 5) Pythagorean triple
    Point p1 = new Point(matrix, 0, 0);
    Point p2 = new Point(matrix, 3, 4);

    assertEquals(
      5,
      GeometryUtil.dist(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    // (20, 21, 29) Pythagoream triple
    Point p3 = new Point(matrix, -7, 3);
    Point p4 = new Point(matrix, -28, -17);

    assertEquals(
      29,
      GeometryUtil.dist(p3, p4),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void slopeAngle_CalculatesAnglesInFirstQuadrant() {
    PointMatrix matrix = new PointMatrix();
    Point p1 = new Point(matrix, 0, 0);
    Point p2 = new Point(matrix, 1, Math.sqrt(3));

    double expected60Degrees = Math.PI / 3;

    assertEquals(
      expected60Degrees,
      GeometryUtil.slopeAngle(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    Point p3 = new Point(matrix, 2, 1);
    Point p4 = new Point(matrix, 3, 1 + Math.sqrt(3));

    assertEquals(
      expected60Degrees,
      GeometryUtil.slopeAngle(p3, p4),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void slopeAngle_CalculatesAnglesInSecondQuadrant() {
    PointMatrix matrix = new PointMatrix();
    Point p1 = new Point(matrix, 0, 0);
    Point p2 = new Point(matrix, -1, Math.sqrt(3));

    double expected120Degrees = 2 * Math.PI / 3;

    assertEquals(
      expected120Degrees,
      GeometryUtil.slopeAngle(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    Point p3 = new Point(matrix, 2, 1);
    Point p4 = new Point(matrix, 1, 1 + Math.sqrt(3));

    assertEquals(
      expected120Degrees,
      GeometryUtil.slopeAngle(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void slopeAngle_CalculatesAnglesInThirdQuadrant() {
    PointMatrix matrix = new PointMatrix();
    Point p1 = new Point(matrix, 0, 0);
    Point p2 = new Point(matrix, -1, -Math.sqrt(3));

    double expected240Degrees = 4 * Math.PI / 3;

    assertEquals(
      expected240Degrees,
      GeometryUtil.slopeAngle(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    Point p3 = new Point(matrix, 2, 1);
    Point p4 = new Point(matrix, 1, 1 - Math.sqrt(3));

    assertEquals(
      expected240Degrees,
      GeometryUtil.slopeAngle(p3, p4),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void slopeAngle_CalculatesAnglesInFourthQuadrant() {
    PointMatrix matrix = new PointMatrix();
    Point p1 = new Point(matrix, 0, 0);
    Point p2 = new Point(matrix, 1, -Math.sqrt(3));

    double expected300Degrees = 5 * Math.PI / 3;

    assertEquals(
      expected300Degrees,
      GeometryUtil.slopeAngle(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    Point p3 = new Point(matrix, 2, 1);
    Point p4 = new Point(matrix, 3, 1 - Math.sqrt(3));

    assertEquals(
      expected300Degrees,
      GeometryUtil.slopeAngle(p3, p4),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void slopeAngle_Handles0Degrees() {
    PointMatrix matrix = new PointMatrix();
    Point p1 = new Point(matrix, 0, 0);
    Point p2 = new Point(matrix, 1, 0);

    assertEquals(
      0,
      GeometryUtil.slopeAngle(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    Point p3 = new Point(matrix, 2, 1);
    Point p4 = new Point(matrix, 4, 1);

    assertEquals(
      0,
      GeometryUtil.slopeAngle(p3, p4),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void slopeAngle_Handles90Degrees() {
    PointMatrix matrix = new PointMatrix();
    Point p1 = new Point(matrix, 0, 0);
    Point p2 = new Point(matrix, 0, 1);

    assertEquals(
      Math.PI / 2,
      GeometryUtil.slopeAngle(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    Point p3 = new Point(matrix, 2, 1);
    Point p4 = new Point(matrix, 2, 3);

    assertEquals(
      Math.PI / 2,
      GeometryUtil.slopeAngle(p3, p4),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void slopeAngle_Handles180Degrees() {
    PointMatrix matrix = new PointMatrix();
    Point p1 = new Point(matrix, 0, 0);
    Point p2 = new Point(matrix, -1, 0);

    assertEquals(
      Math.PI,
      GeometryUtil.slopeAngle(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    Point p3 = new Point(matrix, 2, 1);
    Point p4 = new Point(matrix, 0, 1);

    assertEquals(
      Math.PI,
      GeometryUtil.slopeAngle(p3, p4),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void slopeAngle_Handles270Degrees() {
    PointMatrix matrix = new PointMatrix();
    Point p1 = new Point(matrix, 0, 0);
    Point p2 = new Point(matrix, 0, -1);

    assertEquals(
      3 * Math.PI / 2,
      GeometryUtil.slopeAngle(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    Point p3 = new Point(matrix, 2, 1);
    Point p4 = new Point(matrix, 2, -1);

    assertEquals(
      3 * Math.PI / 2,
      GeometryUtil.slopeAngle(p3, p4),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void slopeAngle_HandlesPointsInSamePosition() {
    PointMatrix matrix = new PointMatrix();
    Point p1 = new Point(matrix, 0, 0);
    Point p2 = new Point(matrix, 0, 0);

    assertEquals(
      0,
      GeometryUtil.slopeAngle(p1, p2),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    Point p3 = new Point(matrix, 2, 1);
    Point p4 = new Point(matrix, 2, 1);

    assertEquals(
      0,
      GeometryUtil.slopeAngle(p3, p4),
      TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }
}
