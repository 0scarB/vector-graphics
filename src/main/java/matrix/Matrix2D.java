package matrix;

import java.util.ArrayList;

public class Matrix2D {
  public int length = 0;
  public final ArrayList<Double> xValues = new ArrayList<Double>(0);
  public final ArrayList<Double> yValues = new ArrayList<Double>(0);
  public final ArrayList<Integer> overwriteableVectors
    = new ArrayList<Integer>(0);

  public int addVector(double x, double y) {
    int overwriteableVectorsLength = overwriteableVectors.size();
    if (overwriteableVectorsLength > 0) {
      int refIndex = overwriteableVectors.remove(
        overwriteableVectorsLength - 1
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

  public void removeVector(int refIndex) throws IndexOutOfBoundsException {
    if (refIndex >= length) {
      throw new IndexOutOfBoundsException();
    }
    overwriteableVectors.add(refIndex);
  }
}
