package shapes;

/**
 * Circle
 *
 * This class represents circle objects that can be moved and scales.  Users of a circle can also get its area.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Ellipse {
    protected Point center;
    protected double minRadius;
    protected double maxRadius;

    /**
     * Constructor with x-y Location for center
     *
     * @param x                 The x-location of the center of the circle -- must be a valid double
     * @param y                 The y-location of the center of the circle
     * @param radius            The radius of the circle -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     */
    public Ellipse(double x, double y, double minRadius, double maxRadius) throws ShapeException {
        Validator.validatePositiveDouble(minRadius, "Invalid radius", maxRadius, "Invalid radius");
        center = new Point(x, y);
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    /**
     * Constructor with a Point for center
     *
     * @param center            The x-location of the center of the ellipse -- must be a valid point
     * @param min radius            The min radius of the ellipse -- must be greater or equal to zero.
     * @param maxRadius         the max radius of the ellise -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     *
     *
     * minRadius and maxRadius are otherwise known as the semimajor-axis and major-axis
     */
    public Ellipse(Point center, double minRadius, double maxRadius) throws ShapeException {
        Validator.validatePositiveDouble(minRadius, "Invalid minradius");
        Validator.validatePositiveDouble(maxRadius, "Invalid maxradius");
        if (center==null)
            throw new ShapeException("Invalid center point");

        this.center = center;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    /**
     * @return  The center of the ellipse
     */
    public Point getCenter() { return center; }

    /**
     * @return  The minradius and maxradius... or semi major and major axis of the circle
     */
    private double getMinRadius() { return minRadius; }
    private double getMaxRadius() { return maxRadius; }
    /**
     * Move the circle
     * @param deltaX            a delta change for the x-location of center of the ellipse
     * @param deltaY            a delta change for the y-location of center of the ellipse
     * @throws ShapeException   Exception thrown if either the delta x or y are not valid doubles
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        center.move(deltaX, deltaY);
    }

    /**
     * Scale the ellipse
     *
     * @param scaleFactor       a non-negative double that represents the percentage to scale the ellipse.
     *                          0>= and <1 to shrink.
     *                          >1 to grow.
     * @throws ShapeException   Exception thrown if the scale factor is not valid
     */

    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        minRadius *= scaleFactor;
        maxRadius *= scaleFactor;
    }

    /**
     * @return  The area of the circle.
     */
    public double computeArea() {
        return Math.PI * minRadius * maxRadius;
    }

}
