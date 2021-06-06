package JK_LEE;

import java.util.Scanner;

public class Jk_BackJoon_14501 {
    public static void main(String[] args) {
/**
 * https://www.acmicpc.net/problem/14501
 * success!
 */
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        // 상담을 완료하는데 걸리는 시간
        // 상담을 마쳤을때 받는 금액
        int t[] = new int[n+5];
        int p[] = new int[n+5];
        for(int i = 1; i <= n; i++) {
            t[i] = s.nextInt();
            p[i] = s.nextInt();
        }

        // 얻을 수 있는 최대이익
        int dp[] = new int[n+5];
        int max=0;

        // i일까지 일했을 최대이익값으로 dp[i]도 새로 갱신해줌
        // i일까지 일했을 때 최대이익
        for(int i=1;i<=n;i++) {
            dp[i] = Math.max(dp[i], max);
            dp[i+t[i]-1] = Math.max(dp[i+t[i]-1], dp[i]+p[i]);
            max = Math.max(max, dp[i]);

        System.out.println(max);
        s.close();
    }

}