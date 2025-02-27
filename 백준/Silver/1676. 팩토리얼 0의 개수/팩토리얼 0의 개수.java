import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
//    static Long sum;
    static BigInteger factorial;
    static int N, cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        factorial = BigInteger.ONE;

        for(int i=1; i<=N; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String s = factorial.toString();

        cnt=0;

        for(int i=s.length()-1; i>0; i--){
            if(s.charAt(i) == '0'){
                cnt++;
            }

            if(s.charAt(i-1) != '0'){
                break;
            }
        }

        System.out.println(cnt);
    }
}