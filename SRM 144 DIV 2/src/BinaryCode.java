public class BinaryCode {
    public String[] decode(String message) {
        String[] decodedMessages = new String[2];
        decodedMessages[0] = decode(message, "0");
        decodedMessages[1] = decode(message, "1");
        return decodedMessages;
    }

    private String decode(String encodedMessage, String decodedMessageAssumedFirstCharacter) {
        int messageLength = encodedMessage.length();
        if (messageLength == 1) {
            if (encodedMessage.equals(decodedMessageAssumedFirstCharacter)) {
                return decodedMessageAssumedFirstCharacter;
            }
            return "NONE";
        }
        final int[] encodedMessageDigits = stringToIntArray(encodedMessage);
        final int[] decodedMessageDigits = new int[messageLength];
        int decodedMessageAssumedFirstDigit = Integer.parseInt(decodedMessageAssumedFirstCharacter);
        decodedMessageDigits[0] = decodedMessageAssumedFirstDigit;
        decodedMessageDigits[1] = encodedMessageDigits[0] - decodedMessageAssumedFirstDigit;
        if (isInvalidBinaryDigit(decodedMessageDigits[1])) {
            return "NONE";
        }
        for (int i = 2; i < messageLength; i++) {
            decodedMessageDigits[i] = encodedMessageDigits[i - 1] - decodedMessageDigits[i - 1] -
                    decodedMessageDigits[i - 2];
            if (isInvalidBinaryDigit(decodedMessageDigits[i])) {
                return "NONE";
            }
        }
        if (encodedMessageDigits[messageLength - 1] != decodedMessageDigits[messageLength - 2] +
                decodedMessageDigits[messageLength - 1]) {
            return "NONE";
        }
        return intArrayToString(decodedMessageDigits);
    }

    private int[] stringToIntArray(String str) {
        int[] intArray = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            intArray[i] = Character.getNumericValue(str.charAt(i));
        }
        return intArray;
    }

    private boolean isInvalidBinaryDigit(int digit) {
        return digit != 0 && digit != 1;
    }

    private String intArrayToString(int[] intArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : intArray) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}
