
public class LC1422 {
   
      public static int maxScore(String s) {
          int left, right, total = 0;

          for (int i = 1; i < s.length(); i++) {
              String l = s.substring(0,i);
              String r = s.substring(i);
              
              left = right = 0;
              
              for (int j = 0; j < l.length(); j++) {
                  if (l.charAt(j) == '0') left++;
              }
              
              for (int j = 0; j < r.length(); j++) {
                 if (r.charAt(j) == '1') right++;
              }
             int temp = left+right;
             if (temp>total) {total = temp;}
             
             System.out.println(l+": "+left);
             System.out.println(r+": "+right);
             System.out.println("total: "+total+'\n');
          }
          return total;
      }
  
   public static void main(String[] args) {
      System.out.println("Max: "+maxScore("011101"));
   }

}
