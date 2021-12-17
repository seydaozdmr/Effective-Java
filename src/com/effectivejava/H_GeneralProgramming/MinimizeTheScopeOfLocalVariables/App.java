package com.effectivejava.H_GeneralProgramming.MinimizeTheScopeOfLocalVariables;

public class App {
    /**
     * The most powerful technique for minimizing the scope of a local variable
     * is to declare it where it is first used.
     * Local değişkenleri kullanacağımız ilk yerde tanımlıyoruz, böylece kodların bakımını yaparken
     * değişkeni baştan aramak ve ilk değerini bulmaya çalışmakta zorlanırız.
     */

    /**
     * Declaring a local variable prematurely can cause its scope not only to begin
     * too early but also to end too late. The scope of a local variable extends from the
     * point where it is declared to the end of the enclosing block. If a variable is
     * declared outside of the block in which it is used, it remains visible after the
     * program exits that block. If a variable is used accidentally before or after its region
     * of intended use, the consequences can be disastrous.
     */

    /**
     * Loops present a special opportunity to minimize the scope of variables. The
     * for loop, in both its traditional and for-each forms, allows you to declare loop
     * variables, limiting their scope to the exact region where they’re needed. (This
     * region consists of the body of the loop and the code in parentheses between the
     * for keyword and the body.) Therefore, prefer for loops to while loops, assuming
     * the contents of the loop variable aren’t needed after the loop terminates.
     */


    /**The for loop has one more advantage over the while loop: it is shorter, which
    enhances readability.
    Here is another loop idiom that minimizes the scope of local variables:
            for (int i = 0, n = expensiveComputation(); i < n; i++) {
    // Do something with i;
    }
     */
    /**
    The important thing to notice about this idiom is that it has two loop variables, i
    and n, both of which have exactly the right scope. The second variable, n, is used
    to store the limit of the first, thus avoiding the cost of a redundant computation in
    every iteration. As a rule, you should use this idiom if the loop test involves a
    method invocation that is guaranteed to return the same result on each iteration.
    A final technique to minimize the scope of local variables is to keep methods
    small and focused. If you combine two activities in the same method, local
    variables relevant to one activity may be in the scope of the code performing the
    other activity. To prevent this from happening, simply separate the method into
    two: one for each activity.
     */
}
