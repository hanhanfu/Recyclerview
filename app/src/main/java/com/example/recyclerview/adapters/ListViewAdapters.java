package com.example.recyclerview.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.beans.ItemBean;

import java.util.List;

public class ListViewAdapters extends RecyclerView.Adapter<ListViewAdapters.InnerHolder>{

    private final List<ItemBean> mData;
    private View inflate;

    public ListViewAdapters(List<ItemBean> data ){
        this.mData = data;
    }
    @NonNull
    @Override
    public ListViewAdapters.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewAdapters.InnerHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData != null){
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private  ImageView icon;
        private  TextView title;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);

            icon = (ImageView) itemView.findViewById(R.id.list_view_icon);
            title = (TextView) itemView.findViewById(R.id.list_view_title);
        }

        public void setData(ItemBean itemBean) {

            icon.setImageResource(itemBean.icon);
            title.setText(itemBean.title);
        }
    }
}
