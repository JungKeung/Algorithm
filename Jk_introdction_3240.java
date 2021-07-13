package JK_LEE.LeetCode;

import java.util.Arrays;
/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
 *  success!
 */
class Jk_introduction_3240 {
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]*=nums[i];
        }
        Arrays.sort(nums);
        return nums;

    }
}
