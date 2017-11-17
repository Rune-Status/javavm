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

package com.javadeobfuscator.javavm.values;

import com.javadeobfuscator.javavm.exceptions.ExecutionException;
import com.javadeobfuscator.javavm.mirrors.JavaClass;
import org.objectweb.asm.tree.AbstractInsnNode;

import java.util.EnumSet;

public class JavaAddress extends JavaValue {
    private static final EnumSet<JavaValueType> TYPES = EnumSet.of(JavaValueType.ADDRESS);
    private final AbstractInsnNode value;


    public JavaAddress(AbstractInsnNode value) {
        this.value = value;
    }

    @Override
    public boolean is(JavaValueType type) {
        return TYPES.contains(type);
    }

    @Override
    public JavaClass getJavaClass() {
        throw new ExecutionException("cannot get class of javaaddress");
    }

    @Override
    public int getSize() {
        return 1;
    }

    public AbstractInsnNode getReturnAddres() {
        return value;
    }

    public String toString() {
        return "JavaAddress(addr=" + value + ")";
    }
}
