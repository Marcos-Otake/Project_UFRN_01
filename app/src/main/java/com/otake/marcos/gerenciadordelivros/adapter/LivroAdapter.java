package com.otake.marcos.gerenciadordelivros.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.otake.marcos.gerenciadordelivros.R;
import com.otake.marcos.gerenciadordelivros.dominio.Livro;

import java.util.List;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.LivroHolder> {

    private List<Livro> livros;
    private Context context;

    public LivroAdapter(List<Livro> livros, Context context) {
        this.livros = livros;
        this.context = context;
    }

    @NonNull
    @Override
    public LivroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_livro,parent,false);
        LivroHolder livroHolder = new LivroHolder(view);

        return livroHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LivroHolder holder, int position) {

        Livro livro = livros.get(position);

        holder.txtTitulo.setText(livro.getTitulo());
        holder.txtAutor.setText(livro.getAutor());
        holder.txtEditora.setText(livro.getEditora());

        if(livro.isEmprestado()){
            holder.ic_livro.setColorFilter(Color.GRAY);
        }
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    public class LivroHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        public TextView txtTitulo;
        public TextView txtAutor;
        public TextView txtEditora;
        public ImageView ic_livro;

        public LivroHolder(@NonNull View view) {
            super(view);

            txtTitulo = view.findViewById(R.id.txtTitulo);
            txtAutor = view.findViewById(R.id.txtAutor);
            txtEditora = view.findViewById(R.id.txtEditora);
            ic_livro = view.findViewById(R.id.ic_livro);

            view.setOnClickListener(this);
            view.setOnLongClickListener(this);

            
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Toast.makeText(context,"OnClick " + (pos + 1),Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View v) {
            int pos = getAdapterPosition();
            Toast.makeText(context,"onLongClick " + (pos + 1),Toast.LENGTH_SHORT).show();
            return true;
        }
    }

}
