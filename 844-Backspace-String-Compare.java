/*
 * solution 1 - Stack
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return getAfterDelete(S).equals(getAfterDelete(T));
        
    }
    
    private String getAfterDelete(String S) {
        Stack<Character> rest = new Stack();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                rest.push(c);
            } else if (!rest.empty()) {
                rest.pop();
            }
        }
        
        return String.valueOf(rest);
    }
}

/*
 * solution 2 - Two Pointers
 */

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
                
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;
            if ((i >= 0) != (j >= 0)) return false; // could both be < 0
            i--;
            j--;
        }
        return true;
    }
}