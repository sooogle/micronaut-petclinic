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

import java.util.Optional;

/**
 * Interface for generic CRUD operations on a repository for a specific type.
 * <p>Note: This is a copy of Micronaut's {@code io.micronaut.data.repository.CrudRepository}.
 *
 * @param <E>  The entity type
 * @param <ID> The ID type
 */
public interface CrudRepository<E, ID> extends Repository<E, ID> {

    <S extends E> S save(S entity);

    <S extends E> Iterable<S> saveAll(Iterable<S> entities);

    <S extends E> S update(S entity);

    <S extends E> Iterable<S> updateAll(Iterable<S> entities);

    Optional<E> findById(ID id);

    boolean existsById(ID id);

    Iterable<E> findAll();

    long count();

    void delete(E entity);

    void deleteById(ID id);

    void deleteAll(Iterable<? extends E> entities);

    void deleteAll();

}
