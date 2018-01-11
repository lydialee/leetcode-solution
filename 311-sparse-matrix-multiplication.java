/*
    图解：
    A: m1 * n1
     1,   0,   0 <- i = 1    - line a1 
    -1,   0,   3 <- i = 2    -      a2
    |     |    |
   j=0   j=1   j=2

    B:  m2 *  n2
col b1   b2   b3
    |    |    |
    7,   0,   0 <- j = 0
    0,   0,   0 <- j = 1
    0,   0,   1 <- j = 2
    |    |   |
   k=0  k=1 k=2

    C: m1 * n2, obviously
    a1b1, a1b2, a1b3
    a2b1, a2b2, a2b3
 */

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m1 = A.length;
        int n1 = A[0].length;
        int m2 = B.length; // no use
        int n2 = B[0].length;
        int[][] matrix = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < n2; k++) {
                    if( B[j][k]!=0 )
                    matrix[i][k] += A[i][j] * B[j][k];
                }       
            }
        }
        return matrix;
    }
}