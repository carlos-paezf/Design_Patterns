# Adapter

## Propósito

Adapter (también llamado Adaptador, Envoltorio, Wrapper), es un patrón de diseño estructural que permite la colaboración entre objetos con interfaces incompatibles.

![a](../../Z-IMG/adapter-1.png)

## Problema

Imagina que estás creando una aplicación de monitoreo del mercado de valores. La aplicación descarga la información de bolsa desde varias fuentes en formato XML para presentarla al usuario con bonitos gráficos y diagramas.

En cierto momento, decides mejorar la aplicación integrando una inteligente biblioteca de análisis de una tercera persona. Pero hay una trampa: la biblioteca de análisis solo funciona con datos en formato JSON. No puedes utilizar la biblioteca de análisis "tal cual" porque ésta espera los datos en un formato que es incompatible con tu aplicación.

![a](../../Z-IMG/adapter-2.png)

Podrías cambiar la biblioteca para que funcione con XML. Sin embargo, esto podría descomponer parte del código existente que depende de la biblioteca. Y lo que es peor, podrías no tener siquiera acceso al código fuente de la biblioteca, lo que hace imposible esta solución.

## Solución

Puedes crear un adaptador. Se trata de un objeto especial que convierte la interfaz de un objeto, de forma que otro objeto pueda comprenderla. Un adaptador envuelve uno de los objetos para esconder la complejidad de la conversión que tiene lugar tras bambalinas. El objeto envuelto ni siquiera es consciente de la existencia del adaptador. Por ejemplo, puedes envolver un objeto que opera con metros y kilómetros con un adaptador que convierte todos los datos al sistema anglosajón, es decir, pies y millas.

Los adaptadores no solo convierten datos a varios formatos, sino que también ayudan a objetos con distintas interfaces a colaborar. Funciona así:

1. El adaptador obtiene una interfaz compatible con uno de los objetos existentes.
2. Utilizando esta interfaz, el objeto existente puede invocar con seguridad los métodos del adaptador.
3. Al recibir una llamada, el adaptador pasa la solicitud al segundo objeto, pero en un formato y orden que ese segundo espera.
4. En ocasiones se puede incluso crear un adaptador de dos direcciones que pueda convertir las llamadas en ambos sentidos.

![a](../../Z-IMG/adapter-3.png)

Regresamos a nuestra aplicación del mercado de valores. Para resolver el dilema de los formatos incompatibles, puedes crear adaptadores de XML a JSON para cada clase de la biblioteca de análisis con la que trabaje tu código directamente. Después ajustas tu código para que se comunique con la biblioteca únicamente a través de estos adaptadores. Cuando un adaptador recibe una llamada, traduce los datos XML entrantes a una estructura JSON y pasa la llamada a los métodos adecuados de un objeto de análisis envuelto.

## Analogía en el mundo real

Cuando viajas de Europa a Estados Unidos por primera vez, puede ser que te lleves una sorpresa cuando intentes cargar tu computadora portátil. Los tipos de enchufe son diferentes en cada país, por lo que un enchufe español no sirve en Estados Unidos. El problema puede solucionarse utilizando un adaptador que incluya el enchufe americano y el europeo. Una maleta antes y después de un viaje al extranjero.

![a](../../Z-IMG/adapter-4.png)

## Estructura

### Adaptador de objetos

Esta implementación utiliza el principio de composición de objetos: el adaptador implementa la interfaz de un objeto y envuelve el otro. Puede implementarse en todos los lenguajes de programación populares.

![a](../../Z-IMG/adapter-5.png)

1. La clase **Cliente** contiene la lógica de negocio existente del programa.
2. La **Interfaz con el Cliente** describe un protocolo que otras clases deben seguir para poder colaborar con el código cliente.
3. **Servicio** es alguna clase útil (normalmente de una tercera parte o heredada). El cliente no puede utilizar directamente esta clase porque tienen una interfaz incompatible.
4. La clase **Adaptadora** es capaz de trabajar tanto con la clase cliente como con la clase de servicio: implementa la interfaz con el cliente, mientras envuelve el objeto de la clase de servicio. La clase adaptadora recibe llamadas del cliente a través de la interfaz adaptadora y las traduce en llamadas al objeto envuelto de la clase de servicio, pero en un formato que pueda comprender.
5. El código cliente no se acopla a la clase adaptadora concreta siempre y cuando funcione con la clase adaptadora a través de la interfaz con el cliente. Gracias a esto, puede introducir nuevos tipos de adaptadores en el programa sin descomponer el código cliente existente. Esto puede resultar útil cuando la interfaz de la clase de servicio se cambia o sustituye.

