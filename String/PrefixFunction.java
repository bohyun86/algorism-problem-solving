package string;

public class PrefixFunction {
    public static void main(String[] args) {
        String s = "pullupifIpullup";
        int[] pi = computePrefixFunction(s);
        
        // Print the prefix function array
        for (int value : pi) {
            System.out.print(value + " ");
        }
    }

    public static int[] computePrefixFunction(String s) {
        int n = s.length();
        int[] pi = new int[n];
        int k = 0;

        for (int i = 1; i < n; i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i)) {
                k = pi[k - 1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                k++;
            }
            pi[i] = k;
        }
        return pi;
    }
}