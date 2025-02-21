import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        /*
        * 1. 브루트포스 사용
        * 666부터 시작해서 가능한 모든 수 탐색
        * */
        int num = 666;

        while(N > 1){
            num++;
            if(String.valueOf(num).contains("666")){
                N--;
            }
        }
        System.out.println(num);

    }
}