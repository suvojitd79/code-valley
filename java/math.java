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
    


    public static void main(String[] args){

        System.out.println(new math().count(25));

    }

}