/*
	方法一：中心扩展法
 */
class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) {
            extendPalidrome(s, i, i); // 中心是奇数的扩展 aba
            extendPalidrome(s, i, i + 1); // 中心是偶数的扩展 abba
        }
        
        return count;
    }
    
    private void extendPalidrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }
}


/*
	方法二：Manaster's algorithm
 */
class Solution {
    public int countSubstrings(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z) ans += (v + 1) / 2;
        return ans;
    }
}
