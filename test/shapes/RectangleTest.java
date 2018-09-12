package shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point bottomLeftPoint = new Point(1, 2);
        Rectangle myRectangle = new Rectangle(bottomLeftPoint, 4, 5);
        assertSame(bottomLeftPoint, myRectangle.getPoint());
        assertEquals(4, myRectangle.getWidth(), 0);
        assertEquals(5, myRectangle.getHeight(), 0);

        myRectangle = new Rectangle(1.3, 2.6, 2.5, 3.1);
        assertEquals(1.3, myRectangle.getPoint().getX(), 0);
        assertEquals(2.6, myRectangle.getPoint().getY(), 0);
        assertEquals(2.5, myRectangle.getWidth(), 0);
        assertEquals(3.1, myRectangle.getHeight(), 0);
    }


    @Test
    public void testInvalidConstruction() {
        try {
            new Rectangle(1, 2, Double.POSITIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }

        try {
            new Rectangle(1, 2, 3, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid height", e.getMessage());
        }

        try {
            new Rectangle(1, 2, Double.NEGATIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }

        try {
            new Rectangle(1, 2, 3, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid height", e.getMessage());
        }

        try {
            new Rectangle(1, 2, Double.NaN, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }

        try {
            new Rectangle(1, 2, 3, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid height", e.getMessage());
        }

    }

    @Test
    public void testMove() throws Exception {
        Rectangle myRectangle = new Rectangle(1, 2, 5, 6);
        assertEquals(1, myRectangle.getCenter().getX(), 0);
        assertEquals(2, myRectangle.getCenter().getY(), 0);
        assertEquals(5, myRectangle.getMinRadius(), 0);
        assertEquals(6, myRectangle.getMaxRadius(), 0);

        myRectangle.move(3,  4);
        assertEquals(4, myRectangle.getCenter().getX(), 0);
        assertEquals(6, myRectangle.getCenter().getY(), 0);
        assertEquals(5, myRectangle.getMinRadius(), 0);
        assertEquals(6, myRectangle.getMaxRadius(), 0);

    }

    @Test
    public void testComputeArea() throws ShapeException {
        Rectangle myRectangle = new Rectangle(1, 2, 5, 2);
        assertEquals(10, myRectangle.computeArea(), 0.0001);

        myRectangle = new Rectangle(1, 2, 4, 5);
        assertEquals(20, myRectangle.computeArea(), 0.0001);

        myRectangle = new Rectangle(1, 2, 3, 5);
        assertEquals(15, myRectangle.computeArea(), 0);

    }
