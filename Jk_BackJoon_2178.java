package JK_LEE.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2178
 * fail
 */
// 미로 탐색
public class Jk_BackJoon_2178 {

    static int n; // 세로
    static int m; // 가로
    static int[][] maps;
    static int[][] cnts; // 이동할 때 최소 칸수

    // 북 동 남 서
    static int[] dy = {-1, 0, 1, 0}; // 세로
    static int[] dx = {0, 1, 0, -1}; // 가로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        n = Integer.parseInt(str.split(" ")[0]);
        m = Integer.parseInt(str.split(" ")[1]);

        maps = new int[n+1][m+1];
        cnts = new int[n+1][m+1];

        StringTokenizer st;
        for(int i=1; i<n+1; i++) {
            str = br.readLine();

            for(int j=1; j<m+1; j++) {
                maps[i][j] = Integer.parseInt(str.split("")[j-1]);
            }
        }

        // == 입력 끝

        bfs();

        // 도착위치(n,m) 의 최소 칸 수
        System.out.println(cnts[n][m]);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        // 1,1에서 시작
        q.offer(new int[]{1,1});
        cnts[1][1] = 1;

        // 세로, 가로
        int[] current = new int[2];
        int[] next = new int[2];
        while(!q.isEmpty()) {
            current = q.poll();

            // 4방향의 인접 위치
            for(int i=0; i<4; i++) {
                next[0] = current[0] + dy[i];
                next[1] = current[1] + dx[i];

                // 범위 안에 있고 이동할 수 있는 곳이고(map[][]==1) 방문한 적 없을 때(cnts[][]==0)
                if(next[0]>0 && next[1]>0 && next[0]<=n && next[1]<=m && maps[next[0]][next[1]]==1 && cnts[next[0]][next[1]]==0) {
                    q.offer(new int[] {next[0], next[1]});
                    cnts[next[0]][next[1]] = cnts[current[0]][current[1]]+1;
                }
            }
        }
    }

}