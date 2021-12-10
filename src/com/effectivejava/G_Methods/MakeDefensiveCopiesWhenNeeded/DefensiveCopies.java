package com.effectivejava.G_Methods.MakeDefensiveCopiesWhenNeeded;

import java.util.Date;

public class DefensiveCopies {
    /**
     * One thing that makes Java a pleasure to use is that it is a safe language. This
     * means that in the absence of native methods it is immune to buffer overruns, array
     * overruns, wild pointers, and other memory corruption errors that plague unsafe
     * languages such as C and C++. In a safe language, it is possible to write classes and
     * to know with certainty that their invariants will hold, no matter what happens in
     * any other part of the system. This is not possible in languages that treat all of
     * memory as one giant array.
     *
     * Even in a safe language, you aren’t insulated from other classes without some
     * effort on your part.
     * You must program defensively, with the assumption that
     * clients of your class will do their best to destroy its invariants.
     *
     * While it is impossible for another class to modify an object’s internal state
     * without some assistance from the object, it is surprisingly easy to provide such
     * assistance without meaning to do so. For example, consider the following class,
     * which purports to represent an immutable time period:
     */

    static final class Period{
        private final Date start;
        private final Date end;
        /**
         * @param start the beginning of the period
         * @param end the end of the period; must not precede start
         * @throws IllegalArgumentException if start is after end
         * @throws NullPointerException if start or end is null
         */
        public Period(Date start, Date end) {
            if (start.compareTo(end) > 0)
                throw new IllegalArgumentException(
                        start + " after " + end);
            this.start = start;
            this.end = end;
        }
        public Date start() {
            return start;
        }

        public Date end() {
            return end;
        }
        /**
         * At first glance, this class may appear to be immutable and to enforce the
         * invariant that the start of a period does not follow its end. It is, however, easy to
         * violate this invariant by exploiting the fact that Date is mutable:
         * // Attack the internals of a Period instance
         *
         */
        public static void main(String[] args) {
            Date start = new Date();
            Date end = new Date();
            Period p = new Period(start, end);
            end.setYear(78); // Modifies internals of p!
            //Sınıf immutable olarak gözükse bile sınıf içerisindeki nesnelere bir şekilde ulaşıp onların
            // state'ini değiştirebiliriz.
            /**
             * As of Java 8, the obvious way to fix this problem is to use Instant (or Local-
             * DateTime or ZonedDateTime) in place of a Date because Instant (and the other
             * java.time classes) are immutable (Item 17). Date is obsolete and should no longer
             * be used in new code.
             * That said, the problem still exists: there are times when
             * you’ll have to use mutable value types in your APIs and internal representations,
             * and the techniques discussed in this item are appropriate for those times.
             */
            /**
             * To protect the internals of a Period instance from this sort of attack, it is
             * essential to make a defensive copy of each mutable parameter to the constructor
             * and to use the copies as components of the Period instance in place of the
             * originals:
             */
            /**
             * // Repaired constructor - makes defensive copies of parameters
             * Period sınıfını constructor'ını düzelttik ve içerisindeki statelere referans geçmek yerine
             * yeni nesneler oluşturup onları referanslarını geçtik.
             *
             * public Period(Date start, Date end) {
             * this.start = new Date(start.getTime());
             * this.end = new Date(end.getTime());
             * if (this.start.compareTo(this.end) > 0)
             * throw new IllegalArgumentException(
             * this.start + " after " + this.end);
             * }
             */
            /**
             * With the new constructor in place, the previous attack will have no effect on
             * the Period instance. Note that defensive copies are made before checking the
             * validity of the parameters (Item 49), and the validity check is performed on
             * the copies rather than on the originals. While this may seem unnatural, it is
             * necessary. It protects the class against changes to the parameters from another
             * thread during the window of vulnerability between the time the parameters are
             * checked and the time they are copied. In the computer security community, this is
             * known as a time-of-check/time-of-use or TOCTOU attack [Viega01].
             */

            /**
             * While the replacement constructor successfully defends against the previous
             *             attack, it is still possible to mutate a Period instance, because its accessors offer
             *             access to its mutable internals:
             */


            // Second attack on the internals of a Period instance
            Date start2 = new Date();
            Date end2 = new Date();
            Period p2 = new Period(start2, end2);
            /// end() ile Date nesnesine erişebiliyoruz ve içeriğini değiştirebiliyoruz.
            p2.end().setYear(78); // Modifies internals of p!

            /**
             * // Repaired accessors - make defensive copies of internal fields
             * public Date start() {
             * return new Date(start.getTime());
             * }
             * public Date end() {
             * return new Date(end.getTime());
             * }
             */

            /**
             * Defensive copying of parameters is not just for immutable classes. Any time
             * you write a method or constructor that stores a reference to a client-provided
             * object in an internal data structure, think about whether the client-provided object
             * is potentially mutable. If it is, think about whether your class could tolerate a
             * change in the object after it was entered into the data structure. If the answer is no,
             * you must defensively copy the object and enter the copy into the data structure in
             * place of the original. For example, if you are considering using a client-provided
             * object reference as an element in an internal Set instance or as a key in an internal
             * Map instance, you should be aware that the invariants of the set or map would be
             * corrupted if the object were modified after it is inserted.
             */

            /**
             * Arguably, the real lesson in all of this is that you should, where possible, use
             * immutable objects as components of your objects so that you that don’t have to
             * worry about defensive copying (Item 17). In the case of our Period example, use
             * Instant (or LocalDateTime or ZonedDateTime), unless you’re using a release
             * prior to Java 8. If you are using an earlier release, one option is to store the
             * primitive long returned by Date.getTime() in place of a Date reference.
             */

            /**
             * There may be a performance penalty associated with defensive copying and it
             * isn’t always justified. If a class trusts its caller not to modify an internal
             * component, perhaps because the class and its client are both part of the same
             * package, then it may be appropriate to dispense with defensive copying. Under
             * these circumstances, the class documentation should make it clear that the caller
             * must not modify the affected parameters or return values.
             */

            /**
             * In summary, if a class has mutable components that it gets from or returns to
             * its clients, the class must defensively copy these components. If the cost of the
             * copy would be prohibitive and the class trusts its clients not to modify the components
             * inappropriately, then the defensive copy may be replaced by documentation
             * outlining the client’s responsibility not to modify the affected components.
             */
        }


    }


}
