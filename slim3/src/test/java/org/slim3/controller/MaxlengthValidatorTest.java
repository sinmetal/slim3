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
package org.slim3.controller;

import java.util.Locale;

import junit.framework.TestCase;

import org.slim3.tester.MockHttpServletRequest;
import org.slim3.tester.MockServletContext;
import org.slim3.util.ApplicationMessage;

/**
 * @author higa
 * 
 */
public class MaxlengthValidatorTest extends TestCase {

    private MockServletContext servletContext = new MockServletContext();

    private MockHttpServletRequest request =
        new MockHttpServletRequest(servletContext);

    private MaxlengthValidator validator = new MaxlengthValidator(3);

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ApplicationMessage.setBundle("test", Locale.ENGLISH);
    }

    @Override
    protected void tearDown() throws Exception {
        ApplicationMessage.clearBundle();
        super.tearDown();
    }

    /**
     * @throws Exception
     */
    public void testValidateForNull() throws Exception {
        assertNull(validator.validate(request, "aaa"));
    }

    /**
     * @throws Exception
     */
    public void testValidateForEmptyString() throws Exception {
        request.setAttribute("aaa", "");
        assertNull(validator.validate(request, "aaa"));
    }

    /**
     * @throws Exception
     */
    public void testValidateForValid() throws Exception {
        request.setAttribute("aaa", "111");
        assertNull(validator.validate(request, "aaa"));
    }

    /**
     * @throws Exception
     */
    public void testValidateForInvalid() throws Exception {
        request.setAttribute("aaa", "xxxx");
        assertEquals("Aaa can not be greater than 3 characters.", validator
            .validate(request, "aaa"));
    }
}