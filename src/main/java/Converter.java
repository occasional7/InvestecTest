public class Converter {

    private static final String[] englishWords = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static final int billion = 1000000000;
    private static final int million = 1000000;
    private static final int thousand = 1000;
    private static final int hundred = 100;
    private static final int twenty = 20;
    private static final int ten = 10;

    public static String convert(long number) {
        if (number > 0)
            return convertRecursively(number);
        else
            return "zero";
    }

    private static String convertRecursively(long number) {
        StringBuilder sb = new StringBuilder();

        if (number >= billion) {
            sb.append(convertRecursively(number / billion))
                    .append(" billion, ")
                    .append(convertRecursively(number % billion));
        } else if (number >= million) {
            sb.append(convertRecursively(number / million))
                    .append(" million, ")
                    .append(convertRecursively(number % million));
        } else if (number >= thousand) {
            sb.append(convertRecursively(number / thousand))
                    .append(" thousand")
                    .append(number % thousand > 99 ? ", " : " and ")
                    .append(convertRecursively(number % thousand));
        } else if (number >= hundred) {
            sb.append(convertRecursively(number / hundred))
                    .append(" hundred")
                    .append(number % hundred > 0 ? " and " : "")
                    .append(convertRecursively(number % hundred));
        } else if (number >= twenty) {
            long reminder = number % ten;
            sb.append(englishWords[(int) ((number - twenty) / ten + twenty)]);
            if (reminder > 0) {
                sb.append("-").append(englishWords[(int) reminder]);
            }
        } else {
            sb.append(englishWords[(int) number]);
        }

        return sb.toString().trim();
    }
}
