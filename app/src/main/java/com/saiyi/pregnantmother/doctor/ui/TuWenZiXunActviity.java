package com.saiyi.pregnantmother.doctor.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.PhotoPreviewActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.intent.PhotoPreviewIntent;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.sunday.common.mvp.PresenterImpl;
import com.sunday.common.widgets.NoScrollGridview;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by 陈姣姣 on 2018/7/9.
 */
public class TuWenZiXunActviity extends BKMVPActivity {

    private static final int NUM_COLUMNS = 4;
    private static final int MAX_PHOTO = 9;
    private static final int REQUEST_CAMERA_CODE = 10;
    private static final int REQUEST_PREVIEW_CODE = 20;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private GridAdapter gridAdapter;


    EditText etContent;
    NoScrollGridview gvPhoto;
    TextView tvSbumit;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuwenzixun);
    }


    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.By_consulting);
        etContent =findViewById(R.id.et_content);
        gvPhoto =findViewById(R.id.gv_photo);
        tvSbumit =findViewById(R.id.tv_sbumit);
        initGVPhoto();

        tvSbumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(MessageActivity.class );
            }
        });
    }

    private void initGVPhoto() {
        int cols = getResources().getDisplayMetrics().widthPixels / getResources().getDisplayMetrics().densityDpi;
        cols = cols < NUM_COLUMNS ? NUM_COLUMNS : cols;
        gvPhoto.setNumColumns(cols);
        gvPhoto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String imgs = (String) parent.getItemAtPosition(position);
                if ("paizhao".equals(imgs) ){
                    PhotoPickerIntent intent = new PhotoPickerIntent(TuWenZiXunActviity.this);
                    intent.setSelectModel(SelectModel.MULTI);
                    intent.setShowCarema(true); // 是否显示拍照
                    intent.setMaxTotal(MAX_PHOTO); // 最多选择照片数量，默认为9
                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                    startActivityForResult(intent, REQUEST_CAMERA_CODE);
                }else{
                    PhotoPreviewIntent intent = new PhotoPreviewIntent(TuWenZiXunActviity.this);
                    intent.setCurrentItem(position);
                    intent.setPhotoPaths(imagePaths);
                    startActivityForResult(intent, REQUEST_PREVIEW_CODE);
                }
            }
        });
        imagePaths.add("paizhao");
        gridAdapter = new TuWenZiXunActviity.GridAdapter(imagePaths);
        gvPhoto.setAdapter(gridAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                // 选择照片
                case REQUEST_CAMERA_CODE:
                    ArrayList<String> list = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
                    loadAdpater(list);
                    break;
                // 预览
                case REQUEST_PREVIEW_CODE:
                    ArrayList<String> ListExtra = data.getStringArrayListExtra(PhotoPreviewActivity.EXTRA_RESULT);
                    loadAdpater(ListExtra);
                    break;
            }
        }
    }

    private void loadAdpater(ArrayList<String> paths){
        if (imagePaths!=null&& imagePaths.size()>0){
            imagePaths.clear();
        }
        if (paths.contains("paizhao")){
            paths.remove("paizhao");
        }
        paths.add("paizhao");
        imagePaths.addAll(paths);
        gridAdapter  = new TuWenZiXunActviity.GridAdapter(imagePaths);
        gvPhoto.setAdapter(gridAdapter);
        try{
            JSONArray obj = new JSONArray(imagePaths);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private class GridAdapter extends BaseAdapter {
        private ArrayList<String> listUrls;
        private LayoutInflater inflater;
        public GridAdapter(ArrayList<String> listUrls) {
            this.listUrls = listUrls;
            if(listUrls.size() == 7){
                listUrls.remove(listUrls.size()-1);
            }
            inflater = LayoutInflater.from(TuWenZiXunActviity.this);
        }

        public int getCount(){
            return  listUrls.size();
        }
        @Override
        public String getItem(int position) {
            return listUrls.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TuWenZiXunActviity.GridAdapter.ViewHolder holder = null;
            if (convertView == null) {
                holder = new TuWenZiXunActviity.GridAdapter.ViewHolder();
                convertView = inflater.inflate(R.layout.item_image, parent,false);
                holder.image = (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            } else {
                holder = (TuWenZiXunActviity.GridAdapter.ViewHolder)convertView.getTag();
            }

            final String path=listUrls.get(position);
            if (path.equals("paizhao")){
                holder.image.setImageResource(R.drawable.zhaopian);
            }else {
                Glide.with(TuWenZiXunActviity.this)
                        .load(path)
                        .placeholder(R.mipmap.default_error)
                        .error(R.mipmap.default_error)
                        .centerCrop()
                        .crossFade()
                        .into(holder.image);
            }
            return convertView;
        }
        class ViewHolder {
            ImageView image;
        }
    }
}
