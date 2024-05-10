#include<iostream>

using namespace std;

int main(){
    int start_idx = 1;
    int end_idx = 1;
    int sum = 1;
    int cnt = 1;
    int N;

    cin >> N;
    
    while(end_idx != N){
        if(sum < N){
            end_idx++;
            sum += end_idx;
        }
        else if(sum == N){
            cnt++;
            end_idx++;
            sum += end_idx;
        }
        else if(sum > N){
            sum -= start_idx;
            start_idx++;
        }
    }

    cout << cnt;
}