package com.effectivejava.F_LambdasAndStreams.UseCautionWhenMakingStreamsParallel;

import java.math.BigInteger;
import java.util.SplittableRandom;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class App {
    public static void main(String[] args) {



        //Consider this program from Item 45:
// Stream-based program to generate the first 20 Mersenne primes
//         primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
//                    .filter(mersenne -> mersenne.isProbablePrime(50))
//                    .limit(20)
//                    .forEach(System.out::println);


        /**
         * On my machine, this program immediately starts printing primes and takes
         * 12.5 seconds to run to completion. Suppose I naively try to speed it up by adding a
         * call to parallel() to the stream pipeline. What do you think will happen to its
         * performance? Will it get a few percent faster? A few percent slower? Sadly, what
         * happens is that it doesn’t print anything, but CPU usage spikes to 90 percent and
         * stays there indefinitely (a liveness failure). The program might terminate eventually,
         * but I was unwilling to find out; I stopped it forcibly after half an hour.
         */

        /**
         * What’s going on here? Simply put, the streams library has no idea how to parallelize
         * this pipeline and the heuristics fail. Even under the best of circumstances,
         * parallelizing a pipeline is unlikely to increase its performance if the source is
         * from Stream.iterate, or the intermediate operation limit is used.
         */

//        primes().parallel().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
//                .filter(mersenne -> mersenne.isProbablePrime(50))
//                .limit(20)
//                .forEach(System.out::println);
        /**
         * Thus, the cost of computing a single extra element is roughly equal to
         * the cost of computing all previous elements combined, and this innocuous-looking
         * pipeline brings the automatic parallelization algorithm to its knees. The moral of
         * this story is simple: Do not parallelize stream pipelines indiscriminately. The
         * performance consequences may be disastrous.
         */

        /**
         * The nature of a stream pipeline’s terminal operation also affects the effectiveness
         * of parallel execution. If a significant amount of work is done in the terminal
         * operation compared to the overall work of the pipeline and that operation is inherently
         * sequential, then parallelizing the pipeline will have limited effectiveness.
         * The best terminal operations for parallelism are reductions, where all of the
         * elements emerging from the pipeline are combined using one of Stream’s reduce
         * methods, or prepackaged reductions such as min, max, count, and sum. The shortcircuiting
         * operations anyMatch, allMatch, and noneMatch are also amenable to
         * parallelism. The operations performed by Stream’s collect method, which are
         * known as mutable reductions, are not good candidates for parallelism because the
         * overhead of combining collections is costly.
         */

        /**
         * Not only can parallelizing a stream lead to poor performance, including
         * liveness failures; it can lead to incorrect results and unpredictable behavior
         * (safety failures).
         */


        /**
         * If you are going to parallelize a stream of random numbers, start with a
         * SplittableRandom instance rather than a ThreadLocalRandom (or the essentially
         * obsolete Random). SplittableRandom is designed for precisely this use, and has
         * the potential for linear speedup. ThreadLocalRandom is designed for use by a
         * single thread, and will adapt itself to function as a parallel stream source, but
         * won’t be as fast as SplittableRandom. Random synchronizes on every operation,
         * so it will result in excessive, parallelism-killing contention.
         */


        SplittableRandom myRandom = new SplittableRandom();
        long count= LongStream.rangeClosed(2, myRandom.nextLong(1000))
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i->i.isProbablePrime(150))
                .count();
        System.out.println(count);

        /**
         * SUMMARY:
         * In summary, do not even attempt to parallelize a stream pipeline unless you
         * have good reason to believe that it will preserve the correctness of the computation
         * and increase its speed. The cost of inappropriately parallelizing a stream can be a
         * program failure or performance disaster. If you believe that parallelism may be
         * justified, ensure that your code remains correct when run in parallel, and do careful
         * performance measurements under realistic conditions. If your code remains correct
         * and these experiments bear out your suspicion of increased performance, then and
         * only then parallelize the stream in production code.
         */
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    /**
     *  As a simple example of a stream pipeline where parallelism is effective, consider
     * this function for computing π(n), the number of primes less than or equal to n:
     */

    // Prime-counting stream pipeline - benefits from parallelization
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    /**
     * On my machine, it takes 31 seconds to compute π(108) using this function. Simply
     * adding a parallel() call reduces the time to 9.2 seconds:
     * // Prime-counting stream pipeline - parallel version
     */
    static long piWithParallel(long n) {
     return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
     }
}
