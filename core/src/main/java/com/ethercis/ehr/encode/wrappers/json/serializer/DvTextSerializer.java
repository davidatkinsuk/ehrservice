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
package com.ethercis.ehr.encode.wrappers.json.serializer;

import com.ethercis.ehr.encode.wrappers.ObjectSnakeCase;
import com.ethercis.ehr.encode.wrappers.json.I_DvTypeAdapter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import org.openehr.rm.datatypes.text.DvText;

import java.lang.reflect.Type;

/**
 * GSON adapter for DvDateTime
 * Required since JSON does not support natively a DateTime data type
 */
public class DvTextSerializer extends DvTypeSerializer<DvText> {

	public DvTextSerializer(AdapterType adapterType) {
		super(adapterType);
	}

	public DvTextSerializer() {
	}


	@Override
	public JsonElement serialize(DvText dvText, Type type, JsonSerializationContext jsonSerializationContext) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(I_DvTypeAdapter.TAG_CLASS_RAW_JSON, new ObjectSnakeCase(dvText).camelToUpperSnake());
		jsonObject.addProperty("value", dvText.getValue());
		return jsonObject;
	}
}
