/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutrod;

/**
 *
 * @author vasanth
 */
public class CutRod {

    int max(int a, int b)
    {
        return ((a > b)?a : b);
    }
    int cutRod(int price[], int n)
    {
        if (n <= 0)
            return 0;
        int max_val = java.lang.Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) 
            max_val = max(max_val, price[i] + cutRod(price, n - i - 1));
        return max_val;
        
    }
    int cutRodDyn(int price[], int n) 
    {
        int val[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max_val = -1;
            for (int j = 0; j < i; j++) {
                max_val = max(max_val, price[j] + val[ i - j - 1]);
            }
            val[i] = max_val;
        }
        return val[n];
    }
    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println("cut rod maximum obtainable benefit:"+new CutRod().cutRod(price, price.length));
        System.out.println("cut rod maximum obtainable benefit:"+new CutRod().cutRodDyn(price, price.length));
    }
}
