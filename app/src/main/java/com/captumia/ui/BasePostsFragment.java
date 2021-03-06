package com.captumia.ui;

import com.captumia.R;
import com.captumia.data.Post;
import com.captumia.ui.adapters.PostsAdapter;
import com.captumia.ui.content.ServiceFragment;
import com.utilsframework.android.adapters.ViewArrayAdapter;

public abstract class BasePostsFragment extends BaseLazyLoadingFragment<Post> {
    @Override
    protected ViewArrayAdapter<Post, ?> createAdapter() {
        return new PostsAdapter(getContext());
    }

    @Override
    protected void onListItemClicked(Post item, int position) {
        ServiceFragment fragment = ServiceFragment.create(item, false);
        getNavigationInterface().replaceFragment(fragment, 1);
    }

    @Override
    protected int getRootLayout() {
        return R.layout.posts;
    }

    @Override
    protected int getNoInternetConnectionViewId() {
        return R.id.no_connection;
    }

    @Override
    protected int getEmptyListResourceId() {
        return R.id.empty;
    }
}
