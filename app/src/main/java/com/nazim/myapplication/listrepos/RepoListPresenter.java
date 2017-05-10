package com.nazim.myapplication.listrepos;

import android.util.Log;
import com.nazim.myapplication.model.Repo;
import com.nazim.myapplication.repository.GithubRepository;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

class RepoListPresenter {

    private final static String PROJECT_ID = "DefinitelyTyped";

    private final CompositeSubscription compositeSubscription;
    private GithubRepository githubRepository;

    @Inject
    RepoListPresenter(final GithubRepository githubRepository) {
        this.githubRepository = githubRepository;
        compositeSubscription = new CompositeSubscription();
    }

    void loadData(final RepoListAdapter repoListAdapter) {
        Observable<List<Repo>> repoObservable = githubRepository.getForkedProjectForGivenProject(PROJECT_ID);
        compositeSubscription.add(repoObservable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<List<Repo>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    Log.e("RepoListActivity", "Error", e);
                }

                @Override
                public void onNext(List<Repo> repos) {
                    repoListAdapter.setData(repos);
                    repoListAdapter.notifyDataSetChanged();
                }
            }));
    }

    void unbind() {
        if (!compositeSubscription.isUnsubscribed()) {
            compositeSubscription.unsubscribe();
        }
    }
}
