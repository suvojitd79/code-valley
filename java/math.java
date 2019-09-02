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
    
    

    public static void main(String[] args){

        System.out.println(new math().count(25));

    }
    

}