package geometry.primitive.pathsegment;

import geometry.PointMatrix;
import geometry.primitive.Point;

public class CircularArc {
  Point center;
  Point start;
  Point end;
  double r;

  public CircularArc(
    PointMatrix matrix,
    double cx, double cy, double r,
    double startX, double startY,
    double endX, double endY
  ) {
    this.center = new Point(matrix, cx, cy);
    this.start = new Point(matrix, startX, startY);
    this.end = new Point(matrix, endX, endY);
    this.r = r;
  }
}
