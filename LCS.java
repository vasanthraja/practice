/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lcs;

/**
 *
 * @author vasanth
 */
public class LCS {

    /**
     * @param args the command line arguments
     */
    int max(int a, int b)
    {
        return (a > b)?a:b;
    }
    int lcs(char [] x, char []y, int m, int n)
    {
        if (m == 0 || n == 0)
            return 0;
         if (x[m - 1] == y[n - 1])
             return 1 + lcs(x, y, m - 1, n -1);
         else
             return max(lcs(x, y, m -1, n), lcs(x, y, m, n - 1));
        
    }
    int lcsDyn(char []x, char []y, int m, int n) 
    {
        int lcs[][] =  new int[m + 1][n + 1];
        for (int k = 0; k <= m; k++) {
            for (int l = 0; l <= n; l++) {
            if (k == 0 || l == 0 )
               lcs[k][l] =  0;      
                
            }   
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1])
                    lcs[i][j] = 1 + lcs[ i - 1][j - 1];
                else
                    lcs[i][j] =  max(lcs[i - 1][j], lcs[i][j -1]);
            }
            
        }
        
        /*Print the least common subsequence*/
        System.out.println("");
        recons(x, y, m, n, lcs);
        System.out.println("");
        return lcs[m][n];
    }
    public void recons(char []x, char []y, int m, int n, int lcs[][])
    {
        if (m == 0 || n == 0)
            return;
        else if (x[m - 1] == y [n - 1])
        {
            recons(x, y, m - 1, n -1, lcs);
            System.out.print("" + x[m - 1]);
        }
        else if (lcs[m][n] == lcs[m - 1][n])
            recons(x, y, m - 1, n, lcs);
        else
            recons(x, y, m, n - 1, lcs);
            
    }
    public static void main(String[] args) {
        char x[] = {'A','G', 'G','M', 'X', 'T', 'Y', 'G', 'A','B'};
        char y[] = {'X', 'G', 'G', 'T', 'X', 'Y', 'A', 'B'};
        System.out.println("" + new LCS().lcs(x, y, x.length, y.length));
        System.out.println("" + new LCS().lcsDyn(x, y, x.length, y.length));
    }
}
