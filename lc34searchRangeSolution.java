class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int resL = findLowerBounds(nums, target);
        
        int resR = 0;
        if(resL < 0 || resL > nums.length-1 ) return new int[]{-1, -1};
        if(nums[resL]!=target)//此处记得判断nums[resL]  target之间的大小
            return new int[]{-1,-1};
        else{
            resR = findUpperBounds(nums, target);
        }
        return new int[]{resL, resR};
    }

    public int findUpperBounds(int[] nums, int target) {
        //向右寻找上界
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return right;
    }

    public int findLowerBounds(int[] nums, int target) {
        //向左寻找下界
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }
}
