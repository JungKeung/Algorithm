package JK_LEE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.acmicpc.net/problem/15664
 * fail
 */
public class Jk_BackJoon_15664 {
    static int N, M;
    static int[] visited = new int[10001];
    static ArrayList<Integer> a;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // temp에 " "을 기준으로 String을 나눠 담음.
        // String을 int로 변환 후 담음.
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        input = new int[N];

        // TreeSet 에 add
        // 각 번호에 맞게 카운트
        temp = br.readLine().split(" ");
        Set<Integer> s = new TreeSet<Integer>();
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(temp[i]);
            s.add(t);
            visited[t]++;
        }

        // arraylist에 트리셋을 넣어줌
        a = new ArrayList<Integer>(s);
        dfs(0, bw, "", a.get(0));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, BufferedWriter bw, String str, int com) {
        if (depth == M) {// 종료 지점.
            try {
                bw.write(str + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        for (int i = 0; i < a.size(); i++) {
            if (visited[a.get(i)] > 0 && com <= a.get(i)) {
                visited[a.get(i)]--;
                dfs(depth + 1, bw, str + a.get(i) + " ", a.get(i));
                visited[a.get(i)]++;

            }
        }
    }
}