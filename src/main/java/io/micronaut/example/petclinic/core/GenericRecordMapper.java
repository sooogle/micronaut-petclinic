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

import io.micronaut.core.beans.BeanIntrospection;
import org.jooq.Record;
import org.jooq.RecordMapper;

/**
 * A generic {@link RecordMapper} implementation with the help of Micronaut's {@link BeanIntrospection}.
 * <p>The DTO class must be annotated with {@code @Introspected}.
 *
 * @param <T> type of the DTO
 */
public class GenericRecordMapper<T> implements RecordMapper<Record, T> {

    private final Class<T> clazz;

    /**
     * @param clazz the class of the DTO
     */
    public GenericRecordMapper(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Create a {@code GenericRecordMapper}.
     *
     * @param clazz the class of the DTO
     * @param <T>   the type of the DTO
     * @return {@code GenericRecordMapper}
     */
    public static <T> GenericRecordMapper<T> mapping(Class<T> clazz) {
        return new GenericRecordMapper<>(clazz);
    }

    /**
     * Map {@link Record} into the DTO of given type T.
     * <p>Constructor arguments of the DTO must be exactly same as the fields of the record.
     *
     * @param record the record
     * @return DTO
     */
    @Override
    public T map(Record record) {
        var values = new Object[record.fields().length];
        for (var i = 0; i < record.fields().length; i++) {
            values[i] = record.getValue(i);
        }
        return BeanIntrospection.getIntrospection(clazz).instantiate(values);
    }

}
