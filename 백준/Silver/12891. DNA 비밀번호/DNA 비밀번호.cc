#include <iostream>
#include <vector>

using namespace std;

int checkArr[4];
int condition[4];
int cnt=0;
int checkCnt=0;
void add(char str);
void remove(char str);
// void check();

int main(){
    //DNA 문자열 길이, 부분 문자열 길이 입력받기
    int S, P;
    cin >> S >> P;
    
    //DNA 문자열 입력받기
    string DNA;
    cin >> DNA;
    
    //최소갯수 입력 받기
    for (int i = 0; i < 4; i++){
        cin >> condition[i];
        if (condition[i] == 0){
            checkCnt++;
        }
    }
    //슬라이딩 윈도우 초기 세팅
    for (int i = 0; i < P; i++){
        add(DNA[i]);
    }
    if (checkCnt == 4){
        // cout << "check test" << '\n';
        cnt++;
    }

    //조건에 만족하는 전체 갯수 세기
    int start = 0;
    int end = P;
    while(end < S){
        // cout << "test" << "\n";
        add(DNA[end]);
        remove(DNA[start]);
        // cout << checkCnt << "\n";
        if (checkCnt == 4){
            cnt++;
        }
        start++;
        end++;
    }
    cout << cnt << "\n";
}

void add(char str){
    switch (str)
    {
    case 'A':
        checkArr[0]++;
        if (checkArr[0] == condition[0]){
            checkCnt++;
        }
        break;
    case 'C':
        checkArr[1]++;
        if (checkArr[1] == condition[1]){
            checkCnt++;
        }
        break;
    case 'G':
        checkArr[2]++;
        if (checkArr[2] == condition[2]){
            checkCnt++;
        }
        break;
    case 'T':
        checkArr[3]++;
        if (checkArr[3] == condition[3]){
            checkCnt++;
        }
        break;
    default:
        break;
    }
}

void remove(char str){
    switch (str)
    {
    case 'A':
        if (checkArr[0] == condition[0]){
            checkCnt--;
        }
        checkArr[0]--;
        break;
    case 'C':
        if (checkArr[1] == condition[1]){
            checkCnt--;
        }
        checkArr[1]--;
        break;
    case 'G':
        if (checkArr[2] == condition[2]){
            checkCnt--;
        }
        checkArr[2]--;
        break;
    case 'T':
        if (checkArr[3] == condition[3]){
            checkCnt--;
        }
        checkArr[3]--;
        break;
    
    default:
        break;
    }
}