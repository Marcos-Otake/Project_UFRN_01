package com.otake.marcos.gerenciadordelivros.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.otake.marcos.gerenciadordelivros.R;
import com.otake.marcos.gerenciadordelivros.adapter.LivroAdapter;
import com.otake.marcos.gerenciadordelivros.dominio.Livro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Livro> listaLivros = new ArrayList<>();

        listaLivros.add(new Livro(1L, "Android para Leigos ","Michael Burton","Alta Books", false));
        listaLivros.add(new Livro(2L,"Android para Programadores","Paul J, Deitel","Bookman",true));
        listaLivros.add(new Livro(3L,"Desenvolvimento para Android","Griffiths, David","Alta books",false));
        listaLivros.add(new Livro(4L,"Android Base de Dados","Queirós, Ricardo","FCA Editora",true));
        listaLivros.add(new Livro(5L,"Android em Ação","King, Chris","Elsevier - Campus",false));
        listaLivros.add(new Livro(6L,"Jogos em Android","Queirós, Ricardo","FCA - Editora",true));
        listaLivros.add(new Livro(7L,"Android Essencial com Kotlin","Ricardo R.","NOVATEC",false));


        LivroAdapter livroAdapter = new LivroAdapter(listaLivros,this);

        recyclerView.setAdapter(livroAdapter);
    }
}