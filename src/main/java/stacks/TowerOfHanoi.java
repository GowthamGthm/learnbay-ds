
/*
Tower of Hanoi.
*/


import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        towerOfHanoi(4,'A','B','C');
    }

    private static void towerOfHanoi(int n, char a, char b, char c) {

        if(n==1)
        {
            System.out.println(a+"->"+b);
            return;        }

        towerOfHanoi(n-1,a,c,b);// head recursion
        System.out.println(a+"->"+b);
        towerOfHanoi(n - 1, c, b, a);// tail recursion


    }

}
