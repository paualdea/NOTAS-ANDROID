package ut3.act3.notas_android;

// IMPORTS
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ut3.act3.notas_android.bd.NotaApplication;
import ut3.act3.notas_android.bd.NotaDatabase;
import ut3.act3.notas_android.bd.Notas;

/**
 * Actividad principal de la aplicación.
 *
 * @author Pau Aldea Batista
 * @version 1.0.0
 */
public class MainActivity extends AppCompatActivity implements Adapter.notaListener {
    // Creamos el RecyclerView y su adaptador
    RecyclerView vistaNotas;
    Adapter adapter;

    // Creamos la lista de notas
    List<Nota> notas = new ArrayList<Nota>();

    // Creamos la lista de notas de la DB y la DB
    List<Notas> notasDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Mostramos la actividad
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Habilitamos características de visualización modernas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Creamos el boton y lo vinculamos desde el layout
        FloatingActionButton addNota = findViewById(R.id.addNota);

        // Asignamos y declaramos el RecyclerView con su adaptador y su layout manager
        vistaNotas = findViewById(R.id.vistaNotas);
        vistaNotas.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(getApplicationContext(), notas, this);
        vistaNotas.setAdapter(adapter);

        // Creamos una instancia de la app e importamos la DB
        NotaApplication app = (NotaApplication) getApplication();
        NotaDatabase db = app.db;

        // Obtenemos todas las notas de la DB
        notasDB = db.notaDao().getNotas();

        // Traducimos las notas para la lista de notas del RecyclerView
        for (int i = 0; i < notasDB.size(); i++) {
            notas.add(new Nota(notasDB.get(i).getTitulo(), notasDB.get(i).getDescripcion()));
        }

        // Notificamos al adaptador que hay nueva info
        adapter.notifyDataSetChanged();

        // Añaidmos el listener para el boton de nueva nota
        addNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos un INTENT para cambiar de actividad
                Intent intent = new Intent(MainActivity.this, NuevaNota.class);

                // Lanzamos el intent
                startActivity(intent);
            }
        });
    }

    /**
     * Se ejecuta esta función cada vez que volvemos de otra actividad
     */
    @Override
    protected void onResume() {
        super.onResume();

        // Limpiamos la lista de notas
        notas.clear();

        // Obtenemos la DB
        NotaApplication app = (NotaApplication) getApplication();
        NotaDatabase db = app.db;

        // Obtenemos todas las notas de la DB
        notasDB = db.notaDao().getNotas();

        // Actualizamos la lista de notas
        for (int i = 0; i < notasDB.size(); i++) {
            notas.add(new Nota(notasDB.get(i).getTitulo(), notasDB.get(i).getDescripcion()));
        }

        // Actualizamos el adapter
        adapter.notifyDataSetChanged();
    }

    /**
     * Función que ejecuta al hacer clic en una nota.
     * Recibe como parametro una Nota.
     *
     * @param nota
     */
    @Override public void onNotaClick(Nota nota) {
        // Creamos un INTENT para cambiar de actividad
        Intent intent = new Intent(this, NotaDetalles.class);

        // Añadimos los parametros de la nota clicada a la actividad
        intent.putExtra("titulo", nota.getTitulo());
        intent.putExtra("descripcion", nota.getDescripcion());

        // Lanzamos el intent
        startActivity(intent);
    }
}