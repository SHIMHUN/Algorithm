class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int col = sizes[0].length; // 배열 가로 길이
        int row = sizes.length; // 배열 세로 길이
            
        
        int max = 0;
        int max_x_idx = 0;
        int max_y_idx = 0;
        int other_num = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(max < sizes[i][j]){
                    max = sizes[i][j];
                    other_num = (j==0)? sizes[i][1] : sizes[i][0];
                    max_x_idx = i;
                    max_y_idx = j;
                }
            }
        }
        
        int min = max;
        int larger = 0;
        for(int i=0; i<row; i++){
            if(i==max_x_idx){
                continue;
            }
            int small = Math.min(sizes[i][0], sizes[i][1]);
            if(small > larger){
                larger = small;
            }
        }
        
        System.out.println(max);
        // System.out.println(larger);
        System.out.println(other_num);
        
        return max * Math.max(larger, other_num);
    }
}