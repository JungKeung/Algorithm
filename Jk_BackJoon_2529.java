package JK_LEE.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * https://www.acmicpc.net/problem/2529
 * fail
 */
public class Jk_BackJoon_2529 {
    public static int n;// 부등호의 개수
    public static String sign []; // 부등호 집어 넣는 문자열 배열
    public static boolean visit[];
    public static ArrayList<String> arr= new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visit = new boolean[10];
        n = sc.nextInt();
        sign = new String[n]; // 크기 선언 잊지 말기
        for(int i =0 ; i < n;i++){
            sign[i]=sc.next();
        }
        for(int i = 0 ; i < 10 ; i++) {
            Arrays.fill(visit, false);//수열을 새로만들기 시작할떄마다 visit[] 값 새로 초기화 후 시작
            visit[i]= true;
            solve(i,0,0,i+""); // 첫시작 수 , 부등호 배열 인덱스 , 깊이, 출력할 문자열
        }
        System.out.println(arr.get(arr.size()-1));
        System.out.println(arr.get(0));
    }
    public static void solve(int start, int idx , int depth ,String str) {
        if(depth==n) { // 깊이와 부등호 문자열 수 같으면
            arr.add(str); // 문자열을 어레이 리스트에 추가 ! 끝!
        } else {
            for(int i =0 ; i < 10 ; i++) {
                if(!visit[i]) {
                    if(sign[idx].equals("<")) {
                        if(start>i) { // 이전의 i값과 현재의 i값 비교
                            continue;
                        }
                        visit[i]=true;
                        solve(i,idx+1,depth+1,str+i);
                        visit[i]=false;
                    }
                    else if(sign[idx].equals(">")) {
                        if(start<i) {
                            continue;
                        }
                        visit[i]=true;
                        solve(i,idx+1,depth+1,str+i);
                        visit[i]=false;
                    }
                }
            }
        }
    }

}

