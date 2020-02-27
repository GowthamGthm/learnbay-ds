

public class StringMatchingPatternAlgorithm {

    public static int MOD_VALUE = 101;

    public static void main(String[] args) {
        String txt = "1234567";
        String pat = "12345";
        bruteForceApproach(txt, pat);
        rabinKarpAlgorithm(txt, pat);

    }

    // O(m*n)
    static void bruteForceApproach(String txt, String pat) {

        for (int i = 0; i < txt.length() - pat.length(); i++) {
            int j = i;
            int count = 0;
            if (pat.charAt(0) == txt.charAt(i)) {
                int k = 0;
                while (txt.charAt(j++) == pat.charAt(k++)) {
                    count++;
                    if (count == pat.length()) {
                        System.out.println("true");
                        return;
                    }
                }
            }

        }
        System.out.println("false");
    }

    // Rabin karp's algorithm
    static void rabinKarpAlgorithm(String txt, String pat) {
        int patLength = pat.length();
        int hashCodeForPattern = 0;
        int hashCodeForTextWindow = 0;
        for (int j = 0; j < patLength; j++) {
            hashCodeForPattern += (hashCodeForPattern * 10 + pat.charAt(j)) % MOD_VALUE;
            hashCodeForTextWindow += (hashCodeForTextWindow * 10 + txt.charAt(j)) % MOD_VALUE;
        }
        for (int i = 0; i < txt.length() - patLength; i++) {
            if (hashCodeForPattern != hashCodeForTextWindow) {
                hashCodeForTextWindow = calculateHashCodeForSecondOnwardsWindows
                        (hashCodeForTextWindow, txt, i, patLength);
                continue;

            }
            int count = 0;
            int k = i;
            while (txt.charAt(k) == pat.charAt(k)) {
                k++;
                count++;
                if (count == pat.length()) {
                    System.out.println("true");
                    return;
                }
            }

        }
        System.out.println("false");

    }

    private static int calculateHashCodeForSecondOnwardsWindows(int hashCodeForTextWindow,
                                                                String txt, int prevElement, int patLength) {
        return (hashCodeForTextWindow -
                txt.charAt(prevElement) * 10) % MOD_VALUE
                + txt.charAt(prevElement + patLength);
    }

}
