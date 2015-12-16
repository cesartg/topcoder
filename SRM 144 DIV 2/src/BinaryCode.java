public class BinaryCode {
    public String[] decode(String message) {
        String[] decodedMessages = new String[2];
        decodedMessages[0] = decode(message, 0);
        decodedMessages[1] = decode(message, 1);
        return decodedMessages;
    }

    private String decode(final String encodedMessage, final int assumedFirstCharacter) {
        final int messageLength = encodedMessage.length();
        if (messageLength == 1) {
            if (encodedMessage.equals(assumedFirstCharacter + "")) {
                return assumedFirstCharacter + "";
            }
            return "NONE";
        }
        final int[] encodedMessageInts = stringToIntArray(encodedMessage);
        final int[] decodedMessageInts = new int[messageLength];
        decodedMessageInts[0] = assumedFirstCharacter;
        decodedMessageInts[1] = encodedMessageInts[0] - assumedFirstCharacter;
        if (decodedMessageInts[1] != 0 && decodedMessageInts[1] != 1) {
            return "NONE";
        }
        for (int i = 2; i < messageLength; i++) {
            decodedMessageInts[i] = encodedMessageInts[i - 1] - decodedMessageInts[i - 1] -
                    decodedMessageInts[i - 2];
            if (decodedMessageInts[i] != 0 && decodedMessageInts[i] != 1) {
                return "NONE";
            }
        }
        if (encodedMessageInts[messageLength - 1] != decodedMessageInts[messageLength - 2] +
                decodedMessageInts[messageLength - 1]) {
            return "NONE";
        }
        return intArrayToString(decodedMessageInts);
    }

    private int[] stringToIntArray(String str) {
        final int stringLength = str.length();
        final int[] intArray = new int[stringLength];
        for (int i = 0; i < stringLength; i++) {
            intArray[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        return intArray;
    }

    private String intArrayToString(int[] intArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : intArray) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}
