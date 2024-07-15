#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    // int nums[5];
    int N;
    cin >> N;
    vector<int> nums(N,0);

    for(int i=0; i<N; i++){
        cin >> nums[i];
    }

    for(int i=0; i<N-1; i++){
        for(int j=0; j<N-i-1; j++){
            if(nums[j] > nums[j+1]){
                // int replace_num = nums[j];
                // nums[j] = nums[j+1];
                // nums[j+1] = replace_num;

                int replace_num = nums[j+1];
                nums[j+1] = nums[j];
                nums[j] = replace_num;
            }
        }
    }

    for(int i=0; i<N; i++){
        cout << nums[i] << "\n";
    }

    return 0;
}
