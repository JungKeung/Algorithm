package JK_LEE;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class JK_BackJoon_2133 {
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        dp = new int[31];
        dp[0] = 1; // 0일때 1을 고려해준다
        dp[1] = 0;

        if(num > 1)
            dp[2] = 3;

        for(int i = 4; i <= num; i+=2) {    //4부터 2씩 증가 반복
            dp[i] = 3 * dp[i-2];            // i-2 번째 dp값 * 3
            for(int j = 0; j < i-2; j+=2) { // 0부터 i-2번 쨰 수보다 작은 경우 반복
                dp[i] += dp[j] * 2;         //위에 dp[i-2] * 3 한 값에 계속해서 더해준다.
            }
        }
        System.out.println(dp[num]);
    }

}



