
/*
* Maximum difference between two elements such that larger element appears after the smaller number
* Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.*/
public class MaxDifferenceBetweenTwoElements {


    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxDifferenceBetweenTwoElements(arr, arr.length));
    }

    public static int maxDifferenceBetweenTwoElements(int[] arr, int n) {
        int min = 0, max = 0;
        int diff = 0;
        for (int i = 1; i < n; i++) {

            if (arr[min] > arr[i]) {
                min = i;
                continue;
            }

            int diffCurr = arr[i] - arr[min];
            if (diffCurr > diff) {
                diff = diffCurr;
                max = i;
            }

        }
        return diff;
    }
}
