#include <iostream>
#include <string>
#include <typeinfo>
// #include <>

using namespace std;

int main(){
    int result = 0;
    int N;
    string nums;
    cin >> N >> nums;
    for (int i = 0; i < N; i++){

        result += nums[i] - '0';
    }
    cout << result;
}