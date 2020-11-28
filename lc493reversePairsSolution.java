(今天是hard题，什么都不说了，看懂答案最重要)
493. 翻转对
给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。

你需要返回给定数组中的重要翻转对的数量。

示例 1:

输入: [1,3,2,3,1]
输出: 2
示例 2:

输入: [2,4,3,5,1]
输出: 3
注意:

给定数组的长度不会超过50000。
输入数组中的所有数字都在32位整数的表示范围内。
方法一：二分法，通过最原始的二分法，得到最终的结果
class Solution {
    public int reverse(List<Integer> list, int k){
        //遍历list，得到id, 通过二分法得到id
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            int mid = left + (right - left + 1)/2;
            if(list.get(mid)<=k) left = mid;
            else right = mid - 1;
        }
        return left;
    }
    public int reversePairs(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            list.add(nums[i]);
        }
        //对list进行排序
        list.sort(Comparator.comparingInt(o -> o));  
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int t = nums[i];
            int tId = reverse(list, t);
            int target;
            //寻找小于当前元素二倍的元素
            if(t >= 0){
                if(t % 2 == 0) target = t/2 - 1;
                else target = t/2;
            }
            else{
                if((-t)%2==0){
                    target=t/2-1;
                }
                else{
                    target=t/2-1;
                }
            }
            //将当前元素弹出
            list.remove(tId);
         
           
            int off = reverse(list, target);
            if(off < list.size() && list.get(off)<=target){
                count += (off + 1);
            }
        }
        return count;
        

    }
}
