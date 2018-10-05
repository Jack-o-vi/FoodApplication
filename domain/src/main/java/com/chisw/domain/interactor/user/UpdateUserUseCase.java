package com.chisw.domain.interactor.user;

import com.chisw.domain.abstraction.repository.Repository;
import com.chisw.domain.abstraction.specification.Specification;
import com.chisw.domain.executors.PostExecutionThread;
import com.chisw.domain.executors.ThreadExecutor;
import com.chisw.domain.interactor.UseCase;
import com.chisw.domain.model.user.User;

import io.reactivex.Observable;

public class UpdateUserUseCase extends UseCase<UpdateUserUseCase.UpdateUserParameter, UpdateUserUseCase.UpdateUserResult> {

    private Repository<User> repository;

    public UpdateUserUseCase(ThreadExecutor threadExecutor,
                             PostExecutionThread postExecutionThread,
                             Repository<User> repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<UpdateUserResult> createObservable(UpdateUserParameter parameter) {
        return repository.updateItems(parameter.getUser(), parameter.getSpecification())
                .map((row) -> new UpdateUserResult((Integer) row));
    }

    public static class UpdateUserParameter implements UseCase.UseCaseParameter {
        private Specification specification;
        private User user;

        public UpdateUserParameter(User user, Specification specification) {
            this.user = user;
            this.specification = specification;
        }

        Specification getSpecification() {
            return specification;
        }

        public User getUser() {
            return user;
        }
    }

    public static class UpdateUserResult implements UseCase.UseCaseResult {
        private Integer updatedRow;

        UpdateUserResult(Integer updatedRow) {
            this.updatedRow = updatedRow;
        }


        public Integer getUpdatedRow() {
            return updatedRow;
        }
    }
}
