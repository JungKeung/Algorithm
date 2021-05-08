package JK_LEE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jk_BackJoon_11057 {
    static long[][] dp;
    static long[] result;
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        result = new long[n + 1];
        dp = new long[n + 1][10]; // y: N, x: 끝의 자리 수 0 ~ 9
        // n = 1 초기화
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        result[1] = 10;

        for(int i = 2; i <= n; i++) {	// n자리까지 구하는 dp의 y를 구하는 방법
            for(int j = 0; j < 10; j++) { // dp의 x를 구하는 방법
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    dp[i][j] %= 10007;
                }
                result[i] += dp[i][j];
            }
        }
        System.out.println(result[n] % 10007);
    }
}