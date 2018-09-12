package shapes;

/**
 * Circle
 *
 * This class represents circle objects that can be moved and scales.  Users of a circle can also get its area.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Circle extends Ellipse{

    /**
     *
     * @return      getMinRadius() -- this will go and use the getMinRadius() which will then get a minRadius to be used as the radius
     */
    public double getRadius() { return getMinRadius(); }
    protected double radius;
    radius = minRadius;


    /**
     * @param center            this will create the center of the circle
     * @param minRadius         this redefines the minRadius to be used as the min and max radius so they are always equal
     * @throws shapeException   handles exceptions
     */
    public Circle(Point center, double radius) throws shapeException {
        super(center, radius, radius);
        Validator.validatePositiveDouble(radius, "Invalid radius");
    }
