package Model;

import org.junit.jupiter.api.Test;

import Model.DOFCalculator;
import Model.Lens;
import Model.LensManager;

import static org.junit.jupiter.api.Assertions.*;

class DOFCalculatorTest {
    private static final double COC = 0.029;    // "Circle of Confusion" for a "Full Frame" camera

    @Test
    void hyperfocalDistance() {
        assertEquals(47.89,DOFCalculator.hyperfocalDistance(50, 1.8, COC)/1000,0.1);
        assertEquals(10.78,DOFCalculator.hyperfocalDistance(50, 8, COC)/1000,0.1);
        assertEquals(7.84,DOFCalculator.hyperfocalDistance(50, 11, COC)/1000,0.1);
        assertEquals(99.75,DOFCalculator.hyperfocalDistance(90, 2.8, COC)/1000,0.1);

    }

    @Test
    void nearFocalPoint() {
        assertEquals(1.08,DOFCalculator.nearFocalPoint(50, 1.8, COC, 1.1)/1000,0.1);
        assertEquals(0.92,DOFCalculator.nearFocalPoint(50, 8, COC, 1)/1000,0.1);
        assertEquals(5.16,DOFCalculator.nearFocalPoint(50, 11, COC, 15)/1000,0.1);
        assertEquals(1.96,DOFCalculator.nearFocalPoint(90, 2.8, COC, 2)/1000,0.1);


    }

    @Test
    void farFocalPoint() {
        assertEquals(1.12,DOFCalculator.farFocalPoint(50, 1.8, COC, 1.1)/1000,0.1);
        assertEquals(1.10,DOFCalculator.farFocalPoint(50, 8, COC, 1)/1000,0.1);
        assertEquals(Double.POSITIVE_INFINITY,DOFCalculator.farFocalPoint(50, 11, COC, 15)/1000,0.1);
        assertEquals(2.04,DOFCalculator.farFocalPoint(90, 2.8, COC, 2)/1000,0.1);

    }

    @Test
    void depthOfField() {
        assertEquals(0.05,DOFCalculator.depthOfField(50, 1.8, COC, 1.1)/1000,0.1);
        assertEquals(0.18,DOFCalculator.depthOfField(50, 8, COC, 1)/1000,0.1);
        assertEquals(Double.POSITIVE_INFINITY,DOFCalculator.depthOfField(50, 11, COC, 15)/1000,0.1);
        assertEquals(0.08,DOFCalculator.depthOfField(90, 2.8, COC, 2)/1000,0.1);

    }
}