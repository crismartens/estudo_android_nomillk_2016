package br.edu.usj.nomilk.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.usj.nomilk.R;
import br.edu.usj.nomilk.entity.Estabelecimento;

public class AdapterEstabelecimento extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<Estabelecimento> itens;

    public AdapterEstabelecimento(Context context, ArrayList<Estabelecimento> itens) {

        this.itens = itens;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount()
    {
        return itens.size();
    }

    public Estabelecimento getItem(int position)
    {
        return itens.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent)
    {

        Estabelecimento item = itens.get(position);

        view = mInflater.inflate(R.layout.layout_list_estabelecimento, null);

        ((TextView) view.findViewById(R.id.estabelecimentolist)).setText(item.getNome());

        return view;
    }
}


