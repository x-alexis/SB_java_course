public class Main {

  public static void main(String[] args) {
  }

  public static String splitTextIntoWords(String text) {
    //TODO реализуйте метод
    return text.replaceAll("[^A-z|\\s|\\-|’]", "").replaceAll("\\s+|-", "\n");
  }

}