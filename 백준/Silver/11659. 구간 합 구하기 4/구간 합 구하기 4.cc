#include <iostream>
#include <sstream>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    // //주어진 값들 배열화
    // int nums[100000];
    // for(int i=0; i<N; i++){
    //     cin >> nums[i];
    // }
  
    //구간합 배열화
    int sum_nums[100001] = {};
    // sum_nums[0] = nums[0]; //1번째 인덱스에 초기 값 할당
    for (int i=1; i<=N; i++){
        int num;
        cin >> num;
        sum_nums[i] = num + sum_nums[i-1];
        // cout << sum_nums[i];
    }

    // // //M개의 구간합 구하기
    // string line;
    // int cnt = 0;
    // getline(cin, line);
    // for(int j=0; j<M; j++){
    //     getline(cin, line); // 라인단위로 읽기. \n이 나올때까지
    //     stringstream ss(line);

    //     string buffer;
    //     int start, end;
    //     while (getline(ss, buffer, ' ')){
    //         if(cnt == 0){
    //             cout << "start : " << buffer << endl;
    //             // start = atoi(buffer.c_str());
    //             cnt++;
    //         }
    //         else{
    //             cout << "end : " << buffer << endl;
    //             // end = atoi(buffer.c_str());
    //         }
    //     }
    //     // cout << sum_nums[end] - sum_nums[start] << endl;
        
    //     cnt = 0;
    //     // int start, end;
    //     // cin >> start >> end; 
    //     // // cin >> end;
    //     // cout << start;
    //     // cout << endl;
    //     // // cout << sum_nums[end] - sum_nums[start-1] << endl;
    // }

    for(int j=0; j<M; j++){
        int start, end;
        cin >> start >> end;
        cout << sum_nums[end] - sum_nums[start-1] << "\n"; //인덱스가 0번부터 시작하므로 i번째 원소는 i-1번째 인덱스를 말한다
    }

    return 0;
}