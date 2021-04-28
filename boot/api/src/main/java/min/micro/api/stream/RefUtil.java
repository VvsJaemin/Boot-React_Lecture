package min.micro.api.stream;

import io.swagger.models.auth.In;

import java.util.function.*;

public class RefUtil {


    public static Consumer<String> print = System.out::print;
    public static Function<Object, String> string = String::valueOf;
    public static Function<String, Integer> integer = Integer::parseInt;
    public static BiFunction<String, String, Boolean> equals = String :: equals;


    public static Function<Double,Double> abs = Math::abs;
    public static Function<Float, Float> absf = Math::abs;
    public static Function<Integer, Integer> absi = Math::abs;
    public static Function<Long, Long> absl = Math::abs;

    public static Function<Double, Double> ceil = Math::ceil;
    public static Function<Double, Double> floor = Math::floor;

    public static BiFunction<Double, Double, Double> max = Math::max;
    public static BiFunction<Float, Float, Float> maxf = Math::max;
    public static BiFunction<Integer, Integer, Integer> maxi = Math::max;
    public static BiFunction<Long, Long, Long> maxl = Math::max;

    public static BiFunction<Double, Double, Double> mind = Math::min;
    public static BiFunction<Float, Float, Float> minf = Math::min;
    public static BiFunction<Integer, Integer, Integer> mini = Math::min;
    public static BiFunction<Long, Long, Long> minl = Math::min;

    public static Supplier<Double> random = Math::random;
    public static BiFunction<Integer,Integer,Integer> rangeUnderRandom = (t,u)->(int)(Math.random()*(u-t))+t;
    public static BiFunction<Integer,Integer,Integer> rangeBelowRandom = (t,u)->(int)(Math.random()*(u-t))+t;


    public static Function<Double, Double> rint = Math::rint;

    public static Function<Double, Long> round = Math::round;

    //-----------------------------------------------------------------------------

    public static Function<Integer, Integer> intvalue = Integer::intValue;
    public static Function<String, Integer> parseint = Integer::parseInt;
    public static Function<String, Integer> valueof = Integer::valueOf;



}
