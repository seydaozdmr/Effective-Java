package com.effectivejava.I_Exceptions.UseCheckedExceptionsForRecoverableConditions;

import java.util.concurrent.Executors;

public class App {
    /**
     * The cardinal rule in deciding whether to use a checked or an unchecked
     * exception is this: use checked exceptions for conditions from which the caller
     * can reasonably be expected to recover.
     */
    /**
     * Each checked exception that a method is declared to throw is therefore a
     * potent indication to the API user that the associated condition is a possible
     * outcome of invoking the method.
     */

    /**
     * Use runtime exceptions to indicate programming errors. The great majority
     * of runtime exceptions indicate precondition violations. A precondition violation
     * is simply a failure by the client of an API to adhere to the contract established
     * by the API specification. For example, the contract for array access specifies that
     * the array index must be between zero and the array length minus one, inclusive.
     * ArrayIndexOutOfBoundsException indicates that this precondition was violated.
     */

    /**
     * To summarize, throw checked exceptions for recoverable conditions and
     * unchecked exceptions for programming errors. When in doubt, throw unchecked
     * exceptions. Don’t define any throwables that are neither checked exceptions nor
     * runtime exceptions. Provide methods on your checked exceptions to aid in
     * recovery.
     */
    /**
     * Tanımladığım bu istisna sınıfı eğer bu durum düzeltilmesi gereken bir durumsa
     * ortaya çıkacaktır ve böyle bir durumda kullanılmalıdır.
     */
    static class WrongCalculatedTax extends Exception{
        public WrongCalculatedTax(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        int amount=-100;
        try{
            System.out.println(calculateBill(amount));
        }catch (WrongCalculatedTax e){
            System.out.println(e.getMessage());
        }



    }

    static double calculateBill(int amount) throws WrongCalculatedTax {
        double result=amount+amount*0.18;
        if(result<amount)
            throw new WrongCalculatedTax("vergi hesabı yanlış hesaplanmıştır "+result);
        return result;
    }
}
