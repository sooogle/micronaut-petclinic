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

import static io.micronaut.example.petclinic.Tables.OWNERS;
import static io.micronaut.example.petclinic.Tables.PETS;
import static io.micronaut.example.petclinic.Tables.TYPES;
import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;

import io.micronaut.core.util.StringUtils;
import io.micronaut.example.petclinic.tables.pojos.Owners;
import io.micronaut.example.petclinic.tables.records.OwnersRecord;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import org.jooq.Condition;
import org.jooq.Configuration;
import org.jooq.Record7;
import org.jooq.SelectJoinStep;
import org.jooq.impl.DAOImpl;

@Singleton
public class OwnerRepositoryImpl extends DAOImpl<OwnersRecord, Owners, Integer> implements OwnerRepository {

    protected OwnerRepositoryImpl(Configuration configuration) {
        super(OWNERS, Owners.class, configuration);
    }

    @Override
    public Integer getId(Owners object) {
        return object.getId();
    }

    @Override
    public OwnerDTO findOne(Integer id) {
        return selectFromOwners()
            .where(OWNERS.ID.eq(id))
            .fetchOne(mapping(OwnerDTO::new));
    }

    @Override
    public List<OwnerDTO> findAll(String lastName) {
        var conditions = new ArrayList<Condition>();
        if (StringUtils.hasText(lastName)) {
            conditions.add(OWNERS.LAST_NAME.startsWithIgnoreCase(lastName));
        }
        return selectFromOwners()
            .where(conditions)
            .fetch(mapping(OwnerDTO::new));
    }

    public SelectJoinStep<Record7<Integer, String, String, String, String, String, List<OwnerDTO.PetDTO>>> selectFromOwners() {
        return ctx()
            .select(
                OWNERS.ID,
                OWNERS.FIRST_NAME,
                OWNERS.LAST_NAME,
                OWNERS.ADDRESS,
                OWNERS.CITY,
                OWNERS.TELEPHONE,
                multiset(
                    select(
                        PETS.ID,
                        PETS.NAME,
                        PETS.BIRTH_DATE,
                        PETS.TYPE_ID,
                        TYPES.NAME
                    ).from(PETS)
                        .innerJoin(TYPES).on(PETS.TYPE_ID.eq(TYPES.ID))
                        .where(OWNERS.ID.eq(PETS.OWNER_ID))
                ).as("pets").convertFrom(r -> r.map(mapping(OwnerDTO.PetDTO::new)))
            )
            .from(OWNERS);
    }

}
