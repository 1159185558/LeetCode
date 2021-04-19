//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 476 👎 0


package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的前序遍历
public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
        // TO TEST
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

        public List<Integer> preorderTraversal(TreeNode root) {
            preOrder(root);
//            recursionPreOrder(root);
            return list;
        }

        /**
         * 递归实现树的前序遍历
         *  执行耗时:0 ms,击败了100.00% 的Java用户
         * 	内存消耗:36.6 MB,击败了60.49% 的Java用户
         * @param node
         */
        private void preOrder(TreeNode node) {
            if (node == null) return;
            list.add(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }

        /**
         * 利用栈来实现树的前序遍历
         *  执行耗时:1 ms,击败了41.12% 的Java用户
         * 	内存消耗:36.8 MB,击败了42.66% 的Java用户
         * @param node
         */
        private void recursionPreOrder(TreeNode node) {
            if (node == null) return;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);
            while (!stack.empty()) {
                TreeNode item = stack.pop();
                list.add(item.val);
                if (item.right != null) {
                    stack.push(item.right);
                }
                if (item.left != null) {
                    stack.push(item.left);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}