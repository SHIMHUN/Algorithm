import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] s = br.readLine().split(" ");
            int[] input = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            int H = input[0];
            int W = input[1];
            int N = input[2];

            int roomNum = (N%H == 0)? N/H : N/H + 1;
            int floor = (N%H == 0)? H : N%H;

            if(N%H == 0){
                roomNum = N/H;
                floor = H;
            }else{
                roomNum = N/H + 1;
                floor = N%H;
            }

            sb.append(floor*100 + roomNum).append("\n");
        }
        System.out.print(sb.toString());
    }
}