package com.effectivejava.J_Concurrency.UseLazyInitializationJudiciously;

public class LazyInitialization {
    /**
     * If you need to use lazy initialization for performance on an instance field,
     * use the double-check idiom. This idiom avoids the cost of locking when
     * accessing the field after initialization (Item 79). The idea behind the idiom is to
     * check the value of the field twice (hence the name double-check): once without
     * locking and then, if the field appears to be uninitialized, a second time with
     * locking. Only if the second check indicates that the field is uninitialized does the
     * call initialize the field. Because there is no locking once the field is initialized, it is
     * critical that the field be declared volatile (Item 78). Here is the idiom:
     */

    private volatile FieldType field;

    private FieldType getField(){
        FieldType result=field;
        if(result==null){
            synchronized (this){
                if(field==null){
                    result=new FieldType();
                }
            }
        }
        return result;
    }

    /**
     * In summary, you should initialize most fields normally, not lazily. If you must
     * initialize a field lazily in order to achieve your performance goals or to break a
     * harmful initialization circularity, then use the appropriate lazy initialization
     * technique. For instance fields, it is the double-check idiom; for static fields, the
     * lazy initialization holder class idiom. For instance fields that can tolerate repeated
     * initialization, you may also consider the single-check idiom.
     */

    private static class FieldHolder2 {
        static final FieldType2 field = computeFieldValue();

        private static FieldType2 computeFieldValue() {
            return new FieldType2();
        }
    }
    private static FieldType2 getField2() {
        return FieldHolder2.field;
    }
}
