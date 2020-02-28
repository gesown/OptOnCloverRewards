/*
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
package com.clover.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public abstract class SimpleSyncClient extends ContentObserver {
  public static final String METHOD_GET = "get";
  public static final String METHOD_PUT = "put";
  public static final String METHOD_UPDATE = "update";

  public static final String EXTRA_DATA = "data";
  public static final String EXTRA_ITEM_ID = "itemId";

  protected final Context context;

  public SimpleSyncClient(Context context) {
    this(context, new Handler(Looper.getMainLooper()));
  }

  public SimpleSyncClient(Context context, Handler observerHandler) {
    super(observerHandler);
    this.context = context;
  }

  public byte[] getData() {
    Bundle result = context.getContentResolver().call(getAuthorityUri(), METHOD_GET, null, null);
    if (result == null) {
      return null;
    }
    return result.getByteArray(EXTRA_DATA);
  }

  protected void putData(byte[] data) {
    Bundle extras = new Bundle();
    extras.putByteArray(EXTRA_DATA, data);
    context.getContentResolver().call(getAuthorityUri(), METHOD_PUT, null, null);
  }

  public void updateData(byte[] data) {
    Bundle extras = new Bundle();
    extras.putByteArray(EXTRA_DATA, data);
    context.getContentResolver().call(getAuthorityUri(), METHOD_UPDATE, null, extras);
  }

  public void updateData(String itemId, byte[] data) {
    Bundle extras = new Bundle();
    extras.putByteArray(EXTRA_DATA, data);
    extras.putString(EXTRA_ITEM_ID, itemId);
    context.getContentResolver().call(getAuthorityUri(), METHOD_UPDATE, null, extras);
  }

  protected abstract String getAuthority();

  protected Uri getAuthorityUri() {
    return Uri.parse("content://" + getAuthority());
  }

  public void register() {
    context.getContentResolver().registerContentObserver(getAuthorityUri(), false, this);
  }

  public void unregister() {
    context.getContentResolver().unregisterContentObserver(this);
  }
}
