package com.effectivejava.H_GeneralProgramming.PreferForEachLoopsToTraditionalForLoops;



import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Element> myList = List.of(new Element("e1"),new Element("e2"),new Element("e3"));

        /**
         * Here is a traditional for loop to iterate over a collection:
         */
        for(Iterator<Element> iterator=myList.iterator();iterator.hasNext();){
            System.out.println(iterator.next().getDescription());
        }
        /**
         * and here is a traditional for loop to iterate over an array:
         */
        // Not the best way to iterate over an array!
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }

        /**
         * These idioms are better than while loops (Item 57), but they aren’t perfect. The
         * iterator and the index variables are both just clutter—all you need are the elements.
         * Furthermore, they represent opportunities for error. The iterator occurs three times
         * in each loop and the index variable four, which gives you many chances to use the
         * wrong variable. If you do, there is no guarantee that the compiler will catch the
         * problem. Finally, the two loops are quite different, drawing unnecessary attention
         * to the type of the container and adding a (minor) hassle to changing that type.
         * The for-each loop (officially known as the “enhanced for statement”) solves
         * all of these problems. It gets rid of the clutter and the opportunity for error by hiding
         * the iterator or index variable. The resulting idiom applies equally to collections
         * and arrays, easing the process of switching the implementation type of a
         * container from one to the other:
         */
        for(Element e:myList){
            /**
             * When you see the colon (:), read it as “in.” Thus, the loop above reads as “for
             * each element e in elements.” There is no performance penalty for using for-each
             * loops, even for arrays: the code they generate is essentially identical to the code
             * you would write by hand.
             */
            System.out.println(e.getDescription());
        }

        /**
         * The advantages of the for-each loop over the traditional for loop are even
         * greater when it comes to nested iteration. Here is a common mistake that people
         * make when doing nested iteration:
         */

        List<Card> deck = new ArrayList<>();

        for (Suit suit : suits)
            for (Rank rank : ranks)
                deck.add(new Card(suit, rank));


        /**
         * Unfortunately, there are three common situations where you can’t use for-each:
         * • Destructive filtering—If you need to traverse a collection removing selected
         * elements, then you need to use an explicit iterator so that you can call its
         * remove method. You can often avoid explicit traversal by using Collection’s
         * removeIf method, added in Java 8.
         * • Transforming—If you need to traverse a list or array and replace some or all
         * of the values of its elements, then you need the list iterator or array index in
         * order to replace the value of an element.
         * • Parallel iteration—If you need to traverse multiple collections in parallel,
         * then you need explicit control over the iterator or index variable so that all iterators
         * or index variables can be advanced in lockstep (as demonstrated unintentionally
         * in the buggy card and dice examples above).
         */
    }


    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());
}
class Element{
    private String description;

    public Element(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
enum Suit { CLUB, DIAMOND, HEART, SPADE }
enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
    NINE, TEN, JACK, QUEEN, KING }

class Card{
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
}
