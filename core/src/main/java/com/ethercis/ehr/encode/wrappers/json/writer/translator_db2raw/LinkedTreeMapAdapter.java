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
package com.ethercis.ehr.encode.wrappers.json.writer.translator_db2raw;

import com.ethercis.ehr.encode.CompositionSerializer;
import com.ethercis.ehr.encode.wrappers.SnakeCase;
import com.ethercis.ehr.encode.wrappers.json.I_DvTypeAdapter;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * GSON adapter for LinkedTreeMap
 */
public class LinkedTreeMapAdapter extends TypeAdapter<LinkedTreeMap> implements I_DvTypeAdapter {

    Logger logger = LogManager.getLogger(LinkedTreeMapAdapter.class);

    protected AdapterType adapterType = AdapterType._DBJSON2RAWJSON;
    protected String parentArchetypeNodeId = null;
    protected String nodeName = null;
    boolean isRoot = true;
    int depth = 0;

    public LinkedTreeMapAdapter(AdapterType adapterType) {
        super();
        this.adapterType = adapterType;
        isRoot = true;
    }

    public LinkedTreeMapAdapter() {
        super();
        this.adapterType = AdapterType._DBJSON2RAWJSON;
        isRoot = true;
    }

    public LinkedTreeMapAdapter(String parentArchetypeNodeId, String nodeName) {
        super();
        this.adapterType = AdapterType._DBJSON2RAWJSON;
        this.parentArchetypeNodeId = parentArchetypeNodeId;
        this.nodeName = nodeName;
        isRoot = false;
    }

