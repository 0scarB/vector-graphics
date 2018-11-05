package matrix;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import utils.Utils;

public class Vector2DTest {

  @Test public void Vector2D_AssignsMatrix() {
    Matrix2D matrix = new Matrix2D();
    Vector2D vector = new Vector2D(matrix, 1, 2);

    assertSame(vector.matrix, matrix);
  }

  @Test public void Vector2D_AssignsReferenceIndexToAddVectorReturnValue() {
    int expectedReferenceIndex = 7;
    Matrix2D mockMatrix = mock(Matrix2D.class);
    when(mockMatrix.addVector(1, 2)).thenReturn(expectedReferenceIndex);

    Vector2D vector = new Vector2D(mockMatrix, 1, 2);

    verify(mockMatrix, times(1)).addVector(1, 2);
    assertEquals(vector.refIndex, expectedReferenceIndex);
  }

  @Test public void update_SetsXAndYValuesAtReferenceIndexInMatrix() {
    Matrix2D matrix = new Matrix2D();
    Vector2D vector = new Vector2D(matrix, 1, 2);

    assertEquals(
      matrix.xValues.get(vector.refIndex),
      1,
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      matrix.yValues.get(vector.refIndex),
      2,
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );

    vector.update(3, 4);

    assertEquals(
      matrix.xValues.get(vector.refIndex),
      3,
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
    assertEquals(
      matrix.yValues.get(vector.refIndex),
      4,
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void remove_CallsMatrix2DremoveVectorWithReferenceIndex() {
    Matrix2D mockMatrix = mock(Matrix2D.class);
    Vector2D vector = new Vector2D(mockMatrix, 1, 2);

    vector.remove();

    verify(mockMatrix, times(1)).removeVector(vector.refIndex);
  }

  @Test public void getX_ReturnsMatrixXValueAtReferenceIndex() {
    Matrix2D matrix = new Matrix2D();
    Vector2D vector = new Vector2D(matrix, 1, 2);

    assertEquals(
      vector.getX(),
      matrix.xValues.get(vector.refIndex),
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }

  @Test public void getY_ReturnsMatrixYValueAtReferenceIndex() {
    Matrix2D matrix = new Matrix2D();
    Vector2D vector = new Vector2D(matrix, 1, 2);

    assertEquals(
      vector.getY(),
      matrix.yValues.get(vector.refIndex),
      Utils.DOUBLE_ASSERT_EQUALS_PERCISION
    );
  }
}
