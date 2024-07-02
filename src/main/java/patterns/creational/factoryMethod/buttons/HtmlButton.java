package patterns.creational.factoryMethod.buttons;

public class HtmlButton implements Button{
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
    }

    @Override
    public void onClick() {
        System.out.println("Click! Buttons says - \"Hello world!\"");
    }
}