    //	@Override
    public LinkedTreeMap read(JsonReader arg0) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    //	@Override
    private void writeInternal(JsonWriter writer, LinkedTreeMap map) throws IOException {

        boolean isItemsOnly = new Children(map).isItemsOnly();
        boolean isMultiContent = new Children(map).isMultiContent();
        String parentItemsArchetypeNodeId = null;

        int cursor = 0;
        int lastChild = 0;
        if (isItemsOnly) {
            //get the archetype node id
            if (map.containsKey(I_DvTypeAdapter.ARCHETYPE_NODE_ID)){
                parentItemsArchetypeNodeId = (String) map.get(I_DvTypeAdapter.ARCHETYPE_NODE_ID);
                map.remove(I_DvTypeAdapter.ARCHETYPE_NODE_ID);
            }
            lastChild = map.size() - 1;
        } else if (isMultiContent) {
            if (map.containsKey(I_DvTypeAdapter.ARCHETYPE_NODE_ID)){
                parentItemsArchetypeNodeId = (String) map.get(I_DvTypeAdapter.ARCHETYPE_NODE_ID);
                map.remove(I_DvTypeAdapter.ARCHETYPE_NODE_ID);
            }
            lastChild = new Children(map).contentCount();
        }
        ArrayList nodeNameValue = null;

        for (Object entry : map.entrySet()) {
            if (entry instanceof Map.Entry) {
                String key = (String) ((Map.Entry) entry).getKey();
                String jsonKey = new RawJsonKey(key).toRawJson();
                String archetypeNodeId = new NodeId(key).predicate();

                Object value = ((Map.Entry) entry).getValue();

                if (value == null)
                    continue;

                //for activities and events, process it as arrays
                if (key.equals(CompositionSerializer.TAG_EVENTS) || key.equals(CompositionSerializer.TAG_ACTIVITIES)) {
                    //get the entry key
                    //TODO: support more than one entry!!!
                    if (((LinkedTreeMap) value).entrySet().toArray().length > 1) {
                        logger.warn("Detected more than one entry for " + key + "; size found:" + ((LinkedTreeMap) value).entrySet().toArray().length);
                    }
                    Map.Entry entry1 = (Map.Entry) ((LinkedTreeMap) value).entrySet().toArray()[0];
                    key = (String) entry1.getKey();
                    value = entry1.getValue();
                    ((LinkedTreeMap) ((ArrayList) value).get(0)).put(AT_CLASS, new DomainStructure(archetypeNodeId).archetypeSlotType());
                }

                if (value instanceof ArrayList) {
                    if (isItemsOnly) {
                        if (cursor == 0) { //initial
                            writer.name(ITEMS);
                            writer.beginArray();
                            if (key.equals(CompositionSerializer.TAG_NAME)) {
//                                writeNameAsValue(writer, (ArrayList) value);
                                nodeNameValue = (ArrayList) value;
                            } else {
                                new ArrayListAdapter(archetypeNodeId, key).write(writer, (ArrayList) value);
                            }
                            cursor++;
                        } else { //next siblings
                            if (key.equals(CompositionSerializer.TAG_NAME)) {
                                nodeNameValue = (ArrayList) value;
                            } else
                                new LinkedTreeMapAdapter(archetypeNodeId, key).write(writer, (LinkedTreeMap) ((ArrayList) value).get(0));
                            cursor++;
                        }
                        if (cursor > lastChild) {
                            writer.endArray();
                            writer.name(I_DvTypeAdapter.ARCHETYPE_NODE_ID).value(parentItemsArchetypeNodeId);
                            writeNameAsValue(writer, nodeNameValue);
                        }
                    } else if (isMultiContent && key.contains(CompositionSerializer.TAG_CONTENT)) {
                        //assumed sorted (LinkedTreeMap preserve input order)
                        if (value instanceof ArrayList && ((ArrayList) value).size() > 0 && ((ArrayList) value).get(0) instanceof LinkedTreeMap) {
                            ((LinkedTreeMap) ((ArrayList) value).get(0)).put(ARCHETYPE_NODE_ID, archetypeNodeId);
                            ((LinkedTreeMap) ((ArrayList) value).get(0)).put(AT_CLASS, new DomainStructure(archetypeNodeId).archetypeSlotType());
                        }

                        if (cursor == 0) { //initial
                            if (key.equals(CompositionSerializer.TAG_NAME)) {
//                                writeNameAsValue(writer, (ArrayList) value);
                                nodeNameValue = (ArrayList) value;
                            } else {
                                //insert archetype node id
                                writer.name(jsonKey);
                                writer.beginArray();
                                new ArrayListAdapter(archetypeNodeId, key).write(writer, (ArrayList) value);
                            }
                            cursor++;
                        } else { //next siblings
                            if (key.equals(CompositionSerializer.TAG_NAME)) {
                                nodeNameValue = (ArrayList) value;
                            } else
                                new LinkedTreeMapAdapter(archetypeNodeId, key).write(writer, (LinkedTreeMap) ((ArrayList) value).get(0));
                            cursor++;
                        }
                        if (cursor > lastChild - 1) {
                            writer.endArray();
                            writer.name(I_DvTypeAdapter.ARCHETYPE_NODE_ID).value(parentItemsArchetypeNodeId);
                            writeNameAsValue(writer, nodeNameValue);
                        }
                    } else {
                        if (key.equals(CompositionSerializer.TAG_NAME)) {
//                            writeNameAsValue(writer, (ArrayList) value);
                            nodeNameValue = (ArrayList) value;
                        } else {
                            writer.name(jsonKey);
                            writer.beginArray();
                            new ArrayListAdapter(archetypeNodeId, key).write(writer, (ArrayList) value);
                            writer.endArray();
                            if (nodeNameValue == null) {
                                nodeNameValue = nodeName(map);
                            }
                            writeNameAsValue(writer, nodeNameValue);
                        }
                    }
                } else if (value instanceof LinkedTreeMap) {
                    LinkedTreeMap valueMap = (LinkedTreeMap) value;
                    //get the value point type and add it to the value map
                    if (valueMap.containsKey(CompositionSerializer.TAG_CLASS)) {
                        String elementType = (String) valueMap.get(CompositionSerializer.TAG_CLASS);
                        valueMap.put(AT_CLASS, new SnakeCase(elementType).camelToUpperSnake());
                        valueMap.remove(CompositionSerializer.TAG_CLASS);
                        //TODO: CHC, 180426 temporary fix, modify DB encoding to not include name for attribute.
                        if (key.contains("/time") && valueMap.containsKey(CompositionSerializer.TAG_NAME)) {
                            valueMap.remove(CompositionSerializer.TAG_NAME);
                        }
                    }
                    if (isNodePredicate(key))
                        valueMap.put(ARCHETYPE_NODE_ID, archetypeNodeId);
                    else if (key.equals(CompositionSerializer.TAG_ORIGIN)){
                        //compact time expression
                        valueMap = compactTimeMap(valueMap);
                    }
                    else if (key.equals(CompositionSerializer.TAG_TIME)){
                        //compact time expression
                        valueMap = compactTimeMap(valueMap);
                    }
                    writer.name(jsonKey);
                    new LinkedTreeMapAdapter().write(writer, valueMap);
                } else if (value instanceof String) {
                    if (key.equals(CompositionSerializer.TAG_CLASS)) {
//                        System.out.println("name:" + AT_CLASS);
//                        writer.name(AT_CLASS).value(new SnakeCase(((String) value)).camelToUpperSnake());
                    } else if (key.equals(CompositionSerializer.TAG_PATH)) {
                        writer.name(AT_CLASS).value(ELEMENT);
                        //get the actual archetypeNodeId from path
                        archetypeNodeId = new PathAttribute((String) value).archetypeNodeId();
//                        writer.name(ARCHETYPE_NODE_ID).value(archetypeNodeId);
                        new ArchetypeNodeId(writer, archetypeNodeId).write();
                    } else if (key.equals(CompositionSerializer.TAG_NAME)) {
//                        System.out.println("name:" + NAME);
                        writeNameAsValue(writer, value.toString());
//                        writer.name(NAME).value((String) value);
                    } else {
//                        System.out.println("name:" + key);
                        writer.name(jsonKey).value((String) value);
                    }
                } else if (value instanceof Double) {
//                    System.out.println("name:" + new SnakeCase(key).camelToSnake());
                    writer.name(new SnakeCase(key).camelToSnake()).value((Double) value);
                } else if (value instanceof Long) {
//                    System.out.println("name:" + new SnakeCase(key).camelToSnake());
                    writer.name(new SnakeCase(key).camelToSnake()).value((Long) value);
                } else if (value instanceof Number) {
//                    System.out.println("name:" + new SnakeCase(key).camelToSnake());
                    writer.name(new SnakeCase(key).camelToSnake()).value((Number) value);
                } else if (value instanceof Boolean) {
//                    System.out.println("name:" + new SnakeCase(key).camelToSnake());
                    writer.name(new SnakeCase(key).camelToSnake()).value((Boolean) value);
                } else
                    throw new IllegalArgumentException("Could not handle value type for key:" + key + ", value:" + value);
            } else
                throw new IllegalArgumentException("Entry is not a map:" + entry);
        }

        return;
    }

