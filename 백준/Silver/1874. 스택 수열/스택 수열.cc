#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    vector<int> A(N,0);

    for (int i=0; i<N; i++){ //주어진 수열 입력받기
        cin >> A[i];
    }

    stack<int> myStack;
    vector<char> resultV;
    int num = 1; //카운트 변수
    bool result = true;

    for(int i=0; i<A.size(); i++){
        int su = A[i]; //현재 수열의 수

        if(su >= num){ //현재 값이 num보다 크다면 num이 su가 될 때까지 오름차 순으로 저장한다
            while(su >= num){
                myStack.push(num++);
                resultV.push_back('+');
            }
            
            myStack.pop();
            resultV.push_back('-');
        }
        else{
            int n = myStack.top(); //pop을 하면 값이 바로 삭제되므로 top으로 먼저 값을 저장해놓고 pop으로 삭제
            myStack.pop();
            
            if (n > su){ //pop한 값이 현재 수열의 값과 다른 경우
                cout << "NO";
                result = false;
                break;
            }
            else if(n == su){ //pop한 값이 현재 수열의 값과 같은 경우
                resultV.push_back('-');
            }
        }
    }

    if(result){//수열을 만들 수 있다면
        for(int i=0; i<resultV.size(); i++){
            cout << resultV[i] << "\n";
        }
    }

    // int n;
    // cin >> n;
    // stack<int> nums;
    // vector<string> result;

    // // for(int i=0; i<n; i++){
    
    // int cnt = 1;
    // while(cnt <= 8){

    //     int num;
    //     cin >> num;

    //     if(nums.empty()){ //아직 아무런 값도 입력받지 않은 경우
    //         for (int j=1; j<num+1; j++){
    //             nums.push(j);
    //             result.push_back("+");
    //             cout << "test1" << "\n";
    //             cnt++;
    //         }
    //         nums.pop();
    //         result.push_back("-");
    //     }
    //     else{
    //         int num_top;
    //         num_top = nums.top();

    //         if(num_top == num){
    //             nums.pop();
    //             result.push_back("-");
    //         }
    //         else if(num_top < num){
    //             nums.push(cnt);
    //             result.push_back("+");
    //             cout << cnt << "\n";
    //             cnt++;
    //         }
    //         // else{
    //         //     cout << "NO" << "\n";
    //         //     return;
    //         // }
    //     }
    // }

    // for (int i=0; i<n; i++){
    //     cout<< result[i] << "\n";
    // }

    // return 0;
}
