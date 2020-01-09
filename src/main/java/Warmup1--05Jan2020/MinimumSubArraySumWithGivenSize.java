/*
Minimum Sum Sub Array of size given size K

Complexity
Time:O(n)
Space:o(n)
*/


public class MinimumSubArraySumWithGivenSize {
  public static void main(String[] args) {
    int[] a = {10, 4, -9, 5, 6, 3, 8, 9};
    int n = a.length;
    int subArraySize = 3;
    System.out.println(findMinimumSumOfSubArrayOfGivenSize(a, n, subArraySize));
  }

  private static String findMinimumSumOfSubArrayOfGivenSize(int[] a, int n, int subArraySize) {

    int[] cumulativeSumAtEachIndex=new int[n];

    int index=subArraySize;
    cumulativeSumAtEachIndex[0] = a[0];
    for (int i = 1; i < n; i++) {
      cumulativeSumAtEachIndex[i] = a[i] + cumulativeSumAtEachIndex[i - 1];
    }
    int sum = cumulativeSumAtEachIndex[subArraySize-1];
    for (int i = subArraySize; i < n; i++) {
      int nextSum=cumulativeSumAtEachIndex[i]-cumulativeSumAtEachIndex[i-subArraySize];
      if (sum < nextSum) {
        sum = nextSum ;
        index=i+1;
      }
    }
    return "Index " + (index-subArraySize)+ " to " +(index-1)+" with Sum as " +sum;
  }
}
