package geometry.primitive.pathsegment;

import geometry.GeometryUtil;
import geometry.PointMatrix;
import geometry.primitive.Point;

public class Line extends AbstractPathSegment {
  public final Point p1;
  public final Point p2;

  public Line(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public Line(PointMatrix matrix, double x1, double y1, double x2, double y2) {
    this.p1 = new Point(matrix, x1, y1);
    this.p2 = new Point(matrix, x2, y2);
  }

  public void remove() {
    p1.remove();
    p2.remove();
  }

  public double size() {
    return GeometryUtil.dist(p1, p2);
  }

  public double[] interpolate(double frac) {
    double frac2 = 1 - frac;
    double[] vector = {
      p1.getX() * frac2 + p2.getX() * frac,
      p1.getY() * frac2 + p2.getY() * frac
    };
    return vector;
  }
}
