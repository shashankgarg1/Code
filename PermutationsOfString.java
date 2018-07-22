import java.lang.StringBuilder;

class Permutations {
    private StringBuilder swap(StringBuilder str, int sourcePos, int targetPos) {
        char sourceChar = str.charAt(sourcePos);
        char targetChar = str.charAt(targetPos);

        str.setCharAt(sourcePos, targetChar);
        str.setCharAt(targetPos, sourceChar);
        return str;
    }

    private void findPermutations(StringBuilder str, int left, int right) {
        if (left == right) {
            System.out.println(str.toString());
            return;
        }

        for (int i = left; i <= right; i++) {
            str = this.swap(str, left, i);
            this.findPermutations(str, left + 1, right);
            str = this.swap(str, left, i);
        }
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("ABC");
        (new Permutations()).findPermutations(str, 0, str.length() - 1);
    }
}