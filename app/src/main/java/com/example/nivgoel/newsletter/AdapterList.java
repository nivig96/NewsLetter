package com.example.nivgoel.newsletter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.URL;
import java.util.List;

/**
 * Created by nivgoel on 07-03-2018.
 */

public class AdapterList extends ArrayAdapter<Articles>{
    private final Activity context;
    private List<Articles> articlesList;
    private LayoutInflater inflater;
    ProgressBar loader;

    public AdapterList(Activity context, List<Articles> articlesList)
    {
        super(context,R.layout.list,articlesList);
        this.context=context;
        this.articlesList = articlesList;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list, null, true);
        TextView nameTextField = (TextView) rowView.findViewById(R.id.txt);
        TextView infoTextField=(TextView) rowView.findViewById(R.id.cla);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);


        Articles articles=articlesList.get(position);
        nameTextField.setText(articles.getTitle());
        infoTextField.setText(articles.getDescription());

        loader = (ProgressBar) rowView.findViewById(R.id.loader);



        FetchImage image = new FetchImage(rowView);
        image.execute(articles.getURLtoImage());

//        Log.i("ImageUrl",articles.getURLtoImage());

        return rowView;
    }

    class FetchImage extends AsyncTask<String, Void, Bitmap>{

            View temp;
        public FetchImage(View view){
            this.temp = view;

        }
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bmp = null;
            try {

                URL url = new URL(strings[0]);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            }catch (Exception es){
                es.printStackTrace();

            }

            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap ==null){
                Log.d("FetchImage", "No Image received");
            }else{
                ImageView  a = (ImageView) temp.findViewById(R.id.img);
                a.setImageBitmap(bitmap);
                ProgressBar b = (ProgressBar) temp.findViewById(R.id.loader);
                b.setVisibility(temp.GONE);

            }
        }
    }

}
