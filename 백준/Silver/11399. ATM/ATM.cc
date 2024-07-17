#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> nums(N,0);
    for(int i=0; i<N; i++){
        cin >> nums[i];
    }
 
    for(int i=1; i<N; i++){
        int insert_idx = i;
        int insert_data = nums[i];

        for(int j=i-1; j>=0; j--){ //기준점이 되는 인덱스부터 역순으로 비교하면서 찾아감. 이미 정렬되어있기 때문에 값이 커지는 지점만 찾으면 됨
            if(nums[j] < insert_data){ //값이 커지는 지점 발견
                insert_idx = j+1;
                break;
            }
            if(j==0){ //끝까지 돌았는데 지점을 찾지 못했다면 i는 가장 작은 값임
                insert_idx = 0;
            }
        }

        for(int j=i; j>insert_idx; j--){ //insert_idx에 값 삽입
            nums[j] = nums[j-1]; //한칸씩 뒤로 밀어내기
        }
        nums[insert_idx] = insert_data; //삽입 지점에 데이터 삽입
    }

    vector<int> S(N,0); //합 배열 만들기
    S[0] = nums[0];
    for(int i=1; i<N; i++){
        S[i] = S[i-1] + nums[i];
    }

    int sum = 0;
    for(int i=0; i<N; i++){ //걸리는 시간 총합 구하기
        sum += S[i];
    }
    cout << sum;
}
