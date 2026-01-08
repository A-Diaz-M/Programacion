void main() {
    int num = 0;
    int num2 = 1;
    int num3;

    for (int i = 0; i < 30; i++){
        num3 = num + num2;
        IO.println(num);
        num = num2;
        num2 = num3;
    }
}