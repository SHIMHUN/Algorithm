import java.io.*;

public class Main {
    static int K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        System.out.println(findNum());
    }

    public static String findNum() {

        K = K + 1;

        while (K > 1) {
            if (K % 2 == 0) {
                sb.append("4"); // 짝수이면 4
            } else{
                sb.append("7");  // 홀수이면 7
            }
            K /= 2;
        }

        return sb.reverse().toString(); // 결과를 뒤집어서 출력 -> 이진수는 뒤부터 시작됨
    }
}
