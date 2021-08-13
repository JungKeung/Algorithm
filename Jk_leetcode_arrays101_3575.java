package JK_LEE.LeetCode;
/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3575/
 *  success!
 */
public class Jk_leetcode_arrays101_3575 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
         return index;
    }
}

