package JK_LEE;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
/**
 * https://www.acmicpc.net/problem/15663
 * fail
 */
public class Jk_BackJoon_15663{
    static int n;
    static int m;
    static int[] nums;      // 주어지는 숫자를 저장
    static int[] selected;  // m개를 선택하는 배열
    static boolean[] check; // 방문 여부 판단하는 배열

    static LinkedHashSet<String> ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        nums = new int[n];
        selected = new int[m];
        check = new boolean[n];
        ans = new LinkedHashSet<>();

        line = br.readLine().split(" ");
        for(int i=0; i < n; i++){
            nums[i] = Integer.parseInt(line[i]);
        }

        // 숫자를 미리 정렬시킴
        Arrays.sort(nums);
        go(0);

        // LinkedHashSet에 저장된 내역을 출력
        ans.forEach(System.out::println);
        br.close();
    }

    private static void go(int seq){
        if(seq == m){
            StringBuilder sb = new StringBuilder();
            for(int i : selected){
                sb.append(i).append(" ");
            }
            // sb 객체를 LinkedHashSet에 넣어 중복되는 경우는 제외 시킴
            ans.add(sb.toString());
            return;
        }

        // N과 M(1), N과 M(5)와 동일한 로직 사용
        for(int i=0; i < n; i++){
            if(check[i]) continue;
            check[i] = true;
            selected[seq] = nums[i];
            go(seq+1);
            check[i] = false;
        }
    }
}