### Clase Adaptadora

Esta implementación utiliza la herencia, porque la clase adaptadora hereda interfaces de ambos objetos al mismo tiempo. Ten en cuenta que esta opción sólo puede implementarse en lenguajes de programación que soporten la herencia múltiple, como C++.

![a](../../Z-IMG/adapter-6.png)

1. La **Clase Adaptadora** no necesita envolver objetos porque hereda comportamientos tanto de la clase cliente como de la clase de servicio. La adaptación tiene lugar dentro le los métodos sobrescritos. La clase adaptadora resultante puede utilizarse en lugar de una clase cliente existente.

## Pseudocódigo

Este ejemplo del patrón Adapter se basa en el clásico conflicto entre piezas cuadradas y agujeros redondos.

![a](../../Z-IMG/adapter-7.png)

El patrón Adapter finge ser una pieza redonda con un radio igual a la mitad del diámetro del cuadrado (en otras palabras, el radio del circulo más pequeño en el que quepa la pieza cuadrada).

### Código

```nim
class RoundHole is
    constructor RoundHole(radius) {...}

    method getRadius() is

    method fits(pag: RoundPeg) is
        return this.getRadius() >= peg.getRadius()


class RoundPeg is
    constructor RoundPeg(radius) {...}

    method getRadius() is


class SquarePeg is
    constructor SquarePeg(width) {...}

    method getWidth() is


class SquarePegAdapter extends RoundPeg is
    private field peg: SquarePeg

    constructor SquarePegAdapter(peg: SquarePeg) is
        this.peg = peg

    method getRadius() is
        return peg.getWidth() * Math.sqrt(2) / 2


hole = new RoundHole(5)
rpeg = new RoundPeg(5)
hole.fits(rpeg)

small_sqpeg = new SquarePeg(5)
large_sqpeg = new SquarePeg(10)
hole.fits(small_sqpeg)

small_sqpeg_adapter = new SquarePegAdapter(small_sqpeg)
large_sqpeg_adapter = new SquarePegAdapter(large_sqpeg)
hole.fits(small_sqpeg_adapter)
hole.fits(large_sqpeg_adapter)
```

### Explicación del Código

Digamos que tienes 2 clases con interfaces compatibles: `RoundHole` (Hoyo Redondo) y `RoundPeg` (Pieza Redonda).

```nim
class RoundHole is
    constructor RoundHole(radius) {...}
```

Devuelve el radio del agujero.

```nim
    method getRadius() is

    method fits(pag: RoundPeg) is
        return this.getRadius() >= peg.getRadius()


class RoundPeg is
    constructor RoundPeg(radius) {...}
```

Devuelve el radio de la pieza.

```nim
    method getRadius() is
```

Pero hay una clase incompatible: `SquarePeg` (Pieza Cuadrada)

```nim
class SquarePeg is
    constructor SquarePeg(width) {...}
```

Devuelve la anchura de la pieza cuadrada.

```nim
    method getWidth() is
```

Una clase adaptadora te permite encajar piezas cuadradas en hoyos redondos. Extiende la clase `RoundPeg` para permitir a los objetos adaptadores actuar como piezas redondas.

En realidad, el adaptador contiene una instancia de la clase `SquarePeg`.

```nim
class SquarePegAdapter extends RoundPeg is
    private field peg: SquarePeg

    constructor SquarePegAdapter(peg: SquarePeg) is
        this.peg = peg
```

El adaptador simula que es una pieza redonda con un radio que pueda albergar la pieza cuadrada que el adaptador envuelve.

```nim
    method getRadius() is
        return peg.getWidth() * Math.sqrt(2) / 2
```

En algún punto del código cliente. Esta primera instancia retornara verdadero.

```nim
hole = new RoundHole(5)
rpeg = new RoundPeg(5)
hole.fits(rpeg)
```

Pero esta instancia no va a compilar, son tipos incompatibles.

```nim
small_sqpeg = new SquarePeg(5)
large_sqpeg = new SquarePeg(10)
hole.fits(small_sqpeg)
```

Al usar el adapter permitimos que se compile, y podemos obtener:

```nim
small_sqpeg_adapter = new SquarePegAdapter(small_sqpeg)
large_sqpeg_adapter = new SquarePegAdapter(large_sqpeg)
```

