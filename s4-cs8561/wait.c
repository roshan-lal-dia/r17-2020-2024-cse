#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
void main() {
    int i =0, pid;
    printf ("Ready to fork\n");
    pid = fork();
    if (pid ==0) {
        printf("Child starts\n");
        for (i =0; i<10;i++)
        printf("%d\t", i);
        printf ("Child ends\n");
    }else {
        wait(0);
        for (i =0; i < 10; i++)
        printf("%d\t", i);
    printf ("parent process ends\n");
         }
}