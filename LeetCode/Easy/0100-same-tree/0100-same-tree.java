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
    public boolean bfs(TreeNode p, TreeNode q){
        //TreeNode 저장해둘 큐 선언
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while(!queue.isEmpty()){
            TreeNode tn1 = queue.poll();
            TreeNode tn2 = queue.poll();
            
            if(tn1==null && tn2==null) continue; //재귀함수가 아니므로 아직 큐에 남아있는 노드를 확인하고 처리해야함 -> continue 처리
            if(tn1==null || tn2==null) return false;
            if(tn1.val != tn2.val) return false;

            queue.offer(tn1.left);
            queue.offer(tn2.left);
            queue.offer(tn1.right);
            queue.offer(tn2.right);
        }

        return true;
    }

    public boolean dfs(TreeNode tnp, TreeNode tnq){
        //tree 끝까지 갔는데도(더이상 방문할 노드가 없음) false가 리턴되지 않으면 그동안 모든 노드의 값이 같았단 얘기
        if(tnp == null && tnq == null) return true; 
        
        //서로 상태가 다른 경우 false 리턴
        if(tnp == null || tnq == null) return false; 
        if(tnp.val != tnq.val) return false;
        
        //왼, 오 영역 탐색 중 하나라도 false가 나오면 결과는 false
        //즉, 모든 영역이 조건을 만족해야 true 리턴
        return dfs(tnp.left, tnq.left) && dfs(tnp.right, tnq.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return bfs(p,q);
        return dfs(p,q);
    }
}