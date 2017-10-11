Given an array of integers, move all the 0s to the right end of the array.

The relative order of the elements in the original array does not need to be maintained.

public class Solution {
  public int[] moveZero(int[] array) {
    if (array == null || array.length <= 1) return array;
    partition(array, 0, array.length-1);
    return array;
  } 
  private void partition(int[] array, int low, int high) {
    while (low <= high) {
        if (array[low] == 0) {
            swap(array, low, high);
            high--;
        } else {
            low++;
        }
    }
  }

  private void swap(int[] array, int m, int n) {
    int temp = array[m];
    array[m] = array[n];
    array[n] = temp;
  }
}

