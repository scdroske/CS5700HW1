package examples.shapes;

/**
 *
 *  Line
 *
 *  This class represents line objects that can be moved.  Users of a line can also get its length and slope
 *
 */
@SuppressWarnings("WeakerAccess")
public class Line {
    public Point point1;
    public Point point2;

    /**
     * Constructor based on x-y Locations
     * @param x1                The x-location of first point -- must be a valid double.
     * @param y1                The y-location of first point -- must be a valid double.
     * @param x2                The x-location of second point -- must be a valid double.
     * @param y2                The y-location of second point -- must be a valid double.
     * @throws ShapeException   Exception throw if any of the parameters are invalid
     */
    public Line(double x1, double y1, double x2, double y2) throws ShapeException {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
    }

    /**
     *
     * @param point1            The first point -- must not be null
     * @param point2            The second point -- must not b e null
     * @throws ShapeException   Exception throw if any of the parameters are invalid
     */
    public Line(Point point1, Point point2) throws ShapeException {
        if (point1==null || point2==null)
            throw new ShapeException("Invalid Point");

        this.point1 = point1;
        this.point2 = point2;
    }

    /**
     * @return  The first point
     */
    public Point getPoint1() { return point1; }

    /**
     * @return  The second point
     */
    // TODO: improve encapsulation, but cloning
    public Point getPoint2() { return point2; }

    /**
     * Move a line
     *
     * @param deltaX            The delta x-location by which the line should be moved -- must be a valid double
     * @param deltaY            The delta y-location by which the line should be moved -- must be a valid double
     * @throws ShapeException   Exception throw if any of the parameters are invalid
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
    }

    /**
     * @return  The length of the line
     */
    public double computeLength() {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) +
                Math.pow(point2.getY() - point1.getY(), 2));
    }

    /**
     * @return  The slope of the line
     */
    public double computeSlope() {
        return (point2.getX() - point1.getX())/(point2.getY() - point1.getY());
    }
}
