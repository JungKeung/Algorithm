package JK_LEE.LeetCode;

import java.util.Arrays;

public class Jk_leetcode_arrays101_3228 {
    public int heightChecker(int[] heights) {
        //copyOf 사용하여 copy 배열에 heights 배열을 복사 해준다.
        int[] copy = Arrays.copyOf(heights, heights.length);
        // copy 배열을 정리한다
        Arrays.sort(copy);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            // heights 배열와 copy배열이 같은지 확인한다.
            if (heights[i] != copy[i]) {
                count++;
            }
        }
        return count;
    }
}
