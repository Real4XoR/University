#include <stdio.h>

// Define structure record

// Implement print_record_ptr() function

int main(void)
{
    struct record rec;

    scanf("%s %d %f", rec.name, &rec.age, &rec.height);
    print_record_ptr(&rec);
    return 0;
}
