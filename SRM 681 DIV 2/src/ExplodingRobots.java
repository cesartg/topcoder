public class ExplodingRobots {
    public String canExplode(int x1, int y1, int x2, int y2, String instructions) {
        int verticalInstructions = countVerticalInstructions(instructions);
        int horizontalInstructions = instructions.length() - verticalInstructions;
        int horizontalDistance = Math.abs(x1 - x2);
        int verticalDistance = Math.abs(y1 - y2);
        if (verticalDistance <= verticalInstructions && horizontalDistance <= horizontalInstructions) {
            return "Explosion";
        }
        return "Safe";
    }

    private int countVerticalInstructions(String instructions) {
        int verticalInstructions = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'U' || c == 'D') {
                verticalInstructions++;
            }
        }
        return verticalInstructions;
    }
}
