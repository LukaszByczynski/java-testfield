package testfield.interview;

class NumberPalindrome {

  static boolean isNumberPalindrome(int value) {

    int number = value;
    int reversed = 0;

    while (number != 0) {
      reversed = reversed * 10 + number % 10;
      number /= 10;
    }

    return reversed == value;
  }

  public static void main(String[] args) {

    System.out.println("123" + isNumberPalindrome(123));
    System.out.println("121" + isNumberPalindrome(121));

  }
}
