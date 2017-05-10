package com.nazim.myapplication.repodetails;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.nazim.myapplication.R;
import com.nazim.myapplication.model.Owner;
import com.nazim.myapplication.model.Repo;

public class RepoDetailsView extends LinearLayout {

    @BindView(R.id.repo_detail_desc) TextView repoDescription;
    @BindView(R.id.repo_detail_img) ImageView repoUserAvatar;
    @BindView(R.id.repo_detail_login) TextView repoUserLogin;
    @BindView(R.id.repo_detail_name) TextView repoName;
    @BindView(R.id.repo_detail_repo_language) TextView repoLanguage;
    @BindView(R.id.repo_detail_repo_url) TextView repoUrl;
    @BindView(R.id.repo_detail_user_url) TextView userRepoUrl;
    private Repo repo;

    public RepoDetailsView(Context context) {
        super(context);
    }

    public RepoDetailsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        View v = LayoutInflater.from(context).inflate(R.layout.repo_detail_view, this);
        ButterKnife.bind(this, v);
    }

    public void bind(Repo repo) {
        this.repo = repo;
        initView();
    }

    private void initView() {
        repoDescription.setText(repo.getDescription());
        final Owner owner = repo.getOwner();
        //TODO Make it more generic, ImageLoader
        Glide.with(getContext()).load(owner.getAvatarUrl()).
            error(R.mipmap.ic_launcher).into(repoUserAvatar);
        repoUserLogin.setText(owner.getLogin());
        repoName.setText(repo.getFullName());
        repoLanguage.setText(repo.getLanguage());
        repoUrl.setText(repo.getUrl());
        userRepoUrl.setText(owner.getUrl());
    }
}
