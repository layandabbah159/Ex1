package assignments.ex1;
public class Ex1 {

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     *            /@return
     */
    public static int number2Int(String num) {
        if (!isNumber(num)) {
            return -1;
        }

        int bIndex = num.indexOf('b');
        String numberPart = num.substring(0, bIndex);
        String basePart = num.substring(bIndex + 1);

        int base = 0;
        try {
            base = Integer.parseInt(basePart, 16);
        } catch (NumberFormatException e) {
            return -1;
        }

        if (base < 2 || base > 16) {
            return -1;
        }

        try {
            return Integer.parseInt(numberPart, base);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) {
            return false;
        }

        int bIndex = a.indexOf('b');
        if (bIndex == -1) {
            return false;
        }

        String numberPart = a.substring(0, bIndex);
        String basePart = a.substring(bIndex + 1);

        if (numberPart.isEmpty() || basePart.isEmpty()) {
            return false;
        }


        try {
            int base = Integer.parseInt(basePart, 16);
            if (base < 2 || base > 16) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }


        try {
            Integer.parseInt(numberPart, Integer.parseInt(basePart, 16));
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return "";
        }

        if (num == 0) {
            return "0bA";
        }

        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int remainder = num % base;
            if (remainder < 10) {
                result.append((char) ('0' + remainder));
            } else {
                result.append((char) ('A' + (remainder - 10)));
            }
            num /= base;
        }
        result.append("b").append(Integer.toHexString(base).toUpperCase());
        return result.reverse().toString();
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        return number2Int(n1) == number2Int(n2);
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int maxIndex = 0;
        int maxValue = number2Int(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
