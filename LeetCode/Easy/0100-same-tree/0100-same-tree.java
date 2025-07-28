/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean dfs(TreeNode tnp, TreeNode tnq){
        //tree 끝까지 갔는데도 false가 리턴되지 않으면 그동안 모든 노드의 값이 같았단 얘기
        if(tnp == null && tnq == null) return true; 
        
        //서로 상태가 다른 경우 false 리턴
        if(tnp == null || tnq == null) return false; 
        if(tnp.val != tnq.val) return false;

        return dfs(tnp.left, tnq.left) && dfs(tnp.right, tnq.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
}