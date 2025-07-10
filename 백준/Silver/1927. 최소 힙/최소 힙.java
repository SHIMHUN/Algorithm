import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            int num = sc.nextInt();
            if(num == 0){
                if(pq.isEmpty()){
                    sb.append("0"+"\n");
                }else{
                    sb.append(String.valueOf(pq.poll()) + "\n");
                }
            }else{
                pq.offer(num);
            }
        }

        System.out.println(sb);
    }
}