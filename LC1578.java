/* https://leetcode.com/problems/minimum-time-to-make-rope-colorful/?envType=daily-question&envId=2023-12-27 */

public class LC1578 {
   
   public static int minCost(String colors, int[] neededTime) {
      
      int total = 0;
      for (int i = 0; i < colors.length(); i++) {
          int max = 0;
          int j = i;
          while (j != colors.length()-1 && colors.charAt(j) == colors.charAt(j+1)) {
              total += neededTime[j];
              if (max < neededTime[j]) max = neededTime[j];
              j++;
          }
          total += neededTime[j];
//          System.out.print("["+i+"] "+colors.charAt(i)+", Total: "+total+"->");
          if (max < neededTime[j]) max = neededTime[j];
          total -= max;
//          System.out.println(total);
          i = j;
      }
      return total;
   }
   
   public static void main(String[] args) {

      String colors = "abc";
      int[] neededTime = {1,2,3};
      System.out.println(minCost(colors,neededTime));
     
      String colors1 = "abbcccaaaababbbbb";
      int[] neededTime1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
      System.out.println(minCost(colors1,neededTime1));
   }
}
