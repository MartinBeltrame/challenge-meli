package com.challenge.meli.domain.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.challenge.meli.R;
import com.challenge.meli.domain.interfaces.ListenerProduct;
import com.challenge.meli.domain.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ViewHolder> {

    private List<Product> products = new ArrayList<>();
    private ListenerProduct listenerProduct;

    public AdapterProducts(ListenerProduct listenerProduct) {
        this.listenerProduct = listenerProduct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(products.get(i));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Product product;

        ImageView image;
        TextView title;
        TextView price;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_product);
            title = itemView.findViewById(R.id.title_product);
            price = itemView.findViewById(R.id.price_product);
            itemView.setOnClickListener(this);
        }

        void bind(Product product) {
            this.product = product;
            title.setText(this.product.getTitle());
            price.setText(String.valueOf("$ " + this.product.getPrice()));
            Picasso.get().load(this.product.getThumbnail()).into(image);
        }

        @Override
        public void onClick(View v) {
            listenerProduct.selectProduct(product.getId());
        }
    }
}

