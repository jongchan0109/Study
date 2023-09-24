#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

long long compare(const void *a,const void *b){
    long long num1= *(long long *)a;
    long long num2 = *(long long *)b;
    if(num1 > num2){
        return 1;
    }
    else if(num1 < num2){
        return -1;
    }
    else{
        return 0;
    }
}

int main(void){
    long long arr[2001];
    int n;
    scanf("%d",&n);

    for(int i = 0;i<n;i++){
        scanf("%lld",&arr[i]);
    }

    qsort(arr,n,sizeof(long long),compare); //배열을 정렬합니다

    int count = 0;

    for(int i = 0;i<n;i++){ //배열의 개수만큼 for문 돌리면서
        int l = 0;
        int r = n-1;

        while(l<r && r<n){ //l과 r이 같지 않아야 한다.

            long long sum = arr[l] + arr[r]; //두 수의 합
            if(l == i)
            {
                l++;
                continue;
            }
            else if(r==i)
            {
                r--;
                continue;
            }
            if(sum > arr[i]){
                r--; //합이 구하고자 하는 배열의 원소보다 크다면 r줄이면서 범위 축소
            }
            else if(sum < arr[i]){
                l++;  //그 외에는 왼쪽 증가
            }
            else if(sum == arr[i]){
                count++;
                break;  //합이 배열의 원소라면 count증가시키고 루프 탈출
            }
        }
    }
    printf("%d",count);
}