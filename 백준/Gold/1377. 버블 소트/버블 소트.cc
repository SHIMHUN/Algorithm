#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <cmath>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    int N;
    cin >> N;
    vector<pair<int, int> > A(N);

    for (int i=0; i<N; i++){
        cin >> A[i].first;
        A[i].second =i;
    }

    sort(A.begin(), A.end());
    int Max = 0;

    for (int i=0; i<N; i++){
        if(Max < A[i].second - i){
            Max = A[i].second - i;
        }
    }
    cout << Max +1;
    // int N;
    // cin >> N;
    // int nums[N];
    // map<int, int> sort_before;

    // for (int i=1; i<=N; i++){
    //     cin >> nums[i];
    //     sort_before.insert(make_pair(nums[i],i));
    // }

    // sort(nums, nums+N);
    
    // int high_value = 0;
    // int cnt = 0;
    // for (int i=1; i<=N; i++){
    //     int num_before = sort_before.find(nums[i])->second;
    //     int num_after = i;
    //     int diff = num_after - num_before;

    //     if (abs(diff) > high_value){
    //         high_value = abs(diff);
    //     }
    // }

    // if (N==1){
    //     cout << 1 << "\n";
    // }
    // else{
    //     cout << high_value << "\n";
    // }

}