package JK_LEE;

import java.io.*;
import java.util.*;

public class Jk_BackJoon_11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n+1];
        int[][] dp = new int[2][n+1];
        int max = 0;

        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }
        for(int i = 1; i <= n; i++) {
            int maxLen = 0;
            for(int j = 1; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(maxLen < dp[0][j]) {
                        maxLen = dp[0][j];
                    }
                }
            }
            dp[0][i] = maxLen + 1;
        }
        for(int i = n; i > 0; i--) {
            int maxLen = 0;
            for(int j = n; j > i ; j--) {
                if(nums[j] < nums[i]) {
                    if(maxLen < dp[1][j]) {
                        maxLen = dp[1][j];
                    }
                }
            }
            dp[1][i] = maxLen + 1;
        }

        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dp[0][i] + dp[1][i] - 1);
        }

        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }
}
