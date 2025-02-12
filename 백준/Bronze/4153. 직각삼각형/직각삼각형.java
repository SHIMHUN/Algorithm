import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String[] line = br.readLine().split(" ");
            int[] nums = Arrays.stream(line).mapToInt(x-> Integer.parseInt(x)*Integer.parseInt(x)).toArray();

            if(nums[0] == 0 && nums[1] == 0 && nums[2] == 0){
                break;
            }

            int max = -1;
            int max_idx = -1;

            for(int i=0; i<3; i++){
                if(max < nums[i]){
                    max = nums[i];
                    max_idx = i;
                }
            }

            int sum = 0;
            for(int i=0; i<3; i++){
                if(i == max_idx){
                    continue;
                }
                sum += nums[i];
            }

            if(nums[max_idx] == sum){
                sb.append("right");
            }else{
                sb.append("wrong");
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}