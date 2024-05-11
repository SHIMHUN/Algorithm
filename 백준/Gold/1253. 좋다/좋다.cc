#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    int N;
    cin >> N;

    //데이터 배열에 저장
    vector<int> V(N,0);
    for (int i = 0; i < N; i++){
        cin >> V[i];
    }

    //배열 정렬
    sort(V.begin(), V.end());

    //연산 수행
    int cnt = 0;
    int i=0;
    int j=N-1;
    for (int k = 0; k < N; k++){
        int i=0;
        int j=N-1;

        while(i < j){
            int num = V[i] + V[j];

            if (num == V[k]){
                if (i != k && j != k){
                    cnt++;
                    break;
                }
                else if (i == k){
                    i++;
                }
                else if (j == k){
                    j--;
                }
            }
            else if(num < V[k]){
                i++;

            }
            else if(num > V[k]){
                j--;
            }
        }
    }
    std::cout << cnt << "\n";
    return 0;
}