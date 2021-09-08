# Singleton en TypeScript

Singleton es un patrón de diseño creacional que garantiza que tan solo exista un objeto de su tipo y proporciona un único punto de acceso a él para cualquier otro código. El patrón tiene prácticamente los mismos pros y contras que las variables globales. Aunque son muy útiles, rompen la modularidad de tu código.

No se puede utilizar una clase que dependa del Singleton en otro contexto. Tendrás que llevar también la clase Singleton. La mayoria de las veces, esta limitación aparee durante la creación de pruebas de unidad.

## Uso del patrón en TypeScript

### Ejemplos de Uso

Muchos desarrolladores consideran el patron Singleton como un antipatrón. Por este motivo, su uso está en declive en el código TypeScript.

### Identificación

El patrón Singleton se puede reconocer por un método de creación estático, que devuelve el mismo objeto guardado en caché.

## Ejemplo Conceptual

Este ejemplo ilustra la estructura del patrón de diseño Singleton y se centra en las siguientes preguntas:

- ¿De qué clases se compone?
- ¿Qué papeles juegan esas clases?
- ¿De qué forma se relacionan los elementos del patrón?

`index.ts` Ejemplo conceptual.

La clase Singleton define el método `getInstance()` que permite el acceso al cliente a la unica instancia de Singleton.

```typescript
class Singleton {
    private static instance: Singleton;
```

El constructor del Singleton siempre debe ser privado para prevenir una llamada directa al constructor por medio del operador `new`.

```typescript
    private constructor() {}
```

El método estático que controla el acceso a la instancia singleton. Esta implementación le permite a las subclases que la clase Singleton se mantenga solo una instancia de cada clase alrededor.

```typescript
    public static getInstance(): Singleton {
        if (!Singleton.instance) {
            Singleton.instance = new Singleton();
        }
        return Singleton.instance;
    }
```

Finalmente, cualquier singleton debe definir cualquier logica de negocios, la cual puede ser ejecutada en esta instancia.

```typescript
    public someBusinessLogic() {}
}
```

Código cliente.

```typescript
function clientCode() {
    const s1 = Singleton.getInstance();
    const s2 = Singleton.getInstance();

    if (s1 === s2) {
        console.log('Singleton works, both variables contain the same instance.');
    } else {
        console.log('Singleton failed, variables contain different instances.');
    }
}


clientCode();
```

### Output

![out](../../../Z-IMG/singleton-11.png)
