package com.chisw.domain.interactor;

import com.chisw.domain.executors.PostExecutionThread;
import com.chisw.domain.executors.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;

public abstract class UseCase<P extends UseCase.UseCaseParameter, T extends UseCase.UseCaseResult> implements Interactor<P, T> {

    private ThreadExecutor threadExecutor;
    private PostExecutionThread postExecutionThread;

    private Disposable disposable = Disposables.empty();

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    protected abstract Observable<T> createObservable(UseCase.UseCaseParameter params);

    @Override
    public void execute(P params, Consumer<T> d) {
        disposable = createObservable(params)
                .subscribeOn(threadExecutor.getThreadExecutorSchedulers())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(d);
    }

    @Override
    public Observable<T> execute(P params) {
        return createObservable(params);
    }

    public void unsubscribe() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public interface UseCaseParameter {
    }

    public interface UseCaseResult {
    }
}
