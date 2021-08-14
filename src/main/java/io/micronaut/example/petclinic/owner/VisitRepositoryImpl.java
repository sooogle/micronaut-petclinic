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
package io.micronaut.example.petclinic.owner;

import static io.micronaut.example.petclinic.Tables.VISITS;

import io.micronaut.example.petclinic.core.AbstractJooqRepository;
import io.micronaut.example.petclinic.tables.pojos.Visits;
import io.micronaut.example.petclinic.tables.records.VisitsRecord;
import javax.inject.Singleton;
import org.jooq.Configuration;

@Singleton
public class VisitRepositoryImpl extends AbstractJooqRepository<VisitsRecord, Visits, Integer> implements VisitRepository {

    protected VisitRepositoryImpl(Configuration configuration) {
        super(VISITS, Visits.class, configuration);
    }

    @Override
    public Integer getId(Visits object) {
        return object.getId();
    }

}
