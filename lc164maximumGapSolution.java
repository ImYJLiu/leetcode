164. 最大间距
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

如果数组元素个数小于 2，则返回 0。

示例 1:

输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。

方法一：不讲武德，直接arrays.sort(),时间复杂度：o(nlogn)
class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int max_sub = 0;
        for(int i = 0; i < nums.length-1 ; i++){
            max_sub = Math.max(nums[i+1] - nums[i], max_sub);
        }
        return max_sub;

    }
}
