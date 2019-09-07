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





    */





    public static void main(String[] args){

        
    }

}