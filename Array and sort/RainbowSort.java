Given an array of balls, where the color of the balls can only be Red, Green or Blue, 
sort the balls such that all the Red balls are grouped on the left side, all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. 
(Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

//rainbow sort
public class Solution {
  public int[] rainbowSort(int[] array) {
    if (array == null || array.length <= 1) return array;
    partition(array, 0, array.length-1);
    return array;
  }

  private void partition(int[] array, int low, int high) {
    int j = high, k = low;
    while(k <= j) {
        if (array[k] < 0) {
            swap(array,low,k);
            low++;
            k++;
        } else if (array[k] == 0) {
            k++;
        } else {
            swap(array,k,j);
            j--;
        }
    }//low and k is the 2 plates for the buffer 0s
  }




  private void swap(int[] array, int m, int n) {
    int temp = array[m];
    array[m] = array[n];
    array[n] = temp;
  }
}

