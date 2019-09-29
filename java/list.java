import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class list{
    
    /*
        Merge two sorted linked lists
    */

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        
        if(A==null) return B;
        
        if(B==null) return A;
        
        ListNode root = new ListNode(0);
        ListNode r = root;
        
        while(A!=null && B!=null){
            
            if(A.val < B.val){
                
                root.next = A;
                root = A;
                A = A.next;
            }else{
                
                root.next = B;
                root = B;
                B = B.next;
            }
            
        }
        
        if(A != null) root.next = A;
        if(B != null) root.next = B;
    
        return r.next;
        
    }


    /*

    Intersection of Linked Lists

    */
    

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        
        if(a==null || b==null) return null;
        
        ListNode t1 = a;
        ListNode t2 = b;
        
        
        int d1 = 1,d2=1;
        
        while(t1 != null){
            
            t1 = t1.next;
            d1++;
        }
        
        while(t2 != null){
            
            t2 = t2.next;
            d2++;
        }
     
     int m = 0;
     if(d1 < d2){
         
        m = (d2-d1);
        while(m!=0){
               
            b = b.next;
            m --;
            
        } 
         
     }else{
         
         m = (d1-d2);
         
        while(m!=0){
               
            a = a.next;
            m --;
            
        } 
        
     }
     
     while(a!=b){
         
         a = a.next;
         b = b.next;
         
     }
     return a;
        
    }


    /*
   
    Flatten a Linked List


    Input 1:
    3 -> 4 -> 20 -> 20 ->30
    |    |    |     |    |
    7    11   22    20   31
    |               |    |
    7               28   39
    |               |
    8               39

    Output 1:
    3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39 

    */


    /*
    class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }
    */



    ListNode flatten(ListNode root) {
        
        if(root == null || root.right ==null) return root;    
        
        root.right = flatten(root.right);
        
        root = mergeTwoLists(root, root.right);
        
        return root;
        
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
            
            if(A==null) return B;
            
            if(B==null) return A;
            
            ListNode root = new ListNode(0);
            ListNode r = root;
            
            while(A!=null && B!=null){
                
                if(A.val < B.val){
                    
                    root.down = A;
                    root = A;
                    A = A.down;
                }else{
                    
                    root.down = B;
                    root = B;
                    B = B.down;
                }
                
            }
            
            if(A != null) root.down = A;
            if(B != null) root.down = B;
        
            return r.down;
            
        }




    /*

    clone a linked list with next and random pointer
    
    */

        /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */

    public RandomListNode copyRandomList(RandomListNode head) {
        
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        
        RandomListNode temp = head;
        
        while(temp != null){
            
                RandomListNode copy = new RandomListNode(temp.label);
                map.put(temp, copy);
                temp = temp.next;
        }
        
        temp = head;
        
        while(temp != null){
            
                RandomListNode copy = map.get(temp);
                copy.next = map.get(temp.next);
                copy.random = map.get(temp.random);
                temp = temp.next;
        }
        
        return map.get(head);
    }



    public static void main(String[] args){

        
    }


}