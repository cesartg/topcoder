public class CoinFlipsDiv2 {
	public int countCoins(String state) {
        int count = 0;
        for (int i = 0; i < state.length(); i++) {
            if(i > 0 && !equalsToPreviousCoin(state, i)) {
                count++;
            } else if(i < state.length() - 1 && !equalsToNextCoin(state, i)) {
                count++;
            }
        }
        return count;
    }
    private boolean equalsToPreviousCoin(String state, int i) {
        return state.charAt(i) == state.charAt(i - 1);
    }

    private boolean equalsToNextCoin(String state, int i) {
        return state.charAt(i) == state.charAt(i + 1);
    }
}
