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

package com.javadeobfuscator.javavm.utils;

import org.apache.commons.lang3.StringEscapeUtils;

public class NameHelper {

    public static String nameAndType(String name, String type) {
        return name + "." + type;
    }

    public static String prettyOwnerNameDesc(String owner, String name, String desc) {
        return StringEscapeUtils.escapeJava(owner) + "." + StringEscapeUtils.escapeJava(name) + "." + StringEscapeUtils.escapeJava(desc);
    }
}
