#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    string N;
    cin >> N;

    vector<int> nums(N.size(), 0);

    for(int i=0; i<N.size(); i++){
        nums[i] = stoi(N.substr(i, 1));
    }

    for(int i=0; i<N.size(); i++){
        int Max = i;
        for(int j=i+1; j<N.size(); j++){
            if(nums[j] > nums[Max]){
                Max = j;
            }
        }

        if(nums[Max] > nums[i]){
            int temp = nums[i];
            nums[i] = nums[Max];
            nums[Max] = temp;
        }
    }

    for(int i=0; i<N.size(); i++){
        cout << nums[i];
    }
}