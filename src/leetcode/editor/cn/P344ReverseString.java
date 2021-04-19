//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 双指针 字符串 
// 👍 332 👎 0


package leetcode.editor.cn;


//Java：反转字符串
public class P344ReverseString {
    public static void main(String[] args) {
        Solution solution = new P344ReverseString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            if (s == null) return;
            //recursionSolution(s, 0, s.length - 1);
            forSolution(s);
        }

        /**
         * 递归实现，效率低，占用空间大，但是代码简单明了
         * @param chars
         * @param front
         * @param tail
         */
        private void recursionSolution(char[] chars, int front, int tail) {
            if (chars == null || front >= tail) return;
            char tmp = chars[front];
            chars[front] = chars[tail];
            chars[tail] = tmp;
            recursionSolution(chars, front + 1, tail - 1);
        }

        /**
         * 转化为循环执行，效率好，占用空间少
         * @param chars
         */
        private void forSolution(char[] chars) {
            if (chars == null) return;
            for (int front = 0, tail = chars.length - 1; front < tail; front++, tail--) {
                char tmp = chars[front];
                chars[front] = chars[tail];
                chars[tail] = tmp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}