#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int p, w, c, v;
int parent[1001];

struct s {
	int a, b, c;
};

bool cmp(s &s1, s &s2) {
	return s1.c > s2.c;
}

vector<s>arr;

int find(int x) {
	if (parent[x] == x) return x;
	return parent[x] = find(parent[x]);
}

int merge(int x, int y) {
	x = find(x);
	y = find(y);
	if (x > y) parent[x] = y;
	else parent[y] = x;
	if (find(c) == find(v)) return 1;
	else return 0;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> p >> w;
	cin >> c >> v;
	arr.resize(w);
	for (int i = 0; i < 1001; i++) parent[i] = i;
	for (int i = 0; i < w; i++)
	{
		int x, y, z; cin >> x >> y >> z;
		arr[i] = { x,y,z };
	}
	sort(arr.begin(), arr.end(), cmp);
	for (int i = 0; i < w; i++)
	{
		int result = merge(arr[i].a, arr[i].b);
		int width = arr[i].c;
		if (result) {
			cout << width << "\n";
			break;
		}
	}
	
	return 0;
}
