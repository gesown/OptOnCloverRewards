/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */

/*
 * Copyright (C) 2019 Clover Network, Inc.
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

package com.clover.sdk.v3.order;

@SuppressWarnings("all")
public class DiscountListFdParcelable extends com.clover.sdk.FdParcelable<java.util.List<com.clover.sdk.v3.order.Discount>> {
  public DiscountListFdParcelable(java.util.List<com.clover.sdk.v3.order.Discount> value) {
    super(value);
  }

  public DiscountListFdParcelable(android.os.Parcel in) {
    super(in);
  }

  public static final android.os.Parcelable.Creator<DiscountListFdParcelable> CREATOR = new android.os.Parcelable.Creator<DiscountListFdParcelable>() {
    @Override
    public DiscountListFdParcelable createFromParcel(android.os.Parcel in) {
      return new DiscountListFdParcelable(in);
    }

    @Override
    public DiscountListFdParcelable[] newArray(int size) {
      return new DiscountListFdParcelable[size];
    }
  };
}
