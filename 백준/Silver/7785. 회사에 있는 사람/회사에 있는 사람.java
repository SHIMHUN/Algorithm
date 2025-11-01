import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        while(n-- > 0){
            String[] s = br.readLine().split(" ");
            if(s[1].equals("enter")) set.add(s[0]);
            else set.remove(s[0]);
        }

        List<String> al = new ArrayList<>(set);
        Collections.sort(al, Collections.reverseOrder());

        for(String s : al){
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}