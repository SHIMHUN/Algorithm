#include <iostream>
#include <string>
// #include <sstream>
// #include <vector>
using namespace std;

int main(){
    int N;
    string input;
    int M = 0;
    int sum = 0;
    int scores[1000]; //N이 1000보다 작거나 같으므로 미리 배열 초기화
    cin >> N;
    for (int i=0; i<N; i++){
        cin >> scores[i]; 
        if (scores[i] > M){
            M = scores[i];
        }
        sum += scores[i];
        // cout << scores[i] << endl;
    }

    double result1 = 100.0 * sum / M / N;
    // double result2 = 100 / M * sum / N;
    // double result3 = 100 / N * sum / M;
    // double result4 = 100 / N / M * sum;
    cout << result1 << endl;
    // cout << result2 << endl;
    // cout << result3 << endl;
    // cout << result4 << endl;

    return 0;
}