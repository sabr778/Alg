Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.

Assumptions

A is not null
K is guranteed to be >= 0 and K is guranteed to be <= A.length
Return

A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T. 
Examples

A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}

public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if (k == 0) return new int[0];
    int[] ret = new int[k];
    int pivot = findClosest(array, target);
    ret[0] = array[pivot];
    int left = pivot - 1, right = pivot + 1;
    for (int i = 1; i < k; i++) {
      if (left >= 0 && right < array.length) {
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) ret[i] = array[left--];
        else ret[i] = array[right++];
      } else if (left < 0) {
        ret[i] = array[right++];
      } else {
        ret[i] = array[left--];
      }
    }
    return ret;
  }

  private int findClosest(int[] array, int target) {
    if (array == null || array.length == 0) return -1;
    int left = 0, right = array.length -1;
    while (left < right -1) {
      int mid = left + (right - left) /2;
      if (array[mid] == target) return mid;
      else if (array[mid] < target) left = mid;
      else right = mid;
    }
    return Math.abs(array[left] - target) <= Math.abs(array[right] - target) ? left : right;
  }
}