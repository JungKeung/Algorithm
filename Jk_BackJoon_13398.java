package JK_LEE;
import java.io.*;

public class Jk_BackJoon_13398 {
    static int n;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n][2];

        String[] sarr = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(sarr[i]);

        dp[0][0] = 0;
        dp[0][1] = arr[0];
        int max = dp[0][1];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], arr[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        bw.write(max + "\n");
        bw.flush();
    }
}
