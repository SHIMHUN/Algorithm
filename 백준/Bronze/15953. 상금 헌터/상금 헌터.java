import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = calcPrizeA(Integer.parseInt(st.nextToken()));
            int b = calcPrizeB(Integer.parseInt(st.nextToken()));
            sb.append(a+b).append("\n");
        }

        System.out.println(sb);

    }

    static int calcPrizeA(int a){
        if(a==1) return 5000000;
        else if(a>=2 && a<=3) return 3000000;
        else if(a>=4 && a<=6) return 2000000;
        else if(a>=7 && a<=10) return 500000;
        else if(a>=11 && a<=15) return 300000;
        else if(a>=16 && a<=21) return 100000;
        else return 0;
    }

    static int calcPrizeB(int b){
        if(b==1) return 5120000;
        else if(b>=2 && b<=3) return 2560000;
        else if(b>=4 && b<=7) return 1280000;
        else if(b>=8 && b<=15) return 640000;
        else if(b>=16 && b<=31) return 320000;
        else return 0;
    }
}