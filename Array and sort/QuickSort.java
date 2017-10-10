//quick sort
public class Solution {
  public int[] quickSort(int[] array) {
    if (array == null || array.length <= 1) return array;
    sort(array,0,array.length-1);
    return array;
  }

  private void sort(int[] array, int low, int high) {
    if (low < high) {
      int pivot = partition(array, low, high);
      sort(array, low, pivot-1);
      sort(array, pivot+1, high);
    }
  }

  private int partition(int[] array, int low, int high) {
    int j = high -1;
    while (low <= j) {
      if (array[low] <= array[high]) {
        low++;
      } else {
        swap(array, low, j);
        j--;
      }
    }
    swap(array,low,high);
    return low;
  }

  private void swap(int[] array, int m, int n) {
    int temp = array[m];
    array[m] = array[n];
    array[n] = temp;
  }
}