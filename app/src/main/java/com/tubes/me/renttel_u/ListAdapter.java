package com.tubes.me.renttel_u;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by USER on 13-Nov-16.
 */

public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Listnya> mListnyaList;

    public ListAdapter(Context mContext, List<Listnya> mListnyaList) {
        this.mContext = mContext;
        this.mListnyaList = mListnyaList;
    }

    @Override
    public int getCount() {
        return mListnyaList.size();
    }

    @Override
    public Object getItem(int position) {
        return mListnyaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.list_item, null);
        TextView tvnamamotor = (TextView)v.findViewById(R.id.namamotor);
        TextView tvnamarental = (TextView)v.findViewById(R.id.namarental);
        TextView tvharga = (TextView)v.findViewById(R.id.harga);

        tvnamamotor.setText(mListnyaList.get(position).getNamamotor());
        tvnamarental.setText(mListnyaList.get(position).getNamarental());
        /*tvharga.setText(String.valueOf(mListnyaList.get(position).getHarga()) + " Rp. ");*/
        tvharga.setText(String.valueOf("Rp." + mListnyaList.get(position).getHarga() + "/24 jam"));

        v.setTag(mListnyaList.get(position).getId());

        return v;
    }
}
