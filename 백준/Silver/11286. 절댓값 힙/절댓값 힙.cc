#include <iostream>
#include <queue>

using namespace std;

struct compare{
    bool operator()(int o1, int o2){
        int first_abs = abs(o1);
        int second_abs = abs(o2);

        if (first_abs == second_abs){ //절대값이 같다면 더 작은 값에 우선순위
            return o1 > o2;
        }
        else {
            return first_abs > second_abs; //절대값이 더 작은 값에 우선순위
        }
    }
};

int main(){
    ios::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    priority_queue<int, vector<int>, compare> MyQueue;

    int N;
    cin >> N;
 
    for(int i=0; i<N; i++){ //N개의 수 입력받기
        // cout << "test" << "\n";
        int x;
        cin >> x;
        if (x!=0){
            MyQueue.push(x);
        }
        else{
            if (MyQueue.empty()){ //큐가 비어있으면
                cout << "0" << "\n";
            }
            else{
                cout << MyQueue.top() << "\n";
                MyQueue.pop();
            }
        }
    }

}