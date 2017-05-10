package com.nazim.myapplication.repository;

import com.nazim.myapplication.api.GithubService;
import com.nazim.myapplication.model.Repo;
import java.util.List;
import rx.Observable;

public class GithubRepository {

    private final GithubService githubService;

    public GithubRepository(GithubService githubService) {
        this.githubService = githubService;
    }

    public Observable<List<Repo>> getForkedProjectForGivenProject(final String projectId) {
        return githubService.getForkedProjectForGivenProject(projectId);
    }
}
