package JK_LEE.LeetCode;
/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3258/
 *  success!
 */
class Jk_leetcode_arrays101_3258 {

    public int removeDuplicates(int[] nums) {

        //배열의 길이가 0일때의 예외처리
        if(nums.length==0) return 0;

        int result=1;
        for(int i=1 ; i<nums.length ; i++){
            //요소가 중복값이 아닐 때에만 가져오고 리턴할 배열의 길이를 늘려줌
            if(nums[i]!=nums[i-1]){
                nums[result]=nums[i];
                result++;
            }
        }
        return result;
    }

}