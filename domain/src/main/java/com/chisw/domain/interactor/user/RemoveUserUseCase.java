package com.chisw.domain.interactor.user;

import com.chisw.domain.executors.PostExecutionThread;
import com.chisw.domain.executors.ThreadExecutor;
import com.chisw.domain.interactor.UseCase;

import io.reactivex.Observable;

public class RemoveUserUseCase extends UseCase<RemoveUserUseCase.RemoveUseCaseParameter, RemoveUserUseCase.RemoveUseCaseResult> {

    public RemoveUserUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Observable<RemoveUseCaseResult> createObservable(UseCaseParameter params) {
        return null;
    }

    public class RemoveUseCaseParameter implements UseCase.UseCaseParameter {

    }

    public class RemoveUseCaseResult implements UseCase.UseCaseResult {

    }
}
