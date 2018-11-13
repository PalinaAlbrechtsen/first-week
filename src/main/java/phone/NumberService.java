package phone;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class NumberService {

    public String getStringNumberWithRegex(List<Integer> nums) {
        String number = getStringFromListOfDigits(nums);
        String format = "($1)$2";
        number = number.replaceFirst("(\\d{3})(\\d{7})", format);

        return number;
    }

    public String getStringNumber(List<Integer> nums) {
        String number = getStringFromListOfDigits(nums);

        return new StringBuilder(number)
                .insert(0, "(")
                .insert(4, ")")
                .toString();
    }

    public String getStringNumberThirdVariant(List<Integer> nums) {
        String number = getStringFromListOfDigits(nums);
        String format = "(%s)%s";
        String formattedNumber = null;
        Pattern pattern = Pattern.compile("(?<first>\\d{3})(?<second>\\d{7})");
        Matcher matcher = pattern.matcher(number);

        while (matcher.find()) {
            String first = matcher.group("first");
            String second = matcher.group("second");
            formattedNumber = String.format(format, first, second);
        }

        return formattedNumber;
    }

    private String getStringFromListOfDigits(List<Integer> nums) {
        return nums.stream()
                .map(Objects::toString)
                .collect(Collectors.joining());
    }
}