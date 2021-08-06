package JK_LEE.LeetCode;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
 *  success!
 */
class Jk_leetcode_arrays101_3238 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for(int n : nums){
            if(n==1){
                count ++;
                if(max < count) max =count;
            }
            else count = 0;
        }
        return max;

    }
}