package com.chisw.data.db.specification;

import com.chisw.data.db.entities.v5.DatabaseContract;

public class DefaultSqlSpecification implements SqlSpecification {

    private Long id;
    private DatabaseContract databaseContract;

    public DefaultSqlSpecification(Long id, DatabaseContract databaseContract) {
        this.id = id;
        this.databaseContract = databaseContract;
    }

    public DefaultSqlSpecification() {
    }

    @Override
    public String[] projection() {
        return null;
    }

    @Override
    public String[] selectionArgs() {
        if (id != null) {
            return new String[]{id.toString()};
        }
        return null;
    }

    @Override
    public String selection() {
        if (databaseContract != null) {
            return databaseContract.getId() + " = ?";
        }
        return null;
    }

    @Override
    public String sortOrder() {
        return null;
    }

    @Override
    public String groupBy() {
        return null;
    }

    @Override
    public String having() {
        return null;
    }
}
