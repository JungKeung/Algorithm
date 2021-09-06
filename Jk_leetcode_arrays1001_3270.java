package JK_LEE.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jk_leetcode_arrays1001_3270 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<> ();
            for(int i =0; i< nums.length; i++){
            if(nums[i] != i+1) {
                if(Arrays.binarySearch(nums, i+1)<0){
                    result.add(i+1);
                };
            }
        }
       return result;
    }
}
