#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int a, b, sum;
    char line [20];
    FILE *in; // use for handling input file
    FILE *out; // use for handling output file

    // Open raw.txt for reading
    in = fopen("C:\\Users\\cobba\\OneDrive\\Documents\\Code\\C\\NWEN 241\\Exercises\\Exercise 3\\nwen241_exercise3_files\\raw.txt", "r");
    // Open processed.txt for writing
    out = fopen ("processed.txt", "w");
    // Go thru raw.txt file and generate processed.txt file accordingly
    fscanf(in, "%f %f", &a, &b);
    fclose(in);
    sum = a + b;
    printf("%d\n", line);
    
    fputs(line, out);
    fclose(out);

    return 0;
}
