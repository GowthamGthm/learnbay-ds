/*
Print Duplicates numbers in an array.

 Expected time complexity is of O(n).

Note you cannot use Set or Map for this problem.

Given Range : 0 to 10.
Input : 1,2,2,2,2,4,5,7,8,8
Output : 2, 8

Every duplicate element should be printed only once.*/

public class DuplicateElementsInArray {
  public static void main(String[] args) {
    int[] a = {1, 2, 2, 2, 4, 4, 5, 7, 8, 8};
    int n = a.length;
    printDuplicateElements(a, n);
  }

  private static void printDuplicateElements(int[] a, int n) {

    for (int i = 0; i < n; i++) {
      int val = Math.abs(a[i]);
      if (a[val] > 0) {
        a[val] = -1 * a[val];
      } else {
        a[val] = -1;
      }
    }

    for (int j = 0; j < n; j++) {
      if (a[j] == -1) {
        System.out.println(j);
      }
    }
  }
}
