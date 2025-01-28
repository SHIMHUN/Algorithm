import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        long K = Long.parseLong(split[1]);

        String[] line = br.readLine().split(" ");
        int[] arr = new int[N];
        long distance = 0L;
        for(int i=0; i<N; i++){
            int parsed = Integer.parseInt(line[i]);
            distance+=parsed;
            arr[i] = parsed;
        }

        int result = 0;

        if(K <= distance){//끝까지 안간경우
            for(int i=0; i<N; i++){
                if(K<0){
                    break;
                }
                K-=arr[i];
                result=i+1;
            }

        }else{ //끝까지 간 경우
           long back = K-distance; //다시 돌아가야 할 거리
            for(int i=N-1; i>=0; i--){
                if(back<0){
                    break;
                }
                back-=arr[i];
                result=i+1;
            }
        }

        System.out.println(result);
    }
}