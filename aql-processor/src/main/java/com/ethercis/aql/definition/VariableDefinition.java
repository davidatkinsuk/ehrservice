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

package com.ethercis.aql.definition;

/**
 * Container of a variable (symbol) with its path and alias (AS 'alias')
 * Created by christian on 5/3/2016.
 */
public class VariableDefinition {

    private String path;
    private String alias;
    private String identifier;

    public VariableDefinition(String path, String alias, String identifier) {
        this.path = path;
        this.alias = alias;
        this.identifier = identifier;
    }

    public String getPath() {
        return path;
    }

    public String getAlias() {
        return alias;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String toString(){
        return identifier+"::"+path;
    }
}
