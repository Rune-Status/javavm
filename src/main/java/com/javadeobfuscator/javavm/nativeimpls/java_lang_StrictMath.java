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

package com.javadeobfuscator.javavm.nativeimpls;

import com.javadeobfuscator.javavm.Cause;
import com.javadeobfuscator.javavm.Effect;
import com.javadeobfuscator.javavm.VirtualMachine;
import com.javadeobfuscator.javavm.hooks.HookGenerator;
import com.javadeobfuscator.javavm.values.JavaWrapper;

public class java_lang_StrictMath {
    private static final String THIS = "java/lang/StrictMath";

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "log", "(D)D", true, Cause.ALL, Effect.ALL, (ctx, inst, args) -> {
            return JavaWrapper.createDouble(vm, StrictMath.log(args[0].asDouble()));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "pow", "(DD)D", true, Cause.ALL, Effect.ALL, (ctx, inst, args) -> {
            return JavaWrapper.createDouble(vm, StrictMath.pow(args[0].asDouble(), args[1].asDouble()));
        }));
    }
}
