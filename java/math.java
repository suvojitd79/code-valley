import java.util.*;

public class math{

    /**
    * 
    Largest Coprime Divisor
    You are given two positive numbers A and B. You need to find the maximum valued integer X such that:
    X divides A i.e. A % X = 0
    X and B are co-prime i.e. gcd(X, B) = 1
    For example,
    A = 30
    B = 12
    We return
    X = 5
     */

    public int cpFact(int A, int B) {

        while(gcd(A,B)!=1){
            
            A = A / gcd(A,B);
            
        }
        return A;
    }

    public int gcd(int x,int y){
        
        if(y==0) return x;
        
        return gcd(y,x%y);
    }

    /**
     * Day of the week
     *  (sakamoto's algorithm)
     */

    public String solveGetDay(int A, int B, int C) {
    
        HashMap<Integer,String> map = new HashMap<>();
        map.put(0,"sunday");
        map.put(1,"monday");
        map.put(2,"tuesday");
        map.put(3,"wednesday");
        map.put(4,"thursday");
        map.put(5,"friday");
        map.put(6,"saturday");
        
        return map.get(getDay(A,B,C));
    }
    
    public int getDay(int d,int m,int y){
        
        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        y -= m < 3 ? 1:0;       
        return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;

    }
    

    /*
    Count of divisors for multiple queries
    Given an array of integers A, find and return the count of divisors of each element of the array.
    */

    public ArrayList<Integer> solveCountFactorsWithQueries(ArrayList<Integer> A) {
        
        ArrayList<Integer> ans = new ArrayList<>(A.size());    
        
        int max = Collections.max(A);
        
        max += 1;
        
        int[] cache = new int[max];
        
        cache[1] = 1;
        
        for(int i=2;i<max;i++) cache[i] = 2;
        
        
        for(int i=2;i*2<max;i++){
            for(int j=2;i*j<max;j++){
                
                cache[i*j]++ ;   
                
            }
            
        }
        
        for(Integer x: A){
            
            ans.add(cache[x]);
            
        }
        
     return ans;   
    }




    // count the number of factors of a number

    public int count(int x){
        
        
        int n = (int) Math.sqrt(x);
        
        int count = 0;
        
        for(int i=1;i<= n;i++){
            
            if(x % i ==0)
                count += 2;
        }
        return Math.sqrt(x) - n == 0 ? count - 1  : count ;
    }
    
    /*

    Count pairs in array whose sum is divisible by the given number
    Given an array of integers A and an integer B, find and return the number of pairs in A whoes sum is divisible by B. Since the answer may be large, return the answer modulo (10^9 + 7). 
    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.
    Output Format
    Return the total number of pairs for which the sum is divisible by B modulo (10^9 + 7).
    Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 10^9 
    1 <= B <= 10^6
    For Example
    Input 1:
        A = [1, 2, 3, 4, 5]
        B = 2
    Output 1:
        4

    Input 2:
        A = [5, 17, 100, 11]
        B = 28
    Output 2:
        1

    */


    public int solve(ArrayList<Integer> A, int B) {
        
        if(A.size()<2) return 0;
        
        long[] cache = new long[B];
        
        for(Integer x:A) cache[x%B]++;
        
        long count = (cache[0] * (cache[0] - 1))/2;
        
        for(int i=1;i<=B/2-1;i++){
            
            count += cache[i] * cache[B-i];
            
        }
        
        if(B%2==0) count += (cache[B/2]*(cache[B/2]-1))/2;
        else count += cache[B/2] * cache[B/2+1]; 
        
        return (int) (count % 1000000007L);
    }




    /**
    *   Size three subsequences divisible by B
        Given an array of integers A and an integer B. Find and return the number of subsequences of length 3 whose sum is divisible by B.  Since the total number of subsequences may be very large. Return the total number of subsequences of length 3 whose sum is divisible by B modulo (109+7). 
        
        Input Format
        The only argument given is the integer array A.
        Output Format
        Return the number of subsequences of length 3 whose sum is divisible by B modulo (10^9+7). 
        Constraints
        1 <= length of the array <= 100000
        1 <= A[i] <= 10^9 
        1 <= B <= 10^3
        
        For Example
        Input 1:
            A = [6, 1, 1, 4, 1, 5, 3]
            B = 2
        Output 1:
            20

        Input 2:
            A = [4, 10, 9]
            B = 5
        Output 2:
            0
     * 
     */

    public int solve3SumMod(ArrayList<Integer> A, int B) {
        
        long[] cache = new long[B];    
        
        for(Integer x:A){
            cache[x%B]++;
        }
        
        long count = 0;
        
        for(int i=0;i<B;i++){
            for(int j=i;j<B;j++){
             
                int k = (B - (i+j)%B) %B;
                   
                if(k < j) continue; 
                
                if(i==j && j==k)
                    count +=  ((cache[i] * (cache[i]-1)* (cache[i]-2))/6);
                else if(i==j)
                    count += ((cache[i]*(cache[i]-1)*cache[k])/2) ;
                else if(j==k)
                    count += ((cache[j]*(cache[j]-1)*cache[i])/2);
                else if(i==k)
                    count += ((cache[i]*(cache[i]-1)*cache[j])/2);
                else 
                    count += ( cache[i]*cache[j]*cache[k] );
            }
            
        }
        
        return (int) (count % 1000000007L);
    }
    

