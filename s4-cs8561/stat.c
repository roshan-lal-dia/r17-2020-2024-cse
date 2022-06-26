#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <errno.h>
#include <unistd.h>

void main (int argc,char  **argv) {
    char *fname;
    struct  stat buf;
    fname = *++argv;
    if(stat(fname, &buf) == 0 ) {
        printf("The uid of %s is %d\n", fname, buf.st_uid);
    }else {
        perror("stat");
        exit(1);
    }
    exit(0);

}