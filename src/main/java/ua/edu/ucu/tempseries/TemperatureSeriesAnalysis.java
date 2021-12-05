package ua.edu.ucu.tempseries;
import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private static final int MINPOSSIBLE = -273;
    private double[] temps;

    public TemperatureSeriesAnalysis() {
        this.temps = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        checkMinTemp(temperatureSeries);
        temps = Arrays.stream(temperatureSeries).sorted().toArray();
    }

    public double average() {
        checkEmpty();
        double answer;
        double sum = 0;
        for (double temp: temps) {
            sum += temp;
        }
        answer = sum/temps.length;
        return answer;
    }

    public double deviation() throws IllegalArgumentException {
        checkEmpty();
        double sqrSum = 0;
        for (double x: this.temps) {
            sqrSum += x*x;
        }
        double avg = this.average();
        return Math.sqrt(sqrSum / temps.length - avg * avg);
    }

    public double min() throws IllegalArgumentException {
        checkEmpty();
        double mn = this.temps[0];
        for (double temperature: this.temps) {
            mn = Math.min(mn, temperature);
        }
        return mn;
    }

    public double max() {
        checkEmpty();
        return temps[temps.length-1];
    }

    public double findTempClosestToZero() throws IllegalArgumentException {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        checkEmpty();
        double closestDistance = 600;
        double closestValue = 0;
        for (double temp: temps) {
            double check = Math.abs(temp - tempValue);
            if (check < closestDistance) {
                closestDistance = check;
                closestValue = temp;
            }
        }
        return closestValue;
    }

    public double[] findTempsLessThen(double tempValue) {
        checkEmpty();
        int size = 0;
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] < tempValue) {
                size = i+1;
            }
        }
        double[] result = new double[size];
        for (int j = 0; j < size; j++) {
            result[j] = temps[j];
        }
        return result;
    }

    private void checkEmpty() {
        if (temps.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double[] findTempsGreaterThen(double tempValue) {
        checkEmpty();
        int i = 0;
        while (temps[i] < tempValue) { i++; }
        if (temps[i] == tempValue) {
            i++;
        }
        double[] result = new double[temps.length - i];
        for (int j = i; j < temps.length; j++) {
            result[j-i] = temps[j];
        }
        return result;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    private void checkMinTemp(double[] temperatures) {
        for (double temp: temperatures) {
            if (temp < MINPOSSIBLE) {
                throw new InputMismatchException();
            }
        }
    }

    public int addTemps(double... temperatures) {
        checkMinTemp(temperatures);
        int arrOneSize = temperatures.length;
        int arrTwoSize = temperatures.length;
        double[] tempArr = new double[arrOneSize + arrTwoSize];
        System.arraycopy(temperatures, 0, tempArr, 0, arrOneSize);
        System.arraycopy(temperatures, 0, tempArr, arrOneSize, arrTwoSize);
        temperatures = Arrays.stream(tempArr).sorted().toArray();
        return temperatures.length;
    }
}
