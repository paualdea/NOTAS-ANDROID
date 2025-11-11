# Persistencia con Room - SQLite (Android)

Este proyecto es una aplicación Android sencilla desarrollada como parte de la **Actividad 3: "Persistencia de notas con SQLite/Room"** de la Unidad 3 del curso de **Programación Multimedia y Dispositivos Móviles**.

Simula una aplicación de notas en la que podemos crear y ver las notas usando `Intent`. Podemos activar o desactivar la persistencia total (base de datos que guarda incluso si cerramos la aplicación) editando el siguiente fichero:

`NotaAplicacion.java` (dentro del paquete `db`)
```java
package ut3.act3.notas_android.bd;

import android.app.Application;
import androidx.room.Room;

/**
 * Esta clase crea una aplicación que podemos usar en todas las clases en la que acceder a la BD
*/
public class NotaApplication extends Application {
    public NotaDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();

        // Creamos la DB
        db = Room.databaseBuilder(getApplicationContext(), NotaDatabase.class, "notas").allowMainThreadQueries().build();

        // DESCOMENTAR ESTA LÍNEA SI QUEREMOS QUE SE RESETEE LA BD CADA VEZ QUE EJECUTEMOS LA APLICACION
        // db.clearAllTables();
    }
}
```
Debemos editar la linea 20 de este fichero para desactivar / activar la persistencia.

El objetivo principal es poner en práctica la comunicación entre actividades (pasando información), la implementación de una BD con `Room` y `SQLite` y procesar su información en un `RecyclerView`.


## Cómo Ejecutar el Proyecto (PC)

1.  Clona este repositorio en tu máquina local.
2.  Abre el proyecto con Android Studio.
3.  Ejecuta la aplicación en un emulador de Android o en un dispositivo físico.

## Cómo Ejecutar el Proyecto (Android)

1. Descarga la APK de la _release_
2. Instala la aplicación
3. Ejecuta la aplicación normalmente

---
_Este proyecto sirve como control de versiones y evidencia del trabajo realizado para la asignatura._
