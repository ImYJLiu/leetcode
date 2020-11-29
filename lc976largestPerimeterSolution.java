976. 三角形的最大周长
给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。

如果不能形成任何面积不为零的三角形，返回 0。

 

示例 1：

输入：[2,1,2]
输出：5

方法1：昨天的我哭哭啼啼，今天的我重拳出击
class Solution {
    public int largestPerimeter(int[] A) {
        //先进行排序
        Arrays.sort(A);
        for(int i = A.length - 1 ; i >= 2 ; i--){
            if(A[i-2] + A[i-1] > A[i]){//两边之和大于第三边
                return A[i-2] + A[i-1] + A[i];
            }
        }
        return 0;
    }
}
