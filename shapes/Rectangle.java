package shapes;

/**
 * Rectangle
 */
@SuppressWarnings("WeakerAccess")
public class Rectangle implements GeneralShape {
    protected Point bottomLeftPoint;
    protected double width;
    protected double height;


    @Override
    public void getInput() {
        public double getHeight () {
            return height;
        }

        public double getWidth () {
            return width;
        }

        public Point getPoint() {
            return bottomLeftPoint;
        }

    }

    protected Point bottomRightPoint;
    protected Point topLeftPoint;
    protected Point topRightPoint;


    public Rectangle(Point bottomLeftPoint, double width, double height) throws ShapeException{
        Validator.validatePositiveDouble(width, "Invalid width");
        Validator.validatePositiveDouble(height, "Invalid height");
        if (point==null)
            throw new ShapeException("Invalid point");

        this.bottomLeftPoint = bottomLeftPoint;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        bottomLeftPoint.move(deltaX, deltaY);
        bottomRightPoint.move(deltaX, deltaY);
        topLeftPoint.move(deltaX,deltaY);
        topRightPoint.move(deltaX,deltaY);
    }




}