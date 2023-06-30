package fr.william.weatherapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.william.weatherapp.R;
import fr.william.weatherapp.models.City;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<City> mCities;

    // Constructor
    public FavoriteAdapter(Context mContext, ArrayList<City> mCities) {
        this.mContext = mContext;
        this.mCities = mCities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_favorite_city, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        City city = mCities.get(position);
        holder.mTextViewCity.setText(city.mName);
        holder.mTextViewTemperature.setText(city.mTemperature);
        holder.mTextViewDescription.setText(city.mDescription);
        holder.mImageViewWeatherIcon.setImageResource(city.mWeatherIcon);
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    // Classe holder qui contient la vue d’un item
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewCity;
        ImageView mImageViewWeatherIcon;
        TextView mTextViewTemperature;
        TextView mTextViewDescription;

        public ViewHolder(TextView view) {
            super(view);
            mTextViewCity = (TextView) view.findViewById(R.id.text_view_item_city_name);
            mImageViewWeatherIcon = (ImageView) view.findViewById(R.id.image_view_item_picture);
            mTextViewTemperature = (TextView) view.findViewById(R.id.text_view_item_temperature);
            mTextViewDescription = (TextView) view.findViewById(R.id.text_view_item_description);
        }

        public ViewHolder(View view) {
            super(view);
        }
    }
}
