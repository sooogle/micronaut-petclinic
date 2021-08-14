/*
 *  Copyright 2021 original authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.micronaut.example.petclinic.core;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.UpdatableRecord;
import org.jooq.impl.DAOImpl;

public abstract class AbstractJooqRepository<R extends UpdatableRecord<R>, E, ID> implements JooqRepository<E, ID> {

    private final DAOImpl<R, E, ID> dao;

    protected AbstractJooqRepository(Table<R> table, Class<E> type, Configuration configuration) {
        this.dao = new DAOImpl<>(table, type, configuration) {
            @Override
            public ID getId(E entity) {
                return AbstractJooqRepository.this.getId(entity);
            }
        };
    }

    @Override
    public <S extends E> S save(S entity) {
        dao.insert(entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S extends E> Iterable<S> saveAll(Iterable<S> entities) {
        List<E> entityList = iterableToList(entities);
        dao.insert(entityList);
        return (Iterable<S>) entityList;
    }

    @Override
    public <S extends E> S update(S entity) {
        dao.update(entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S extends E> Iterable<S> updateAll(Iterable<S> entities) {
        List<E> entityList = iterableToList(entities);
        dao.update(entityList);
        return (Iterable<S>) entityList;
    }

    @Override
    public Optional<E> findById(ID id) {
        return Optional.ofNullable(dao.findById(id));
    }

    @Override
    public boolean existsById(ID id) {
        return dao.existsById(id);
    }

    @Override
    public List<E> findAll() {
        return dao.findAll();
    }

    @Override
    public long count() {
        return dao.count();
    }

    @Override
    public void delete(E entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends E> entities) {
        dao.delete(iterableToList(entities));
    }

    @Override
    public void deleteById(ID id) {
        dao.deleteById(Collections.singletonList(id));
    }

    @Override
    public void deleteAll() {
        dao.ctx().deleteFrom(dao.getTable()).execute();
    }

    protected DSLContext ctx() {
        return dao.ctx();
    }

    private <S extends E> List<E> iterableToList(Iterable<S> entities) {
        return StreamSupport.stream(entities.spliterator(), false).collect(Collectors.toList());
    }

}
