import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        System.out.println(findLuckyNumber(K));
    }

    public static String findLuckyNumber(int K) {
        StringBuilder sb = new StringBuilder();

        // K를 2진수로 변환 (1-based index)
        K = K + 1;  // 1부터 시작하는 인덱스로 맞추기

        while (K > 1) {
            if (K % 2 == 0) sb.append("4"); // 짝수이면 4
            else sb.append("7");  // 홀수이면 7
            K /= 2;
        }

        return sb.reverse().toString(); // 앞에서부터 만든 값을 뒤집기
    }
}
