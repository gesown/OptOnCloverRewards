/**
 * Copyright (C) 2016 Clover Network, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.clover.connector.sdk.v3;

import com.clover.sdk.v1.Intents;

import android.accounts.Account;
import android.content.Intent;

public class DisplayIntent {
  public static final String ACTION_DISPLAY_SERVICE_V3 = "com.clover.intent.action.DISPLAY_SERVICE_V3";

  public static Account getAccount(Intent intent) {
    return intent.getParcelableExtra(Intents.EXTRA_ACCOUNT);
  }

  public static int getVersion(Intent intent) {
    return intent.getIntExtra(Intents.EXTRA_VERSION, 3);
  }
}