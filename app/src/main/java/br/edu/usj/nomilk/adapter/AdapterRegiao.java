package br.edu.usj.nomilk.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.usj.nomilk.R;
import br.edu.usj.nomilk.entity.Região;


public class AdapterRegiao extends BaseAdapter {

        private LayoutInflater mInflater;
        private ArrayList<Região> itens;

        public AdapterRegiao(Context context, ArrayList<Região> itens) {

            this.itens = itens;
            mInflater = LayoutInflater.from(context);
        }

        public int getCount()
        {
            return itens.size();
        }

        public Região getItem(int position)
        {
            return itens.get(position);
        }

        public long getItemId(int position)
        {
            return position;
        }

        public View getView(int position, View view, ViewGroup parent)
        {

            Região item = itens.get(position);

            view = mInflater.inflate(R.layout.layout_list_regiao, null);

            ((TextView) view.findViewById(R.id.regiaolist)).setText(item.getRegiao());

            return view;
        }
    }


