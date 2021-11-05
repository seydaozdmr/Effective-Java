package com.effectivejava.E_EnumsAndAnnotations.UseEnumsInsteadOfIntConstants;

public enum PayRollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayRollDay() {
        this(PayType.WEEKDAY);
    }

    PayRollDay(PayType payType){
        this.payType=payType;
    }

    int pay(int minutesWorked, int payRate){
        return payType.pay(minutesWorked,payRate);
    }

    private enum PayType {
        WEEKDAY {
            int overTimePay (int minutesWorked,int payRate){
                return minutesWorked<=MINUTES_PER_SHIFT ? 0 : (minutesWorked-MINUTES_PER_SHIFT) * payRate /2;
            }
        },

        WEEKEND{
            int overTimePay(int minutesWorked,int payRate){
                return minutesWorked * payRate /2;
            }
        };


        abstract int overTimePay(int minutesWorked, int payRate);
        private static final int MINUTES_PER_SHIFT= 8*60;

        int pay(int minutesWorked, int payRate){
            int basePay=minutesWorked * payRate;
            return basePay + overTimePay(minutesWorked,payRate);
        }
    }
}
