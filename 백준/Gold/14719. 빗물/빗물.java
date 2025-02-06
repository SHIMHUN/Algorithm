import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int H, W;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        H = Integer.parseInt(s[0]);
        W = Integer.parseInt(s[1]);

        String[] line = br.readLine().split(" ");

        arr = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();

        int result=0;
        for(int i=1; i<W-1; i++){ //처음이랑 마지막은 제외
            int left=0, right=0;
            for(int j = 0; j < i; j++) {
                left = Math.max(arr[j], left);
            }

            for(int j = i + 1; j < W; j++) {
                right = Math.max(arr[j], right);
            }

            if(arr[i] < left && arr[i] < right){
                result+=Math.min(left,right)-arr[i];
            }

        }
        System.out.println(result);
    }
}