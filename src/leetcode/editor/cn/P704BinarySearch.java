//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 二分查找 
// 👍 225 👎 0


package leetcode.editor.cn;

//Java：二分查找
public class P704BinarySearch {
    public static void main(String[] args) {
        Solution solution = new P704BinarySearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return targetIfExist(nums, target);
        }

        /**
         * 判断target是否在数组中，在的话返回数组下标
         *
         * @param nums
         * @param target
         * @return
         */
        public int targetIfExist(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return -1;
        }

        /**
         * 返回target的最左索引
         *
         * @param nums
         * @param target
         * @return
         */
        public int left_bound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            //区间左闭右开
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    //不直接返回，向右继续压缩区间
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if ((nums[mid]) > target) {
                    right = mid;
                }
            }
            //处理边界情况，target大于nums所有元素，target小于nums所有元素
            if (left == nums.length || nums[left] != target) {
                return -1;
            }
            return left;
        }

        /**
         * 返回target的最右侧索引
         *
         * @param nums
         * @param target
         * @return
         */
        public int right_round(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    //不直接返回，向右压缩空间
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            //处理边界条件，注意right处元素取不到
            if (right == 0 || nums[right - 1] != target) {
                return -1;
            }
            return right - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}