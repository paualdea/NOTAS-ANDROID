package ut3.act3.notas_android;

// IMPORTS
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ut3.act3.notas_android.bd.NotaApplication;
import ut3.act3.notas_android.bd.NotaDatabase;
import ut3.act3.notas_android.bd.Notas;

public class NuevaNota extends AppCompatActivity {

    // Creamos los objetos de la actividad
    EditText titulo, descripcion;
    FloatingActionButton addNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Mostramos la actividad
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout_nueva_nota);

        // Creamos una instancia de la app e importamos la DB
        NotaApplication app = (NotaApplication) getApplication();
        NotaDatabase db = app.db;

        // Vinculamos los elementos
        titulo = findViewById(R.id.titulo);
        descripcion = findViewById(R.id.descripcion);
        addNota = findViewById(R.id.add);

        // Añaidmos el listener para el boton de nueva nota
        addNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recopilamos los datos de los EditText
                String tituloText = titulo.getText().toString();
                String descripcionText = descripcion.getText().toString();

                // Obtenemos el ID de la nota a crear
                int id = db.notaDao().idNota();

                // Creamos la nueva nota
                Notas nota = new Notas(id, tituloText, descripcionText);

                // La insertamos en la DB
                db.notaDao().insertNota(nota);

                // Finalizamos la actividad
                finish();
            }
        });

    }
}
