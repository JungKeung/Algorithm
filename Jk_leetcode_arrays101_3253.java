package JK_LEE.LeetCode;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3253/
 *  success!
 */
public class Jk_leetcode_arrays101_3253 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[index--] = nums2[j--];
            } else {
                nums1[index--] = nums1[i--];
            }
        }

        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}