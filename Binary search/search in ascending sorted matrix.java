Given a 2D matrix that contains integers only, which each row is sorted in an ascending order.
 The first element of next row is larger than (or equal to) the last element of previous row.

Given a target number, returning the position that the target locates within the matrix. 
If the target number does not exist in the matrix, return {-1, -1}.

Assumptions:

The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
Examples:

matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }

target = 7, return {1, 2}

target = 6, return {-1, -1} to represent the target number does not exist in the matrix.

public class Solution {
  public int[] search(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) return new int[] {-1, -1};
    int row = findLoE(matrix, target);
    if (row == -1) return new int[] {-1, -1};
    int column = binarySearch(matrix[row], target);
    if (column == -1) return new int[] {-1, -1};
    return new int[] {row, column};
  }
  
  //find less or equal. Be attention this time is to find the row
  private int findLoE(int[][] matrix, int target) {
    if (matrix[0][0] > target) return -1;
    int left = 0, right = matrix.length -1;
    while (left < right - 1) {
        int mid = left + (right - left)/2;
        if (matrix[mid][0] == target) return mid;
        else if (matrix[mid][0] < target) left = mid;
        else right = mid;
    }
    return matrix[right][0] <= target ? right : left;
  }

  private int binarySearch(int[] array, int target) {
    int left = 0, right = array.length -1;
    while (left <= right) {
        int mid = left + (right - left)/2;
        if (array[mid] == target) return mid;
        else if (array[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
  }
}
