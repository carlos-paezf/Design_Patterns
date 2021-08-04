# Abstract Factory en JAVA

Abstract Factory es un patrón de diseño creacional que resuelve el problema de crear familias enteras de productos sin especificar sus clases concretas. El patrón Abstract Factory define una interfaz para crear todos los productos, pero deja la propia creación de productos para las clases de fábrica concretas. Cada tipo de fábrica se corresponde con cierta variedad de producto.

El código cliente invoca los métodos de creación de un objeto de fábrica en lugar de crear los productos directamente con una llamada al constructor (operador new). Como una fábrica se corresponde con una única variante de producto, todos sus productos serán compatibles.

El código cliente trabaja con fábricas y productos únicamente a través de sus interfaces abstractas. Esto permite al mismo código cliente trabajar con productos diferentes. Simplemente, creas una nueva clase fábrica concreta y la pasas al código cliente.

## Uso del patrón en Java

### Ejemplos de uso

El patrón Abstract Factory es muy común en el código Java. Muchos frameworks y bibliotecas lo utilizan para proporcionar una forma de extender y personalizar sus componentes estándar. Aquí tienes algunos ejemplos de las principales bibliotecas de Java:

- `javax.xml.parsers.DocumentBuilderFactory#newInstance()`
- `javax.xml.transform.TransformerFactory#newInstance()`
- `javax.xml.xpath.XPathFactory#newInstance()`

### Identificación

El patrón es fácil de reconocer por los métodos, que devuelven un objeto de fábrica. Después, la fábrica se utiliza para crear subcomponentes específicos.

## Familias de componentes GUI multiplataforma y su producción

En este ejemplo, los botones y las casillas actuarán como productos. Tienen dos variantes: macOS y Windows. La fábrica abstracta define una interfaz para crear botones y casillas. Hay dos fábricas concretas, que devuelven ambos productos en una única variante. El código cliente funciona con fábricas y productos utilizando interfaces abstractas. Esto permite al código cliente funcionar con cualquier variante de producto creada por el objeto de fábrica.

### buttons: Primera jerarquía de productos

`buttons/Button.java`. Abstract Factory asume que tu tienes muchas familias de productos, estructurados dentro herencias de clases separadas (Button/Checkbox). Todos los productos de la misma familia tienen una interfaz común. Esta es una interfaz común para la familia de botones.

```java
package main.java.buttons;

public interface Button {
    void paint();
}
```

`buttons/MacOSButton.java`. Todos las familias de productos tienen las mismas variantes. En este caso es una variante de botón para MacOS.

```java
package main.java.buttons;

import main.java.buttons.Button;

public class MacOSButton implements Button {
    
    @Override
    public void paint() {
        System.out.println("You have created MacOSButton");
    }
}
```

`buttons/WindowsButton.java`. Todas las familias de productos tienen las mismas variantes. Esta es otra variante de un botón.

```java
package main.java.buttons;

import  main.java.buttons.Button;

public class WindowsButton implements Button {
    
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
```

### checkboxes: Segunda jerarquía de productos

`checkboxes/Checkbox.java`. Los Checkboxes son la segunda familia de productos. Estos tienen las mismas variantes que los botones.

```java
package main.java.checkboxes;

public interface Checkbox {
    void paint();
}
```

`checkboxes/MacOSCheckbox.java`. Todos las familias de productos tienen las mismas variantes. Esta es una variante para macOS.

```java
package main.java.checkboxes;

import main.java.checkboxes.Checkbox;

public class MacOSCheckbox implements Checkbox {
    
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
```

`checkboxes/WindowsCheckbox.java`. Todas las familias de productos tienen las mismas variantes. Esta es una variante de checkbox para Windows.

```java
package main.java.checkboxes;

import main.java.checkboxes.Checkbox;

public class WindowsCheckbox implements Checkbox {
    
    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}
```

### factories

`factories/GUIFactory.java`. La fábrica abstracta conoce acerca de todos los productos de tipo abstracto.

```java
package main.java.factories;

import main.java.buttons.Button;
import main.java.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

`factories/MacOSFactory.java`. Cada fábrica concreta extiende la fábrica base y la responsabilidad de crear productos de una sola variedad.

```java
package main.java.factories;

import main.java.buttons.Button;
import main.java.buttons.MacOSButton;
import main.java.checkboxes.Checkbox;
import main.java.checkboxes.MacOSCheckbox;
import main.java.buttons.MacOSButton;

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
```

`factories/WindowsFactory.java`. Cada fábrica concreta extiende la fábrica concreta y la responsabilidad de crear productos de una sola variedad.

```java
package main.java.factories;

import main.java.buttons.Button;
import main.java.buttons.WindowsButton;
import main.java.checkboxes.Checkbox;
import main.java.checkboxes.WindowsCheckbox;

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
```

### app

`app/Application.java`. Los usuarios de la fábrica no tienen cuidado acerca de la fábrica concreta están usando, ya que ellos trabajan con fábricas y productos a través de interfaces abstractas.

```java
package main.java.app;

import main.java.buttons.Button;
import main.java.checkboxes.Checkbox;
import main.java.factories.GUIFactory;

public class Application {

    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
```

`app/ApplicationConfigurator.java`. Esta la clase demo, todo irá junto aquí. La aplicación elige el tipo de fábrica y la crea en tiempo de ejecución, generalmente en la etapa de inicialización, según la configuración o las variables de entorno.

```java
package main.java.app;

import main.java.app.Application;
import main.java.factories.GUIFactory;
import main.java.factories.MacOSFactory;
import main.java.factories.WindowsFactory;

public class ApplicationConfigurator {

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
```

### Output

![a_f](../../../Z-IMG/abstract-factory-9.png)
![a_f](../../../Z-IMG/abstract-factory-10.png)
