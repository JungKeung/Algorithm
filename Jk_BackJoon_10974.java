package JK_LEE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * https://www.acmicpc.net/problem/10974
 * fail
 */
public class Jk_BackJoon_10974{
    public static int map[], n;
    public static StringBuilder res = new StringBuilder ();
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int i; n = Integer.parseInt(in.readLine());
        for(i=0;i<n;i++) {
            /* 매번 map을 새로 생성
             * 단, i번째 숫자를 먼저 순열 만드는데 사용하므로 i번째 값은 0으로 초기화
             * ex) n=4, i=1이면 1 0 1 1, i=3이면 1 1 1 0 */
            initMap(i);
            dfs((i+1)+" ", 1);
        }
        out.write(res.toString());
        out.close();
        in.close();
    }

    private static void dfs(String p, int cnt){
        if(cnt == n){
            res.append(p+"\n");
            return;
        }
        //매번 맨 처음(i=0)부터 탐색함 -> 순열 p는 자동 오름차순 구성
        for(int i=0;i<n;i++){
            if(map[i]==1){
                map[i] = 0; //visit배열 사용하지 않고 map값을 직접 0으로 바꿈
                dfs(p+((i+1)+" "), cnt+1);
                map[i] = 1; //원상복구
            }
        }
    }

    private static void initMap(int k){
        map = new int[n];
        for(int i=0;i<n;i++) if(i!=k) map[i] = 1;
    }
}