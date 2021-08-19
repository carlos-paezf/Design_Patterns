# Builder en PYTHON

Builder es un patrón de diseño creacional que permite construir objetos complejos paso a paso. Al contrario de otros patrones creacionales, Builder no necesita que los productos tengan una interfaz común. Esto hace posible crear distintos productos utilizando el mismo proceso de construcción.

## Uso del patrón en Python

### Ejemplos de uso

El patrón Builder es muy conocido en el mundo Python. Resulta especialmente útil cuando debes crear un objeto con muchas opciones posibles de configuración.

### Identificación

El patrón Builder se puede reconocer por la clase, que tienen un único método de creación y varios métodos para configurar el objeto resultante. A menudo, los métodos del Builder soportan el encadenamiento (por ejemplo, `algúnBuilder.establecerValorA(1).establecerValorB(2).crear()`).

## Ejemplo Conceptual

Este ejemplo ilustra la estructura del patrón de diseño Builder. Se centra en responder las siguientes preguntas:

- ¿De qué clases se compone?
- ¿Qué papeles juegan esas clases?
- ¿De qué forma se relacionan los elementos del patrón?

`main.py`: Ejemplo conceptual.

```python
from __future__ import annotations
from abc import ABC, abstractmethod
from typing import Any
```

La interfaz Builder especifica los métodos para la creación de diferentes partes de los objetos Producto.

```python
class Builder(ABC):
    @property
    @abstractmethod
    def product(self) -> None:
        pass

    @abstractmethod
    def produce_part_a(self) -> None:
        pass

    @abstractmethod
    def produce_part_b(self) -> None:
        pass

    @abstractmethod
    def produce_part_c(self) -> None:
        pass
```

Las clases de Constructores Concretos siguen la interfaz Builder y proveen implementaciones especificas de los pasos de construcción. Tu programa puede tener varias variantes de los Constructores, implementados de manera diferente.

Una instancia de constructor 'fresco' debe contener un objeto producto en blanco, el cual es usado en un montaje adicional.

```python
class ConcreteBuilder1(Builder):
    def __init__(self) -> None:
        self.reset()
    
    def reset(self) -> None:
        self._product = Product1()
```

Se supone que los constructores concretos proveen sus propios métodos para recuperar resultados. Esto es porque varios tipos de constructores pueden crear productos diferentes por completo, que no siguen la misma interfaz. Por lo tanto tales métodos no pueden ser declarados en la interfaz Builder base (al menos en un lenguaje de programación de tipado estático). Tenga en cuenta que PHP es un lenguaje de tipado dinámico y este método puede estar en la interfaz base. Sin embargo, nosotros no lo declararemos allí por el bien de la claridad.

Usualmente, después de retornar el resultado final al cliente, una instancia de construcción se espera que este lista para producir otros productos. Esto es porque es una practica usual llamar el método reset al finalizar el cuerpo del método getProduct(). Sin embargo, este comportamiento no es obligatorio, y tu puedes crear tus constructores y esperar para hacer una llamada explicita al reset desde el código cliente después de eliminar el resultado previo.

```python
    @property
    def product(self) -> Product1:
        product = self._product
        self.reset()
        return product
    
    def produce_part_a(self) -> None:
        self._product.add("PartA1")
    
    def produce_part_b(self) -> None:
        self._product.add("PartB1")

    def produce_part_c(self) -> None:
        self._product.add("PartC1")
```

Tiene sentido usar el patrón Builder solo cuando tus productos son bastantes complejos y requieres configuraciones extensas. A diferencia de otros patrones creacionales, los diferentes constructores concretos pueden producir productos no relacionados. En otras palabras, los resultados de varios constructores no podrían seguir siempre la misma interfaz.

```python
class Product1():
    def __init__(self) -> None:
        self.parts = []
    
    def add(self, part: Any) -> None:
        self.parts.append(part)
    
    def list_parts(self) -> None:
        print(f"Product parts: {', '.join(self.parts)}", end="")
```

El director es solo responsable de ejecutar los pasos de construcción en una secuencia particular. Esto es útil cuando cuando se producen productos de acuerdo a una orden especifica o una configuración. Estrictamente hablando, la clase director es opcional, desde el código cliente se puede controlar la construcción directamente.

```python
class Director:
    def __init__(self) -> None:
        self._builder = None
    
    @property
    def builder(self) -> Builder:
        return self._builder
```

El director trabaja con cualquier instancia de construcción que el código cliente le pasa. De esta manera, el código cliente puede alterar el el tipo final de los nuevos productos ensamblados.

```python
    @builder.setter
    def builder(self, builder: Builder) -> None:
        self._builder = builder
```

El director puede construir muchas variantes de productos usando los mismos pasos de construcción.

```python
    def build_minimal_viable_product(self) -> None:
        self.builder.produce_part_a()
    
    def build_full_feature_product(self) -> None:
        self.builder.produce_part_a()
        self.builder.produce_part_b()
        self.builder.produce_part_c()
```

El código cliente crea un objeto constructor, pasándolo al director e instanciando el proceso de construcción. El resultado final es recuperado del objeto constructor.

```python
if __name__ == "__main__":
    director = Director()
    builder = ConcreteBuilder1()
    director.builder = builder

    print("Standard basic product: ")
    director.build_minimal_viable_product()
    builder.product.list_parts()

    print('\n')

    print("Standard full featured product: ")
    director.build_full_feature_product()
    builder.product.list_parts()

    print('\n')
```

Recuerda, el patrón Builder puede ser usado sin una clase Director.

```python
    print("Custom product: ")
    builder.produce_part_a()
    builder.produce_part_b()
    builder.product.list_parts()
```

### Output

![out](../../../Z-IMG/builder-12.png)
