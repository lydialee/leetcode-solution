/* 1 费马定理 Fer'mat Theorem
     time: O(√c*logc), space: O(1)
     1） 第一层 - for 循环：最多 0~√c 个 prime factor，
     2） 第二层 - while 循环：每个 prime factor 最多循环 logc 次。
         i = 2， logc; i = 3, log3c; i = 4, log4c; ...
     因此总共最坏情况：O(√c*logc)

     Any positive number nn is expressible as a sum of two squares 
     if and only if the prime factorization of n, 
     every prime of the form (4k+3) occurs an even number of times.
     
     如果一个自然数是两个数的平方和，
     当且仅当，这个数质因式分解数中，[每一个]模 4 余 3 的质因数的个数，都是偶数。
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        // prime factorization 质因数分解：辗转相除法。Euclidean algorithm
        for (int i = 2; i * i <= c; i++) {  // [2, √c]
            int count = 0;
            // 如果能被2整除，
            if (c % i == 0) {
                // 则一直除到不能再除为止。
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                // 对于每个 i ，都检查一下，是否模 4 余 3
                // 假如模 4 余 3，个数却不是偶数，则立即 return false
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3; // 最后除剩下的c 肯定是质因数。只有一个，所以只需要它是不是模 4 余 3。
    }
}

// 2 two pointers
// time：O(√c*logc), space: O( 1 )
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int low = 0, high = (int)Math.sqrt(c);
        while (low <= high) {
            int sum = low * low + high * high;
            if (sum < c) {
                low++;
            } else if (sum > c) {
                high--;
            } else {
                return true;
            }
        }
        return false;
    }
}

// 3 sqrt time: O( √c*logc ) , space: O( 1 )
class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) {
            double b = Math.sqrt(c - i * i);
            if (b == (int)b) {
                return true;
            }
        }
        return false;
    }
}

