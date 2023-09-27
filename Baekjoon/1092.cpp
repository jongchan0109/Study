#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(int a,int b)
{
    if(a>b)
        return true;
    else
        return false;
}


int main() {
    int N, M;
    vector<int> crane;
    vector<int> box;
    
    cin >> N;
    for (int i = 0; i < N; i++) {
        int n;
        cin >> n;
        crane.push_back(n);
    }
    cin >> M;
    for (int i = 0; i < M; i++) {
        int m;
        cin >> m;
        box.push_back(m);
    }
    sort(crane.begin(), crane.end(),compare);
    sort(box.begin(), box.end(),compare);

    int cnt = 0;
    if (crane.front() < box.front()) {
        cout << -1;
        return 0;
    }

    while (!box.empty()) {
        cnt++;
        // 크레인 가장 큰 무게 부터
        for (int i = 0; i < crane.size(); i++) {
            // 상자 가장 큰 무게 부터
            for (int j=0;j<box.size();j++) {
                // 옮길 수 있으면 삭제하고 다음 크레인으로
                if (crane[i] >= box[j]) {
                    box.erase(box.begin() + j);
                    break;
                }
            }
        }
    }
    cout << cnt;
    return 0;
}