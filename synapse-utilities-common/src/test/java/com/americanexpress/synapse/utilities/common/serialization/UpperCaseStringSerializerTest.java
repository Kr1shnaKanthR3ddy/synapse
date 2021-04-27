/*
 * Copyright 2020 American Express Travel Related Services Company, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.americanexpress.synapse.utilities.common.serialization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpperCaseStringSerializerTest extends BaseTestStringSerializer {

    @BeforeEach
    @Override
    public void initializeModel() {
        super.initializeModel();
        setTestField("first_name");
    }

    @Override
    public void arrangeNullField() {
        model.setFirstName(null);
    }

    @Override
    public void arrangeEmptyValue() {
        model.setFirstName("");
    }

    @Override
    public void arrangeWhiteSpace() {
        model.setFirstName(" ");
    }

    @Test
    @Override
    public void serialize_clean() throws Exception {
        model.setFirstName("Bob");
        String expected = "{\"" + testField + "\":\"BOB\"}";
        String actual = mapper.writeValueAsString(model);
        assertEquals(expected, actual, "Serialization expected uppercase string.");
    }
}
