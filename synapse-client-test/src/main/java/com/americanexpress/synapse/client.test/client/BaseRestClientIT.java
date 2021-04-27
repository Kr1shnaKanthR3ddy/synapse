/*
 * Copyright 2020 American Express Travel Related Services Company, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.americanexpress.synapse.client.test.client;


import com.americanexpress.synapse.client.rest.client.BaseRestClient;
import com.americanexpress.synapse.client.rest.factory.BaseClientHttpHeadersFactory;
import com.americanexpress.synapse.client.rest.model.BaseClientRequest;
import com.americanexpress.synapse.client.rest.model.BaseClientResponse;

public abstract class BaseRestClientIT<I extends BaseClientRequest,
        O extends BaseClientResponse,
        H extends BaseClientHttpHeadersFactory<I>,
        C extends BaseRestClient<I, O, H>> extends BaseRestClientTest<I, O, H, C> {

    protected abstract void callService_success() throws Exception;

}
