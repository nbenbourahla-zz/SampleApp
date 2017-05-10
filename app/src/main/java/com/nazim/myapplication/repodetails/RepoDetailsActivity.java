package com.nazim.myapplication.repodetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.nazim.myapplication.R;
import com.nazim.myapplication.common.Constants;
import com.nazim.myapplication.model.Repo;

public class RepoDetailsActivity extends AppCompatActivity {

    @BindView(R.id.repo_detail_view) RepoDetailsView repoDetailsView;
    private Repo repo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repo_detail);

        ButterKnife.bind(this);

        if (getIntent() != null && getIntent().hasExtra(Constants.REPO_EXTRA_KEY)) {
            repo = getIntent().getParcelableExtra(Constants.REPO_EXTRA_KEY);
        } else {
            throw new IllegalStateException("Cannot call this activity without Repo");
        }

        repoDetailsView.bind(repo);
    }
}
