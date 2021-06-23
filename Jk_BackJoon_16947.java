package JK_LEE.Algorithm;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/16947
 * fail
 */
public class Jk_BackJoon_16947 {
    static int[] check;
    static int N;
    static int[] Dis;
    static ArrayList<Integer>[] arr;
    static ArrayList<Integer> Cycle;
    static boolean getCycle = false;

    public static int go(int x , int p ){
        // x : 현재 노드 , p : 이전 노드
        if(check[x] == 1) return x;
        check[x] = 1;
        for(int y : arr[x]) {
            if(y == p) continue; // 이전 노드를 재방문 한거면 생략
            int res = go(y, x); //다음번 노드 검사
            if(res == -2) return -2; //사이클을 찾았으나 사이클에 속하지 않음
            if(res >=0 ) {
                check[x] = 2;
                if(x == res) return -2; //시작 정점을 찾았다면, 해당 노드로부터 이전의 노드는 사이클에 속하지 않는 노드들이므로 -2를 리턴한다.
                else return res; //아니면 시작노드를 찾을때까지 -2 리턴
            }
        }
        return -1; //사이클을 찾지 못함
    }
    public static void bfs(int start) {
        boolean[] visit = new boolean[N+1];
        int[] cnt = new int[N+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;
        while(!que.isEmpty()) {
            int x = que.poll();
            for(int i=0 ; i<arr[x].size() ; i++) {
                int nx = arr[x].get(i);
                if(!visit[nx]) {
                    visit[nx] = true;
                    cnt[nx] = cnt[x] + 1;
                    que.add(nx);
                }
            }
        }
        // System.out.println("start : "+ start);
        for(int i=1 ; i<=N; i++) {
            Dis[i] = Math.min(Dis[i], cnt[i]);
        }
        // System.out.println();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        Dis = new int[N+1];
        for(int i=1; i<=N; i++) {
            Dis[i] = Integer.MAX_VALUE;
            arr[i] = new ArrayList<Integer>();
        }

        String[] inputs;
        for(int i=0 ; i<N; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b  = Integer.parseInt(inputs[1]);
            arr[a].add(b);
            arr[b].add(a);
        }

        check = new int[N+1];
        for(int i=1 ; i<=N; i++) {
            int res = go(1, 0);
            if(res != -1) break;
        }
        for(int i=1 ; i<=N; i++) {
            if(check[i] == 2)
                bfs(i);
        }

        for(int i=1 ; i<=N; i++) {
            System.out.print(Dis[i] +" ");
        }
        System.out.println();

    }
}
