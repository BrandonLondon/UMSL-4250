#include <stdio.h>
#include <stdlib.h>
#define SIZE 1000

void f1() {
    char arr[SIZE];
    static int n = 1;
    static long int addr;

    printf("Call #%d\t at %p \n", n, arr);
    printf("AR Size: #%d\t is %ld\n", n, addr - (long)(arr));
    n++;
    addr = (long)(arr);
    if (n < 11) {
        f1();
    } else {
        return;
    }
}

void f2() {
    char arr[SIZE];
    static int n = 1;
    static long int addr;

    printf("Call #%d\t at %p \n", n, arr);
    printf("AR Size: #%d\t is %ld\n", n, addr - (long)(arr));
    printf("Stack Size\t%d is %ld\n", n, n*addr);
    n++;
    addr = (long)(arr);

    f2();

}

void f3() {
    char *arr = (char*) malloc(sizeof(char) * SIZE);
    static int n = 1;
    static long int addr;
    char c;

    printf("Call #%d\t at %p \n", n, (long)&c);
    printf("AR Size: #%d\t is %ld\n", n, addr - (long)&c);

    n++;
    addr = (long)&c;

    free(arr);

    if(n < 11) {
        f3();
    } else {
        return;
    }
    
}

int main() {
    f1();
    //f2();
    //f3();
    return 0;
}