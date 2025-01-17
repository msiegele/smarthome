package org.eclipse.smarthome.binding.digitalstrom.internal.digitalSTROMLibary.digitalSTROMStructure.digitalSTROMScene.constants;

/**
 * Copyright (c) 2010-2014, openHAB.org and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

import java.util.HashMap;

/**
 * The {@link EventPropertyEnum} contains all DigitalSTROM-Event properties of an ESH-Event.
 *
 * @author Alexander Betker
 * @since 1.3.0
 */
public enum EventPropertyEnum {

    EVENT_NAME("eventName"),
    ZONEID("zoneID"),
    SCENEID("sceneID"),
    ORIGIN_DEVICEID("originDeviceID"),
    GROUPID("groupID"),
    GROUP_NAME("groupName"),
    DSID("dsid"),
    IS_DEVICE_CALL("isDevice");

    private final String id;

    static final HashMap<String, EventPropertyEnum> eventProperties = new HashMap<String, EventPropertyEnum>();

    static {
        for (EventPropertyEnum ev : EventPropertyEnum.values()) {
            eventProperties.put(ev.getId(), ev);
        }
    }

    /**
     * Returns true if the given property exists at the ESH event properties otherwise false.
     * 
     * @param property
     * @return contains property (true = yes | false = no)
     */
    public static boolean containsId(String property) {
        return eventProperties.keySet().contains(property);
    }

    /**
     * Returns the {@link EventPropertyEnum} to the given property.
     * 
     * @param property
     * @return EventPropertyEnum
     */
    public static EventPropertyEnum getProperty(String property) {
        return eventProperties.get(property);
    }

    private EventPropertyEnum(String id) {
        this.id = id;
    }

    /**
     * Returns the id of this {@link EventPropertyEnum}.
     * 
     * @return id of this {@link EventPropertyEnum}
     */

    public String getId() {
        return id;
    }

}
