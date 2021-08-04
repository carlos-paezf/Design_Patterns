package main.java.factories;

import main.java.buttons.Button;
import main.java.buttons.MacOSButton;
import main.java.checkboxes.Checkbox;
import main.java.checkboxes.MacOSCheckbox;
import main.java.buttons.MacOSButton;


/**
 * Each concrete factory extends basic factory and responsible
 * for creating products of a single variety.
 */
public class MacOSFactory implements GUIFactory {
    
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
