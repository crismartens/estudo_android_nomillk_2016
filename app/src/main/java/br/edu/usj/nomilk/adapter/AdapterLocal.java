package br.edu.usj.nomilk.adapter;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.usj.nomilk.R;
import br.edu.usj.nomilk.entity.MeuLocal;

public class AdapterLocal extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<MeuLocal> itens;


    public AdapterLocal(Context context, ArrayList<MeuLocal> itens) {

        this.itens = itens;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return itens.size();
    }

    public MeuLocal getItem(int position) {
        return itens.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {


            MeuLocal item = itens.get(position);

            view = mInflater.inflate(R.layout.layout_list_locais, null);

            ((TextView) view.findViewById(R.id.meulocal)).setText(item.getEstabelecimento());
            ((TextView) view.findViewById(R.id.datalocal)).setText(item.getData());
            ((TextView) view.findViewById(R.id.regiaolocal)).setText(item.getRegiao());
            ((TextView) view.findViewById(R.id.statuslocal)).setText(item.getStatus());

            return view;
        }
    }



