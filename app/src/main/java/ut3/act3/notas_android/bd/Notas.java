package ut3.act3.notas_android.bd;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Esta clase crea una entidad (tabla) en SQLite usando Room
 */
@Entity
public class Notas {
    // Cremos la PK como un ID y luego creamos el resto de campos de la tabla
    @PrimaryKey
    @NonNull
    int id;
    String titulo;
    String descripcion;

    // CONSTRUCTOR
    public Notas(int id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
