package com.captumia.ui;

import android.app.Activity;

import com.captumia.R;
import com.captumia.data.Post;
import com.captumia.network.PostsByCategoryLazyLoadingList;
import com.captumia.ui.adapters.PostsAdapter;
import com.utils.framework.collections.LazyLoadingList;
import com.utilsframework.android.adapters.ViewArrayAdapter;
import com.utilsframework.android.fragments.Fragments;
import com.utilsframework.android.network.retrofit.RetrofitRequestManager;

public class PostsByCategoryFragment extends BaseLazyLoadingFragment<Post> {
    public static final String CATEGORY_ID = "categoryId";

    private int categoryId;

    public static PostsByCategoryFragment create(int categoryId) {
        return Fragments.createFragmentWith1Arg(new PostsByCategoryFragment(), CATEGORY_ID,
                categoryId);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        categoryId = getArguments().getInt(CATEGORY_ID);
    }

    @Override
    protected ViewArrayAdapter<Post, ?> createAdapter() {
        return new PostsAdapter(getContext());
    }

    @Override
    protected LazyLoadingList<Post> getLazyLoadingList(RetrofitRequestManager requestManager,
                                                       String filter) {
        return new PostsByCategoryLazyLoadingList(requestManager,
                getRestApiClient(), categoryId);
    }

    @Override
    protected void onListItemClicked(Post item, int position) {

    }

    @Override
    protected int getRootLayout() {
        return R.layout.posts;
    }

    @Override
    protected int getNoInternetConnectionViewId() {
        return R.id.no_connection;
    }
}