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
    // Lista de elementos (necesario)
    List<Nota> notas;
    Context context;

    // CONSTRUCTOR
    public Adapter(Context context, List<Nota> notas) {
        this.context = context;
        this.notas = notas;
    }

    // FUNCIONES HEREDADAS
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos la vista con el layout personalizado
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_nota, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Asignamos los valores a los elementos de la lista
        holder.titulo.setText(notas.get(position).getTitulo());
        holder.descripcion.setText(notas.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    // Implementamos la clase de ViewHolder anidada para optimizar
    class ViewHolder extends RecyclerView.ViewHolder {
        // Creamos los elementos de la vista
        TextView titulo, descripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Asignamos los elementos de la vista
            titulo = itemView.findViewById(R.id.titulo);
            descripcion = itemView.findViewById(R.id.descripcion);
        }
    }
}

