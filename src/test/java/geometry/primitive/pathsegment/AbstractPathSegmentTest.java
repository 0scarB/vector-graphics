package geometry.primitive.pathsegment;

import org.junit.Test;
import static org.junit.Assert.*;
import utils.TestingUtil;
import geometry.PointMatrix;
import geometry.primitive.Point;

public class AbstractPathSegmentTest {

  class AbstractPathSegmentSubtype extends AbstractPathSegment {

    // Dummy method
    public void remove() {}

    // Dummy method
    public double size() {
      return 0;
    }

    public double[] interpolate(double frac) {
      double[] vector = new double[]{1, 2};
      return vector;
    }
  }

  @Test public void interpolate_ReturnsVectorAsPoint() {
    double expectedX = 1;
    double expectedY = 2;
    PointMatrix matrix = new PointMatrix();
    AbstractPathSegmentSubtype obj = new AbstractPathSegmentSubtype();
    Point p = obj.interpolate(matrix, 0);

    assertEquals(
      expectedX, p.getX(), TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      expectedY, p.getY(), TestingUtil.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }
}
