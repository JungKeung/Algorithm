package JK_LEE;

import java.io.*;
import java.util.ArrayList;

/**
 *  https://www.acmicpc.net/problem/1248
 *  fail
 */


import java.io.*;
import java.util.*;

public class Jk_BackJoon_1248 {
    public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();
    public static int n;
    public static int[] num;            //n개의 숫자 만드는 배
    public static String mark;          //입력받은 부호
    public static boolean[] isUsedNumber;     //0~10 숫자 사용 여부
    public static char[][] checkMark;     //Mark 저장하는 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        isUsedNumber = new boolean[11];
        checkMark = new char[n][n];
        mark = br.readLine();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                checkMark[i][j] = mark.charAt(idx++);
            }
//            System.out.println(Arrays.toString(checkMark[i]));
        }

        getPermutation(0);
//        System.out.println(sb);
    }

    public static void getPermutation(int idx) {
        boolean isAnswer = isPossible(idx);     //여태까지 만들어진 순열과 부호와 비교
        if (!isAnswer) return;                  //불가능하다면 가지치기
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                sb.append(num[i] + " ");
            }
            System.out.println(sb);
            System.exit(0);
        }
        //모든 경우의 수를 만들어보자
        for (int i = 0; i <= 10; i++) {
            if (checkMark[idx][idx] == '+') num[idx] = -i + 10;
            if (checkMark[idx][idx] == '0') num[idx] = 0;
            if (checkMark[idx][idx] == '-') num[idx] = i - 10;
            getPermutation(idx + 1);
        }
    }

    public static boolean isPossible(int n) {   //만든 배열로 입력받은 문자를 만들수 있는지 확인
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += num[j];
                if (checkMark[i][j] == '+' && sum <= 0) return false;
                if (checkMark[i][j] == '0' && sum != 0) return false;
                if (checkMark[i][j] == '-' && sum >= 0) return false;
            }
        }
        return true;
    }
}