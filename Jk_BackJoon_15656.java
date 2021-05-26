package JK_LEE;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/15656
 * success!
 */
public class Jk_BackJoon_15656{
    static int n;
    static int m;
    static int[] nums;
    static int[] selected;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        nums = new int[n];
        selected = new int[m];

        line = br.readLine().split(" ");
        for(int i=0; i < n; i++){
            nums[i] = Integer.parseInt(line[i]);
        }

        // 숫자를 미리 정렬시킴
        Arrays.sort(nums);

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

        // 같은 숫자가 있는지, 이전 숫자의 크기가 몇인지 등을 체크하지 않고
        // 바로 다음 숫자로 넘어간다.
        for(int i=1; i <= n; i++){
            selected[seq] = nums[i-1];
            go(seq+1);
        }
    }
}