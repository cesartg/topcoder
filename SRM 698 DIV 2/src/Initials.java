public class Initials {
    public String getInitials(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String t : name.split("\\s+")) {
            stringBuilder.append(t.charAt(0));
        }
        return stringBuilder.toString();
    }
}
