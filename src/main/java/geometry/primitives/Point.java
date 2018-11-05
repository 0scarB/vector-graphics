package geometry.primitives;

import geometry.PointMatrix;

public class Point {
  public final PointMatrix matrix;
  public final int refIndex;

  public Point(PointMatrix matrix, double x, double y) {
    this.matrix = matrix;
    this.refIndex = matrix.addPoint(x, y);
  }

  public void update(double x, double y) {
    matrix.xValues.set(refIndex, x);
    matrix.yValues.set(refIndex, y);
  }

  public void remove() {
    matrix.removePoint(refIndex);
  }

  public double getX() {
    return matrix.xValues.get(refIndex);
  }

  public double getY() {
    return matrix.yValues.get(refIndex);
  }
}
