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

import jakarta.inject.Named;
import jakarta.inject.Singleton;
import java.time.LocalDateTime;
import java.util.Optional;
import org.jooq.RecordContext;
import org.jooq.impl.DefaultRecordListener;

/**
 * Set dates of the record automatically .
 * <p><a href="https://github.com/jOOQ/jOOQ/issues/6250">Automatic update of dates</a>
 * <p><a href="https://github.com/jOOQ/jOOQ/issues/1592">Add formal support for "audit" fields, such as CREATED_AT, CREATED_BY, MODIFIED_AT, MODIFIED_BY</a>
 */
@Named("default") // for the "default" datasource
@Singleton
public class CommonRecordListener extends DefaultRecordListener {

    private static final String CREATED_AT_FIELD = "created_at";
    private static final String UPDATED_AT_FIELD = "update_at";

    @Override
    public void insertStart(RecordContext ctx) {
        var now = LocalDateTime.now();
        setTimestamp(ctx, CREATED_AT_FIELD, now);
        setTimestamp(ctx, UPDATED_AT_FIELD, now);
    }

    @Override
    public void updateStart(RecordContext ctx) {
        setTimestamp(ctx, UPDATED_AT_FIELD, LocalDateTime.now());
    }

    private void setTimestamp(RecordContext ctx, String fieldName, LocalDateTime now) {
        Optional.ofNullable(ctx.record().field(fieldName))
            .ifPresent(field -> ctx.record().set(field.coerce(LocalDateTime.class), now));
    }
}
