// selection sort
public class Solution {
  public int[] solve(int[] array) {
    sort(array);
    return array;
  }

  private void sort(int[] array) {
  	if (array == null || array.length <= 1) return;
  	for (int i = 0; i <= array.length-2; i++) {
  		for (int j = i+1; j <= array.length-1; j++) {
  			if (array[j] <= array[i]) swap(array,i,j);
  		}
  	}
  }

  private void swap(int[] array, int m, int n) {
  	int temp = array[m];
  	array[m] = array[n];
  	array[n] = temp;
  }
}
