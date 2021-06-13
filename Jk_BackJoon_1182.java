package JK_LEE.Algorithm;
/**
 * https://www.acmicpc.net/problem/1182
 * fail
 */

import java.util.Scanner;

public class Jk_BackJoon_1182 {
    static int n, s;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        n = sc.nextInt();
        s = sc.nextInt();

        //입력 받기
        arr = new int[n];
        for( int i = 0; i < n; i++)
            arr[i] = sc.nextInt ();

        //결과값 초기화
        result = 0;
        solve();
        System.out.println(result);
    }

    static int result;
    private static void solve(){
        // 모든 조합을 만들어 주기
        for( int i = 0; i <(1<<n); i++){
            //선택될 개수가 1개 이상이면
            if(Integer.bitCount (i) > 0){
                int sum = 0;
                for( int j = 0; j < n; j++){
                    //해당 선택 index 더해주기
                    if(((1<<j) & i) > 0)
                        sum += arr[j];
                }
                if(sum == s) result++;
            }
        }
    }
}
