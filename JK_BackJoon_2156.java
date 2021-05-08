package JK_LEE;
import java.io.*;
import java.util.StringTokenizer;

public class JK_BackJoon_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] amount = new int[n];
        int[] DP = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            amount[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(amount[0]);
        } else if (n == 2) {
            System.out.println(amount[0] + amount[1]);
        } else {
            DP[0] = amount[0];
            DP[1] = DP[0] + amount[1];
            DP[2] = Math.max(DP[1], Math.max(amount[0] + amount[2], amount[1] + amount[2]));

            for (int i = 3; i < n; i++) {
                DP[i] = Math.max(DP[i - 3] + amount[i] + amount[i - 1], DP[i - 2] + amount[i]);
                DP[i] = Math.max(DP[i - 1], DP[i]);
            }
            System.out.println(DP[n - 1]);
        }

    }

}