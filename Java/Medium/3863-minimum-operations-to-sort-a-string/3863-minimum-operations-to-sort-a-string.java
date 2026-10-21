
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Step 1: Check if already sorted
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) return 0;

        // Step 2: Length 2 and unsorted
        if (n == 2) return -1;

        // Step 3: Find minimum and maximum characters
        char min = s.charAt(0);
        char max = s.charAt(0);

        for (int i = 1; i < n; i++) {
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        // Step 4: Only one operation needed
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Step 5: Check middle characters
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        // Step 6: Remaining case
        return 3;
    }
}