    //	@Override
    public void write(JsonWriter writer, LinkedTreeMap map) throws IOException {

//        MapUtils.debugPrint(System.out, "begin object"+(depth++), map);

        writer.beginObject();
        String nodeKey = new PathAttribute().structuralNodeKey(map);
        String path = new PathAttribute().findPath(map);
        if (path != null && nodeKey != null) {
            String archetypeNodeId = new PathAttribute(path).parentArchetypeNodeId(nodeKey);
//            String parentNodeName = new PathAttribute(path).parentNodeName(nodeKey);
            if (archetypeNodeId != null) {
//                writer.name(ARCHETYPE_NODE_ID).value(archetypeNodeId);
                new ArchetypeNodeId(writer, archetypeNodeId).write();
            }
        } else if (parentArchetypeNodeId != null) {
            new ArchetypeNodeId(writer, parentArchetypeNodeId).write();
        }

        writeInternal(writer, map);
//        System.out.println("end object ============================================="+(depth--));
        writer.endObject();
        return;
    }

    boolean isTerminal(ArrayList list) {
        for (Object object : list) {
//            if (object instanceof ArrayList)
//                return true;
//            else if (object.getClass().getCanonicalName().contains("java.lang"))
//                return true;
            if (object instanceof LinkedTreeMap) {
                for (Object entry : ((LinkedTreeMap) object).entrySet()) {
//                    String itemKey = ((Map.Entry) entry).getKey().toString();
//                    if (itemKey.equals(CompositionSerializer.TAG_NAME))
//                        continue;
////                    if (!(itemKey.contains(ITEMS)) && !(itemKey.equals(CompositionSerializer.TAG_NAME)))
////                        return true;
                    Object mapValue = ((Map.Entry) entry).getValue();
//                    if (mapValue instanceof LinkedTreeMap) {
//                        Map values = (Map) mapValue;
//                        if (values.containsKey(CompositionSerializer.TAG_CLASS))
//                            return true;
//                    }
                    if (mapValue instanceof ArrayList) {
                        return false;
                    }
//                    else {
//                        throw new IllegalArgumentException("Unhandled type:"+mapValue.getClass());
//                    }

                }
            }
//            else {
//                throw new IllegalArgumentException("Unknown type:"+object.getClass());
//            }
        }
        return true;
    }

    void writeNameAsValue(JsonWriter writer, String value) throws IOException {
        if (value == null || value.isEmpty())
            return;
        writer.name(NAME);
        writer.beginObject();
        writer.name(VALUE).value(value);
        writer.endObject();
    }

    void writeNameAsValue(JsonWriter writer, ArrayList value) throws IOException {
//        return;
        //get the name value
        //protective against old entries in the DB...
        if (value == null)
            return;
        Object nameDefinition = ((Map) (value.get(0))).get("value");
        writeNameAsValue(writer, nameDefinition.toString());

//        writeNameAsValue(writer, );
    }

    private ArrayList nodeName(Map map) {
        ArrayList nodeNameValue = null;

        if (map.get(CompositionSerializer.TAG_NAME) != null) {
            nodeNameValue = (ArrayList) map.get(CompositionSerializer.TAG_NAME);
        }

        return nodeNameValue;
    }

    private boolean isNodePredicate(String key){
        //a key in the form '/xyz[atNNNN]'
        if (key.startsWith("/") && key.contains("[") && key.contains("]"))
            return true;
        else
            return false;
    }

    private LinkedTreeMap compactTimeMap(LinkedTreeMap valueMap){
        LinkedTreeMap compactMap = new LinkedTreeMap();
        for (Object item: valueMap.entrySet()){
            String key = (String) ((Map.Entry) item).getKey();
            if (key.equals(CompositionSerializer.TAG_VALUE)){
                String value = (String) ((LinkedTreeMap) ((Map.Entry) item).getValue()).get("value");
                compactMap.put(CompositionSerializer.TAG_VALUE, value);
            }
            else {
                compactMap.put(((Map.Entry)item).getKey(), ((Map.Entry)item).getValue());
            }

        }
        return compactMap;
    }

}
