package JK_LEE;

import java.io.*;
import java.util.Arrays;
/**
 * https://www.acmicpc.net/problem/15665
 * success!
 */
public class Jk_BackJoon_15665{
    static int n;
    static int m;
    static int[] nums;     // 주어지는 숫자를 저장
    static int[] unique;   // 중복되는 숫자를 빼고 고유 숫자들만 저장
    static int[] selected; // m개를 선택하는 배열
    static int[] count;    // 중복되는 숫자가 몇 번 나오는지 저장
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        nums = new int[n];
        unique = new int[n];
        selected = new int[m];
        count = new int[n];

        line = br.readLine().split(" ");
        for(int i=0; i < n; i++){
            nums[i] = Integer.parseInt(line[i]);
        }

        // 숫자를 미리 정렬시킴
        Arrays.sort(nums);

        // 각 숫자를 중복된 개수를 세고 고유 숫자만 따로 저장한다.
        unique = new int[n];
        int current = nums[0];
        int k = 0;
        int cnt = 1;
        for(int i=1; i < n; i++){
            if(nums[i] == current){
                cnt++;
            } else {
                count[k] = cnt;
                unique[k] = current;
                k++;
                cnt = 1;
                current = nums[i];
            }
        }
        count[k] = cnt;
        unique[k] = current;
        go(0);

        System.out.println(sb);
        br.close();
    }

    private static void go(int seq){
        if(seq == m){
            for(int i : selected){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i < n; i++){
            // 현재 중복된 숫자를 사용할 수 있는 것이 0개 초과라면
            if(count[i] > 0){
                selected[seq] = unique[i];
                go(seq+1);
            }
        }
    }
}