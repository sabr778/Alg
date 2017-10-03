// bubble sort
public class Solution {
  public int[] solve(int[] array) {
    sort(array);
    return array;
  }

  private void sort(int[] array) {
  	if (array == null || array.length <= 1) return;
    for (int i = 0; i < array.length-1; i ++) {
      for (int j = 1; j < array.length-i; j++) {
        if (array[j-1] > array[j]) swap(array,j-1,j);
      }
    }
  }

  private void swap(int[] array, int m, int n) {
  	int temp = array[m];
  	array[m] = array[n];
  	array[n] = temp;
  }
}
