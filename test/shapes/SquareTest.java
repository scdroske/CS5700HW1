package shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point bottomLeftPoint = new Point(1, 2);
        Square mySquare = new Square(bottomLeftPoint, 5, 5);
        assertSame(bottomLeftPoint, mySquare.getPoint());
        assertEquals(5, mySquare.getWidth(), 0);
        assertEquals(5, mySquare.getHeight(), 0);

        mySquare = new Square(1.3, 2.6, 2.5, 2.5);
        assertEquals(1.3, mySquare.getPoint().getX(), 0);
        assertEquals(2.6, mySquare.getPoint().getY(), 0);
        assertEquals(2.5, mySquare.getWidth(), 0);
        assertEquals(2.5, mySquare.getHeight(), 0);
    }


    @Test
    public void testInvalidConstruction() {
        try {
            new Square(1, 2, 4, 3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Not a Square", e.getMessage());
        }

        try {
            new Square(1, 2, 3, 5);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Not a Square", e.getMessage());
        }

    }

    @Test
    public void testMove() throws Exception {
        Square mySquare = new Square(1, 2, 5, 5);
        assertEquals(1, mySquare.getCenter().getX(), 0);
        assertEquals(2, mySquare.getCenter().getY(), 0);
        assertEquals(5, mySquare.getMinRadius(), 0);
        assertEquals(5, mySquare.getMaxRadius(), 0);

        mySquare.move(3,  4);
        assertEquals(4, mySquare.getCenter().getX(), 0);
        assertEquals(6, mySquare.getCenter().getY(), 0);
        assertEquals(5, mySquare.getMinRadius(), 0);
        assertEquals(5, mySquare.getMaxRadius(), 0);

    }

    @Test
    public void testComputeArea() throws ShapeException {
        Square mySquare = new Square(1, 2, 5, 5);
        assertEquals(25, mySquare.computeArea(), 0.0001);

        mySquare = new Square(1, 2, 4, 4);
        assertEquals(16, mySquare.computeArea(), 0.0001);

        mySquare = new Square(1, 2, 3, 3);
        assertEquals(9, mySquare.computeArea(), 0);

    }
