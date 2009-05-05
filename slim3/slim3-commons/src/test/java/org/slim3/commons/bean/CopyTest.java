/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.slim3.commons.bean;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

/**
 * @author higa
 */
public class CopyTest extends TestCase {

    /**
     * @throws Exception
     */
    public void testExecuteForBeanToBean() throws Exception {
        MyBean src = new MyBean();
        src.setAaa("aaa");
        MyBean dest = new MyBean();
        new Copy(src, dest).execute();
        assertEquals("aaa", dest.getAaa());
    }

    /**
     * @throws Exception
     */
    public void testConstructorForSrcIsNull() throws Exception {
        try {
            new Copy(null, "");
            fail();
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    /**
     * @throws Exception
     */
    public void testConstructorForDestIsNull() throws Exception {
        try {
            new Copy("", null);
            fail();
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    /**
     * @throws Exception
     */
    public void testExecuteForBeanToMap() throws Exception {
        MyBean src = new MyBean();
        src.setAaa("aaa");
        Map<String, Object> dest = new HashMap<String, Object>();
        new Copy(src, dest).execute();
        assertEquals("aaa", dest.get("aaa"));
    }

    /**
     * @throws Exception
     */
    public void testExecuteForMapToBean() throws Exception {
        Map<String, Object> src = new HashMap<String, Object>();
        src.put("aaa", "aaa");
        MyBean dest = new MyBean();
        new Copy(src, dest).execute();
        assertEquals("aaa", dest.getAaa());
    }

    /**
     * @throws Exception
     */
    public void testExecuteForMapToMap() throws Exception {
        Map<String, Object> src = new HashMap<String, Object>();
        src.put("aaa", "aaa");
        Map<String, Object> dest = new HashMap<String, Object>();
        new Copy(src, dest).execute();
        assertEquals("aaa", dest.get("aaa"));
    }
}
