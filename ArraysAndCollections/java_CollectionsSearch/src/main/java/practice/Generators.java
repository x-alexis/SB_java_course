package practice;

public class Generators {
    public static String getRandomInt(int min, int max){
        return getRandomInt(min, max, 2);
    }
    public static String getRandomInt(int min, int max, int len){
        int newInt = (int) ((Math.random() * (max + 1 - min)) + min);
        if(len == 3 || newInt > 99) return String.format("%03d", newInt);
        return String.format("%02d", newInt);
    }
    public static char getRandomChar(){
        String allowedChars = "АВЕКМНОРСТУХ";
        int index = (int)(allowedChars.length() * Math.random());
        return allowedChars.charAt(index);
    }
}
