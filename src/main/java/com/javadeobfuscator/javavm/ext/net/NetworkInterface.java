/*
 * Copyright 2017 Sam Sun <github-contact@samczsun.com>
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

package com.javadeobfuscator.javavm.ext.net;

import java.util.List;

public class NetworkInterface {
    private String name;
    private String displayName;
    private List<InterfaceAddress> bindings;

    public NetworkInterface() {

    }

    public NetworkInterface(String name, String displayName, List<InterfaceAddress> bindings) {
        this.name = name;
        this.displayName = displayName;
        this.bindings = bindings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<InterfaceAddress> getBindings() {
        return bindings;
    }

    public void setBindings(List<InterfaceAddress> bindings) {
        this.bindings = bindings;
    }
}
