public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    int sum = 0;
    int beginIndx = 0;
    int spaceIndx;
    int lenStr = text.length();

    while (beginIndx <= lenStr){
      spaceIndx = text.indexOf(" ", beginIndx);
      if (spaceIndx < 0){spaceIndx = lenStr;}
      String str = text.substring(beginIndx, spaceIndx).trim();
      try {
        sum += Integer.parseInt(str);
      } catch (NumberFormatException e) {
      }
      beginIndx = spaceIndx + 1;
    }
    System.out.println(sum);
  }

}