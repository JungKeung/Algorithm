package JK_LEE.LeetCode;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3251/
 *  fail!
 */
class Jk_leetcode_arrays101_3251 {
    public boolean validMountainArray(int[] arr) {
        // 길이가 3미만이면 거짓
        if (arr.length<3)
            return false;

        int len = arr.length;
        int i = 0;

        // 첫번째 값을 증가시켜준다
        while (i+1 < len && arr[i]<arr[i+1])
            i++;

        //시작 또는 끝 문 문자가 카운터와 동일 해야한다
        if (i==0 || i==len-1)
            return false;

        // 배열이 줄어드는 동안 배열 증가
        // 마지막 카운터 인덱스 시작
        while (i+1 < len && arr[i]>arr[i+1])
            i++;

        // 길이와 같은 경우 반환
        return i == len-1;

    }
}