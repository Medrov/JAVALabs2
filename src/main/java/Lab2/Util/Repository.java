package main.java.Lab2.Util;

public class Repository {
    private static final int NUM_STATISTICS = 11;
    private static Repository INSTANCE;
    private double[][] matrix;
    private double[][] parameters;

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] getParameters() {
        return parameters;
    }

    public double getCov(int i, int j) {
        return Calculator.getCovariance(matrix[i], matrix[j]);
    }

    public void setParameters() {
        if (matrix == null) {
            System.out.println("Данные не импортированы");
            return;
        }

        parameters = new double[NUM_STATISTICS][matrix.length];
        for (int i = 0; i < NUM_STATISTICS; i++) {
            for (int j = 0; j < matrix.length; j++) {
                parameters[i][j] = Decider(i, j, matrix);
            }
        }
    }

    public double Decider(int i, int j, double[][] matrix) {
        switch (i) {
            case 0:
                return Calculator.getGeometricMean(matrix[j]);
            case 1:
                return Calculator.getArithmeticMean(matrix[j]);
            case 2:
                return Calculator.getStandardDeviation(matrix[j]);
            case 3:
                return Calculator.getRange(matrix[j]);
            case 4:
                return Calculator.getSampleSize(matrix[j]);
            case 5:
                return Calculator.getCoefficientOfVariation(matrix[j]);
            case 6:
                return Calculator.getLowerConfidenceInterval(matrix[j]);
            case 7:
                return Calculator.getUpperConfidenceInterval(matrix[j]);
            case 8:
                return Calculator.getVariance(matrix[j]);
            case 9:
                return Calculator.getMax(matrix[j]);
            case 10:
                return Calculator.getMin(matrix[j]);
            default:
                return 0;
        }
    }
}
