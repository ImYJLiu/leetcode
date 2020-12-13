面试题 04.02. 最小高度树
难度
简单

64





给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0 
         / \ 
       -3   9 
       /   / 
     -10  5 面试题 04.02. 最小高度树
难度
简单
// 只要我不动脑，就永远用递归。

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //最小高度树，左右两边的高度要接近
        return high(nums, 0, nums.length - 1);
    }
    public TreeNode high(int[] nums, int low, int high){
        if(low > high) return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = high(nums, low, mid-1);
        root.right = high(nums, mid+1, high);
        return root;
    }
}
