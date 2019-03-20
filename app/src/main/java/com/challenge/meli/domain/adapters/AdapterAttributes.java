package com.challenge.meli.domain.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.challenge.meli.R;
import com.challenge.meli.domain.models.Attribute;

import java.util.ArrayList;
import java.util.List;

public class AdapterAttributes extends RecyclerView.Adapter<AdapterAttributes.ViewHolder> {

    private List<Attribute> attributes = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_attribute_product, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(attributes.get(i));
    }

    @Override
    public int getItemCount() {
        return attributes.size();
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        Attribute attribute;

        TextView name;
        TextView value;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            value = itemView.findViewById(R.id.value);
        }

        void bind(Attribute attribute) {
            this.attribute = attribute;
            String sName = this.attribute.getName() + ":";
            String sValue = this.attribute.getValueName();

            name.setText(sName);
            if (sValue == null) {
                sValue = "-";
            }
            value.setText(sValue);
        }
    }
}
