/**

 word break problem

*/

public class Solution {
    
    public int wordBreak(String A, ArrayList<String> B) {
        
        int n = A.length();
        int[] cache = new int[n];
        int ans = solve(0, cache, A, B);
        return ans == 1?1:0;
            
    }
    
    public boolean startsWith(int skip,String data,String A){
        
        if((skip + data.length()) > A.length()) return false;
        
        for(int i=0;i<data.length();i++){
            if(A.charAt(skip+i) != data.charAt(i)) return false;
        }
        return true;
    }
    
    
    public int solve(int start, int[] cache, String A, ArrayList<String> B){
        
        //base case
        if(start == A.length()) return 1;
        
        if(cache[start] != 0) return cache[start]; 
        
        int ans = -1;
        
        for(int i=0;i<B.size();i++)
            if(startsWith(start, B.get(i), A) && solve(B.get(i).length() + start , cache, A , B) == 1){
               ans = 1;
               break;
        }
        
        cache[start] = ans;
        return ans;
    }
    
    
}

