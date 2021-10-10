package com.effectivejava.C_ClassesAndInterfaces.FavorStaticMemberClassesOverNonStatic;

public class Cabinet {
    private int shelf;

    public  static class egg {
        private int totalNumberOfEgg;
        private int whichShelf;

        public egg(int totalNumberOfEgg) {
            this.totalNumberOfEgg = totalNumberOfEgg;

        }
    }

    public class cheese {
        /**
         * If an instance of a nested class can exist in isolation from an instance of its enclosing class,
         * then the nested class must be a static member class: it is impossible to create an instance of a
         * nonstatic member class without an enclosing instance.
         */
    }
}
