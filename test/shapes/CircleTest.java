package shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point center = new Point(1,2);
        Circle myCircle = new Ellipse(center, 5);
        assertSame(center, myCircle.getCenter());
        assertEquals(5, myCircle.getMinRadius(), 0);
        assertEquals(5, myCircle.getMaxRadius(), 0);
        myCircle = new Ellipse(1.3, 2.6, 2.5, 3.1);
        assertEquals(1.3, myCircle.getCenter().getX(), 0);
        assertEquals(2.6, myCircle.getCenter().getY(), 0);
        assertEquals(2.5, myCircle.getMinRadius(), 0);
        assertEquals(2.5, myCircle.getMaxRadius(), 0);
    }

    @Test
    public void testInvalidConstruction() {

        try {
            new Circle(new Point(1, 2), 2, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("This is not a circle", e.getMessage());
        }

        try {
            new Ellipse(new Point(1, 2), 3, 4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("This is not a circle", e.getMessage());
        }

    }

    @Test
    public void testMove() throws Exception {
        Circle myCircle = new Circle(1, 2, 5, 5);
        assertEquals(1, myCircle.getCenter().getX(), 0);
        assertEquals(2, myCircle.getCenter().getY(), 0);
        assertEquals(5, myCircle.getMinRadius(), 0);
        assertEquals(5, myCircle.getMaxRadius(), 0);
    }

    @Test
    public void testScale() throws ShapeException {
        Ellipse myEllipse = new Circle(1, 2, 5, 5);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMinRadius(), 0);
        assertEquals(5, myEllipse.getMaxRadius(), 0);

        myEllipse.scale(3);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(15, myEllipse.getMinRadius(), 0);
        assertEquals(15, myEllipse.getMaxRadius(), 0);

        myEllipse.scale(0.2);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(3, myEllipse.getMinRadius(), 0);
        assertEquals(3, myEllipse.getMaxRadius(), 0);

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