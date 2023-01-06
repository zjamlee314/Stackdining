package com.stackdining.www.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Evan
 * on 2022/3/4
 */
public class ImageUtil {

    /**
     * @param context
     * @param dp
     * @return dip转pix
     */
    public static int dp2px(Context context, float dp) {
        if (context != null && dp != 0) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dp * scale + 0.5f);
        }
        return (int) dp;
    }

    //将字符串转化成Drawable
    public synchronized static Drawable StringToDrawable(String icon) {
        if (icon == null || icon.length() < 10)
            return null;
        byte[] img = Base64.decode(icon.getBytes(), Base64.DEFAULT);
        Bitmap bitmap;
        if (img != null) {
            bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
            @SuppressWarnings("deprecation")
            Drawable drawable = new BitmapDrawable(bitmap);

            return drawable;
        }
        return null;
    }

    /**
     * glide默认图设置圆角
     */
    public static void GlideDefaultImgRadius(Context context, int drawable, String url, int Radius, ImageView imageView){
        RequestOptions options = new RequestOptions()
                .placeholder(drawable)
                .error(drawable)
                .transform(new CenterCrop(), new RoundedCorners(Radius));

        Glide.with(context).load(url)
                .thumbnail(loadTransform(context, drawable, Radius))
                .apply(options).into(imageView);
    }

    private static RequestBuilder<Drawable> loadTransform(Context context, @DrawableRes int placeholderId, int radius) {
        return Glide.with(context)
                .load(placeholderId)
                .apply(new RequestOptions().transform(new CenterCrop(), new RoundedCorners(radius)));

    }

}

