public class Solution {
  public int lastOccur(int[] array, int target) {
    if (array == null || array.length == 0) return -1;
    int left = 0, right = array.length -1;
    while (left < right -1) {
        int mid = left + (right - left)/2;
        if (array[mid] == target) left = mid;
        else if (array[mid] < target) left = mid;
        else right = mid;
    }
    return array[right] == target ? right : (array[left] == target ? left : -1);
  }
}