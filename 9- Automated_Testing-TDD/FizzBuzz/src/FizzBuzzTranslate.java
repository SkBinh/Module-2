public class FizzBuzzTranslate {
    public static String Translate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;

        if (isBuzz && isFizz) {
            return "FizzBuzz";
        } else if (isFizz) {
            return "Fizz";
        } else if (isBuzz) {
            return "Buzz";
        } else {
            return numberToWord(number);
        }
    }
    private static String numberToWord(int number) {
        if (number >= 100) {
            throw new IllegalArgumentException("Number must be less than 100");
        }

        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        if (number < 10) {
            return words[number];
        }

        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        if (number < 20) {
            return teens[number - 10];
        }

        String[] tens = {"", "","twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        int tensDigit = number / 10;
        int onesDigit = number % 10;

        return onesDigit == 0 ? tens[tensDigit] : tens[tensDigit] + " " + words[onesDigit];
    }
}
