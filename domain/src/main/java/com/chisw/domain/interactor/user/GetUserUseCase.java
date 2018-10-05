package com.chisw.domain.interactor.user;

import com.chisw.domain.abstraction.repository.Repository;
import com.chisw.domain.abstraction.specification.Specification;
import com.chisw.domain.executors.PostExecutionThread;
import com.chisw.domain.executors.ThreadExecutor;
import com.chisw.domain.interactor.UseCase;
import com.chisw.domain.model.user.User;

import io.reactivex.Observable;

public class GetUserUseCase extends UseCase<GetUserUseCase.GetUserParameter, GetUserUseCase.GetUserResult> {

    private Repository<User> repository;

    public GetUserUseCase(ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread,
                          Repository<User> repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<GetUserUseCase.GetUserResult> createObservable(GetUserParameter params) {
        return repository.getItems(params.getSpecification()).map(GetUserResult::new);
    }

    public static class GetUserParameter implements UseCase.UseCaseParameter {
        private Specification specification;

        public GetUserParameter(Specification specification) {
            this.specification = specification;
        }

        Specification getSpecification() {
            return specification;
        }
    }

    public static class GetUserResult implements UseCase.UseCaseResult {
        private User user;

        GetUserResult(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

}
