/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.myorg.example.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jcr.Session;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;

import com.day.cq.wcm.api.Page;

@Model(adaptables=SlingHttpServletRequest.class)
public class HelloWorldModel {

    @Inject
    private SlingSettingsService settings;
    
    @Inject
    private ResourceResolver resolver;
    
    @Inject
    private ResourceResolverFactory resolverFactory;

    @Inject @Named("sling:resourceType") @Default(values="No resourceType")
    protected String resourceType;

    private String message;
    
    @Inject
    private Page currentPage;
    @PostConstruct
    protected void init()  {
    	
        message = "\tHello World!\n";
        message += "\tThis is instance: " + settings.getSlingId() + "\n";
     //   message += "\tThis is USER: " + currentPage.getPath() + "\n";
       // message += "\tThis is USER FROM SESSIon: " + resolver.adaptTo(Session.class).getUserID() + "\n";
        message += "\tResource type is: " + resourceType + "\n";
    }

    public String getMessage() {
        return message;
    }
    public Page getResourcePage() {
        return currentPage;
    }
  
}
