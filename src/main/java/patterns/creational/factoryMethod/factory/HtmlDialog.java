package patterns.creational.factoryMethod.factory;

import patterns.creational.factoryMethod.buttons.Button;
import patterns.creational.factoryMethod.buttons.HtmlButton;

public class HtmlDialog extends Dialog{
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
