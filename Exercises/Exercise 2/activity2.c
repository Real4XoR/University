#include <stdio.h>

// Define structure record

struct record {
   char name[40];
   short int age;
   float  height;
} r;

// Implement print_record() function
void print_record(struct record *r) {
    printf("Name  : %s\n", r->name);
    printf("Age   : %i\n", r->age);
    printf("Height: %f", r->height);
}

int main(void)
{
    struct record rec;

    scanf("%s %d %f", &rec.name, &rec.age, &rec.height);
    print_record(&rec);
    return 0;
}
