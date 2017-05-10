package com.nazim.myapplication.api;

import com.nazim.myapplication.model.Repo;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubService {

    @GET("repos/{projectId}/{projectId}/forks")
    Observable<List<Repo>> getForkedProjectForGivenProject(@Path("projectId") String projectId);
}
