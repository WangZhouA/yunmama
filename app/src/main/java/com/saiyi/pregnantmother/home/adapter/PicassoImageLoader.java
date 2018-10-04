package com.saiyi.pregnantmother.home.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

import java.io.File;

/**
 * 广告轮播图片加载器
 */
public class PicassoImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        int pathInt;
        if (path instanceof Integer) {
            pathInt = (Integer)path;
            //Picasso 加载图片简单用法
            Picasso.with(context).load(pathInt).into(imageView);
        } else if(path instanceof File){
            Picasso.with(context).load((File) path).into(imageView);
        }else {
            return;
        }

    }
}
