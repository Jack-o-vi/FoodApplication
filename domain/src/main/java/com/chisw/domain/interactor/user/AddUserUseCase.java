package com.chisw.domain.interactor.user;

import com.chisw.domain.abstraction.repository.Repository;
import com.chisw.domain.executors.PostExecutionThread;
import com.chisw.domain.executors.ThreadExecutor;
import com.chisw.domain.interactor.UseCase;
import com.chisw.domain.model.user.User;

import io.reactivex.Observable;

public class AddUserUseCase extends UseCase<AddUserUseCase.AddUserParameter, AddUserUseCase.AddUserResult> {

    private Repository<User> repository;

    public AddUserUseCase(ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread,
                          Repository<User> repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<AddUserUseCase.AddUserResult> createObservable(AddUserParameter params) {
        return repository.addItem(params.getSpecification()).map((a) -> new AddUserResult((long) a));
    }

    public static class AddUserParameter implements UseCase.UseCaseParameter {
        private User user;

        public AddUserParameter(User user) {
            this.user = user;
        }

        User getSpecification() {
            return user;
        }
    }

    public static class AddUserResult implements UseCase.UseCaseResult {
        private Long userId;

        AddUserResult(Long userId) {
            this.userId = userId;
        }

        public Long getUserId() {
            return userId;
        }
    }

}
