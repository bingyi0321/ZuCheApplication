package com.example.zucheapplication.entity.car;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zucheapplication.R;
import com.example.zucheapplication.util.MyApplication;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author bingyi
 * @ClassName CarInfoItemAdapter
 * @Description 车辆信息项
 * email 1005196988@qq.com
 * Created by bingyi on 2021/7/2/0002 16:26
 */
public class CarInfoItemAdapter extends RecyclerView.Adapter<CarInfoItemAdapter.CarInfoItemViewHolder> {

    private final List<Car> data;

    public CarInfoItemAdapter(List<Car> data) {
        this.data = data;
    }


    @NonNull
    @NotNull
    @Override
    public CarInfoItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_info, parent,
                false);
        return new CarInfoItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CarInfoItemViewHolder holder, int position) {
        Car car = data.get(position);
        //Glide.with(context).load(imageUrl).placeholder(R.mipmap.ic_launcher).into(imageView);
        Glide.with(MyApplication.getContext()).load(car.getCar_image()).placeholder(R.mipmap.ic_launcher).into(holder.imageCar);
        //Picasso.with(MyApplication.getContext()).load(Uri.parse(car.getCar_image())).into(holder.imageCar);
        holder.txtCarPlate.setText(car.getCar_plate());
        holder.txtCarBrand.setText(car.getCar_brand());
        holder.txtCarType.setText(car.getCar_type());
        holder.txtPrice.setText(String.format(Locale.CHINA, "%.2f", car.getPrice()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class CarInfoItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageCar;
        TextView txtCarPlate;
        TextView txtCarBrand;
        TextView txtCarType;
        TextView txtPrice;

        public CarInfoItemViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageCar = itemView.findViewById(R.id.image_car);
            txtCarPlate = itemView.findViewById(R.id.txt_car_plate);
            txtCarBrand = itemView.findViewById(R.id.txt_car_brand);
            txtCarType = itemView.findViewById(R.id.txt_car_type);
            txtPrice = itemView.findViewById(R.id.txt_car_price);
        }
    }
}
