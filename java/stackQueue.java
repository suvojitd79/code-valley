import java.util.*;
public class stackQueue{

    /*

        Largest Rectangle in Histogram	
        
    */

    public int maxArea(ArrayList<Integer> list){

        int max_area = 0, global_max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        
        int i = 0;

        while(i<list.size()){

            if(stack.isEmpty() || list.get(stack.peekLast()) <= list.get(i))    
                {
                    stack.addLast(i);
                    i++;
                }
            else{

                // calculate the area
                int h = list.get(stack.peekLast());
                stack.removeLast(); 
                max_area = h * (stack.isEmpty()?i:i-stack.peekLast()-1);
                if(max_area > global_max) 
                    global_max = max_area;
            }    


        }

        while(!stack.isEmpty()){

            int h = list.get(stack.peekLast());
            stack.removeLast();
            max_area = h * (stack.isEmpty()?i:i-stack.peekLast()-1);
                if(max_area > global_max) 
                    global_max = max_area;

        }

        return global_max;
    }


    /*

    Nearest Smaller Element	

    */

    public ArrayList<Integer> getSmallerElement(ArrayList<Integer> A){

        ArrayList<Integer> list = new ArrayList<>();
        if(A.size()==0) return list;
        LinkedList<Integer> stack = new LinkedList<>();
        
        
        for(int i=0;i<A.size();i++){
            
            while(!stack.isEmpty() && stack.peekLast() >= A.get(i))
                stack.removeLast();
            if(stack.isEmpty())
                list.add(-1);
            else
                list.add(stack.peekLast());
        
            stack.addLast(A.get(i));
        }
        
        return list;

    }



    /*

    Gas station

    */

    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        
        if(A.size()==0) return -1;
        if(A.size()==1) return 0;
        
        int start = 0,end = 1;
        
        int curr = A.get(start) - B.get(start);
        
        while(curr<0 || start!=end){
            
            while(curr<0 && start != end){
                
                curr -= A.get(start) - B.get(start);
                
                start = (start + 1) % A.size();
                
                if(start == 0) return -1;
            
            }
            
            curr += (A.get(end) - B.get(end));
            end = (end + 1) % A.size();
            
        }
        
        return start;
        
    }



    /*

    Reversing the first B elements of queue	

    */

    public ArrayList<Integer> solveReverseB(ArrayList<Integer> A, int B) {
        
        int n = A.size();
        LinkedList<Integer> stack = new LinkedList<>();
        
        for(int i=n-1;i > B-1;i--)
            stack.addLast(A.get(i));
        for(int i=0;i<B;i++)
            stack.addLast(A.get(i));
        int i=0;
        while(!stack.isEmpty())
            A.set(i++, stack.pollLast());
        return A;
    }

    /*
    N integers containing only 1,2 and 3
    Given an integer A. Find and Return first positive A integers in ascending order containing only digits 1,2 and 3.
    
    Input 1:
    A = 3
    Output 1:
        [1, 2, 3]

    Input 2:
        A = 7
    Output 2:
        [1, 2, 3, 11, 12, 13, 21]
    */


    public static void main(String[] args){

        System.out.println(new stackQueue().maxArea(new ArrayList<>(Arrays.asList(1))));
        
    }

}