    /**
     Kingdom War
        Two kingdoms are on a war right now, kingdom X and kingdom Y. As a war specialist of kingdom X, you scouted kingdom Y area. A kingdom area is defined as a N x M grid with each cell denoting a village. Each cell has a value which denotes the strength of each corresponding village. The strength can also be negative, representing those warriors of your kingdom who were held hostages. There's also another thing to be noticed.
        The strength of any village on row larger than one (2<=r<=N) is stronger or equal to the strength of village which is exactly above it.
        The strength of any village on column larger than one (2<=c<=M) is stronger or equal to the strength of vilage which is exactly to its left. (stronger means having higher value as defined above).
        So your task is, find the largest sum of strength that you can erase by bombing one sub-matrix in the grid. Input format:
        First line consists of 2 integers N and M denoting the number of rows and columns in the grid respectively.
        The next N lines, consists of M integers each denoting the strength of each cell.

        1 <= N <= 1500
        1 <= M <= 1500
        -200 <= Cell Strength <= 200
        Output:
        The largest sum of strength that you can get by choosing one sub-matrix.
        Example:
        Input:
        3 3
        -5 -4 -1
        -3 2 4
        2 5 8

        Output:
        19

        Explanation:
        Bomb the sub-matrix from (2,2) to (3,3): 2 + 4 + 5 + 8 = 19

     */
    

    public int solveKingdomWar(ArrayList<ArrayList<Integer>> A) {
        
        int r = A.size();
        int c = A.get(0).size();
        
        
        int[][] cache = new int[r][c]; 
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                
                cache[i][j] = A.get(i).get(j);
                   
            }
        }
        
        
        // suffix sum column wise
        for(int i=2;i<=c;i++){
            for(int j=0;j<r;j++){
                    cache[j][c-i] = cache[j][c-i+1] + cache[j][c-i];
            }
        }
    
        //suffix sum row wise
        
        // suffix sum column wise
        for(int i=2;i<=r;i++){
            for(int j=0;j<c;j++){
                    cache[r-i][j] = cache[r-i+1][j] + cache[r-i][j];
            }
        }
        
        int ans = Integer.MIN_VALUE;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                
                ans = Math.max(ans, cache[i][j]);
                   
            }
        }
        
    
        return ans;
    }
    

    /*

    Sub-matrix Sum Queries : 
    
    Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum. Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out. Note: Rows are numbered from top to bottom and columns are numbered from left to right. Sum may be large so return the answer mod 10^9 + 7. 

    */


    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
    
        int r = A.size();
        int c = A.get(0).size();
        int q = B.size();
        int mod = 1000000007;
    
        long[][] cache = new long[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                    
                    cache[i][j] = A.get(i).get(j);
                    
            }
        }
        
        // prefix sum column wise
        
        for(int i=1;i<c;i++){
            for(int j=0;j<r;j++){
                
                cache[j][i] = (cache[j][i] + cache[j][i-1]) % mod; 
                
            }
        }
        
        // prefix sum row wise
        
        for(int i=1;i<r;i++){
            for(int j=0;j<c;j++){
                
                cache[i][j] = (cache[i][j] + cache[i-1][j]) % mod; 
                
            }
        }
        
        ArrayList<Integer> a = new ArrayList<>();
        
        
        for(int i=0;i<q;i++){
            
            int x1 = B.get(i)-1, y1 = C.get(i)-1;
            int x2 = D.get(i)-1, y2 = E.get(i)-1;
            
            long ans = cache[x2][y2];
            
            if(x1-1 >= 0) 
                ans = ( ans - cache[x1-1][y2]) % mod;
            if(y1-1 >= 0)
                ans = ( ans - cache[x2][y1-1]) % mod;
            if(x1-1 >= 0 && y1-1 >= 0)
                ans = (ans + cache[x1-1][y1-1]) % mod;
            
            ans = ( ans + mod ) % mod;
            
            a.add((int) ans);
            
        }
        
        return a;
        
    }





    /*

    Number Of Digit One : 

    Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

    Example:

    Input: 13
    Output: 6 
    Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

    */


    public int solveDigit1(int A) {
        
        
        int ans = 0;
        
        for(long i=1;i<=A;i*=10){
            
            long d = 10 * i;
            
            ans += ((A/d) * i) + Math.min(Math.max(A % d - i + 1, 0), (int) i);
            
        }
        
        return ans;
        
        }


    /*
            
        Count of paths in a grid
        Given an integer A, find and return the number of paths in a grid of size (A x A) that starts from (1, 1) and reaches (A, A) without crossing the major diagonal. Since the result can be large, return the result modulo (10^9 + 7). 
        Input Format
        The only argument given is integer A.
        Output Format
        Return the number of paths modulo (10^9 + 7).
        Constraints
        1 <= A <= 10^6
        For Example
        Input 1:
            A = 2
        Output 1:
            1

        Input 2:
            A = 5
        Output 2:
            14
    */

    public int solveCatalan(int A) {
        
        long[] cache = new long[A];
        cache[0] = 1;
        cache[1] = 1;
        int mod = 1000000007;
        
        for(int i = 2;i<A;i++){
            cache[i] = 0;
            for(int j=0;j<i;j++){
                
                cache[i] += cache[j] * cache[i-j-1];
                cache[i] = cache[i] % mod; 
            }
            
        }    
        
        return (int) ((cache[A-1] + mod) % mod);
        
    }




    public static void main(String[] args){

        System.out.println(new math().count(25));

    }
    

}