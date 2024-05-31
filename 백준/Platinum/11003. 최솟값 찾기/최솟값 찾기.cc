#include <iostream>
#include <deque>
using namespace std;
typedef pair<int, int> Node;

int main(){

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, L, num;
    cin >> N >> L;

    deque<Node> myDeque;
    for (int i = 0; i < N; i++){
        cin >> num;

        while (myDeque.size() && myDeque.back().second > num){
            myDeque.pop_back();
        }
        myDeque.push_back(Node(i,num));

        if (myDeque.front().first <= i-L){
            myDeque.pop_front();
        }

        cout << myDeque.front().second << ' ';
    }
}
