public class OffByN implements CharacterComparator {
    /* implement a single constructor that takes in an int*/
    private int num;
    public OffByN(int x) {
        num = x;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == num || x - y == -num) {
            return true;
        }
        return false;
    }
}
