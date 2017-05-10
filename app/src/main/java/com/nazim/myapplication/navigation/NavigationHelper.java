package com.nazim.myapplication.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import com.nazim.myapplication.R;
import com.nazim.myapplication.common.Constants;
import com.nazim.myapplication.common.Helper;
import com.nazim.myapplication.model.Repo;
import com.nazim.myapplication.repodetails.RepoDetailsActivity;
import com.nazim.myapplication.repodetails.RepoDetailsView;

public class NavigationHelper {

    //TODO : Improve NavigationHelper Shouldn't create the popup
    public void navigateToRepoDetails(@NonNull Context context, @NonNull Repo repo) {
        if (!Helper.isTablet(context)) {
            Intent intent = new Intent(context, RepoDetailsActivity.class);
            intent.putExtra(Constants.REPO_EXTRA_KEY, repo);
            context.startActivity(intent);
        } else {
            RepoDetailsView customView =
                (RepoDetailsView) LayoutInflater.from(context).inflate(R.layout.repo_detail, null);
            customView.bind(repo);
            new AlertDialog.Builder(context).setView(customView).setCancelable(true).create().show();
        }
    }
}
