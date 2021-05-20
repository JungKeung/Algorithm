package JK_LEE;

/**
 * https://www.acmicpc.net/problem/9095
 * success!
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Jk_BackJoon_9095{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++){
            int number = Integer.parseInt(br.readLine());
            // 3칸비교이므로 +2
            int d[] = new int[number+2];
            d[0] = 1;
            d[1] = 1;
            d[2] = 2;
            for (int j = 3; j <= number; j++){
                d[j] = d[j-1] + d[j-2] + d[j-3];
            }
            System.out.println(d[number]);
        }
    }
}

