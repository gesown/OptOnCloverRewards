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
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clover.sdk.v3.analytics;

import com.clover.sdk.GenericClient;
import com.clover.sdk.GenericParcelable;

/**
 * This is an auto-generated Clover data object.
 * <p>
 * <h3>Fields</h3>
 * <ul>
 * <li>{@link #getAdjustAmount adjustAmount}</li>
 * <li>{@link #getCreatedTime createdTime}</li>
 * <li>{@link #getMerchant merchant}</li>
 * <li>{@link #getCardTransaction cardTransaction}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class TipAdjustedPayload extends GenericParcelable implements com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  /**
   * Adjusted amount like tip, auth or cash back
   */
  public java.lang.Integer getAdjustAmount() {
    return genClient.cacheGet(CacheKey.adjustAmount);
  }

  public java.lang.Long getCreatedTime() {
    return genClient.cacheGet(CacheKey.createdTime);
  }

  public com.clover.sdk.v3.base.Reference getMerchant() {
    return genClient.cacheGet(CacheKey.merchant);
  }

  public com.clover.sdk.v3.payments.CardTransaction getCardTransaction() {
    return genClient.cacheGet(CacheKey.cardTransaction);
  }




  private enum CacheKey implements com.clover.sdk.ExtractionStrategyEnum {
    adjustAmount
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Integer.class)),
    createdTime
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Long.class)),
    merchant
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.base.Reference.JSON_CREATOR)),
    cardTransaction
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.payments.CardTransaction.JSON_CREATOR)),
      ;

    private final com.clover.sdk.extractors.ExtractionStrategy extractionStrategy;

    private CacheKey(com.clover.sdk.extractors.ExtractionStrategy s) {
      extractionStrategy = s;
    }

    @Override
    public com.clover.sdk.extractors.ExtractionStrategy getExtractionStrategy() {
      return extractionStrategy;
    }
  }

  private final GenericClient<TipAdjustedPayload> genClient;

  /**
   * Constructs a new empty instance.
   */
  public TipAdjustedPayload() {
    genClient = new GenericClient<TipAdjustedPayload>(this);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
   * Constructs a new empty instance.
   */
  protected TipAdjustedPayload(boolean noInit) {
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public TipAdjustedPayload(String json) throws IllegalArgumentException {
    this();
    try {
      genClient.setJsonObject(new org.json.JSONObject(json));
    } catch (org.json.JSONException e) {
      throw new IllegalArgumentException("invalid json", e);
    }
  }

  /**
   * Construct a new instance backed by the given JSONObject, the parameter is not copied so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public TipAdjustedPayload(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public TipAdjustedPayload(TipAdjustedPayload src) {
    this();
    if (src.genClient.getJsonObject() != null) {
      genClient.setJsonObject(com.clover.sdk.v3.JsonHelper.deepCopy(src.genClient.getJSONObject()));
    }
  }

  /**
   * Returns the internal JSONObject backing this instance, the return value is not a copy so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public org.json.JSONObject getJSONObject() {
    return genClient.getJSONObject();
  }

  @Override
  public void validate() {
  }

  /** Checks whether the 'adjustAmount' field is set and is not null */
  public boolean isNotNullAdjustAmount() {
    return genClient.cacheValueIsNotNull(CacheKey.adjustAmount);
  }

  /** Checks whether the 'createdTime' field is set and is not null */
  public boolean isNotNullCreatedTime() {
    return genClient.cacheValueIsNotNull(CacheKey.createdTime);
  }

  /** Checks whether the 'merchant' field is set and is not null */
  public boolean isNotNullMerchant() {
    return genClient.cacheValueIsNotNull(CacheKey.merchant);
  }

  /** Checks whether the 'cardTransaction' field is set and is not null */
  public boolean isNotNullCardTransaction() {
    return genClient.cacheValueIsNotNull(CacheKey.cardTransaction);
  }



  /** Checks whether the 'adjustAmount' field has been set, however the value could be null */
  public boolean hasAdjustAmount() {
    return genClient.cacheHasKey(CacheKey.adjustAmount);
  }

  /** Checks whether the 'createdTime' field has been set, however the value could be null */
  public boolean hasCreatedTime() {
    return genClient.cacheHasKey(CacheKey.createdTime);
  }

  /** Checks whether the 'merchant' field has been set, however the value could be null */
  public boolean hasMerchant() {
    return genClient.cacheHasKey(CacheKey.merchant);
  }

  /** Checks whether the 'cardTransaction' field has been set, however the value could be null */
  public boolean hasCardTransaction() {
    return genClient.cacheHasKey(CacheKey.cardTransaction);
  }


  /**
   * Sets the field 'adjustAmount'.
   */
  public TipAdjustedPayload setAdjustAmount(java.lang.Integer adjustAmount) {
    return genClient.setOther(adjustAmount, CacheKey.adjustAmount);
  }

  /**
   * Sets the field 'createdTime'.
   */
  public TipAdjustedPayload setCreatedTime(java.lang.Long createdTime) {
    return genClient.setOther(createdTime, CacheKey.createdTime);
  }

  /**
   * Sets the field 'merchant'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public TipAdjustedPayload setMerchant(com.clover.sdk.v3.base.Reference merchant) {
    return genClient.setRecord(merchant, CacheKey.merchant);
  }

  /**
   * Sets the field 'cardTransaction'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public TipAdjustedPayload setCardTransaction(com.clover.sdk.v3.payments.CardTransaction cardTransaction) {
    return genClient.setRecord(cardTransaction, CacheKey.cardTransaction);
  }


  /** Clears the 'adjustAmount' field, the 'has' method for this field will now return false */
  public void clearAdjustAmount() {
    genClient.clear(CacheKey.adjustAmount);
  }
  /** Clears the 'createdTime' field, the 'has' method for this field will now return false */
  public void clearCreatedTime() {
    genClient.clear(CacheKey.createdTime);
  }
  /** Clears the 'merchant' field, the 'has' method for this field will now return false */
  public void clearMerchant() {
    genClient.clear(CacheKey.merchant);
  }
  /** Clears the 'cardTransaction' field, the 'has' method for this field will now return false */
  public void clearCardTransaction() {
    genClient.clear(CacheKey.cardTransaction);
  }


  /**
   * Returns true if this instance has any changes.
   */
  public boolean containsChanges() {
    return genClient.containsChanges();
  }

  /**
   * Reset the log of changes made to this instance, calling copyChanges() after this would return an empty instance.
   */
  public void resetChangeLog() {
    genClient.resetChangeLog();
  }

  /**
   * Create a copy of this instance that contains only fields that were set after the constructor was called.
   */
  public TipAdjustedPayload copyChanges() {
    TipAdjustedPayload copy = new TipAdjustedPayload();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(TipAdjustedPayload src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new TipAdjustedPayload(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<TipAdjustedPayload> CREATOR = new android.os.Parcelable.Creator<TipAdjustedPayload>() {
    @Override
    public TipAdjustedPayload createFromParcel(android.os.Parcel in) {
      TipAdjustedPayload instance = new TipAdjustedPayload(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public TipAdjustedPayload[] newArray(int size) {
      return new TipAdjustedPayload[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<TipAdjustedPayload> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<TipAdjustedPayload>() {
    @Override
    public TipAdjustedPayload create(org.json.JSONObject jsonObject) {
      return new TipAdjustedPayload(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean ADJUSTAMOUNT_IS_REQUIRED = false;
    public static final boolean CREATEDTIME_IS_REQUIRED = false;
    public static final boolean MERCHANT_IS_REQUIRED = false;
    public static final boolean CARDTRANSACTION_IS_REQUIRED = false;

  }

}
