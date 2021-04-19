//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1605 👎 0


package leetcode.editor.cn;

//Java：爬楼梯
public class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            //return climbStairsRecursion(n, new int[n + 1]);
            return climbStairsDP(n);
        }

        /**
         * 递归实现
         *
         * @param n
         * @param dict
         * @return
         */
        public int climbStairsRecursion(int n, int[] dict) {
            //base case
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            //从备忘录直接返回计算过的数据
            if (dict[n] != 0) {
                return dict[n];
            }
            //状态转移方程 dp[n]=dp[n-1]+dp[n-2]
            dict[n] = climbStairsRecursion(n - 1, dict) + climbStairsRecursion(n - 2, dict);
            return dict[n];
        }

        public int climbStairsDP(int n) {
            int pre = 0;
            int cur = 1;
            int tmp;
            for (int i = 0; i < n; i++) {
                tmp = pre + cur;
                pre = cur;
                cur = tmp;
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}