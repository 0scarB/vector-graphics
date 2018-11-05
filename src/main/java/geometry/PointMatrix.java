package geometry;

import java.util.ArrayList;

public class PointMatrix {
  public int length = 0;
  public final ArrayList<Double> xValues = new ArrayList<Double>(0);
  public final ArrayList<Double> yValues = new ArrayList<Double>(0);
  public final ArrayList<Integer> overwriteablePoints
    = new ArrayList<Integer>(0);

  public int addPoint(double x, double y) {
    int overwriteablePointsLength = overwriteablePoints.size();
    if (overwriteablePointsLength > 0) {
      int refIndex = overwriteablePoints.remove(
        overwriteablePointsLength - 1
      );
      xValues.set(refIndex, x);
      yValues.set(refIndex, y);
      return refIndex;
    }
    xValues.add(x);
    yValues.add(y);
    length++;
    return length - 1;
  }

  public void removePoint(int refIndex) throws IndexOutOfBoundsException {
    if (refIndex >= length) {
      throw new IndexOutOfBoundsException();
    }
    overwriteablePoints.add(refIndex);
  }
}
