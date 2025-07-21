package thienln.example;

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    @Override
    public void draw() {
        // Triển khai phương thức draw()
        System.out.println("Drawing a Circle");
    }
}

public class UnimplementedInterfaceExample {
    public static void main(String[] args) {
        // Tạo đối tượng Circle và gọi phương thức draw
        Circle circle = new Circle();
        circle.draw();
    }
}
