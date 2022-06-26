#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<stdlib.h>

int main()
{
 int pid, ret_exec, status;
 pid=fork();

 switch(pid){

 case -1:
   printf("ERROR");
   exit(0);

 case 0:
    execl("ps", "-A", NULL);
    printf("Error executing exec");

 default:
     
    /* code for case default */
 }
}
