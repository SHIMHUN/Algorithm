import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int start = 2;

        if(N == 1) {
            System.out.println(1);
            return;
        }else{
            while(start <= N){
                start += cnt*6;
                cnt++;
                
            }
            System.out.println(cnt);
        }
    }
}



