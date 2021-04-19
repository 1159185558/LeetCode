//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 488 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的后序遍历
public class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
        // TO TEST
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        List<Integer> list = solution.postorderTraversal(node1);
        System.out.println(list);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private List<Integer> list = new LinkedList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            //recursionPost(root);
            loopPost(root);
            return list;
        }

        /**
         * 递归实现
         *
         * @param node
         */
        private void recursionPost(TreeNode node) {
            if (node == null) return;
            recursionPost(node.left);
            recursionPost(node.right);
            list.add(node.val);
        }

        /**
         * 后序遍历是左右根，先按照前序遍历的思想，先访问右子树，后访问左子树，即根右左
         * 此时得到的遍历顺序为根左右是后序遍历的逆序，将得到的list进行逆序操作即可
         *  执行耗时:1 ms,击败了49.37% 的Java用户
         * 	内存消耗:36.8 MB,击败了70.16% 的Java用户
         * @param node
         */
        private void loopPost(TreeNode node) {
            if (node == null) return;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);
            //循环后list中存储的是后序遍历的逆序
            while (!stack.empty()) {
                TreeNode item = stack.pop();
                list.add(item.val);
                if (item.left != null) {
                    stack.push(item.left);
                }
                if (item.right != null) {
                    stack.push(item.right);
                }
            }
            //对list进行逆序操作
            int start = 0, end = list.size() - 1;
            while (list != null && (start < end)) {
                Integer tmp = list.get(start);
                list.set(start, list.get(end));
                list.set(end, tmp);
                start++;
                end--;
            }
        }

        private void loopPost1(TreeNode node){
            if (node==null)return;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode item = node;
            stack.push(node);
            while (!stack.empty()){
                while (item.left!=null){
                    stack.push(item.left);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}