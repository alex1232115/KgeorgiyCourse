package patterns.creational.factoryMethod;

import patterns.creational.factoryMethod.factory.Dialog;
import patterns.creational.factoryMethod.factory.HtmlDialog;
import patterns.creational.factoryMethod.factory.WindowDialog;

public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        String val = "window";
        configure(val);
        runBusinessLogic();
    }

    private static void runBusinessLogic() {
        dialog.renderWindow();
    }

    private static void configure(String val) {
        if (val.equals("window")) {
            dialog = new WindowDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }
}
