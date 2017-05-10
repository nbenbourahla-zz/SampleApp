package com.nazim.myapplication.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nazim.myapplication.repository.GithubRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module public class ApiModule {

    private static final String BASE_URL = "https://api.github.com/";

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(final Gson gson) {
        return new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build();
    }

    @Provides
    @Singleton
    GithubService provideGithubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }

    @Provides
    @Singleton
    GithubRepository provideGithubRepository(GithubService githubService) {
        return new GithubRepository(githubService);
    }
}
