package ut3.act3.notas_android;

// IMPORTS
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    // Creamos una interfaz que lance la función onNotaClick()
    public interface notaListener {
        void onNotaClick(Nota nota);
    }

    // Lista de elementos
    List<Nota> notas;
    Context context;

    // Creamos un listener
    notaListener listener;

    // CONSTRUCTOR
    public Adapter(Context context, List<Nota> notas, notaListener listener) {
        this.context = context;
        this.notas = notas;
        this.listener = listener;
    }

    // FUNCIONES HEREDADAS
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_nota, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Nota nota = notas.get(position);

        // Asignamos los valores
        holder.titulo.setText(nota.getTitulo());
        holder.descripcion.setText(nota.getDescripcion());

        // Asignamos la nota al ViewHolder
        holder.setNota(nota);
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }


    // Implementamos la clase de ViewHolder anidada en el Adapter
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Creamos los elementos de la vista y el listener
        TextView titulo, descripcion;
        notaListener listener;

        // Creamos una variable para guardar la nota actual
        Nota notaActual;

        public ViewHolder(@NonNull View itemView, notaListener listener) {
            super(itemView);

            // Asignamos los elementos de la vista
            titulo = itemView.findViewById(R.id.titulo);
            descripcion = itemView.findViewById(R.id.descripcion);
            this.listener = listener;

            // Hacemos que toda la vista del item escuche los clics
            itemView.setOnClickListener(this);
        }

        // Setter para guardar la nota
        public void setNota(Nota nota) {
            this.notaActual = nota;
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onNotaClick(notaActual);
            }
        }
    }
}