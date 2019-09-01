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
 *          
 *  max contiguous sum in 1D array using kadane's algorithm
 * 
 */

private class SumObject{
    int sum, start, end;

    SumObject(int sum,int start,int end){

        this.sum = sum;
        this.start = start;
        this.end = end;
    }    
}

public SumObject getMax1D(int[] nums){

    int max_so_far = nums[0];
    int max_global = nums[0];
    int start = 0,end = 0;
        
    for(int i=1;i<nums.length;i++){

        if(nums[i] > max_so_far && nums[i] + max_so_far < nums[i]){
            
            max_so_far = nums[i];
            start = i;
        }else
             max_so_far += nums[i];
        
        if(max_so_far > max_global){
            
            max_global = max_so_far;
            end = i;
        }
        
        
    }
    return new SumObject(max_global,start,end);
}



/**
 *  Maximum sum rectangle in a 2D matrix 
 *  time complexity O(col^2 * row) 
 *  space complexity O(row)
 * 
 */


 private class Kadane2D{
    int max_sum,left,right,top,bottom;
    Kadane2D(int max_sum,int left,int right,int top,int bottom){
        this.max_sum = max_sum;
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }
 }

public Kadane2D getMax2D(int[][] matrix){
 
    int[] cache = new int[matrix.length]; //store the intermediate data 
    int col = matrix[0].length;
    Kadane2D kadane2d = new Kadane2D( Integer.MIN_VALUE , -1, -1, -1, -1);

    for(int left = 0; left<col; left++){

        for(int i=0;i<cache.length;i++) cache[i] = 0; // reset    


        for(int right = left;right<col;right++){

             for(int i=0;i<matrix.length;i++) cache[i] += matrix[i][right];

             SumObject sumObject = getMax1D(cache);

             if(sumObject.sum > kadane2d.max_sum){

                kadane2d.max_sum = sumObject.sum;
                kadane2d.left = left;
                kadane2d.right = right;
                kadane2d.top = sumObject.start;
                kadane2d.bottom = sumObject.end;

             }   


        }


    }

    return kadane2d;

}    




public static void main(String[] args){
    //test your code here
}


}





