package JK_LEE.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4963
 * success!
 */

public class Jk_BackJoon_4963 {

    static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int res, w, h, map[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            // 0 0 이 입력되면 종료
            if (w + h == 0)
                break;

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            res = 0;
            // 모든 좌표를 확인하면서
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 땅이면
                    if(map[i][j] == 1) {
                        dfs(i, j);
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }

    public static void dfs(int x, int y) {
        // 방문했으니까 방문 처리
        map[x][y] = 0;

        // 주변을 탐색
        for (int d = 0; d < 8; d++) {
            int xx = x + dx[d];
            int yy = y + dy[d];
            // 범위 벗어나면 pass
            if (xx < 0 || yy < 0 || xx >= h || yy >= w) continue;
            // 물이면 pass
            if (map[xx][yy] == 0) continue;
            // 방문해볼 땅을 방문
            dfs(xx, yy);
        }
    }
}
