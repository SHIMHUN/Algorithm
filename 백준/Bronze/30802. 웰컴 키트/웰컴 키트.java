import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] applicant = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        String[] line = br.readLine().split(" ");

        int T = Integer.parseInt(line[0]);
        int P = Integer.parseInt(line[1]);

        int sum=0;
        for(int i=0; i<applicant.length; i++){
//            int num = applicant[i];
//            if(num <= T){
//                sum++;
//            }else{
//                if(num%T == 0){
//                    sum+=num/T;
//                }else{
//                    sum+=(num/T+1);
//                }
//            }
            sum += applicant[i] / T;
            sum = applicant[i] % T > 0 ? sum + 1 : sum;
        }
        sb.append(sum).append("\n");
        sb.append(N/P + " " + N%P);

        System.out.println(sb.toString());

    }
}