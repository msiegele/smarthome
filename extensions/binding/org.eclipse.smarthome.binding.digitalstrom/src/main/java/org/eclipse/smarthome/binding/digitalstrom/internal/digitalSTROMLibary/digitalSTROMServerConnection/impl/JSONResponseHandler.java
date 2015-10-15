/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.binding.digitalstrom.internal.digitalSTROMLibary.digitalSTROMServerConnection.impl;

import org.eclipse.smarthome.binding.digitalstrom.internal.digitalSTROMLibary.digitalSTROMServerConnection.constants.JSONApiResponseKeysEnum;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link JSONResponseHandler} checks an digitalSTROM-JSON response and can parse it to an {@link JSONObject}.
 *
 * @author Alexander Betker - Initial contribution
 * @author Alex Maier - Initial contribution
 * @author Michael Ochel - add Java-Doc and make methods static
 * @author Matthias Siegele - add Java-Doc and make methods static
 */
public class JSONResponseHandler {

    private static final Logger logger = LoggerFactory.getLogger(JSONResponseHandler.class);

    /**
     * Checks the digitalSTROM-JSON response and return true if it wars successful, otherwise false
     *
     * @param jsonResponse
     * @return true on success
     */
    public static boolean checkResponse(JSONObject jsonResponse) {
        if (jsonResponse == null)
            return false;
        else if (jsonResponse.get(JSONApiResponseKeysEnum.RESPONSE_OK.getKey()) != null) {
            return jsonResponse.get(JSONApiResponseKeysEnum.RESPONSE_OK.getKey()).toString()
                    .equals(JSONApiResponseKeysEnum.RESPONSE_SUCCESSFUL.getKey());
        } else {
            logger.error("JSONResponseHandler: error in json request. Error message : "
                    + jsonResponse.get(JSONApiResponseKeysEnum.RESPONSE_MESSAGE).toString());
        }
        return false;
    }

    /**
     * Returns the {@link JSONObject} from the given digitalSTROM-JSON response {@link String} or null if the json
     * response wars empty.
     *
     * @param jsonResponse
     * @return jsonObject
     */
    public static JSONObject toJSONObject(String jsonResponse) {
        if (jsonResponse != null && !jsonResponse.trim().equals("")) {
            try {
                return (JSONObject) new JSONParser().parse(jsonResponse);
            } catch (ParseException e) {
                logger.error("JSONResponseHandler: " + e.getLocalizedMessage());
            }
        }
        return null;
    }

    /**
     * Returns the result {@link JSONObject} from the given digitalSTROM-JSON response {@link JSONObject}.
     *
     * @param jsonObject
     * @return json result object
     */
    public static JSONObject getResultJSONObject(JSONObject jsonObject) {
        if (jsonObject != null) {
            return (JSONObject) jsonObject.get(JSONApiResponseKeysEnum.RESULT.getKey());
        }
        return null;
    }

}