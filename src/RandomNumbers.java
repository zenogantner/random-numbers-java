import org.apache.commons.math.random.MersenneTwister;
import org.apache.commons.math.random.RandomGenerator;
import org.apache.mahout.math.jet.random.engine.RandomEngine;
import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.XORShiftRNG;

import java.security.SecureRandom;

/**
 */
public class RandomNumbers {
    static final int N = 1000000;

    // TODO also compare http://maths.uncommons.org/api/org/uncommons/maths/random/GaussianGenerator.html

    public static void main(String[] args) throws NoSuchMethodException {
        System.out.printf("%d * n calls, where n is the number in parentheses\n\n", N);

        measureNextInt(new java.util.Random(), "java.util.Random", 100);
        measureNextInt(new SecureRandom(), "SecureRandom", 1);
        measureNextInt(new MersenneTwisterRNG(), "MersenneTwisterRNG", 100);
        measureNextInt(new XORShiftRNG(), "XORShiftRNG", 100);
        measureNextInt(new MersenneTwister(), "MersenneTwister", 100);
        measureNextInt(new MersenneTwisterFast(), "MersenneTwisterFast", 100);
        measureNextInt(new org.apache.commons.math.random.MersenneTwister(), "org.apache.commons.math.random.MersenneTwister", 100);
        measureNextInt(new org.apache.mahout.math.jet.random.engine.MersenneTwister(), "org.apache.mahout.math.jet.random.engine.MersenneTwister", 100);
        System.out.println();

        measureNextLong(new java.util.Random(), "java.util.Random", 100);
        measureNextLong(new SecureRandom(), "SecureRandom", 1);
        measureNextLong(new MersenneTwisterRNG(), "MersenneTwisterRNG", 100);
        measureNextLong(new XORShiftRNG(), "XORShiftRNG", 100);
        measureNextLong(new MersenneTwister(), "MersenneTwister", 100);
        measureNextLong(new MersenneTwisterFast(), "MersenneTwisterFast", 100);
        measureNextLong(new org.apache.commons.math.random.MersenneTwister(), "org.apache.commons.math.random.MersenneTwister", 100);
        measureNextLong(new org.apache.mahout.math.jet.random.engine.MersenneTwister(), "org.apache.mahout.math.jet.random.engine.MersenneTwister", 100);
        System.out.println();

        measureNextDouble(new java.util.Random(), "java.util.Random", 100);
        measureNextDouble(new SecureRandom(), "SecureRandom", 1);
        measureNextDouble(new MersenneTwisterRNG(), "MersenneTwisterRNG", 100);
        measureNextDouble(new XORShiftRNG(), "XORShiftRNG", 100);
        measureNextDouble(new MersenneTwister(), "MersenneTwister", 100);
        measureNextDouble(new MersenneTwisterFast(), "MersenneTwisterFast", 100);
        measureNextDouble(new org.apache.commons.math.random.MersenneTwister(), "org.apache.commons.math.random.MersenneTwister", 100);
        measureNextDouble(new org.apache.mahout.math.jet.random.engine.MersenneTwister(), "org.apache.mahout.math.jet.random.engine.MersenneTwister", 100);
        System.out.println();

        measureNextGaussian(new java.util.Random(), "java.util.Random", 100);
        measureNextGaussian(new SecureRandom(), "SecureRandom", 1);
        measureNextGaussian(new MersenneTwisterRNG(), "MersenneTwisterRNG", 100);
        measureNextGaussian(new XORShiftRNG(), "XORShiftRNG", 100);
        measureNextGaussian(new MersenneTwister(), "MersenneTwister", 100);
        measureNextGaussian(new MersenneTwisterFast(), "MersenneTwisterFast", 100);
        measureNextGaussian(new org.apache.commons.math.random.MersenneTwister(), "org.apache.commons.math.random.MersenneTwister", 100);
        System.out.println();
    }

    static void measureNextLong(java.util.Random rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextLong();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextLong() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextDouble(java.util.Random rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextDouble();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextDouble() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextGaussian(java.util.Random rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextGaussian();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextGaussian() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextInt(java.util.Random rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextInt();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextInt() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextLong(MersenneTwisterFast rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextLong();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextLong() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextDouble(MersenneTwisterFast rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextDouble();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextDouble() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextGaussian(MersenneTwisterFast rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextGaussian();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextGaussian() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextInt(MersenneTwisterFast rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextInt();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextInt() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextLong(RandomGenerator rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextLong();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextLong() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextDouble(RandomGenerator rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextDouble();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextDouble() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextGaussian(RandomGenerator rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextGaussian();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextGaussian() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextInt(RandomGenerator rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextInt();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextInt() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextLong(RandomEngine rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextLong();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextLong() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextDouble(RandomEngine rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextDouble();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextDouble() (%d) %d ms\n", name, n, (endTime - startTime));
    }

    static void measureNextInt(RandomEngine rng, String name, int n) throws NoSuchMethodException {
        long end = N * n;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < end; i++)
            rng.nextInt();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s.nextInt() (%d) %d ms\n", name, n, (endTime - startTime));
    }

}
