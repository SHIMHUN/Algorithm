#include <iostream>
#include <sstream>
using namespace std;

int main(){
    ios::sync_with_stdio(false); //런타임 에러 해결
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;
  
    //구간합 배열화
    int sum_nums[100001] = {}; //모든 배열 요소 0으로 초기화
    for (int i=1; i<=N; i++){
        int num;
        cin >> num;
        sum_nums[i] = num + sum_nums[i-1];
    }

    for(int j=0; j<M; j++){
        int start, end;
        cin >> start >> end;
        cout << sum_nums[end] - sum_nums[start-1] << "\n"; //모든 배열이 0으로 초기화 되어있으므로 극한값. 예를 들어 1번째~1번째 구간합을 구할때 상관없어짐
    }

    return 0;
}