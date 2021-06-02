package JK_LEE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10819
 * fail
 */

public class Jk_BackJoon_10819 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        // 숫자 입력
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        stk = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(stk.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(num);
        int result = Integer.MIN_VALUE;	// 비교 위해서 초기값을 최소 integer로 정의
        do {
            int temp = 0;
            for(int i=0; i<N-1; i++) {
                temp += Math.abs(num[i] - num[i+1]);	// 문제에서 제시한 기본 연산
            }
            result = Integer.max(result, temp);	// 최댓값을 찾아서 result에 값을 갱신
        } while (permutation(num));	// 순열 함수를 통해 모든 경우동안 진행

        System.out.println(result);
    }

    private static boolean permutation(int[] num) {
        int i=0;
        int j=0;
        boolean isLast = true;
        int length = num.length-1;
        for(int k = length; k > 0; k--) {
            if(num[k-1] < num[k]) {
                i = k-1;
                isLast = false;
                break;
            }
        }

        if(isLast == true) return false;

        for(int k=length ; k > 0; k--) {
            if(num[i] < num[k]) {
                j=k;
                break;
            }
        }

        swap(num, i, j);
        reverse(num, i+1, length);
        return true;
    }
    //
    private static void reverse(int[] num, int start, int last) {
        while(start < last) {
            swap(num, start, last);
            start++;
            last--;
        }
    }
    // 앞뒤 바꿔주는 함수
    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}