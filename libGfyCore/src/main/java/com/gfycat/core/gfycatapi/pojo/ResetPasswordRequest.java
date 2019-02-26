/*
 * Copyright (c) 2015-present, Gfycat, Inc. All rights reserved.
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

package com.gfycat.core.gfycatapi.pojo;

/**
 * Created by dekalo on 05.02.16.
 */
public class ResetPasswordRequest {

    final String value;
    final String action = "send_password_reset_email";

    public ResetPasswordRequest(String email) {
        this.value = email;
    }

    public String getValue() {
        return value;
    }

    public String getAction() {
        return action;
    }
}
