public class CalkinWilf {
    public int[] findRational(String path) {
        int[] result = new int[]{1, 1};
        for (char c : path.toCharArray()) {
            if (c == 'L') {
                result[1] += result[0];
            } else {
                result[0] += result[1];
            }
        }
        return result;
    }
}
