//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 798 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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

        public List<Integer> inorderTraversal(TreeNode root) {
            //return loop(root);
            recursion(root);
            return list;
        }

        /**
         * 迭代方式实现遍历
         * 执行耗时:1 ms,击败了42.83% 的Java用户
         * 内存消耗:36.9 MB,击败了58.18% 的Java用户
         *
         * @param root
         * @return
         */
        private List<Integer> loop(TreeNode root) {
            if (root == null) return new LinkedList<>();
            List<Integer> list = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode item = root;
            while (!stack.empty()) {
                while (item.left != null) {
                    stack.push(item.left);
                    item = item.left;
                }
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                    item = node.right;
                }
            }
            return list;
        }

        /**
         * 递归中序遍历
         * 执行耗时:0 ms,击败了100.00% 的Java用户
         * 内存消耗:36.5 MB,击败了91.19% 的Java用户
         *
         * @param node
         */
        private void recursion(TreeNode node) {
            if (node == null) return;
            recursion(node.left);
            list.add(node.val);
            recursion(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}