package com.saiyi.pregnantmother.my.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.my.ui.adress_seletor.OptionsPickerView;
import com.saiyi.pregnantmother.my.view.CustomDatePicker;
import com.saiyi.pregnantmother.my.view.LastInputEditText;
import com.saiyi.pregnantmother.my.view.TimeUtil;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.mvp.PresenterImpl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 陈姣姣 on 2018/7/2.
 */
public class ReNameActivity extends BKMVPActivity {
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_userOnClick)
    TextView tvOnClick;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    int  num;
    Intent intent;
    //时间选择器
    private CustomDatePicker customDatePicker;


    @BindView(R.id.et_Detailed_address)
    LastInputEditText etDetailedAddress;

    @BindView(R.id.Linadress)
    LinearLayout LinAdress;

    // 省数据集合
    private ArrayList<String> mListProvince = new ArrayList<String>();
    // 市数据集合
    private ArrayList<ArrayList<String>> mListCiry = new ArrayList<ArrayList<String>>();
    // 区数据集合
    private ArrayList<ArrayList<ArrayList<String>>> mListArea = new ArrayList<ArrayList<ArrayList<String>>>();

    private OptionsPickerView<String> mOpv;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rename);
        ButterKnife.bind(this);

        intent=getIntent();
        num=intent.getIntExtra("num",0);
        setCityPickView();
        if (num==1) {
            uiState(1,2,R.string.full_name);
        }else if (num==2){
            uiState(2,1,R.string.birthday);
        }else if (num==3){
            uiState(1,2,R.string.phone_number);
        }else if (num==5){
            uiState(2,1,R.string.receiving_address);
            LinAdress.setVisibility(View.VISIBLE);
        }
        mTitleBar.setRightText(R.string.save);
        mTitleBar.showRightText();
        mTitleBar.setClickListener(new NavBar.NavBarOnClickListener() {
            @Override
            public void onLeftIconClick(View view) {
                finish();
            }

            @Override
            public void onLeftSenIconClick(View view) {

            }

            @Override
            public void onRightIconClick(View view) {

            }

            @Override
            public void onRightTxtClick(View view) {
                intent = new Intent(ReNameActivity.this, PersonalCenterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (num==1) {
                    //把返回数据存入Intent
                    intent.putExtra("name", etName.getText().toString());
                }else if (num==2){
                    intent.putExtra("birthday", tvOnClick.getText().toString());
                }else if (num==3){
                    intent.putExtra("phone", etName.getText().toString());
                }else if (num==5){
                    if (!TextUtils.isEmpty(etDetailedAddress.getText().toString())) {
                        intent.putExtra("adress", tvOnClick.getText().toString()+etDetailedAddress.getText().toString());
                    }else {
                        toast(R.string.NO_adress_null+"");
                    }
                }
                startActivity(intent);
                finish();

            }
        });
    }

    String time="";
    public  void etUser(View view){

        Log.e("--->点击时间",""+num);
        if (num==2) {
            initDatePicker();

            if (TextUtils.isEmpty(tvOnClick.getText().toString())){

                customDatePicker.show(TimeUtil.getCurrentTime()+" "+"01:01");
            }else {

                customDatePicker.show(tvOnClick.getText().toString()+" "+"01:01");
            }
        }else if (num==5){

            mOpv.show();

        }
    }


    /**
     *  UI 改变
     * */
    private  void   uiState(int etFlag ,int tvFlag ,int titleIdResouse  ){

        if (etFlag==1){
            etName.setVisibility(View.VISIBLE);
        }else {
            etName.setVisibility(View.GONE);
        }
        if (tvFlag==1){
            tvOnClick.setVisibility(View.VISIBLE);
        }else {
            tvOnClick.setVisibility(View.GONE);
        }

        mTitleBar.setTitle(titleIdResouse);
        tvTitle.setText(titleIdResouse);

    }


    /**
     *  时间选择器
     * */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        customDatePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvOnClick.setText(time.split(" ")[0]);
            }
        }, "2010-01-01 01:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker.showSpecificTime(false); // 不显示时和分
        customDatePicker.setIsLoop(false); // 不允许循环滚动

    }



    //设置城市选择器
    private void setCityPickView(){
        initJsonData();
        // 初始化Json数据
        initJsonDatas();
        mOpv = new OptionsPickerView<String>(this);

        // 设置标题
        mOpv.setTitle(getResources().getString(R.string.Select_city));

        // 设置三级联动效果
        mOpv.setPicker(mListProvince, mListCiry, mListArea, true);

        // 设置是否循环滚动
        mOpv.setCyclic(false, false, false);

        // 设置默认选中的三级项目
        mOpv.setSelectOptions(0, 0, 0);

        // 监听确定选择按钮
        mOpv.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                // 返回的分别是三个级别的选中位置
                String tx = mListProvince.get(options1)
                        + mListCiry.get(options1).get(option2)
                        + mListArea.get(options1).get(option2).get(options3);
              Log.e("--->选择的城市",tx);
                tvOnClick.setText(tx+"");

            }
        });

    }

    private JSONArray mjsonArray;
    /** 初始化Json数据，并释放Json对象 */
    private void initJsonDatas()  {
        try {
            for (int i = 0; i < mjsonArray.length(); i++) {
                JSONObject jsonObject = mjsonArray.getJSONObject(i);
                String province = jsonObject.getString("stateName");

                ArrayList<String> options2Items_01 = new ArrayList<String>();
                ArrayList<ArrayList<String>> options3Items_01 = new ArrayList<ArrayList<String>>();
                JSONArray jsonCs = jsonObject.getJSONArray("cities");
                for (int j = 0; j < jsonCs.length(); j++) {
                    JSONObject jsonC = jsonCs.getJSONObject(j);// 获取每个市的Json对象
                    String city = jsonC.getString("cityName");
                    options2Items_01.add(city);// 添加市数据

                    ArrayList<String> options3Items_01_01 = new ArrayList<String>();
                    JSONArray jsonAs = jsonC.getJSONArray("areas");


                    for (int k = 0; k < jsonAs.length(); k++) {
                        JSONObject obj = jsonAs.getJSONObject(k);
                        String areaName = obj.getString("areaName");
                        options3Items_01_01.add(areaName);// 添加区数据
                        Log.i("--->obj",obj.toString());

                    }
                    options3Items_01.add(options3Items_01_01);
                }

                mListProvince.add(province);// 添加省数据
                mListCiry.add(options2Items_01);
                mListArea.add(options3Items_01);
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        mjsonArray = null;
    }

    /** 从assert文件夹中读取省市区的json文件，然后转化为json对象 */
    private void initJsonData() {
        try {
            getFileContent(getResources().getAssets().open("state.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            StringBuffer sb = new StringBuffer();
            InputStream is = getAssets().open("state.json");
            int len = -1;
            byte[] buf = new byte[1024];
            while ((len = is.read(buf)) != -1) {
                sb.append(new String(buf, 0, len, "UTF-8"));
            }
            is.close();
            mjsonArray=new JSONArray(content);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    InputStream is =null;
    String content= null;
    private String  getFileContent( InputStream is){
        try {

            if (is!=null){

                ByteArrayOutputStream baos =new ByteArrayOutputStream();
                int i =-1;
                while ((i=is.read())!=-1){
                    baos.write(i);
                }
                content=baos.toString();
                baos.flush();
                baos.close();
                is.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  content;
    }
}
