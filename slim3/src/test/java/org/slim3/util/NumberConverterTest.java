/*
 * Copyright 2004-2009 the original author or authors.
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
package org.slim3.util;

import java.sql.Timestamp;

import org.slim3.util.NumberConverter;

import junit.framework.TestCase;

/**
 * @author higa
 * 
 */
public class NumberConverterTest extends TestCase {

    /**
     * @throws Exception
     */
    public void testGetAsObject() throws Exception {
        NumberConverter converter = new NumberConverter("##0");
        assertEquals(new Long("100"), converter.getAsObject("100"));
    }

    /**
     * @throws Exception
     */
    public void testGetAsString() throws Exception {
        NumberConverter converter = new NumberConverter("##0");
        assertEquals("100", converter.getAsString(new Integer("100")));
    }

    /**
     * @throws Exception
     */
    public void testGetAsStringForCastException() throws Exception {
        NumberConverter converter = new NumberConverter("##0");
        try {
            converter.getAsString("aaa");
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    /**
     * @throws Exception
     */
    public void testConstructorForNull() throws Exception {
        try {
            new NumberConverter(null);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    /**
     * @throws Exception
     */
    public void testIsTarget() throws Exception {
        NumberConverter converter = new NumberConverter("##0");
        assertTrue(converter.isTarget(Integer.class));
        assertFalse(converter.isTarget(Timestamp.class));
    }
}