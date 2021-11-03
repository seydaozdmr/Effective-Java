package com.effectivejava.D_Generics.PreferListToArrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PreferGenerics {

    class Choser{
        private final Object[] array;

        public Choser(Collection someData) {
            this.array = someData.toArray();
        }

        public Object choose(){
            Random rnd= ThreadLocalRandom.current();
            return array[rnd.nextInt(array.length)];
        }
    }


    class GenericChoose<T> {
        private final T[] choiceArray;
        /**
         * The compiler is telling you that it can’t vouch for the safety of the cast at runtime
         * because the program won’t know what type T represents—remember, element
         * type information is erased from generics at runtime.
         */
        public GenericChoose(Collection<T> choices) {
            choiceArray = (T[]) choices.toArray();
        }

        // choose method unchanged
    }

    //better solution is using List<> instead array
    public class ChooserList<T> {
        /**
         * This version is a tad more verbose, and perhaps a tad slower, but it’s worth it for
         * the peace of mind that you won’t get a ClassCastException at runtime.
         */
        private final List<T> choiceList;
        public ChooserList(Collection<T> choices) {
            choiceList = new ArrayList<>(choices);
        }
        public T choose() {
            Random rnd = ThreadLocalRandom.current();
            return choiceList.get(rnd.nextInt(choiceList.size()));
        }
    }
}
