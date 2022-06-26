#include <stdio.h>
#include <sys/stat.h>
#include <sys/dir.h>

int main (int argc, char  **argv) {
    DIR *pDir;
    struct dirent *pDirent;
    struct stat buf;
    char *fname;
    fname = *++argv;
    if(pDir=opendir(fname)==NULL) 
    printf("Cannot open this Directory");
    else {
        printf("Name\t Mode\t Ino\t UID\t Atime\n");
        while (pDirent=readdir(pDir)!=0) {
            if(stat(pDirent->d_name, &buf) == 0)
            printf("%s\t %d\t %ld\t %d\t %ld\n",pDirent->d_name, buf.st_mode,buf.st_ino,buf.st_uid,buf.st_atime);
        }
    }
}