Verdadero

```nim
hole.fits(small_sqpeg_adapter)
```

Falso

```nim
hole.fits(large_sqpeg_adapter)
```

## Aplicabilidad

- Utiliza la clase adaptadora cuando quieras usar una clase existente, pero cuya interfaz no sea compatible con el resto del código.

  El patrón Adapter te permite crear una clase intermedia que sirva como traductora entre tu código y una clase heredada, una clase de un tercero o cualquier otra clase con una interfaz extraña.

- Utiliza el patrón cuando quieras reutilizar varias subclases existentes que carezcan de alguna funcionalidad común que no pueda añadirse a la superclase.

  Puedes extender cada subclase y colocar la funcionalidad que falta, dentro de las nuevas clases hijas. No obstante, deberás duplicar el código en todas estas nuevas clases, lo cual huele muy mal.

  Una solución mucho más elegante sería colocar la funcionalidad que falta dentro una clase adaptadora. Después puedes envolver objetos a los que les falten funciones, dentro de la clase adaptadora, obteniendo esas funciones necesarias de un modo dinámico. Para que esto funcione, las clases en cuestión deben tener una interfaz común y el campo de la clase adaptadora debe seguir dicha interfaz. Este procedimiento es muy similar al del patrón **Decorator**.

## Cómo Implementarlo

1. Asegúrate de que tienes al menos dos clases con interfaces incompatibles:
   - Una útil clase *servicio* que no puedes cambiar (a menudo de un tercero, heredada o con muchas dependencias existentes).
   - Una o varias clases *cliente* que se beneficiarían de contar con una clase de servicio.
2. Declara la interfaz con el cliente y describe el modo en que las clases cliente se comunican con la clase de servicio.
3. Crea la clase adaptadora y haz que siga la interfaz con el cliente. Deja todos los métodos vacios por ahora.
4. Añade un campo a la clase adaptadora para almacenar una referencia al objeto de servicio. La práctica común es inicializar este campo a través del constructor, pero en ocasiones es adecuado pasarlo al adaptador cuando se invocan sus métodos.
5. Uno por uno, implementa todos los métodos de la interfaz con el cliente en la clase adaptadora. La clase adaptadora deberá delegar la mayor parte del trabajo real al objeto de servicio, gestionando tan solo la interfaz o la conversión de formato de los datos.
6. Las clases cliente deberán utilizar la clase adaptadora a través de la interfaz con el cliente. Esto te permitirá cambiar o extender las clases adaptadoras sin afectar al código cliente.

## Pros y Contras

|Pros|Contras|
|--|--|
|*Principio de Responsabilidad única*. Puedes separar la interfaz o el código de conversión de datos de la lógica de negocio primaria del programa.|La complejidad general del código aumenta, ya que debes introducir un grupo de nuevas interfaces y clases. En ocasiones resulta más sencillo cambiar la clase de servicio de modo que coincida con el resto de tu código|
|*Principio de abierto/cerrado*. Puedes introducir nuevos tipos de adaptadores al programa sin descomponer el código cliente existente, siempre y cuando trabajen con los adaptadores a través de la interfaz con el cliente||

## Relaciones con otros patrones

- Bridge suele diseñarse con anticipado, lo que te permite desarrollar parte de una aplicación de forma independiente entre sí. Por otro lado, Adapter se utiliza habitualmente con una aplicación existente para hacer que unas clases que de otro modo serían incompatibles, trabajen juntas sin problemas.
- Adapter cambia la interfaz de un objeto existente mientras que Decorator mejora un objeto sin cambiar su interfaz. Además, Decorator soporta la composición recursiva, lo cual no es posible al utilizar Adapter.
- Adapter proporciona una interfaz diferente al objeto envuelto, Proxy le proporciona la misma interfaz y Decorator le proporciona una interfaz mejorada.
- Facade define una nueva interfaz para objetos existentes, mientras que Adapter intenta hacer que la interfaz existente sea utilizable. Normalmente Adapter sólo envuelve un objeto, mientras que Facade trabaja con todo un subsistema de objetos.
- Bridge, State, Strategy (y, hasta cierto punto, Adapter) tienen estructuras muy similares. De hecho, todos estos patrones se basa en la composición, que consiste en delegar trabajo a otros objetos. Sin embargo, todos ellos solucionan problemas diferentes. Un patrón no es simplemente una receta para estructurar tu código de una forma especifica. También puede comunicar a otros desarrolladores el problema que resuelve.
