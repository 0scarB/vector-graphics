package geometry.primitive.pathsegment;

import geometry.PointMatrix;
import geometry.primitive.AbstractPrimitive;
import geometry.primitive.Point;

public abstract class AbstractPathSegment extends AbstractPrimitive {

  public abstract double size();

  public abstract double[] interpolate(double frac);

  public Point interpolate(PointMatrix matrix, double frac) {
    double[] vector = this.interpolate(frac);
    Point p = new Point(matrix, vector[0], vector[1]);
    return p;
  }
}
