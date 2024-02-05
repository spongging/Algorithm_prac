#include <iostream>
#include <vector>
using namespace std;

/*
 다르게 세그 트리 구현, 도저히 하다가 노드 풀로 다 만들고 풀기엔 머리 아픔
 리프 노드가 제곱수가 아니면 정답 오류남,
 tree에서 내가 원하는 인덱스 구간 찾을 때 뽀록나는 문제 같은데 
 예시는
 6
 0 1 2 3 4 5
 그래서 일단 필요한 만큼만 노드 초기화 해보기
 */

int N, h = 1;
vector<int>tree;
int arr[100001];
int result[100001];

void init(int node, int nodeL, int nodeR) {
	if (nodeL == nodeR) {
		tree[node] = 1;
		return;
	}
	int mid = (nodeL + nodeR) / 2;
	init(node * 2, nodeL, mid);
	init(node * 2 + 1, mid + 1, nodeR);
	tree[node] = tree[node * 2] + tree[node * 2 + 1];
}


void update(int node, int nodeL, int nodeR, int idx) {
	if (idx<nodeL || idx>nodeR) return;
	if (nodeL == nodeR) {
		tree[node] = 0; 
		return;
	}
	int mid = (nodeL + nodeR) / 2;
	update(node * 2, nodeL, mid, idx);
	update(node * 2 + 1, mid + 1, nodeR, idx);
	tree[node]--; // decrease(-1) top node  
}

int query(int node, int nodeL, int nodeR, int tmp) { // to finding a index of value
	if (nodeL == nodeR) return nodeL;
	int mid = (nodeL + nodeR) / 2;
	if (tmp < tree[node * 2]) return query(node * 2, nodeL, mid, tmp);
	else return query(node * 2 + 1, mid + 1, nodeR, tmp - tree[node * 2]);
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N; 
	while (N > h)h <<= 1;
	tree.resize(h * 2);
	fill(tree.begin(), tree.end(), 0);

	for (int i = 1; i <= N; i++)
	{
		int num; cin >> num;
		arr[i] = num;
	}

	//for (int i = 0; i < N ; i++) update(i, 1); //init the tree 

	init(1, 1, N); // init the tree

	for (int i = 1; i <= N; i++) //finding a result
	{
		int idx = query(1, 1, N, arr[i]); 
		result[idx] = i; // saving a number into find index
		update(1, 1, N, idx);
	}

	for (int i = 1; i <= N; i++) // printing a array
	{
		cout << result[i] << "\n";
	}
	return 0;

} 
