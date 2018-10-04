package com.saiyi.pregnantmother.home.ui.forum.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.home.adapter.ForumListAdapter;
import com.saiyi.pregnantmother.home.model.bean.Forum;
import com.saiyi.pregnantmother.home.ui.forum.PostingsInfoActivity;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ForumListFragment extends BKMVPFragment {

    private static int TYPE = 0;

    @BindView(R.id.ll_not_postings)
    LinearLayout llNotPostings;
    @BindView(R.id.rv_forum)
    RecyclerView rvForum;

    private ForumListAdapter mForumListAdapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static ForumListFragment newInstance() {
        ForumListFragment fragment = new ForumListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_list, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        rvForum.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Forum> forums = new ArrayList<Forum>();
        forums.add(new Forum());
        forums.add(new Forum());
        mForumListAdapter = new ForumListAdapter(R.layout.item_forum, forums);
        rvForum.setAdapter(mForumListAdapter);
        mForumListAdapter.setOnItemClickListener(onItemClickListener);
        if (TYPE == 0) {
            llNotPostings.setVisibility(View.GONE);
            rvForum.setVisibility(View.VISIBLE);
            TYPE += 1;
        } else {
            TYPE -= 1;
            llNotPostings.setVisibility(View.VISIBLE);
            rvForum.setVisibility(View.GONE);
        }
    }

    protected BaseQuickAdapter.OnItemClickListener onItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            openActivity(PostingsInfoActivity.class);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
