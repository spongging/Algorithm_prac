#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <iomanip>
using namespace std;

int n;
vector<pair<double, double>>coor;
vector<pair<double, pair<int, int>>>edge;
int parent[101];

int find(int x) {
	if (x == parent[x]) return x;
	parent[x] = find(parent[x]);
	return parent[x];
}

bool merge(int x, int y) {
	x = find(x);
	y = find(y);
	if (x == y) return 1;
	if (x > y) parent[x] = y;
	else parent[y] = x;
	return 0;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	double result = 0;
	for (int i = 0; i <= 100; i++) parent[i] = i;
	for (int i = 0; i < n; i++)
	{
		double x, y; cin >> x >> y;
		coor.push_back({ x,y });
	}

	for (int i = 0; i < n; i++)
	{
		double initx = coor[i].first;
		double inity = coor[i].second;

		for (int j = i + 1; j < n; j++)
		{
			double tmpx = coor[j].first;
			double tmpy = coor[j].second;
			double distance = sqrt(pow(initx - tmpx, 2) + pow(inity - tmpy, 2));
			edge.push_back({ distance, {i,j} }); 
		}
	}

	sort(edge.begin(), edge.end());
	for (int i = 0; i < edge.size(); i++)
	{
		if (!merge(edge[i].second.first, edge[i].second.second)) result += edge[i].first;
	}
	cout << fixed << setprecision(2);
	cout << result << "\n";

	return 0;
}
