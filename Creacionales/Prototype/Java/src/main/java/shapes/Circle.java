package shapes;

public class Circle extends Shape {

    public int radius;

    public Circle() {}

    public Circle(Circle target) {
        super(target);
        if (target != null) {
            this.radius = target.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object obj2) {
        if (!(obj2 instanceof Circle) || !super.equals(obj2)) return false;
        Circle shape2 = (Circle) obj2;
        return shape2.radius == radius;
    }
}
