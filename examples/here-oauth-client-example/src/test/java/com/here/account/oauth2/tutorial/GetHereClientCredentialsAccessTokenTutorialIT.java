/*
 * Copyright (c) 2016 HERE Europe B.V.
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
package com.here.account.oauth2.tutorial;

import java.io.File;

import org.junit.Test;

public class GetHereClientCredentialsAccessTokenTutorialIT {

    @Test
    public void test_explicit_defaultCredentialsFile() {
        File file = GetHereClientCredentialsAccessTokenTutorial.getDefaultCredentialsFile();
        String path = null != file ? file.getAbsolutePath() : "broken";
        String[] args = {
                path
        };
        GetHereClientCredentialsAccessTokenTutorial tutorial = 
                GetHereClientCredentialsAccessTokenTutorialTest.mockTutorial(args);
        if (null == file) {
            GetHereClientCredentialsAccessTokenTutorialTest.setTestCreds(tutorial, 
                    GetHereClientCredentialsAccessTokenTutorialTest.getSystemCredentials());
        }
        tutorial.getAccessToken();
    }
    
    @Test
    public void test_noArgs_defaultCredentialsFile() {
        File file = GetHereClientCredentialsAccessTokenTutorial.getDefaultCredentialsFile();
        String[] args = {
        };
        GetHereClientCredentialsAccessTokenTutorial tutorial = 
                GetHereClientCredentialsAccessTokenTutorialTest.mockTutorial(args);
        if (null == file) {
            GetHereClientCredentialsAccessTokenTutorialTest.setTestCreds(tutorial, 
                    GetHereClientCredentialsAccessTokenTutorialTest.getSystemCredentials());
        }
        tutorial.getAccessToken();
    }
    


}
