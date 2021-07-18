package JK_LEE.LeetCode;

import java.util.HashSet;
import java.util.Set;
/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3250/
 *  success!
 */



class Jk_leetcode_arrays101_3250 {
    public boolean checkIfExist(int[] arr) {
       // 1) 일단 같은 원소는 확인할 필요가 없으니 Set객체를 만들고
        Set<Integer> set = new HashSet<> ();
        //배열에 대한 Loop를 돌면서
        for (Integer num : arr) {
            // Set객체에 target element에 대한 곱하기2나 나누기2 element가 없다면 Set에 밀어넣어주고
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                //있다면 바로 true를, Loop끝까지 없다면 false를 리턴해주기로 했다.
                return true;
            }

            set.add(num);
        }
        return false;
    }
}