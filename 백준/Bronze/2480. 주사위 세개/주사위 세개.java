import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int one, two, three;
    static int prize;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        one = Integer.parseInt(st.nextToken());
        two = Integer.parseInt(st.nextToken());
        three = Integer.parseInt(st.nextToken());

        if(one == two && two != three) prize = one*100 + 1000;
        else if(one == three && three != two) prize = one*100 + 1000;
        else if(two == three && three != one) prize = two*100 + 1000;
        else if(one == two && two == three && three==one) prize = one*1000 + 10000;
        else prize = Math.max(one, Math.max(two, three))*100;

        System.out.println(prize);

    }
}