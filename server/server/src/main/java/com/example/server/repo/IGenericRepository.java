package com.example.server.repo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IGenericRepository<T> {
    CompletableFuture<Void> delete(int id);
    CompletableFuture<Void> insert(T entity);
    CompletableFuture<List<T>> selectAll();
    CompletableFuture<T> selectById(int id);
    CompletableFuture<Void> update(T entity);
}