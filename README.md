# Patrones de Diseño - Design Patterns

Los patrones de diseño son soluciones habituales a problemas que ocurren con frecuencia en el diseño de software. (...) El patrón no es una porción especifica de código, sino un concepto general para resolver un problema particular. A menudo los patrones se confunden con algoritmos porque ambos conceptos describen soluciones típicas a problemas conocidos. Mientras que un algoritmo siempre define un grupo claro de acciones para lograr un objetivo, un patrón es una descripción de más alto nivel de una solución. Una analogía de un algoritmo sería una receta de cocina: ambos cuentan con pasos claros para alcanzar una meta. Por su parte, un patrón es más similar a un plano, ya que puedes observar cómo son su resultado y sus funciones, pero el orden exacto de la implementación depende de ti.

## Clasificación de los patrones

Los patrones de diseño varían en su complejidad, nivel de detalle y escala de aplicabilidad al sistema completo que se diseña. Todos los patrones pueden clasificarse por su propósito:

### - Patrones Creacionales

Los ***Patrones Creacionales*** proporcionan mecanismos de creación de objetos que incrementan la flexibilidad y la reutilización de código existente. Entre los patrones creacionales encontramos los siguientes:

- ***Factory Method***: Proporciona una interfaz para la creación de objetos en una super-clase, mientras permite a las subclases alterar el tipo de objetos que se crearán.
- ***Abstract Factory***: Permite producir familias de objetos relacionados sin especificar sus clases concretas.
- ***Builder***: Permite construir objetos complejos paso a paso. Este patrón nos permite producir distintos tipos y representaciones de un objeto empleando el mismo código de construcción.
- ***Prototype***: Permite copiar objetos existentes sin que el código dependa de sus clases.
- ***Singleton***: Permite asegurarnos de que una clase tenga una única instancia, a la vez que proporciona un punto de acceso global a dicha instancia.

### - Patrones Estructurales

Los ***Patrones Estructurales*** explican cómo ensamblar objetos y clases en estructuras más grandes a la vez que se mantiene la flexibilidad y eficiencia de la estructura. Entre los patrones estructurales podemos encontrar:

- ***Adapter***: Permite la colaboración entre objetos con interfaces incompatibles.
- ***Bridge***: Permite dividir una clase grande o un grupo de clases estrechamente relacionadas, en dos jerarquías separadas (abstracción e implementación) que pueden desarrollarse independientemente la una de la otra.
- ***Composite***: Permite componer objetos en estructuras de árbol y trabajar con esas estructuras como si fueran objetos individuales.
- ***Decorator***: Permite añadir funcionalidades a objetos colocando estos objetos dentro de objetos encapsulados especiales que contienen estas funcionalidades.
- ***Facade***: Proporciona una interfaz simplificada a una biblioteca, un framework o cualquier otro grupo complejo de clases.
- ***Flyweight***: Permite mantener más objetos dentro de la cantidad disponible de memoria RAM compartiendo las partes comunes del estado entre varios objetos en lugar de mantener toda la información en cada objeto.
- ***Proxy***: Permite proporcionar un sustituto o marcador de posición para otro objeto. Un proxy controla el acceso al objeto original, permitiéndo hacer algo antes o después de que la solicitud llegue al objeto original.

### - Patrones de Comportamiento

Los ***Patrones de Comportamiento*** se encargan de una comunicación efectiva y la asignación de responsabilidades entre objetos.Entre los patrones de comportamiento se pueden observar:

- ***Chain of Responsability***: Permite pasar solicitudes a lo largo de una cadena de manejadores. Al recibir una solicitud, cada manejador decide si la procesa o si la pasa al siguiente manejador de la cadena.
- ***Command***: Convierte una solicitud en un objeto independiente que contiene toda la información sobre la solicitud. Esta transformación te permite parametrizar los métodos con diferentes solicitudes, retrasar o poner en cola la ejecución de una solicitud y soportar operaciones que no se pueden realizar.
- ***Iterator***: Permite recorrer elementos de una colección sin exponer su representación subyacente ( lista, pila, árbol, etc.)
- ***Mediator***: Permite reducir las dependencias caóticas entre objetos. El patrón restringe las comunicaciones directas entre los objetos, forzándolos a colaborar únicamente a través de un objeto mediador.
- ***Memento***: Permite guardar y restaurar el estado previo de un objeto sin revelar los detalles de su implementación.
- ***Observer***: Permite definir un mecanismo de suscripción para notificar a varios objetos sobre cualquier evento que le suceda al objeto que están observando.
- ***State***: Permite a un objeto alterar su comportamiento cuando su estado interno cambia. Parece como si el objeto cambiara su clase.
- ***Strategy***: Permite definir una familia de algoritmos, colocar cada uno de ellos en una clase separada y hacer sus objetos intercambiables.
- ***Template Method***: Define el esqueleto de un algoritmo en la super-clase pero permite que las subclases sobrescriban pasos del algoritmo sin cambiar su estructura.
- ***Visitor***: Permite separar algoritmos de los objetos sobre los que operan.

---

## Fuente

Refactoring.Guru. (s. f.). Patrones de diseño / Design patterns. Refactoring.Guru. Recuperado 9 de julio de 2021, de <https://refactoring.guru/es/design-patterns>
