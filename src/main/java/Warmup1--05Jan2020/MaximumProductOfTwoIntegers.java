/*Find maximum Product of two integers in an array
    Input : -10, -3, 5, 6, -2
    output : -10 and -3*/

public class MaximumProductOfTwoIntegers {

  public static void main(String[] args) {
    int[] a = {-10, -3, 5, 4, -2};
    int n = a.length;
    System.out.println(findMaximumProductOfTwoIntegerInGivenArray(a, n));
    System.out.println(findMaximumProductOfTwoIntegerInGivenArray(a, n));
  }

  private static String findMaximumProductOfTwoIntegerInGivenArray(int[] a, int n) {
    // res array contains first two elements as max positive numbers and next two elements as max negative numbers
    int[] res = {0, 0, 0, 0};
    for (int i = 0; i < n; i++) {
      if (a[i] > 0 && res[1] < a[i]) {
        res[1] = res[0];
        res[0] = a[i];
      } else if (a[i] < 0 && res[3] > a[i]) {
        res[3] = res[2];
        res[2] = a[i];
      }
    }
    int productWithNegativeNumber = res[2] * res[3];
    int productWithPositiveNumber = res[0] * res[1];
    if (productWithNegativeNumber < productWithPositiveNumber) {
      return res[0] + " and " + res[1];
    } else {
      return res[2] + " and " + res[3];
    }
  }
}
