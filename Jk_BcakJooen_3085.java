package JK_LEE;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *  https://www.acmicpc.net/problem/3085
 *  기타 : 실패, 분석 시작
 */
public class Jk_BcakJooen_3085 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arrCandies = new char[N][N];

        // 입력
        for (int i = 0; i < N; i++) {
            char[] arrTemp = br.readLine().toCharArray();
            arrCandies[i] = arrTemp;
        }

        // 원본 Max연속값 구하기
        int Max = countMaxCandiesSquare(arrCandies);

        // 위치 바꾼 후 Max연속값 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 왼 <-> 오
                if ((j + 1) < N) {
                    swap(arrCandies, i, j, true, false);
                    // 바꾼 라인에 대해서만 Max연속값 구하기
                    int tempMax = countMaxCandiesLine(arrCandies, i, j);
                    swap(arrCandies, i, j, true, true);
                    Max = (tempMax > Max) ? tempMax : Max;
                }
                // 위 <-> 아래
                if ((i + 1) < N) {
                    swap(arrCandies, i, j, false, false);
                    // 바꾼 라인에 대해서만 Max연속값 구하기
                    int tempMax = countMaxCandiesLine(arrCandies, i, j);
                    swap(arrCandies, i, j, false, true);
                    Max = (tempMax > Max) ? tempMax : Max;
                }
            }
        }
        System.out.println(Max);
    }

    private static int countMaxCandiesLine(char[][] arrCandies, int i, int j) {

        int Max = 0;
        int N = arrCandies.length;

        // 가로
        for (int a = 0; a < 2; a++) {
            if (i + a == N) {
                break;
            }

            int count = 1;
            for (int b = 0; b < N - 1; b++) {
                if (arrCandies[i + a][b] == arrCandies[i + a][b + 1]) {
                    count++;
                    Max = (count > Max) ? count : Max;
                    continue;
                }
                count = 1;
            }
        }

        // 세로
        for (int b = 0; b < 2; b++) {
            if (j + b == N) {
                break;
            }

            int count = 1;
            for (int a = 0; a < N - 1; a++) {
                if (arrCandies[a][j + b] == arrCandies[a + 1][j + b]) {
                    count++;
                    Max = (count > Max) ? count : Max;
                    continue;
                }
                count = 1;
            }
        }
        return Max;
    }

    private static int countMaxCandiesSquare(char[][] arrCandies) {

        int Max = 0;
        int N = arrCandies.length;

        // 가로
        for (int i = 0; i < N; i++) {

            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (arrCandies[i][j] == arrCandies[i][j + 1]) {
                    count++;
                    Max = (count > Max) ? count : Max;
                    continue;
                }
                count = 1;
            }
        }

        // 세로
        for (int j = 0; j < N; j++) {

            int count = 1;
            for (int i = 0; i < N - 1; i++) {
                if (arrCandies[i][j] == arrCandies[i + 1][j]) {
                    count++;
                    Max = (count > Max) ? count : Max;
                    continue;
                }
                count = 1;
            }
        }
        return Max;
    }

    private static void swap(char[][] arrCandies, int i, int j, boolean isRight, boolean isReverse) {

        int a = i;
        int b = j;

        if (isRight) {
            b = j + 1;
            if (isReverse) {
                int temp = j;
                j = b;
                b = temp;
            }
        } else {
            a = i + 1;
            if (isReverse) {
                int temp = i;
                i = a;
                a = temp;
            }
        }

        char temp = arrCandies[i][j];
        arrCandies[i][j] = arrCandies[a][b];
        arrCandies[a][b] = temp;
    }
}

