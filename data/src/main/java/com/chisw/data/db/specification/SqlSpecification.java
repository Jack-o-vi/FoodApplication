package com.chisw.data.db.specification;

import com.chisw.domain.abstraction.specification.Specification;

public interface SqlSpecification extends Specification {
    String[] projection();

    String[] selectionArgs();

    String selection();

    String sortOrder();

    String groupBy();

    String having();
}
