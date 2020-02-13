public class LCM {
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else
            return gcd(b % a, a);
    }

    //15 20
    static int lcm(int a, int b) {
        int ans = (a * b) / gcd(a, b);
        return ans;
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        int c = 6;
        int x = lcm(4, 5);
        System.out.println(lcm(x, c));

    }
}