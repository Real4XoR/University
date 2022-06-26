#include <stdio.h>

int main() {
    float ctemp, ftemp;

    printf("Enter temperature: ");

    scanf("%f", &ctemp);

    ftemp = (ctemp * 9/5) + 32;

    printf("%.3f", ftemp);

    return 0;
}