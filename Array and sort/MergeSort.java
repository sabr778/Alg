//merge sort: because the solution below I met wrong result, then come up this one. But the one below would save space.
public class Solution {
  public int[] mergeSort(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 1) return array;
    return sort(array, 0, array.length-1);
  }

  private int[] sort(int[] array, int left, int right) {
    if (left == right) return new int[]{array[left]};
    int mid = left + (right - left)/2;
    int[] arr1 = sort(array, left, mid);
    int[] arr2 = sort(array, mid+1, right);
    return merge(arr1, arr2);
  }

  private int[] merge(int[] arr1, int[] arr2) {
    int i = 0, j = 0, k = 0;
    int[] array = new int[arr1.length + arr2.length];
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] <= arr2[j]) {
            array[k++] = arr1[i++];
        } else {
            array[k++] = arr2[j++];
        }
    }
    while (i < arr1.length) {
        array[k++] = arr1[i++];
    }
    while (j < arr2.length) {
        array[k++] = arr2[j++];
    }
    return array;
  }
}

//merge sort
public class Solution {
  public int[] mergeSort(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 1) return array;
    sort(array, 0, array.length-1);
    return array;
  }

  private void sort(int[] array, int left, int right) {
    if (left < right) {
      int mid = left + (right - left)/2;
      sort(array, left, mid);
      sort(array, mid+1, right);
      merge(array, left, mid, right);
    }
  }

  private void merge(int[] array, int left, int mid, int right) {
    int i = 0, j = 0;
    int k = left; // this is the point I was wrong at frist
    int[] arr1 = Arrays.copyOfRange(array, left, mid+1);
    int[] arr2 = Arrays.copyOfRange(array, mid+1, right+1);
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] <= arr2[j]) {
            array[k++] = arr1[i++];
        } else {
            array[k++] = arr2[j++];
        }
    }
    while (i < arr1.length) {
        array[k++] = arr1[i++];
    }
    while (j < arr2.length) {
        array[k++] = arr2[j++];
    }
  }
}