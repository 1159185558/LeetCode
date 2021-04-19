package DS;

/**
 * 利用树的后序遍历实现寻找BST树中第K大的结点
 */
public class FindBST_K_Node {

    static int i = 0;
    static int val = 0;

    public int kthLargest(TreeNode root, int k) {
        i = k;
        DFS(root);
        return val;
    }


    //树的遍历为算法的及基础模板，要牢记
    private void DFS(TreeNode node) {
        if (node == null) return;
        DFS(node.right);
        i--;
        if (i == 0) {
            val = node.val;
            return;
        }
        DFS(node.left);
    }

}
