package JK_LEE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *https://www.acmicpc.net/submit/10971
 * fail
 */
public class Jk_BackJoon_10971 {
    static boolean[] visit;
    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N];

        // 가능한 경로 수열
        for (int i = 0; i < N; i++) {
            visit[i] = true;
            TSP(i,i,0,0);
            visit[i] = false;
        }
        System.out.print(min);

    }
    static void TSP(int fix , int now , int sum , int count) {

        // 모두 순회했으면
        if(count == N-1) {
            if(arr[now][fix] != 0) // 다시 되돌아 가는게 가능하면
                min = Math.min(min, sum + arr[now][fix]);
        }

        if(sum >= min) return; // 추가된 코드 (백 트래킹)

        for(int i = 0 ; i <N ; i++) {
            if(visit[i] == false && arr[now][i] != 0 ) { // 경로를 아직 탐색하지 않았고 길이 열려있는 경우 탐색
                visit[i] = true;
                TSP(fix,i,sum+arr[now][i],count+1);
                visit[i] = false;
            }

        }

    }
}