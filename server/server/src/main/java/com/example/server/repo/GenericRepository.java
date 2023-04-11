package com.example.server.repo;

import com.example.server.model.Badge;
import com.example.server.model.InProgressBadge;
import com.example.server.model.ModelBase;

import javax.naming.Context;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GenericRepository<T extends ModelBase> implements IGenericRepository<T> {
    protected final AppDbContext context;

    public GenericRepository(AppDbContext context) {
        this.context = context;
    }

    @Override
    public CompletableFuture<T> selectById(int id) {
        return CompletableFuture.supplyAsync(() -> context.getDao(T.class).getById(id));
    }

    @Override
    public CompletableFuture<List<T>> selectAll() {
        return CompletableFuture.supplyAsync(() -> context.getDao(T.class).getAll());
    }

    @Override
    public CompletableFuture<Void> insert(T entity) {
        return CompletableFuture.runAsync(() -> {
            boolean alreadyStored = context.getDao(T.class).getAll().contains(entity);

            if (!alreadyStored) {
                context.getDao(T.class).add(entity);
            }
        }).thenRunAsync(context::saveChanges);
    }

    @Override
    public CompletableFuture<Void> update(T entity) {
        return CompletableFuture.runAsync(() -> context.getDao(T.class).update(entity))
                .thenRunAsync(context::saveChanges);
    }

    @Override
    public CompletableFuture<Void> delete(int id) {
        return CompletableFuture.supplyAsync(() -> context.getDao(T.class).getById(id))
                .thenAcceptAsync(entity -> context.getDao(T.class).delete(entity))
                .thenRunAsync(context::saveChanges);
    }
}