/*
 * Copyright (c) 2018 HERE Europe B.V.
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
package com.here.account.auth.provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import com.here.account.http.HttpProvider.HttpRequestAuthorizer;
import com.here.account.oauth2.ClientCredentialsProvider;

/**
 * @author kmccrack
 */
public class FromHereCredentialsIniFile implements ClientCredentialsProvider {

    private static final String CREDENTIALS_DOT_INI_FILENAME = "credentials.ini";

    private final File file;
    private final String sectionName;
    
    public FromHereCredentialsIniFile() {
        this(getDefaultHereCredentialsIniFile(), FromHereCredentialsIniStream.DEFAULT_INI_SECTION_NAME);
    }

    public FromHereCredentialsIniFile(File file, String sectionName) {
        Objects.requireNonNull(file, "file is required");

        this.file = file;
        this.sectionName = sectionName;
    }
    
    /**
     * The delegate allows for reloading the file each time it is used, 
     * in case it has changed.
     * 
     * @return
     */
    protected ClientCredentialsProvider getDelegate() {
        try (InputStream inputStream = new FileInputStream(file)) {
            return new FromHereCredentialsIniStream(inputStream, sectionName);
        } catch (IOException e) {
            throw new RuntimeException("trouble FromFile " + e, e);
        }
    }
    
    protected File getFile() {
        return file;
    }

    protected static File getDefaultHereCredentialsIniFile() {
        return DefaultHereConfigFiles.getDefaultHereConfigFile(CREDENTIALS_DOT_INI_FILENAME);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTokenEndpointUrl() {
        return getDelegate().getTokenEndpointUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpRequestAuthorizer getClientAuthorizer() {
        return getDelegate().getClientAuthorizer();
    }

}
