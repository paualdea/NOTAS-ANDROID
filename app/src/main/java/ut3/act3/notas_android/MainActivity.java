package ut3.act3.notas_android;

// IMPORTS
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Actividad principal de la aplicación.
 *
 * @author Pau Aldea Batista
 * @version 1.0.0
 */
public class MainActivity extends AppCompatActivity implements Adapter.notaListener {
    // Creamos el RecyclerView
    RecyclerView vistaNotas;

    // Creamos la lista de notas
    List<Nota> notas = new ArrayList<Nota>();


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

        // Asignamos y declaramos el RecyclerView con su adaptador y su layout manager
        vistaNotas = findViewById(R.id.vistaNotas);
        vistaNotas.setLayoutManager(new LinearLayoutManager(this));

        Adapter adapter = new Adapter(getApplicationContext(), notas, this);
        vistaNotas.setAdapter(adapter);

        // Creamos 3 notas que añadimos a la lista
        notas.add(new Nota("Nota 1", "prueba"));
        notas.add(new Nota("Nota 2", "prueba"));
        notas.add(new Nota("Nota 3", "pruebajldajskdljaslkdjlaksjdlkasjdlkasjdlkasjdlkasjdlkajsdlkajsdlkasjdlkajsdlkajsdlkjasldkjaslkdasjlk"));
        notas.add(new Nota("Prueba 3", "jay"));

        // Notificamos al adaptador que hay nueva info
        adapter.notifyDataSetChanged();
    }

    /**
     * Función que ejecuta al hacer clic en una nota.
     * Recibe como parametro una Nota.
     *
     * @param nota
     */
    @Override public void onNotaClick(Nota nota) {
        Log.d("CLIC", "Se ha hecho click en la nota " + nota.getTitulo() + ".");
    }
}