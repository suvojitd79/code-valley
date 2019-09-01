import java.util.*;
public class dp {
    
/**

word break problem

*/

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
    
    

/**
 *  FROG JUMP - 

 */

 //DFS solution
 public boolean canCross(int[] stones) {    
    if(stones.length==0) return true;
    
    HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
    
    for(int i=0;i<stones.length;i++)
        map.put(stones[i], new HashSet<Integer>());
    
    HashSet<Integer> data = map.get(stones[0]);
    data.add(1);
    
    
    for(int i=0;i<stones.length;i++){
        
        int stone = stones[i];
        
        for(Integer x:map.get(stones[i])){
            
                int reach = stone + x;
            
                if(reach == stones[stones.length-1]) return true;
                
                HashSet<Integer> r = map.get(reach);
            
                if(r != null){
                    
                    r.add(x);
                    if(x-1 > 0) r.add(x-1);
                    r.add(x+1);
                }
            
        }
        
        
    }
    
    return false;
}




/**
 * 
 *  Arithmetic Subsequences	

 * 
 */






/**
 *  Maximum sum rectangle in a 2D matrix 
 * 
 * 
 */



}





