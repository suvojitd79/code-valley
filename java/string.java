import java.util.*;

public class string{

    /*
    
    Longest Common Prefix

    Input 1:
    A = ["abcdefgh", "aefghijk", "abcefgh"]
    Output 1:
        "a"
    Explanation 1:
        Longest common prefix of all the strings is "a".

    Input 2:
        A = ["abab", "ab", "abcd"];
    Output 2:
        "ab"
    Explanation 2:
        Longest common prefix of all the strings is "ab".

    */

    public String longestCommonPrefix(ArrayList<String> A) {
        
        int max = Integer.MAX_VALUE;
        for(String x: A) max = Math.min(max, x.length());
        
        String x = "";
        
        for(int i=0;i<max;i++){
            
            char c = A.get(0).charAt(i);
            
            
            for(int j=1;j<A.size();j++){
                
                if(A.get(j).charAt(i) != c) return x;
                
            }
            
            x += c;
        }
        
        return x;
    }


    /*
    
    Given a string A.

    Return the string A after reversing the string word by word.

    Input 1:
    A = "the sky is blue"
    Output 1:
        "blue is sky the"

    Input 2:
        A = "this is ib"
    Output 2:
        "ib is this"

    */

    public String solveReverse(String A) {
        
        A = A.trim();

        String[] x = A.split("\\s{1,}");
        
        String s = "";
        
        for(int i=0;i<x.length;i++)
            s += x[x.length-1-i] + " ";
            
        return s!=""?s.trim():A;

    }

    /*

    Your function should return the string "YES" if it is possible to make the given string a palindrome by changing exactly 1 character. Else, it should return the string "NO".

    input: aba 
    output: YES

    input: abba
    output: NO

    */

    public String solvePalindrome(String A) {
        
        int count = 0;
        
        if(A.length() % 2 != 0) count = 1; 
        
        
        int start = 0,end = A.length()-1;
        
        while(start < end){
            
            if(A.charAt(start++) != A.charAt(end--)) count++;
            
        }
        
        return count == 1?"YES":"NO";
        
    }

    public static void main(String[] args){

    }
}