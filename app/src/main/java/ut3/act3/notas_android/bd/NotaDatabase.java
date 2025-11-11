package ut3.act3.notas_android.bd;

import androidx.room.RoomDatabase;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;

// Declaramos las tablas de la DB, en este caso, sólo Nota
@Database(entities = {Notas.class}, version = 1, exportSchema = false)
public abstract class NotaDatabase extends RoomDatabase {
    public abstract NotaDAO notaDao();
}
