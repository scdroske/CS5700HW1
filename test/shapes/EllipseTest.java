package shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class EllipseTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point center = new Point(1,2);
        Ellipse myEllipse = new Ellipse(center, 5);
        assertSame(center, myEllipse.getCenter());
        assertEquals(5, myEllipse.getMinRadius(), 0);
        assertEquals(5, myEllipse.getMaxRadius(), 0);
        myEllipse = new Ellipse(1.3, 2.6, 2.5, 3.1);
        assertEquals(1.3, myEllipse.getCenter().getX(), 0);
        assertEquals(2.6, myEllipse.getCenter().getY(), 0);
        assertEquals(2.5, myEllipse.getMinRadius(), 0);
        assertEquals(3.1, myEllipse.getMaxRadius(), 0);
    }

    @Test
    public void testInvalidConstruction() {

        try {
            new Ellipse(null, 2.5);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid center point", e.getMessage());
        }

        try {
            new Ellipse( new Point(1, 2), Double.POSITIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid min radius", e.getMessage());
        }

        try {
            new Ellipse( new Point(1, 2), 3, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid max radius", e.getMessage());
        }
        try {
            new Ellipse(new Point(1, 2), Double.NEGATIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid min radius", e.getMessage());
        }

        try {
            new Ellipse(new Point(1, 2), 3, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid max radius", e.getMessage());
        }

        try {
            new Ellipse(new Point(1, 2), Double.NaN, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid min radius", e.getMessage());
        }

        try {
            new Ellipse(new Point(1, 2), 3, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid max radius", e.getMessage());
        }

        try {
            new Ellipse(Double.POSITIVE_INFINITY, 2, 3, 4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Ellipse(Double.NEGATIVE_INFINITY, 2, 3, 4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Ellipse(Double.NaN, 2, 3, 4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Ellipse(1, Double.POSITIVE_INFINITY, 3, 4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Ellipse(1, Double.NEGATIVE_INFINITY, 3, 4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Ellipse(1, Double.NaN, 3, 4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }


        try {
            new Ellipse(1, 2, Double.POSITIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid min radius", e.getMessage());
        }

        try {
            new Ellipse(1, 2, 3, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid max radius", e.getMessage());
        }

        try {
            new Ellipse(1, 2, Double.NEGATIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid min radius", e.getMessage());
        }

        try {
            new Ellipse(1, 2, 3, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid max radius", e.getMessage());
        }

        try {
            new Ellipse(1, 2, Double.NaN, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid min radius", e.getMessage());
        }

        try {
            new Ellipse(1, 2, 3, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid max radius", e.getMessage());
        }
    }

    @Test
    public void testMove() throws Exception {
        Ellipse myEllipse = new Ellipse(1, 2, 5, 6);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMinRadius(), 0);
        assertEquals(6, myEllipse.getMaxRadius(), 0);

        myEllipse.move(3,  4);
        assertEquals(4, myEllipse.getCenter().getX(), 0);
        assertEquals(6, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMinRadius(), 0);
        assertEquals(6, myEllipse.getMaxRadius(), 0);

        myEllipse.move(0.123,  0.456);
        assertEquals(4.123, myEllipse.getCenter().getX(), 0);
        assertEquals(6.456, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMinRadius(), 0);
        assertEquals(6, myEllipse.getMaxRadius(), 0);

        myEllipse.move(-0.123,  -0.456);
        assertEquals(4, myEllipse.getCenter().getX(), 0);
        assertEquals(6, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMinRadius(), 0);
        assertEquals(6, myEllipse.getMaxRadius(), 0);


        myEllipse.move(-12,  -26);
        assertEquals(-8, myEllipse.getCenter().getX(), 0);
        assertEquals(-20, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMinRadius(), 0);
        assertEquals(6, myEllipse.getMaxRadius(), 0);


        try {
            myEllipse.move(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            myEllipse.move(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-x value", e.getMessage());
            // ignore
        }

        try {
            myEllipse.move(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            myEllipse.move(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            myEllipse.move(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            myEllipse.move(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

    }

    @Test
    public void testScale() throws ShapeException {
        Ellipse myEllipse = new Ellipse(1, 2, 5, 6);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMinRadius(), 0);
        assertEquals(6, myEllipse.getMaxRadius(), 0);

        myEllipse.scale(3);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(15, myEllipse.getMinRadius(), 0);
        assertEquals(18, myEllipse.getMaxRadius(), 0);

        myEllipse.scale(0.2);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(3, myEllipse.getMinRadius(), 0);
        assertEquals(3.6, myEllipse.getMaxRadius(), 0);

        try {
            myEllipse.scale(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid scale factor", e.getMessage());

        }

        try {
            myEllipse.scale(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid scale factor", e.getMessage());
        }

        try {
            myEllipse.scale(Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid scale factor", e.getMessage());
        }
    }

    @Test
    public void testComputeArea() throws ShapeException {
        Ellipse myEllipse = new Ellipse(1, 2, 5, 5);
        assertEquals(78.53975, myEllipse.computeArea(), 0.0001);

        myEllipse = new Ellipse(1, 2, 4.234, 4.234);
        assertEquals(56.3185174, myEllipse.computeArea(), 0.0001);

        myEllipse = new Ellipse(1, 2, 0, 0);
        assertEquals(0, myEllipse.computeArea(), 0);

    }

}