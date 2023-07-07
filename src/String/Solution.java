package String;

public class Solution {
    public String longestPalindrome(String A) {
        // Preprocess the input string
        StringBuilder sb = new StringBuilder("#");
        for (char c : A.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }
        String processedString = sb.toString();

        int n = processedString.length();
        int[] palindromeLengths = new int[n]; // Array to store lengths of palindromic substrings
        int center = 0; // Center of the palindrome with the rightmost boundary
        int rightBoundary = 0; // Right boundary of the palindrome with the rightmost boundary

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i; // Mirror index of the current index with respect to the center

            // Check if the current index is within the right boundary
            if (i < rightBoundary) {
                palindromeLengths[i] = Math.min(rightBoundary - i, palindromeLengths[mirror]);
            }

            // Expand around the current index
            while ((i + 1 + palindromeLengths[i])<n && (i - 1 - palindromeLengths[i])>=0 && processedString.charAt(i + 1 + palindromeLengths[i]) == processedString.charAt(i - 1 - palindromeLengths[i])) {
                palindromeLengths[i]++;
            }

            // Update the center and right boundary if necessary
            if (i + palindromeLengths[i] > rightBoundary) {
                center = i;
                rightBoundary = i + palindromeLengths[i];
            }
        }

        // Find the maximum length and corresponding center index
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (palindromeLengths[i] > maxLen) {
                maxLen = palindromeLengths[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2; // Calculate the start index of the longest palindrome
        int end = start + maxLen; // Calculate the end index of the longest palindrome

        return A.substring(start, end);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.longestPalindrome("baab"));
    }
}
