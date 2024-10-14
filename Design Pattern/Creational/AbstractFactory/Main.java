package Creational.AbstractFactory;

interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

interface Button {
    void click();
}

interface Checkbox {
    void check();
}

class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

class WindowsButton implements Button {
    public void click() {
        System.out.println("Windows Button clicked.");
    }
}

class MacButton implements Button {
    public void click() {
        System.out.println("Mac Button clicked.");
    }
}

class WindowsCheckbox implements Checkbox {
    public void check() {
        System.out.println("Windows Checkbox checked.");
    }
}

class MacCheckbox implements Checkbox {
    public void check() {
        System.out.println("Mac Checkbox checked.");
    }
}

public class Main {
    public static void main(String[] args) {
        GUIFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.click();
        checkbox.check();
    }
}
