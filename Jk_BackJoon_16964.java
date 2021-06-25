package JK_LEE.Algorithm;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/16964
 * fail
 */
public class Jk_BackJoon_16964 {
    static int N;
    static ArrayList<Integer>[] adjacent;
    static boolean[] visited;     // 각 장점의 방문 완료 여부 저장 배열
    static int[] compArr2;        // 주어진 순서 값을 저장하는 배열
    static StringBuilder sb = new StringBuilder();
    static int index = 0;

    private static void dfs(int pos) {
        if (pos != compArr2[index++]) {
            System.out.println(0);
            System.exit(0);
        }

        visited[pos] = true;
        if (index < N)
            dfs(compArr2[index]);
        for (int e : adjacent[pos]) {
            if (!visited[e]) {
                dfs(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adjacent = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            adjacent[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] info = br.readLine().split("\\s");
            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            adjacent[a].add(b);
            adjacent[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(adjacent[i]);
        }

        String comp = br.readLine();
        String[] compArr = comp.split("\\s");
        compArr2 = new int[N];
        for (int i = 0; i < N; i++) {
            compArr2[i] = Integer.parseInt(compArr[i]);
        }

        dfs(1);
        System.out.println(1);
        br.close();

    }
}