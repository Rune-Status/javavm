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
import com.javadeobfuscator.javavm.StackTraceHolder;
import com.javadeobfuscator.javavm.VirtualMachine;
import com.javadeobfuscator.javavm.hooks.HookGenerator;
import com.javadeobfuscator.javavm.internals.VMSymbols;
import com.javadeobfuscator.javavm.mirrors.JavaClass;
import com.javadeobfuscator.javavm.utils.ArrayConversionHelper;
import com.javadeobfuscator.javavm.values.JavaWrapper;

import java.security.SecureRandom;
import java.util.List;

public class sun_security_provider_NativeSeedGenerator {
    private final VirtualMachine _vm;

    public sun_security_provider_NativeSeedGenerator(VirtualMachine vm) {
        _vm = vm;
        registerNatives();
    }

    private void registerNatives() {
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "sun/security/provider/NativeSeedGenerator", "nativeGenerateSeed", "([B)Z", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            SecureRandom secureRandom = new SecureRandom();
            byte[] bytes = ArrayConversionHelper.convertByteArray(args[0].asArray());
            secureRandom.nextBytes(bytes);
            for (int i = 0; i < bytes.length; i++) {
                args[0].asArray().set(i, _vm.newByte(bytes[i]));
            }
            return _vm.newBoolean(true);
        }));
    }
}
