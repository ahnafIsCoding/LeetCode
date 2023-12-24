/* https://leetcode.com/problems/path-crossing/?envType=daily-question&envId=2023-12-23 */

import java.util.List;
import java.util.ArrayList;

public class LC1496 {
   
   public static boolean isPathCrossing(String path) {
      
      List<int[]> coordinates = new ArrayList<>();
      int[] origin = new int[2];
      origin[0] = origin[1] = 0;
      coordinates.add(origin);
      
      int[] point = new int[2];
      point[0] = point[1] = 0;
      
      for (int i = 0; i < path.length(); i++) {
         if (path.charAt(i) == 'N') point[1] = point[1]+1;
         if (path.charAt(i) == 'E') point[0] = point[0]+1;
         if (path.charAt(i) == 'S') point[1] = point[1]-1;
         if (path.charAt(i) == 'W') point[0] = point[0]-1;
         
//         System.out.println(i+": "+point[0]+","+point[1]);
         
         for (int j = 0; j < coordinates.size(); j++) {
            if (coordinates.get(j)[0] == point[0] && coordinates.get(j)[1] == point[1]) return true;
         }
         int[] newPoint = new int[2];
         newPoint[0] = point[0];
         newPoint[1] = point[1];
         coordinates.add(newPoint);
//         System.out.println(coordinates);
      }
      return false;
   }
   
   public static void main(String[] args) {
      String s = "NESSW";
      if (isPathCrossing(s)) System.out.println("Path crossed!");
      else System.out.println("Path not crossed!");
   }

}
