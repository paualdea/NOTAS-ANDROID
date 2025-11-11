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

        // TODO DESCOMENTAR ESTA LÍNEA SI QUEREMOS QUE SE RESETEE LA BD CADA VEZ QUE EJECUTEMOS LA APLICACION
        // db.clearAllTables();
    }
}
