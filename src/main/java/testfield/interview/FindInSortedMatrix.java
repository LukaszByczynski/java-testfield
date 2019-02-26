package testfield.interview;

class FindInSortedMatrix {

  static boolean findInSortedMatrix(int[][] matrix, int value) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int start = 0;
    int end = rows - 1;

    // first, search beetwen rows
    while (start <= end) {
      int mid = start + (end - start) / 2;
      int vb = matrix[mid][0];
      int ve = matrix[mid][cols - 1];

      if (vb == value || ve == value)
        return true;

      if (vb < value && ve < value) {
        start = mid + 1;
      } else if (vb > value && ve > value) {
        end = mid - 1;
      } else {
        // we found row, right now we need to find a column
        int row = mid;
        start = 0;
        end = cols - 1;
        while (start <= end) {
          mid = start + (end - start) / 2;
          int v = matrix[row][mid];

          if (v == value)
            return true;

          if (v < value) {
            start = mid + 1;
          } else {
            end = mid - 1;
          }
        }
      }
    }
    return false;

  }

  public static void main(String[] args) {

    System.out.println(
        findInSortedMatrix(new int[][] {{1, 2, 3}, {6, 8, 9}, {10, 11, 22}, {44, 55, 66}}, 44));
    System.out.println(findInSortedMatrix(new int[][] {{1, 2, 3}, {6, 8, 9}}, 5));
  }
}
