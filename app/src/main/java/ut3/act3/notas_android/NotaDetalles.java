package ut3.act3.notas_android;

// IMPORTS
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NotaDetalles extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Vinculamos el layout a la actividad
        setContentView(R.layout.layout_nota_detalles);

        // Recoger el intent que ha iniciado la actividad
        Intent intent = getIntent();

        // Obtenemos las variables que adjuntamos en el intent
        String tituloTexto = intent.getStringExtra("titulo");
        String descripcionTexto = intent.getStringExtra("descripcion");

        // Vinculamos los elementos con la actividad y les damos los valores recibidos
        FloatingActionButton volver = findViewById(R.id.volver);
        TextView titulo = findViewById(R.id.titulo);
        titulo.setText(tituloTexto);
        TextView descripcion = findViewById(R.id.descripcion);
        descripcion.setText(descripcionTexto);

        // Asignamos un listener al boton de volver
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finalizamos la actividad y regresa a la anterior
                finish();
            }
        });
    }
}
