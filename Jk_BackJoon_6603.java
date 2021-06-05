package JK_LEE;


/**
 * https://www.acmicpc.net/problem/6603
 * fail
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로또
// 순열
public class Jk_BackJoon_6603 {
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static final int MAX = 6;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            if(k == 0) {	// 테스트 케이스 종료
                System.out.println(sb.toString());
                return;
            }

            result = new int[k];

            for(int i = 0; i < k; i++) {
                int num = Integer.parseInt(st.nextToken());
                result[i] = num;
            }

            permutation(k, 0, 0, new int[6], new boolean[k]);

            sb.append("\n");
        }
    }

    // 순열로 뽑기 (nPr)
    static void permutation(int n, int r, int index, int[] arr, boolean[] used) {
        if(r == MAX) {	// r개를 전부 뽑은 경우
            for(int ele : arr) {
                sb.append(ele).append(" ");
            }

            sb.append("\n");
            return;
        }

        if(index >= n) {	// r개를 전부 뽑지 않고 index 벗어난 경우
            return;
        }

        if(used[index]) {
            permutation(n, r, index + 1, arr, used);
        }
        else {
            for(int i = index; i < n; i++) {
                used[i] = true;
                arr[r] = result[i];
                permutation(n, r + 1, i + 1, arr, used);
                used[i] = false;
            }
        }
    }
}
