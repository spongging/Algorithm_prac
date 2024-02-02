#include <iostream> 
#include <vector>
#include <climits>
using namespace std;
typedef long long ll;
int n, h;
vector<ll>tree; 
ll nums[100000];

/*int comp(int idx1, int idx2) {  // comparing value and return that index
	if (nums[idx1].second <= nums[idx2].second) return idx1;
	else return idx2;
}*/

/*void update(int idx, int idx2) {
	idx += h;
	tree[idx] = idx2;
	while (idx > 1) {
		idx /= 2;
		tree[idx] = nums[tree[idx * 2]]<= nums[tree[idx * 2 + 1]] ?
			tree[idx * 2] : tree[idx * 2 + 1];
	}
}*/

void update(int node, int st, int ed) {
	if (st == ed)
	{
		tree[node] = st;
		return;
	}
	int mid = (st + ed) / 2;
	update(node * 2, st, mid);
	update(node * 2 + 1, mid + 1, ed);
	if (nums[tree[node * 2]] <= nums[tree[node * 2 + 1]]) tree[node] = tree[node * 2];
	else tree[node] = tree[node * 2 + 1];
}

int query(int L, int R, int node, int nodeL, int nodeR) {
	if (L <= nodeL && nodeR <= R) return tree[node];
	if (L > nodeR || nodeL > R) return -1;

	int mid = (nodeL + nodeR) / 2;
	int first = query(L, R, node * 2, nodeL, mid);
	int last = query(L, R, node * 2 + 1, mid + 1, nodeR);

	if (first == -1) return last;
	else if (last == -1) return first;
	else return nums[first] <= nums[last] ? first : last;
}

ll getArea(int st, int ed) { //get area of between st and ed
	int minIdx = query(st, ed, 1, 0, n - 1);
	ll area = (ll)(ed - st + 1) * nums[minIdx];
	if (st <= minIdx - 1)
	{
		ll tmp = getArea(st, minIdx - 1);
		if (area < tmp) area = tmp;
	}
	if (minIdx + 1 <= ed)
	{
		ll tmp = getArea(minIdx + 1, ed);
		if (area < tmp) area = tmp;
	}
	return area;
}

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	while (1)
	{ 
		cin >> n;
		if (n == 0) break;
		h = 1;
		while (n > h)h <<= 1;
		tree.resize(h * 2);
		//nums[n] = INT_MAX; 
		fill(tree.begin(), tree.end(), n);

		for (int i = 0; i < n; i++)
		{
			ll num; cin >> num;
			nums[i] = num;
		}
		update(1, 0, n - 1);
		ll result = getArea(0, n - 1);
		cout << result << "\n";
		vector<ll>().swap(tree);
	}
	

	return 0;
}
