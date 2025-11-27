void main() {
    double[] nums = {56.8, 117.9, 167};
    double sumaTotal = 0;

    for (double numero : nums) {
        sumaTotal += numero;
    }
    IO.println(sumaTotal / nums.length);
}