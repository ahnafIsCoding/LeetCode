// https://leetcode.com/problems/decode-ways/?envType=daily-question&envId=2023-12-25

public class LC96 {
   
   public static int numDecodings(String s) {
      
      if (s.charAt(0) == '0') return 0;
      
      int num = 1;
      
      for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) != '0') {
            System.out.println("1: "+num);
            if (i < s.length()-1) {
               if (s.charAt(i) == '1') num++;
               System.out.println("2: "+num);
               if (s.charAt(i) == '2' && Character.getNumericValue(s.charAt(i+1)) <= 6) num++;
               System.out.println("3: "+num);
            }
         } else num--;
      }
      
      return num;
   }

   public static void main(String[] args) {
      System.out.println("Total: "+numDecodings("21105"));
   }

}

// how to split strings and find out how many combinations are possible?
