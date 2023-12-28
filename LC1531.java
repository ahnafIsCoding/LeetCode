
/* https://leetcode.com/problems/string-compression-ii/?envType=daily-question&envId=2023-12-28 */

import java.util.HashMap;
import java.util.regex.Pattern;

public class LC1531 {
   
   public static int getLengthOfOptimalCompression(String s, int k) {
      
      String str = "";
      int n = 1;
      int ltrNum = 0;
      for (int i = 0; i < s.length(); i++) {
         int j = i;
         while (j != s.length()-1 && s.charAt(j) == s.charAt(j+1)) {
            n++;
            j++;
         }
         str += Character.toString(s.charAt(j));
         if (n > 1) {
            str += Integer.toString(n);
//            ltrNum += Integer.toString(n).length()+1;
            ltrNum++;
            n = 1;
         }
         i = j;
      }
      int size = str.length();
//      int ltr = size - ltrNum;
      int i = 0;
      while (i < size && k > 0) {
         System.out.println(i+" "+str);
         if (Pattern.matches("[a-z]", Character.toString(str.charAt(i)))) {
            if (i < size - 1) {
               if (!Pattern.matches("[0-9]", Character.toString(str.charAt(i+1)))) {
                  String temp = str.substring(i+1);
                  str = str.substring(0,i) + temp;
                  size--;
               } else i++;
            } else {
               str = str.substring(0,i);
               size--;
            }
         } else i++;
      }
      
      /*
      if (k > 0) {
         HashMap<String,String> map = new HashMap<>();
         i = 0;
         String tempLtr = "";
         String tempNum = "";
         while (i < size - 1 && k > 0) {
            if (Pattern.matches("[a-z]", Character.toString(str.charAt(i)))) {
               tempLtr = Character.toString(str.charAt(i));
               while (Pattern.matches("[0-9]", Character.toString(str.charAt(i+1)))) {
                  tempNum += str.charAt(i+1);
                  i++;
               }
               if (map.containsKey(tempLtr)) {
                  String temp = map.get(tempLtr);
               }
               map.put(tempLtr,tempNum);
               i++;
            }
         }
      }*/
      
      System.out.println(str);
      return str.length(); 
   }

   public static void main(String[] args) {
      String s = "aaabcccd";
      int k = 2;
      System.out.println(s+" -> "+getLengthOfOptimalCompression(s,k));
   }
}
