package shapes;

public class Rectangle extends Shape {

    public int width;
    public int height;

    public Rectangle() {}

    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
    
    @Override
    public boolean equals(Object obj2) {
        if (!(obj2 instanceof Rectangle) || !super.equals(obj2)) return false;
        Rectangle shape2 = (Rectangle) obj2;
        return shape2.width == width && shape2.height == height;
    }
}
