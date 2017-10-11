public class Solution {
  //assume b is non-negative
  public long power(int a, int b) {
    if (b == 0) return 1;
    long temp = power(a,b/2); // save half time
    if (b%2 == 1) return a*temp*temp;
    return temp*temp;
  }
}