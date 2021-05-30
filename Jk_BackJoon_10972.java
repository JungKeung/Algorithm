package JK_LEE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10972
 * success!
 */
//다음 순열
public class Jk_BackJoon_10972 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation(arr)) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }

    public static boolean nextPermutation(int[] arr) {

        //뒤에서부터 탐색하면서 a-1보다 a가 더 큰 경우 찾음
        int a = arr.length - 1;
        while(a > 0 && arr[a-1] >= arr[a]) a--;
        if (a <= 0 ) return false;

        //다시 뒤에서부터 탐색하며 a-1보다 b가 더 큰 경우 찾음
        int b = arr.length - 1;
        while(arr[a-1] >= arr[b]) b--;

        //a랑 b를 swap
        int tmp = arr[a-1];
        arr[a-1] = arr[b];
        arr[b] = tmp;

        //a에서부터 끝까지를 오름차순 정렬
        int start = a;
        int end = arr.length - 1;
        while(start < end) {
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        return true;
    }
}