package geometry;

import java.lang.Math;
import geometry.primitive.Point;

public class GeometryUtil {

  public static double dist(Point p1, Point p2) {
    return Math.hypot(p2.getX() - p1.getX(), p2.getY() - p1.getY());
  }

  public static double slopeAngle(Point p1, Point p2) {
    double xDiff = p2.getX() - p1.getX();
    double yDiff = p2.getY() - p1.getY();
    if (xDiff > 0) {
      if (yDiff < 0) {
        // 2. Quadrant
        return 2 * Math.PI + Math.atan(yDiff / xDiff);
      }
      // 1. Quadrant
      return Math.atan(yDiff / xDiff);
    }
    if (xDiff < 0) {
      // 3/4. Quadrant
      return Math.PI + Math.atan(yDiff / xDiff);
    }

    // If both points lie on the same vertical line.
    if (yDiff > 0) {
      return Math.PI / 2;
    }
    if (yDiff < 0) {
      return 3 * Math.PI / 2;
    }

    // If both points are in the same position.
    return 0;
  }
}
