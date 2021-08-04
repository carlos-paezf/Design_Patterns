package main.java.factories;

import main.java.buttons.Button;
import main.java.checkboxes.Checkbox;


/**
 * Abstract Factory knows about all (abstract) products types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
