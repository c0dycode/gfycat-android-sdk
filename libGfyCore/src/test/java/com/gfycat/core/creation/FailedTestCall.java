/*
 * Copyright (c) 2015-present, Gfycat, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use,
 * copy, modify, and distribute this software in source code or binary form for use
 * in connection with the web services and APIs provided by Gfycat.
 *
 * As with any software that integrates with the Gfycat platform, your use of
 * this software is subject to the Gfycat Terms of Service [https://gfycat.com/terms]
 * and Partner Terms of Service [https://gfycat.com/partners/terms]. This copyright
 * notice shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gfycat.core.creation;


import java.io.IOException;

import retrofit2.Callback;
import retrofit2.Response;

public class FailedTestCall extends TestCall {

    private final String message;

    public FailedTestCall(String message) {
        this.message = message;
    }

    @Override
    public void enqueue(Callback callback) {
        callback.onFailure(this, new IOException("FailedTestCall::enqueue() " + message));
    }

    @Override
    public Response execute() throws IOException {
        throw new IOException("FailedTestCall::execute() " + message);
    }
}
