package JK_LEE.LeetCode;
/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3259/
 *  fail!
 */
class Jk_leetcode_arrays101_3260 {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int j = 0;
        int k = len-1;
        while(j<k){
            if(A[j]%2==0){
                j+=1;
            }
            else{
                int temp = A[k];
                A[k] = A[j];
                A[j] = temp;
                k-=1;
            }
        }
        return A;
    }
}
