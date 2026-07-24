import java.util.*;

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();

        Arrays.sort(words); // Needed for lexicographic order

        boolean[] used = new boolean[words.length];
        List<String> current = new ArrayList<>();

        backtrack(words, used, current, result);

        return result;
    }

    private void backtrack(String[] words, boolean[] used,
                           List<String> current,
                           List<List<String>> result) {

        if (current.size() == 4) {
            if (isValid(current)) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(words[i]);

                backtrack(words, used, current, result);

                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    private boolean isValid(List<String> square) {
        String top = square.get(0);
        String left = square.get(1);
        String right = square.get(2);
        String bottom = square.get(3);

        return top.charAt(0) == left.charAt(0)
                && top.charAt(3) == right.charAt(0)
                && bottom.charAt(0) == left.charAt(3)
                && bottom.charAt(3) == right.charAt(3);
    }
}