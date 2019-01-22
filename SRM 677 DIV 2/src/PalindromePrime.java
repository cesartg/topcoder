import java.util.LinkedList;
import java.util.List;

public class PalindromePrime {
    private static boolean[] isPalindromePrimeArray = createIsPalindromePrimeArray();

    public int count(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (isPalindromePrimeArray[i]) {
                count++;
            }
        }
        return count;
    }

    private static boolean[] createIsPalindromePrimeArray() {
        boolean[] isPalindromePrimeArray = new boolean[1001];
        for (int i = 2; i <= 1000; i++) {
            if (isPalindrome(i) && isPrime(i)) {
                isPalindromePrimeArray[i] = true;
            }
        }
        return isPalindromePrimeArray;
    }

    private static boolean isPalindrome(int i) {
        String s = i + "";
        for (int j = 0; j < s.length() / 2; j++) {
            if (s.charAt(j) != s.charAt(s.length() - j - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int i) {
        for (int j = (int) Math.sqrt(i); j >= 2; j--) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
