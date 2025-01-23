import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int max_idx = 0;
        for(int i=0; i<9; i++){
            int num = Integer.parseInt(reader.readLine());
            if(num > max){
                max = num;
                max_idx = i+1;
            }
        }

        writer.write(max + "\n");
        writer.write(max_idx + "");
        writer.flush();
        writer.close();
    }
}