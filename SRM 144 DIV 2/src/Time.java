public class Time {
    public String whatTime(int seconds) {
        int hours = seconds / 3600;
        seconds -= hours * 3600;
        int minutes = seconds / 60;
        seconds -= minutes * 60;
        return String.format("%d:%d:%d", hours, minutes, seconds);
    }
}
