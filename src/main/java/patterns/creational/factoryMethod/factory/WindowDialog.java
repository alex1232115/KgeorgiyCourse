package patterns.creational.factoryMethod.factory;

import patterns.creational.factoryMethod.buttons.Button;
import patterns.creational.factoryMethod.buttons.WindowButton;

public class WindowDialog extends Dialog{
    @Override
    public Button createButton() {
        return new WindowButton();
    }
}
