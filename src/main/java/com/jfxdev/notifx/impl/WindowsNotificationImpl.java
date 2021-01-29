package com.jfxdev.notifx.impl;

/*
 *  Copyright (C) 2020 Dustin K. Redmond
 *
 *  This program is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the Free
 *  Software Foundation; either version 2 of the License, or (at your option)
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *  FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 *  more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

import static java.nio.charset.StandardCharsets.UTF_16LE;

import static jdk.incubator.foreign.CLinker.C_INT;
import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.MemoryAddress.NULL;

import java.lang.invoke.MethodType;

import jdk.incubator.foreign.LibraryLookup;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.MemoryAddress;

public class WindowsNotificationImpl implements Notification {

    @Override
    public int showMessage(String header, String content) {
        try {
            var user32 = LibraryLookup.ofLibrary("user32");
            var messageBoxFunction = user32.lookup("MessageBoxW");
            var messageBoxLayout = FunctionDescriptor.of(C_INT, C_POINTER, C_POINTER, C_POINTER, C_INT);
            var javaMethodType = MethodType.methodType(int.class, MemoryAddress.class, MemoryAddress.class, MemoryAddress.class, int.class);
            var methodHandle = CLinker.getInstance().downcallHandle(messageBoxFunction.get(), javaMethodType, messageBoxLayout);
            try (var str1 = CLinker.toCString(header, UTF_16LE); var str2 = CLinker.toCString(content, UTF_16LE)) {
                return (int) methodHandle.invokeExact(NULL, str1.address(), str2.address(), 0);
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}
