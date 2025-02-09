import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int max = -1000000;
        int min = 1000000;

        String[] s = br.readLine().split(" ");
        int[] sToInt = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<sToInt.length; i++){
            int num = sToInt[i];
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }

        sb.append(min + " " + max);
        System.out.println(sb.toString());
    }
}