package JK_LEE;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/15655
 * fail
 */
public class Jk_BackJoon_15655{
    static int n;
    static int m;
    static StringBuilder sb;
    static int[] nums; // 10,000이하의 숫자들 저장하는 배열
    static int[] selected;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        nums = new int[n];
        line = br.readLine().split(" ");
        for(int i=0; i < n; i++){
            nums[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(nums);
        selected = new int[m];

        go(0, 1);

        System.out.println(sb);
        br.close();
    }


    // seq는 몇 개의 숫자가 선택되었는지를 알아내는 부분
    // idx는 현재 몇 번째의 숫자를 선택 / 미선택할 것인지를 채택하는 부분
    private static void go(int seq, int idx){
        if(seq == m){
            for(int i : selected){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 아래에서 반복문이 사라진 것을 알 수 있음!
        // 이를 통해 재귀만 사용하여 해결하여 더 빠른 시간복잡도를 유지

        // 만약 계속 재귀를 통해 넘어가면 언젠간 n을 넘어가게 되니, 그 이후에는 바로 반환시킴
        if(idx > n) return;

        // 현재 숫자를 선택하는 경우의 재귀 방식
        // 이후 다음 선택할 숫자로 넘어간다. 아래 2줄은 현재 idx 숫자를 선택하는 경우임
        selected[seq] = nums[idx-1];
        go(seq+1, idx+1);

        // 현재 숫자를 선택하지 않는 경우의 재귀 방식
        selected[seq] = 0;
        go(seq, idx+1);
    }
}