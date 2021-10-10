package com.effectivejava.C_ClassesAndInterfaces.InPublicClassesUseAccessorMethods;

public class Time {
    /**
     * Sınıflarımızı yaratırken alanları değişmez olarak tasarlamak en iyi çözümdür, bu davranış
     * thread safe bir yapı kurmanıza yardımcı olur.
     */

    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    private final int hour;
    private final int minute;

    /**
     * In summary, public classes should never expose mutable fields. It is less
     * harmful, though still questionable, for public classes to expose immutable fields.
     * It is, however, sometimes desirable for package-private or private nested classes to
     * expose fields, whether mutable or immutable.
     */
    public Time(int hour, int minute) {
        if(hour<0 || hour>HOURS_PER_DAY){
            throw new IllegalArgumentException("hour : "+hour);
        }
        if(minute<0 ||minute>MINUTES_PER_HOUR){
            throw new IllegalArgumentException("Min : "+minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
}
