#include <stdio.h>
#include <limits.h>
 
int main()
{
    int check[101][101] = { 0, };
    int count = 4;
    int x1, y1, x2, y2;
    int maxx=INT_MIN, maxy=INT_MIN;
    while (count--)
    {
        scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
        for (int i = y1; i < y2; i++)
        {
            for (int j = x1; j < x2; j++)
            {
                if (check[i][j] == 1)
                {
                    continue;
                }
                else
                {
                    check[i][j] = 1;
                }
            }
        }
        if (maxx < x2)
        {
            maxx = x2;
        }
        if (maxy < y2)
        {
            maxy = y2;
        }
    }
    count = 0;
    for (int i = 0; i <= maxy; i++)
    {
        for (int j = 0; j <= maxx; j++)
        {
            if (check[i][j] == 1)
            {
                count++;
            }
            else
            {
                continue;
            }
        }
    }
    printf("%d", count);
}