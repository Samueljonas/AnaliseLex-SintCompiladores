// File: exemplo.c
int main() {
    int a;
    a = 10;
    int b;
    b = a + 5 * 2; // b = 10 + 10 = 20

    if (a < b) {
        print(a); // Deve imprimir o valor de a (10)
    }
    
    print(b - a); // Deve imprimir 20 - 10 = 10

    return 0;
}