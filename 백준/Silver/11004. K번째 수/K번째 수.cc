#include <iostream>
#include <vector>

using namespace std;

void quickSort(vector<int> &A, int S, int E, int K);
int partition(vector<int> &A, int S, int E);
void swap(vector<int> &A, int i, int j);

int main(){
    ios::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    int N, K;
    cin >> N >> K;
    vector<int> A(N,0);

    for(int i=0; i<N; i++){
        cin >> A[i];
    }
    quickSort(A, 0, N-1, K-1);
    cout << A[K-1];

}

void quickSort(vector<int> &A, int S, int E, int K){
    int pivot = partition(A, S, E);
    if(pivot == K){ //k번째 수가 pivot이면 더이상 구할 필요 없음
        return;
    }
    else if(K < pivot){ //k가 pivot보다 작으면 왼쪽 그룹만 정렬 수행
        quickSort(A, S, pivot-1, K);
    }
    else{   //k가 pivot보다 크면 오른쪽 그룹만 정렬 수행
        quickSort(A, pivot+1, E, K);
    }
}

int partition(vector<int> &A, int S, int E){
    if(S+1 == E){
        if(A[S] > A[E]){
            swap(A,S,E);
        }
    return E;
    }

    int M = (S+E) / 2;
    swap(A,S,M); //중앙 값을 첫번째 요소로 이동
    int pivot = A[S];
    int i = S+1, j=E;

    while(i<=j){
        while(pivot < A[j] && j > 0){ // pivot보다 작은 수가 나올 때까지 j--
            j--;
        }
        while(pivot > A[i] && i < A.size()-1){ // pivot보다 큰 수가 나올 때까지 i++
            i++;
        }
        if (i <= j){ // 찾은 i와 j 교환
            swap(A, i++, j--);
        }
    }
    
    //i == j pivot의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
    A[S] = A[j];
    A[j] = pivot;
    return j;
}

void swap(vector<int> &A, int i, int j){
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
}