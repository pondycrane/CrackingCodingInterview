class AddDigits {
    public int addDigits(int num) {
        return num == 0 ? 0 : num % 9 != 0 ? num % 9 : 9;
    }
}
