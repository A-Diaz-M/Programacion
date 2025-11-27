void main() {
    double[] nums = {3.14, 1.5, 99.9, 99.9};

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            IO.println(String.format("El número %d es MAYOR que el número %d.", (i + 1), i));
        } else if (nums[i] < nums[i - 1]) {
            IO.println(String.format("El número %d es MENOR que el número %d.", (i + 1), i));
        } else if (nums[i] == nums[i - 1]) {
            IO.println(String.format("El número %d es IGUAL que el número %d.", (i + 1), i));
        }
    }
}