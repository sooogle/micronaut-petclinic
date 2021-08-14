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
package io.micronaut.example.petclinic.vet;

import static io.micronaut.example.petclinic.Tables.VETS;
import static io.micronaut.example.petclinic.Tables.VET_SPECIALTIES;
import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.exists;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;
import static org.jooq.impl.DSL.selectOne;

import io.micronaut.core.util.StringUtils;
import io.micronaut.example.petclinic.core.AbstractJooqRepository;
import io.micronaut.example.petclinic.tables.pojos.Vets;
import io.micronaut.example.petclinic.tables.records.VetsRecord;
import io.micronaut.example.petclinic.vet.VetDTO.SpecialityDTO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import org.jooq.Condition;
import org.jooq.Configuration;

@Singleton
public class VetRepositoryImpl extends AbstractJooqRepository<VetsRecord, Vets, Integer> implements VetRepository {

    public VetRepositoryImpl(Configuration configuration) {
        super(VETS, Vets.class, configuration);
    }

    @Override
    public Integer getId(Vets object) {
        return object.getId();
    }

    @Override
    public List<VetDTO> findAll(String lastName, Integer specialityId) {
        var conditions = new ArrayList<Condition>();
        if (StringUtils.hasText(lastName)) {
            conditions.add(VETS.LAST_NAME.startsWithIgnoreCase(lastName));
        }
        if (specialityId != null) {
            conditions.add(
                exists(
                    selectOne()
                        .from(VET_SPECIALTIES)
                        .where(VET_SPECIALTIES.VET_ID.eq(VETS.ID)
                            .and(VET_SPECIALTIES.SPECIALTY_ID.eq(specialityId)))
                )
            );
        }
        return ctx()
            .select(
                VETS.ID,
                VETS.FIRST_NAME,
                VETS.LAST_NAME,
                multiset(
                    select(
                        VET_SPECIALTIES.specialties().ID,
                        VET_SPECIALTIES.specialties().NAME
                    ).from(VET_SPECIALTIES).where(VET_SPECIALTIES.VET_ID.eq(VETS.ID))
                ).as("specialities").convertFrom(r -> r.map(mapping(SpecialityDTO::new)))
            )
            .from(VETS)
            .where(conditions)
            .fetch()
            .map(mapping(VetDTO::new));
    }

}
