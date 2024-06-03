#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main(){
    int N;
    cin >> N;

    vector<int> nums;
    for(int i=0; i<N; i++){ //입력받은 수열 ex) 3 5 2 7
       int num;
       cin >> num;
       nums.push_back(num);
    }
    
    stack<int> indexes;
    vector<int> result(N, 0);
    for(int i=0; i<N; i++){
        if(indexes.empty()){ //스택이 비어있는 초기 단계
            indexes.push(i);
        }
        else{
            if(nums[indexes.top()] > nums[i]){ //오큰 수가 존재할지 안할지는 모르지만, 일단 푸시하고 다음 루프 진행
                indexes.push(i);
            }
            else{
                while(!indexes.empty() && nums[indexes.top()] < nums[i]){ //스택이 빈 상태에서 해당 작업을 진행하면 세그먼트 에러가 뜨므로 조건 추가로 지정
                    result[indexes.top()] = nums[i]; //오큰 수 저장
                    indexes.pop();
                }
                indexes.push(i);
            }
        }
    }

    while(!indexes.empty()){ //스택 비워질 때까지
        result[indexes.top()] = -1;
        indexes.pop();
    }

    for(int i=0; i<N; i++){
        cout << result[i] << " ";
    }
    // cout << " ";
}