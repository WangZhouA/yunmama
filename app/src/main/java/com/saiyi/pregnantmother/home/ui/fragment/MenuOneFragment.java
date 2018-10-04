package com.saiyi.pregnantmother.home.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.doctor.ui.FindDoctorActivity;
import com.saiyi.pregnantmother.home.ui.forum.ForumActivity;
import com.saiyi.pregnantmother.home.ui.school.SchoolActivity;
import com.saiyi.pregnantmother.home.ui.shopping.ShoppingActivity;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MenuOneFragment extends BKMVPFragment {
    Unbinder unbinder;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static MenuOneFragment newInstance() {
        MenuOneFragment fragment = new MenuOneFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ll_school, R.id.ll_forum, R.id.ll_shopping_mall, R.id.ll_find_doctor})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_school:
                openActivity(SchoolActivity.class);
                break;
            case R.id.ll_forum:
                openActivity(ForumActivity.class);
                break;
            case R.id.ll_shopping_mall:
                openActivity(ShoppingActivity.class);
                break;
            case R.id.ll_find_doctor:
                openActivity(FindDoctorActivity.class);
                break;
        }
    }
}
