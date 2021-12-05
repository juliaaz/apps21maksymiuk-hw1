package ua.edu.ucu.tempseries;
import java.util.InputMismatchException;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyTemp() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        // expect exception here
        double actualResult = seriesAnalysis.average();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {5.0, 6.0, 7.0, 8.0, 9.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = Math.sqrt(2);

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysisEmpty = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysisEmpty.deviation();
    }

    @Test
    public void testDeviationWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysisOneEl = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {-5.0, 6.0, -7.0, 8.0, 9.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -7.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysisOneEl = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysisEmpty = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysisEmpty.min();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {5.0, -6.0, 7.0, 8.0, -9.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 8.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysisOneEl = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysisEmpty = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysisEmpty.max();
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysisEmpty = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysisEmpty.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZeroWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysisOneEl = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {5.0, -6.0, 7.0, 8.0, -9.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(3.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysisOneEl = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.findTempClosestToValue(2.3);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysisEmpty = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysisEmpty.findTempClosestToValue(2.3);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-5.0};

        double[] actualResult = seriesAnalysis.findTempsLessThen(-2.0);

        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test
    public void testFindTempsLessThenWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysisOneEl = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};

        // call tested method
        double[] actualResult = seriesAnalysisOneEl.findTempsLessThen(1.0);

        // compare expected result with actual result
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysisEmpty = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysisEmpty.findTempsLessThen(2.0);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {5.0, -6.0, 7.0, 8.0, -9.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {7.0, 8.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(6.0);

        assertEquals(expResult.length, actualResult.length);
        for (int i = 0; i < actualResult.length; i++){
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }

    @Test
    public void testFindTempsGreaterThenWithOneElementArray() {
        double[] temperatureSeries = {1.0};
        TemperatureSeriesAnalysis seriesAnalysisOneEl = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {1.0};

        // call tested method
        double[] actualResult = seriesAnalysisOneEl.findTempsGreaterThen(-1.0);

        // compare expected result with actual result
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysisEmpty = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysisEmpty.findTempsGreaterThen(2.0);
    }

    @Test
    public void testAddTemps() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0, 1.0, 3.7};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] temperatureAddSeries = {-1.0, 5.0};

        int expResult = 4;

        // call tested method
        int actualResult = seriesAnalysis.addTemps(temperatureAddSeries);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsWithOneElementArray() {
        double[] temperatureSeries = {1.0};
        TemperatureSeriesAnalysis seriesAnalysisOneEl = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] temperatureAddSeries = {2.0, 3.0};
        int expResult = 4;

        // call tested method
        int actualResult = seriesAnalysisOneEl.addTemps(temperatureAddSeries);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysisEmpty = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] temperatureAddSeries = {2.0, 3.0};
        int expResult = 4;

        // call tested method
        int actualResult = seriesAnalysisEmpty.addTemps(temperatureAddSeries);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);

    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsBadTemperature() {
        double[] temperatureSeries = {5.0, -6.0, 7.0, 8.0, -9.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.addTemps(-315.2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationEmptyAvg() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        seriesAnalysis.average();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // compare expected result with actual result
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics statistics = seriesAnalysis.summaryStatistics();

        assertEquals(statistics.getAvgTemp(), 1.0, 0.00001);
        assertEquals(statistics.getDevTemp(), 3.7416573867739413, 0.00001);
        assertEquals(statistics.getMinTemp(), -5.0, 0.00001);
        assertEquals(statistics.getMaxTemp(), 5.0, 0.00001);
    }
}
