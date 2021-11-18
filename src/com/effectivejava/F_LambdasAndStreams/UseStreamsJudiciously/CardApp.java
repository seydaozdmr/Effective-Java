package com.effectivejava.F_LambdasAndStreams.UseStreamsJudiciously;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CardApp {
    /**
     * There are plenty of tasks where it is not obvious whether to use streams or
     * iteration. For example, consider the task of initializing a new deck of cards.
     * Assume that Card is an immutable value class that encapsulates a Rank and a
     * Suit, both of which are enum types. This task is representative of any task that
     * requires computing all the pairs of elements that can be chosen from two sets.
     * Mathematicians call this the Cartesian product of the two sets. Here’s an iterative
     * implementation with a nested for-each loop that should look very familiar to you:
     */
    public static void main(String[] args) {
        List<Card> deste=new ArrayList<>();

        for(Suit s:Suit.values()){
            for(Rank d: Rank.values()){
                deste.add(new Card(d,s));
            }
        }

        for(Card card:deste){
            System.out.println(card);
        }

        /**
         * And here is a stream-based implementation that makes use of the intermediate
         * operation flatMap. This operation maps each element in a stream to a stream and
         * then concatenates all of these new streams into a single stream (or flattens t
         */


    }

    private static List<Card> newDeck() {
        return Stream.of(Suit.values())
                .flatMap(suit ->
                        Stream.of(Rank.values())
                                .map(rank -> new Card(rank, suit)))
                .collect(toList());
    }
}
