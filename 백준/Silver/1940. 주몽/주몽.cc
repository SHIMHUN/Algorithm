#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int main(){
    int N, M;

    cin >> N >> M;

    // 재료 정렬
    vector<int> V(N, 0);
    for(int i = 0; i < N; i++){
        cin >> V[i];
    } 
    sort(V.begin(), V.end());

    // 답찾기
    int first_idx = 0;
    int second_idx = N-1;
    int cnt = 0;
    while (first_idx < second_idx){
        int sum = V[first_idx] + V[second_idx];
        if (sum == M){
            cnt++;
            first_idx++;
            second_idx--;
        }
        else if (sum < M){
            first_idx++;
        }   
        else if (sum > M){
            second_idx--;
        }
    }

    cout << cnt << "\n";
    return 0;
}