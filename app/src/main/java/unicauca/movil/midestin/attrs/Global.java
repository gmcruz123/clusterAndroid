package unicauca.movil.midestin.attrs;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Kathe on 14/12/2016.
 */

public class Global {

    @BindingAdapter("app:imgUrl")

    public static void setImageUrl(ImageView imageView, String url){
        Context context = imageView.getContext();
        Uri uri = Uri.parse(url);
        Picasso.with(context).load(url).into(imageView);

    }
}
