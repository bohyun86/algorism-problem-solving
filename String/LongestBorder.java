package String;

// 프리픽스 함수를 계산하는 함수와 주어진 단어 리스트에서 가장 긴 경계를 찾는 코드

public class LongestBorder {

    public static void main(String[] args) {
        String[] words = {"hirohito", "miyazaki", "murakami", "ichinomiya", "matsumae"};
        int longestBorderLength = findLongestBorder(words);
        System.out.println("The length of the longest border is: " + longestBorderLength);
    }

    public static int findLongestBorder(String[] words) {
        int longestBorder = 0;

        for (String word : words) {
            int[] pi = computePrefixFunction(word);
            for (int length : pi) {
                if (length > longestBorder) {
                    longestBorder = length;
                }
            }
        }

        return longestBorder;
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
