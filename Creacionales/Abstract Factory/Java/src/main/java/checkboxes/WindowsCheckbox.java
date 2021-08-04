package main.java.checkboxes;

import main.java.checkboxes.Checkbox;


/**
 * All products families have the same variants (MacOS/Windows).
 * This is a variant of a checkbox
 */
public class WindowsCheckbox implements Checkbox {
    
    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}
