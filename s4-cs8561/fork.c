#include <stdio.h>
#include <unistd.h>

int main() {
    int pid;
    pid = fork();
    if (pid == 0 ) {
        printf("Child process is %d\n", getpid());
        printf("Parent process is %d\n", getppid());
    
    }else {
        printf("Parent process is %d\n", getpid());
        printf("Parent of parent process is %d\n", getppid());
    }
    return 0;
}