package JK_LEE.LeetCode;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
 *  success!
 */
public class Jk_introduction_3237 {
    public int findNumbers(int[] nums) {
        int result=0;
        for(int num:nums){
            int sum=0;
            while(num>0){
                num/=10;
                sum++;
            }
            if(sum%2==0)
                result++;
        }
        return result;
    }
}
