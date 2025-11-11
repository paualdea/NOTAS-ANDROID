package ut3.act3.notas_android.bd;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

/**
 * Creamos un interfaz para definir todas las funciones que podremos realizar en la base de datos
 */
@Dao
public interface NotaDAO {
    // Obtener el numero total de notas para generar un ID
    @Query("SELECT COUNT(*) FROM Notas")
    int idNota();

    // Insertar una nota
    @Insert
    void insertNota(Notas nota);

    // Obtener todas las notas
    @Query("SELECT * FROM Notas")
    List<Notas> getNotas();
}
