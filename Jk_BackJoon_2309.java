package JK_LEE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 https://www.acmicpc.net/problem/2309
 기타 : 실패, 분석 시작
 **/
public class Jk_BackJoon_2309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 7난쟁이의 키의 합은 100
        int max = 100;
        int size = 9;
        int sum = 0;
        int[] dwarfs = new int[size];

        for(int i=0; i < size; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }

        boolean checked = false;
        for(int i=0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                if(sum - (dwarfs[i] + dwarfs[j]) == max) {
                    dwarfs[i] = Integer.MIN_VALUE;
                    dwarfs[j] = Integer.MIN_VALUE;
                    checked = true;
                    break;
                }
                if(checked) break;
            }
        }
        Arrays.sort(dwarfs);

        for(int dwarf:dwarfs) if(dwarf != Integer.MIN_VALUE) System.out.println(dwarf);

        br.close();
    }
}