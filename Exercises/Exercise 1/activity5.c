#include <stdio.h>

float calculate_area(float length, float width) {
    return length * width;
}

int main(void) {
    float l, w, a;
    scanf("%f %f", &l, &w);
    a = calculate_area(l, w);
    printf("%f", a);
}