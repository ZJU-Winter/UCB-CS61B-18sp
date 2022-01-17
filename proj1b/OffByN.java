public class OffByN implements CharacterComparator {
    private int N;

    OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(Character.toUpperCase(x) - Character.toUpperCase(y)) == N;
    }
}
