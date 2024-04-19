package main.java.Lab2.Util;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;

public class Calculator {

    private static final Covariance COVARIANCE = new Covariance();
    private static final double Z_VALUE = 1.65; // Z-value for 90% confidence interval

    //1
    public static double getGeometricMean(double[] data) {
        return StatUtils.geometricMean(data);
    }

    //2
    public static double getArithmeticMean(double[] data) {
        return StatUtils.mean(data);
    }

    //3
    public static double getStandardDeviation(double[] data) {
        return Math.sqrt(StatUtils.variance(data));
    }

    //4
    public static double getRange(double[] data) {
        return StatUtils.max(data) - StatUtils.min(data);
    }

    //5
    public static double getCovariance(double[] data1, double[] data2) {
        return COVARIANCE.covariance(data1, data2);
    }

    //6
    public static int getSampleSize(double[] data) {
        return data.length;
    }

    //7
    public static double getCoefficientOfVariation(double[] data) {
        return (getStandardDeviation(data) / getArithmeticMean(data));
    }

    //8.1
    public static double getLowerConfidenceInterval(double[] data) {
        return getArithmeticMean(data) - Z_VALUE * (getStandardDeviation(data) / Math.sqrt(data.length));
    }

    //8.2
    public static double getUpperConfidenceInterval(double[] data) {
        return getArithmeticMean(data) + Z_VALUE * (getStandardDeviation(data) / Math.sqrt(data.length));
    }

    //9
    public static double getVariance(double[] data) {
        return StatUtils.variance(data);
    }

    //10.1
    public static double getMax(double[] data) {
        return StatUtils.max(data);
    }

    //10.2
    public static double getMin(double[] data) {
        return StatUtils.min(data);
    }

}
