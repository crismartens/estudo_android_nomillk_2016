package br.edu.usj.nomilk.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.usj.nomilk.entity.MeuLocal;

public class LocalDAO implements NoMilkDAO<MeuLocal> {

    private DataBaseHelper dbHelper;

    public static final String NOME_TABELA = "meulocal";
    public static final String ID = "_id";
    public static final String ESTABELECIMENTO = "estabelecimento";
    public static final String DATA = "data";
    public static final String REGIAO = "regiao";
    public static final String STATUS = "status";

    private String camposTabela =
            ID + " ,  " +
                    ESTABELECIMENTO + ", " +
                    DATA + ", " +
                    REGIAO + ", " +
                    STATUS;

    private static String camposCriarTabela =
            ID + " INTEGER PRIMARY KEY,  " +
                    ESTABELECIMENTO + " TEXT, " +
                    DATA + " TEXT, " +
                    REGIAO + " TEXT, " +
                    STATUS + " TEXT";

    public LocalDAO(Context contexto) {
        dbHelper = new DataBaseHelper(contexto);
    }

    public static String criarTabela() {
        return "CREATE TABLE " + NOME_TABELA + " (" + camposCriarTabela + ");";
    }

    public boolean salvar(MeuLocal local) {

        ContentValues values = new ContentValues();

        values.put(ESTABELECIMENTO, local.getEstabelecimento());
        values.put(DATA, local.getData());
        values.put(REGIAO, local.getRegiao());
        values.put(STATUS, local.getStatus());

        SQLiteDatabase bd = dbHelper.getWritableDatabase();
        long resultado = bd.insert(NOME_TABELA, null, values);
        return resultado != -1;
    }

    public long update(MeuLocal local){

        ContentValues values = new ContentValues();

        values.put(ID,local.getId());
        values.put(ESTABELECIMENTO, local.getEstabelecimento());
        values.put(DATA, local.getData());
        values.put(REGIAO, local.getRegiao());
        values.put(STATUS, local.getStatus());

        SQLiteDatabase bd = dbHelper.getWritableDatabase();
        long resultado = bd.update(NOME_TABELA, values, ID + " = ?",
        new String[]{local.getId().toString()});

        return resultado;
    }

    public boolean remover(String id) {
        SQLiteDatabase bd = dbHelper.getWritableDatabase();
        int removidos = bd.delete(NOME_TABELA, ID+" = ?", new String[]{id});
        return removidos > 0;
    }


    public MeuLocal obter(String id) {
        return null;
    }

    public List<MeuLocal> listarPorId(String id) {
        return null;
    }

    public List<MeuLocal> listarTodos() {
        SQLiteDatabase bd = dbHelper.getReadableDatabase();
        String query = "SELECT  "+camposTabela +" FROM "+NOME_TABELA ;
        Cursor cursor = bd.rawQuery(query, null);
        cursor.moveToFirst();
        List<MeuLocal> locais = new ArrayList<MeuLocal>();

        for(int i=0; i < cursor.getCount(); i++){
            MeuLocal local = new MeuLocal();
            preencherLocal(local, cursor);
            locais.add(local);
            cursor.moveToNext();
        }

        cursor.close();
        return locais;
    }


    public void fecharConexao() {
        dbHelper.close();
    }

    private void preencherLocal(MeuLocal local, Cursor cursor){
        local.setId(cursor.getInt(cursor.getColumnIndex(ID)));
        local.setEstabelecimento(cursor.getString(cursor.getColumnIndex(ESTABELECIMENTO)));
        local.setData(cursor.getString(cursor.getColumnIndex(DATA)));
        local.setRegiao(cursor.getString(cursor.getColumnIndex(REGIAO)));
        local.setStatus(cursor.getString(cursor.getColumnIndex(STATUS)));
    }
}
