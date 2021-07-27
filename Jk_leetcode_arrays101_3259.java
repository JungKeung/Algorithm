package JK_LEE.LeetCode;
/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3259/
 *  success!
 */
public class Jk_leetcode_arrays101_3259 {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i=arr.length-1; i>=0; i--){
            int v = arr[i];
            arr[i]=max;
            max = Math.max(v,max);
        }
        return arr;
    }
}
