package clerk.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Money {

    TWENTY_FIVE(25),
    FIFTY(50),
    ONE_HUNDREAD(100);

    private static final int SIZE = values().length;
    private Integer amount;

//    public static Integer getAmount() {
//        return values()[new Random().nextInt(SIZE)].amount;
//    }


    public Integer getAmount() {
        return amount;
    }
}
