/*

Check if a sub-array with Sum 0 exits
*/

import java.util.HashMap;

public class SubArrayWithSumZeroExists {

  public static void main(String[] args) {
    int[] a = {3, 4, 3,-2, -5, 1, 0, 1, -4, -2 ,-3};
    int n=a.length;
    System.out.println(checkIfSubArrayWithZeroExists(a,n));
  }

  private static String checkIfSubArrayWithZeroExists(int[] a, int n) {
    HashMap<Integer,Integer> hashMap=new HashMap<>();
    int sum=0;
    for(int i=0;i<n;i++) {
      sum+=a[i];
      if (hashMap.containsKey(sum)) {
        return "yes Sub Array with Sum 0 exits  ";
      }
      hashMap.put(sum,a[i]);
    }
    return "No Sub Array with Sum 0 do not exits ";
  }
}
