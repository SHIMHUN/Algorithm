#include <iostream>
#include <deque>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    deque<int> cards;

    for (int i=1; i<N+1; i++){
        cards.push_front(i);
    }

    while(cards.size() >=3 ){
        int card;
        cards.pop_back();
        card = cards.back();
        cards.pop_back();
        cards.push_front(card);
    }    

    cout << cards.front() << "\n";
}