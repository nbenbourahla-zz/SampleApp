package com.nazim.myapplication.listrepos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.nazim.myapplication.R;
import com.nazim.myapplication.navigation.NavigationHelper;
import com.nazim.myapplication.repository.GithubRepository;
import javax.inject.Inject;

public class RepoListActivity extends AppCompatActivity {

    @Inject GithubRepository githubRepository;
    @Inject NavigationHelper navigationHelper;
    private RepoListAdapter repoListAdapter;
    @Inject RepoListPresenter repoListPresenter;
    private RepoListComponent component;

    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        component = DaggerRepoListComponent.builder().build();
        component.inject(this);

        initView();

        repoListPresenter.loadData(repoListAdapter);
    }

    private void initView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        repoListAdapter = new RepoListAdapter(this, navigationHelper);
        recyclerView.setAdapter(repoListAdapter);
    }

    @Override
    protected void onDestroy() {
        repoListPresenter.unbind();
        component = null;
        super.onDestroy();
    }
}
