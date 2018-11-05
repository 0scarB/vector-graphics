package matrix;

public class Vector2D {
  public final Matrix2D matrix;
  public final int refIndex;

  public Vector2D(Matrix2D matrix, double x, double y) {
    this.matrix = matrix;
    this.refIndex = matrix.addVector(x, y);
  }

  public void update(double x, double y) {
    matrix.xValues.set(refIndex, x);
    matrix.yValues.set(refIndex, y);
  }

  public void remove() {
    matrix.removeVector(refIndex);
  }

  public double getX() {
    return matrix.xValues.get(refIndex);
  }

  public double getY() {
    return matrix.yValues.get(refIndex);
  }
}
