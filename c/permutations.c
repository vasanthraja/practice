#include <stdio.h>
#define TRUE 1
#define FALSE 0
#define SIZE 5
void print(int a[], int n)
{
	int i = 0;
	for(i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}


/*This function permutes a given array*/
void permute(int input[], int out[], int d, int n, int used[])
{
	int i = 0;
	if (n == d)
	{
		print(out, d);
		return;
	}
	for(i = 0; i < n; i ++)
	{
		if (used[i])
			continue;
		used[i] = TRUE;
		out[d] = input[i];
		permute(input, out, d + 1, n, used);
		used[i] = FALSE;
	}
}

int main(void)
{
	int input[SIZE] = {1, 2, 3, 4, 5};
	int output[SIZE];
	int used[SIZE];
	int i = 0;
	for(i = 0; i < SIZE; i++)
		used[i] = FALSE;
	permute(input, output, 0, 4, used);
	return 0;
}
