/**
 * Copyright (C) 2014 Couchbase, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALING
 * IN THE SOFTWARE.
 */
package com.couchbase.client.java.document;

import com.couchbase.client.core.message.ResponseStatus;

/**
 * Represents a Couchbase Server Document which is stored in and retrieved from a Bucket.
 *
 * Implementations need encode provide concrete content behavior, depending on the document type (i.e. JSON,
 * Binary,...).
 *
 * @author Michael Nitschinger
 * @since 2.0
 */
public interface Document<T> {

    /**
    * The per-bucket unique ID of the document.
    *
    * @return the document id.
    */
    String id();

    /**
    * The content of the document.
    *
    * @return the content.
    */
    T content();

    /**
    * The last-known CAS value for the document (0 if not set).
    *
    * @return the CAS value if set.
    */
    long cas();

    /**
    * The optional expiration time for the document (0 if not set).
    *
    * @return the expiration time.
    */
    int expiry();

    /**
     * The status of the response if a document has been retrieved or mutated.
     *
     * @return the status code.
     */
    ResponseStatus status();

}
