package com.milonsheikh.databindingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.milonsheikh.databindingrecyclerview.databinding.ItemRowBinding;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> implements ClickHandler {

    private List<DataModel> dataModelList;
    private Context context;

    public MyRecyclerViewAdapter(List<DataModel> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;
    }

    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        ItemRowBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_row, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataModel dataModel = dataModelList.get(position);
        holder.itemRowBinding.setDataModel(dataModel);
        holder.bind(dataModel);
        holder.itemRowBinding.setClickHandler(this);
    }


    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    @Override
    public void cardClicked(DataModel f) {
        System.out.println("You clicked: "+f.name);
        Toast.makeText(context, "You clicked " + f.name,Toast.LENGTH_LONG).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemRowBinding itemRowBinding;

        public ViewHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.dataModel, obj);
            itemRowBinding.executePendingBindings();
        }
    }
}