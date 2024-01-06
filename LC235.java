import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ */

public class LC235 {
   
   
    // Definition for a binary tree node.
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    

   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

      List<TreeNode> ancestorsOfP = new ArrayList<TreeNode>();
      List<TreeNode> ancestorsOfQ = new ArrayList<TreeNode>();
      
      find(root,p,ancestorsOfP);
      find(root,q,ancestorsOfQ);
      
//      ancestorsOfP.
      
      
      return null;
   }
   
   public void find(TreeNode root, TreeNode t, List<TreeNode> T) {
      if (root.equals(t)) {
         T.add(root);
      }
      if (root.val > t.val) {
         T.add(root);
         find(root.left, t, T);
      }
      if (root.val < t.val) {
         T.add(root);
         find(root.right, t, T);
      }
      return;
   }
   
   public static Integer lowestCommonAncestor(Integer[] root, int p, int q) {
      int size = root.length;
      if (root[0] != null) size++;
      Integer[] tree = new Integer[size];
      if (root[0] != null) {
         tree[0] = null;
         for (int i = 1; i < root.length+1; i++) {
            tree[i] = root[i-1];
         }
      } else {
         tree = root;
      }
      
      int indexOfP = 0, indexOfQ = 0;
      
      for (int i = 1; i < tree.length; i++) {
         if (tree[i] != null && tree[i] == p) indexOfP = i;
         if (tree[i] != null && tree[i] == q) indexOfQ = i;
      }
      
      if (indexOfP == indexOfQ) return tree[indexOfP];

      List<Integer> ancestorsOfP = new ArrayList<Integer>();
      List<Integer> ancestorsOfQ = new ArrayList<Integer>();
      
      for (int i = indexOfP; i > 0; i/=2) {
         ancestorsOfP.add(tree[i]);
      }
      
      for (int i = indexOfQ; i > 0; i/=2) {
         ancestorsOfQ.add(tree[i]);
      }
      
      int diff = Math.abs(ancestorsOfP.size() - ancestorsOfQ.size());
      
      if (ancestorsOfP.size() >= ancestorsOfQ.size()) {
         for (int i = diff; i < ancestorsOfP.size(); i++) {
            if (ancestorsOfP.get(i) == ancestorsOfQ.get(i-diff)) return ancestorsOfP.get(i);
         }
      } else {
         for (int i = diff; i < ancestorsOfQ.size(); i++) {
            if (ancestorsOfQ.get(i) == ancestorsOfP.get(i-diff)) return ancestorsOfQ.get(i);
         }
      }
      return null;
   }
  

   public static void main(String[] args) {
      Integer[] root = {6,2,8,0,4,7,9,null,null,3,5};
      int p = 2, q = 8;
      System.out.println(lowestCommonAncestor(root,p,q));
   }
}
