package com.jfxdev.notifx;

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

import com.jfxdev.notifx.impl.Implementation;

public class NotiFX {

    /**
     * Declare NotiFX's public API here,
     * Implementation.get() will return a platform
     * specific implementation fo the API methods
     * @param header Message header text
     * @param content Message content
     */
    public void showMessage(String header, String content) {
        Implementation.get().showMessage(header, content);
    }

//    public static void main(String[] args) {
        // for testing only
//        new NotiFX().showMessage("Test", "Test2");
//    }

}
