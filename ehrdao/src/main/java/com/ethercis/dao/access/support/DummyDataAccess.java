/*
 * Copyright (c) 2015 Christian Chevalley
 * This file is part of Project Ethercis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ethercis.dao.access.support;

import com.ethercis.ehr.knowledge.I_KnowledgeCache;
import com.ethercis.opt.query.I_IntrospectCache;
import org.jooq.DSLContext;

import java.util.Map;

/**
 * Created by Christian Chevalley on 4/25/2015.
 */
public class DummyDataAccess extends DataAccess {

    public DummyDataAccess(DSLContext context, I_KnowledgeCache knowledge, I_IntrospectCache introspectCache){
        super(context, knowledge, introspectCache);
//        this.connection = connectionHandler.getConnection();
    }

    public DummyDataAccess(Map<String, Object> map) throws Exception {
        super(map);
    }

    @Override
    public DataAccess getDataAccess() {
        return this;
    }
}
