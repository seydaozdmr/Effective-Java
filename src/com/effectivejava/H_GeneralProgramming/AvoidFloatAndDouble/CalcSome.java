package com.effectivejava.H_GeneralProgramming.AvoidFloatAndDouble;

import java.math.BigDecimal;

public class CalcSome {
    /**
     * The float and double types are designed primarily for scientific and engineering
     * calculations. They perform binary floating-point arithmetic, which was carefully
     * designed to furnish accurate approximations quickly over a broad range of
     * magnitudes. They do not, however, provide exact results and should not be used
     * where exact results are required.
     */

    /**
     * The float and double types are particularly
     * ill-suited for monetary calculations because it is impossible to represent 0.1 (or
     * any other negative power of ten) as a float or double exactly.
     */

    /**
     * For example, suppose you have $1.03 in your pocket, and you spend 42¢.
     * How much money do you have left? Here’s a naive program fragment that
     * attempts to answer this question:
     */

    public static void main(String[] args) {
        System.out.println(1.03-0.42);
        /**
         * sonuç olarak 61 cent kalması gerekiyor ama ekranda 0.61000000001 sonucunu görüyoruz.
         */

        /**
         * This is not an isolated case.
         * Suppose you have a dollar in your pocket, and you buy nine washers priced at ten
         * cents each. How much change do you get?
         */
        System.out.println(1.00 - (9*0.10));
        /**
         * Bu işlemin sonucunda 10 cent kalması gerekiyor. Fakat sonuc : 0.09999999999999998
         * You might think that the problem could be solved merely by rounding results
         * prior to printing, but unfortunately this does not always work.
         */

        /**
         * For example,
         * suppose you have a dollar in your pocket, and you see a shelf with a row of
         * delicious candies priced at 10¢, 20¢, 30¢, and so forth, up to a dollar. You buy one
         * of each candy, starting with the one that costs 10¢, until you can’t afford to buy the
         * next candy on the shelf. How many candies do you buy, and how much change do
         * you get? Here’s a naive program designed to solve this problem:
         */

        double funds=1.00;
        int itemsBought=0;
        for(double price=0.10;funds>=price;price+=0.10){
            funds-=price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);
        /**
         * If you run the program, you’ll find that you can afford three pieces of candy, and
         * you have $0.3999999999999999 left. This is the wrong answer! The right way to
         * solve this problem is to use BigDecimal, int, or long for monetary calculations.
         * Sonuç olarak parasal işlemlerde BigDecimal, int ya da long kullanmalıyız.
         */

        /**
         * Here’s a straightforward transformation of the previous program to use the
         * BigDecimal type in place of double. Note that BigDecimal’s String constructor
         * is used rather than its double constructor. This is required in order to avoid introducing
         * inaccurate values into the computation [Bloch05, Puzzle 2]:
         */

        final BigDecimal TWENTY_CENTS=new BigDecimal("0.20");
        int itemsBought2=0;

        BigDecimal funds2=new BigDecimal("2.00");
        for(BigDecimal price = TWENTY_CENTS;funds2.compareTo(price)>=0 ; price=price.add(TWENTY_CENTS)){
            funds2 = funds2.subtract(price);
            itemsBought2++;
        }
        System.out.println(itemsBought2 + " items bought.");
        System.out.println("Money left over: $" + funds2);

        /**
         * Bununla birlikte, BigDecimal kullanmanın iki dezavantajı vardır:
         * İlkel bir aritmetik türü kullanmaktan çok daha az uygundur ve çok daha yavaştır.
         * Tek bir kısa problemi çözüyorsanız,
         * ikinci dezavantaj önemsizdir, ancak birincisi sizi rahatsız edebilir.
         */

        /**
         * An alternative to using BigDecimal is to use int or long, depending on the
         * amounts involved, and to keep track of the decimal point yourself. In this
         * example, the obvious approach is to do all computation in cents instead of dollars.
         * Here’s a straightforward transformation that takes this approach:
         */
        int itemsBought3 = 0;
        int funds3 = 100;
        for (int price = 10; funds3 >= price; price += 10) {
            funds3 -= price;
            itemsBought3++;
        }
        System.out.println(itemsBought3 + " items bought.");
        System.out.println("Cash left over: " + funds3 + " cents");

        /**
         * In summary, don’t use float or double for any calculations that require an
         * exact answer. Use BigDecimal if you want the system to keep track of the decimal
         * point and you don’t mind the inconvenience and cost of not using a primitive type.
         * Using BigDecimal has the added advantage that it gives you full control over
         * rounding, letting you select from eight rounding modes whenever an operation
         * that entails rounding is performed. This comes in handy if you’re performing
         * business calculations with legally mandated rounding behavior. If performance is
         * of the essence, you don’t mind keeping track of the decimal point yourself, and
         * the quantities aren’t too big, use int or long. If the quantities don’t exceed nine
         * decimal digits, you can use int; if they don’t exceed eighteen digits, you can use
         * long. If the quantities might exceed eighteen digits, use BigDecimal.
         */
    }
}
