package com.nazim.myapplication.listrepos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.nazim.myapplication.R;
import com.nazim.myapplication.model.Repo;
import com.nazim.myapplication.navigation.NavigationHelper;
import java.util.List;

class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.ViewHolder> {

    private List<Repo> repoList;
    private final Context context;
    private final NavigationHelper navigationHelper;

    RepoListAdapter(@NonNull final Context context, @NonNull NavigationHelper navigationHelper) {
        this.context = context;
        this.navigationHelper = navigationHelper;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout lineLayout;
        TextView ownerName;
        ImageView ownerImage;

        ViewHolder(View view) {
            super(view);
            lineLayout = (LinearLayout) view.findViewById(R.id.recycler_view_line_layout);
            ownerName = (TextView) view.findViewById(R.id.owner_name);
            ownerImage = (ImageView) view.findViewById(R.id.owner_img);
        }
    }

    public void setData(List<Repo> repoList) {
        this.repoList = repoList;
    }

    @Override
    public RepoListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_list_line, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoListAdapter.ViewHolder holder, int position) {
        final Repo repo = repoList.get(position);
        holder.ownerName.setText(repo.getFullName());
        //TODO : Improve on ImageLoader to be agnostic of Glide
        Glide.with(context).load(repo.getOwner().getAvatarUrl()).
            error(R.mipmap.ic_launcher).into(holder.ownerImage);
        holder.lineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationHelper.navigateToRepoDetails(context, repo);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (repoList != null) return repoList.size();
        return 0;
    }
}
