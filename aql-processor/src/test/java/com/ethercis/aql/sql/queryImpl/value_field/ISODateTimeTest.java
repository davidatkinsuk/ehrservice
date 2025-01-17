/*
 * Copyright (c) Ripple Foundation CIC Ltd, UK, 2017
 * Author: Christian Chevalley
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

package com.ethercis.aql.sql.queryImpl.value_field;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by christian on 1/8/2018.
 */
public class ISODateTimeTest extends TestCase {

    @Test
    public void testValidISO8601DateTime(){
        assertTrue(new ISODateTime("2012-11-10T10:40:01Z").isValidDateTimeExpression());
        assertTrue(new ISODateTime("2012-11-10T10:40:01+09:00").isValidDateTimeExpression());
        assertTrue(new ISODateTime("2012-11-10T10:40:01+00:00").isValidDateTimeExpression());


        assertFalse(new ISODateTime("2012-15-40T10:40:01Z").isValidDateTimeExpression());

        assertFalse(new ISODateTime("2012-11-10").isValidDateTimeExpression());
        assertTrue(new ISODateTime("2012-11-10").isValidDateExpression());

        assertFalse(new ISODateTime("30:00:00Z").isValidTimeExpression());
        assertTrue(new ISODateTime("12:10:00Z").isValidTimeExpression());

    }

}