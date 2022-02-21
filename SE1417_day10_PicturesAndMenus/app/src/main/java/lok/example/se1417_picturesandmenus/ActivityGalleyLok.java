package lok.example.se1417_picturesandmenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ActivityGalleyLok extends AppCompatActivity {
    private Integer[] imageIDs = {
            R.drawable.pic01,
            R.drawable.pic02,
            R.drawable.pic03,
    };

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;

        public ImageAdapter(Context context) {
            this.context = context;
            TypedArray arr = this.context.obtainStyledAttributes(R.styleable.GalleryLokDQ);
            itemBackground = arr.getResourceId(R.styleable.GalleryLokDQ_android_galleryItemBackground,0);
        }
        @Override
        public int getCount() {
            return imageIDs.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;
            if (view == null) {
                imageView = new ImageView(this.context);
                imageView.setImageResource(imageIDs[i]);
                imageView.setLayoutParams(new Gallery.LayoutParams(200,140));
            } else {
                imageView = (ImageView) view;
            }
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galley_lok);
        Gallery gallery = findViewById(R.id.galleryViewsLokDQ);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imageView = findViewById(R.id.imageViewLokDQ);
                imageView.setBackgroundResource(imageIDs[i]);
            }
        });
    }
}