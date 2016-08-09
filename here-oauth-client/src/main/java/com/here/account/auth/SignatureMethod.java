/*
 * Copyright 2016 HERE Global B.V.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.here.account.auth;

/**
 * enum for signature methods.
 * 
 * @author srrajago
 */
public enum SignatureMethod {
    HMACSHA1("HmacSHA1", "HMAC-SHA1"),
    HMACSHA256("HmacSHA256", "HMAC-SHA256");

    private String algorithm;
    private String oauth1SignatureMethod;

    SignatureMethod(String alg, String method) {
        this.algorithm = alg;
        this.oauth1SignatureMethod = method;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getOauth1SignatureMethod() {
        return oauth1SignatureMethod;
    }
}