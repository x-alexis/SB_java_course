public class Main {

  public static void main(String[] args) {

  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    String tmp = text.replaceAll("[А-я]|[A-z]|\\s|-", "");
    int sum = 0;
    if (tmp.length() > 0){
      String[] m = tmp.split(",");
      for (int i = 0; i < m.length; i++){
        sum += Integer.parseInt(m[i]);
      }
    }
    return sum;
  }

}