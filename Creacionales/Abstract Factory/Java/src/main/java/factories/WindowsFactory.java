package main.java.factories;

import main.java.buttons.Button;
import main.java.buttons.WindowsButton;
import main.java.checkboxes.Checkbox;
import main.java.checkboxes.WindowsCheckbox;


/**
 * Each concrete factory extends basic factory and responsible
 * for creating products of a single variety.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}