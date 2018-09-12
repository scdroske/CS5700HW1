package shapes;

/**
 * Rectangle
 */
@SuppressWarnings("WeakerAccess")
public class Square extends Rectangle {

    /**
     * this is where length and height will be made = to eachother
     */
    public double getLength(){ return getWidth();}
    protected double length;
    length = width;
}

public Square(Point point, double length) throws shapeException{
    super(point, length, length);
    Validator.validatePositiveDouble(length, "Invalid Length, must be greater than 0");
}


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
