package DS;

public class QuickSort {

    public void quickSort(int[] nums, int low, int high) {
        //递归结束的基准条件
        if (low > high) {
            return;
        }
        int i=low;
        int j=high;
        int index = nums[i];
        while (i < j) {
            //从后往前找，找到第一个大于index的数值，为何不是从前往后找？
            while (i < j && nums[j] > index) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            //从前往后找，找到第一个大于index的数值
            while (i < j && nums[i] < index) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        //退出循环的条件为i==j,此处i/j的值就是index在数组中经过排序后最终位置
        nums[i] = index;
        //递归的处理左右两部分
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {9, 4, 1, 6, 2, 12, 6, 17, 19, 3, 5};
        quickSort.quickSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
