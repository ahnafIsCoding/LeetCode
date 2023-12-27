/* https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/ */

public class LC28 {
   
   public static int strStr(String haystack, String needle) {
      
      for (int i = 0; i <= haystack.length()-needle.length(); i++) 
         if (haystack.substring(i, i+needle.length()).equals(needle)) return i;
      
      return -1;
   }
   
   public static void main(String[] args) {
      String haystack = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
      String needle = "sed";
      System.out.println(strStr(haystack,needle));
   }
}