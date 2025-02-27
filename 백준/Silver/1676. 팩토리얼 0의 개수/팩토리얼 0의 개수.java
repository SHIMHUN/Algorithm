import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
//    static Long sum;
    static int N, cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

//        sum=1L;

        BigInteger factorial = BigInteger.ONE;

        for(int i=1; i<=N; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
//            sum *= i;
        }

        String s = factorial.toString();

//        String s = Long.toString(sum);
        cnt=0;


//        System.out.println(s);
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