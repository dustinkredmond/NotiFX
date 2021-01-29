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


import com.jfxdev.notifx.util.OSHelper;

/**
 * Implementation represents the actual native implementation of the notification
 * behavior. Calls to {@code Notification.get()} will return a platform specific
 * class that will implement the API.
 */
public class Implementation {

    private static final WindowsNotificationImpl windowsNotification = new WindowsNotificationImpl();
    private static final MacOSNotificationImpl macOSNotification = new MacOSNotificationImpl();

    public static Notification get() {
        OSHelper.Type type = OSHelper.getType();
        switch (type) {
            case WINDOWS: return windowsNotification;
            case MACOS: return macOSNotification;
        }
        throw new UnsupportedOperationException("NotiFX is not supported by"
                + " your operating system or desktop environment.");
    }

}
