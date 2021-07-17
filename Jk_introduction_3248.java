package JK_LEE.LeetCode;
/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3248/
 *  success!
 */

class Jk_introduction_3248 {
    public int removeDuplicates(int[] nums) {

        if(nums.length==0) return 0;

        int result=1;
        for(int i=1 ; i<nums.length ; i++){

            if(nums[i]!=nums[i-1]){
                nums[result]=nums[i];
                result++;
            }
        }
        return result;
    }
}

