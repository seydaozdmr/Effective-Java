package com.effectivejava.I_Exceptions.AvoidUnnecessaryUseOfCheckedExceptions;

public class App {
    /**
     * If a method throws checked exceptions,
     * the code that invokes it must handle them in one or more catch  blocks,
     * or declare that it throws them and let them propagate outward.
     *
     * Bir method bir checked exception fırlatıyorsa o methodu çağıran kodun
     * bu istisnayı catch bloğu içinde yakalaması ya da dışa doğru yayılmasını
     * sağlamalıdır.
     *
     * Either way, it
     * places a burden on the user of the API. The burden increased in Java 8, as methods
     * throwing checked exceptions can’t be used directly in streams (Items 45–48).
     */
    /**
     * In summary, when used sparingly, checked exceptions can increase the
     * reliability of programs; when overused, they make APIs painful to use. If callers
     * won’t be able to recover from failures, throw unchecked exceptions. If recovery
     * may be possible and you want to force callers to handle exceptional conditions,
     * first consider returning an optional. Only if this would provide insufficient
     * information in the case of failure should you throw a checked exception.
     */
}
