package patterns.creational.factoryMethod.factory;

import patterns.creational.factoryMethod.buttons.Button;

public abstract class Dialog {
    /**
     * Базовый класс фабрики. Заметьте, что "фабрика" – это всего лишь
     * дополнительная роль для класса. Он уже имеет какую-то бизнес-логику, в
     * которой требуется создание разнообразных продуктов.
     */

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Подклассы будут переопределять этот метод, чтобы создавать конкретные
     * объекты продуктов, разные для каждой фабрики.
     */
    public abstract Button createButton();
}
