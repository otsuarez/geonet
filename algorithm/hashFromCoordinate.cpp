#include <iostream>
#include <fstream>
#include <stdio.h>
#include <sstream>
#include <algorithm>
#include <cmath>
#include <cstring>
#include <cstdlib>
#include <string>
#include <vector>
#include <map>
#include <list>
#include <queue>
#include <deque>
#include <list>
#include <stack>

#define pb(a) push_back(a)
#define p(a)  push(a)
#define rep(i, b, a) for(int i = (int)b; i < (int)a; i++)

#define LLD long double

using namespace std;

string hexFromInt(int i)
{
	stringstream ss;
	ss << hex << i;
	return ss.str();
}

string a = "";

void hashFromLatLong(LLD lat, LLD lon, LLD latRange, LLD lonRange, LLD latInit, LLD lonInit, LLD latInc, LLD lonInc)
{
	int p = 0, t;
	for (LLD i = latInit; i < latRange; i+=latInc , p++)
	{
		int q = 0;
		for (LLD j = lonInit; j < lonRange; j+=lonInc , q++)
		{
			if (lon > j && lon < j + lonInc &&
				lat > i && lat < i + latInc)
			{
				cout << p << " " << q << endl;
				t = p*4+q;
				a += hexFromInt(t);
				hashFromLatLong(lat, lon, i+latInc, j+lonInc, i, j, latInc / 4, lonInc / 4);
			}
		}
	}
}


int main()
{
	hashFromLatLong(33.3234234+90, 75.342432432+180, 180.0, 360.0, 0, 0, 180.0/4, 360.0/4);
	cout << a.substr(0, 14);
}