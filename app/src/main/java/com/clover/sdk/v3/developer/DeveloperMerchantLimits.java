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

package com.clover.sdk.v3.developer;

import com.clover.sdk.GenericClient;
import com.clover.sdk.GenericParcelable;

/**
 * This is an auto-generated Clover data object.
 * <p>
 * <h3>Fields</h3>
 * <ul>
 * <li>{@link #getRequestLimit requestLimit}</li>
 * <li>{@link #getMerchantRequestLimit merchantRequestLimit}</li>
 * <li>{@link #getConcurrentRequestLimit concurrentRequestLimit}</li>
 * <li>{@link #getConcurrentMerchantRequestLimit concurrentMerchantRequestLimit}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class DeveloperMerchantLimits extends GenericParcelable implements com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  /**
   * Total limit for developers.
   */
  public java.lang.Integer getRequestLimit() {
    return genClient.cacheGet(CacheKey.requestLimit);
  }

  /**
   * Limit for each merchant app.
   */
  public java.lang.Integer getMerchantRequestLimit() {
    return genClient.cacheGet(CacheKey.merchantRequestLimit);
  }

  /**
   * Total concurrent requests for developer app.
   */
  public java.lang.Integer getConcurrentRequestLimit() {
    return genClient.cacheGet(CacheKey.concurrentRequestLimit);
  }

  /**
   * Concurrent request limit for each merchant app.
   */
  public java.lang.Integer getConcurrentMerchantRequestLimit() {
    return genClient.cacheGet(CacheKey.concurrentMerchantRequestLimit);
  }




  private enum CacheKey implements com.clover.sdk.ExtractionStrategyEnum {
    requestLimit
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Integer.class)),
    merchantRequestLimit
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Integer.class)),
    concurrentRequestLimit
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Integer.class)),
    concurrentMerchantRequestLimit
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Integer.class)),
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

  private final GenericClient<DeveloperMerchantLimits> genClient;

  /**
   * Constructs a new empty instance.
   */
  public DeveloperMerchantLimits() {
    genClient = new GenericClient<DeveloperMerchantLimits>(this);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
   * Constructs a new empty instance.
   */
  protected DeveloperMerchantLimits(boolean noInit) {
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public DeveloperMerchantLimits(String json) throws IllegalArgumentException {
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
  public DeveloperMerchantLimits(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public DeveloperMerchantLimits(DeveloperMerchantLimits src) {
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

  /** Checks whether the 'requestLimit' field is set and is not null */
  public boolean isNotNullRequestLimit() {
    return genClient.cacheValueIsNotNull(CacheKey.requestLimit);
  }

  /** Checks whether the 'merchantRequestLimit' field is set and is not null */
  public boolean isNotNullMerchantRequestLimit() {
    return genClient.cacheValueIsNotNull(CacheKey.merchantRequestLimit);
  }

  /** Checks whether the 'concurrentRequestLimit' field is set and is not null */
  public boolean isNotNullConcurrentRequestLimit() {
    return genClient.cacheValueIsNotNull(CacheKey.concurrentRequestLimit);
  }

  /** Checks whether the 'concurrentMerchantRequestLimit' field is set and is not null */
  public boolean isNotNullConcurrentMerchantRequestLimit() {
    return genClient.cacheValueIsNotNull(CacheKey.concurrentMerchantRequestLimit);
  }



  /** Checks whether the 'requestLimit' field has been set, however the value could be null */
  public boolean hasRequestLimit() {
    return genClient.cacheHasKey(CacheKey.requestLimit);
  }

  /** Checks whether the 'merchantRequestLimit' field has been set, however the value could be null */
  public boolean hasMerchantRequestLimit() {
    return genClient.cacheHasKey(CacheKey.merchantRequestLimit);
  }

  /** Checks whether the 'concurrentRequestLimit' field has been set, however the value could be null */
  public boolean hasConcurrentRequestLimit() {
    return genClient.cacheHasKey(CacheKey.concurrentRequestLimit);
  }

  /** Checks whether the 'concurrentMerchantRequestLimit' field has been set, however the value could be null */
  public boolean hasConcurrentMerchantRequestLimit() {
    return genClient.cacheHasKey(CacheKey.concurrentMerchantRequestLimit);
  }


  /**
   * Sets the field 'requestLimit'.
   */
  public DeveloperMerchantLimits setRequestLimit(java.lang.Integer requestLimit) {
    return genClient.setOther(requestLimit, CacheKey.requestLimit);
  }

  /**
   * Sets the field 'merchantRequestLimit'.
   */
  public DeveloperMerchantLimits setMerchantRequestLimit(java.lang.Integer merchantRequestLimit) {
    return genClient.setOther(merchantRequestLimit, CacheKey.merchantRequestLimit);
  }

  /**
   * Sets the field 'concurrentRequestLimit'.
   */
  public DeveloperMerchantLimits setConcurrentRequestLimit(java.lang.Integer concurrentRequestLimit) {
    return genClient.setOther(concurrentRequestLimit, CacheKey.concurrentRequestLimit);
  }

  /**
   * Sets the field 'concurrentMerchantRequestLimit'.
   */
  public DeveloperMerchantLimits setConcurrentMerchantRequestLimit(java.lang.Integer concurrentMerchantRequestLimit) {
    return genClient.setOther(concurrentMerchantRequestLimit, CacheKey.concurrentMerchantRequestLimit);
  }


  /** Clears the 'requestLimit' field, the 'has' method for this field will now return false */
  public void clearRequestLimit() {
    genClient.clear(CacheKey.requestLimit);
  }
  /** Clears the 'merchantRequestLimit' field, the 'has' method for this field will now return false */
  public void clearMerchantRequestLimit() {
    genClient.clear(CacheKey.merchantRequestLimit);
  }
  /** Clears the 'concurrentRequestLimit' field, the 'has' method for this field will now return false */
  public void clearConcurrentRequestLimit() {
    genClient.clear(CacheKey.concurrentRequestLimit);
  }
  /** Clears the 'concurrentMerchantRequestLimit' field, the 'has' method for this field will now return false */
  public void clearConcurrentMerchantRequestLimit() {
    genClient.clear(CacheKey.concurrentMerchantRequestLimit);
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
  public DeveloperMerchantLimits copyChanges() {
    DeveloperMerchantLimits copy = new DeveloperMerchantLimits();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(DeveloperMerchantLimits src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new DeveloperMerchantLimits(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<DeveloperMerchantLimits> CREATOR = new android.os.Parcelable.Creator<DeveloperMerchantLimits>() {
    @Override
    public DeveloperMerchantLimits createFromParcel(android.os.Parcel in) {
      DeveloperMerchantLimits instance = new DeveloperMerchantLimits(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public DeveloperMerchantLimits[] newArray(int size) {
      return new DeveloperMerchantLimits[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<DeveloperMerchantLimits> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<DeveloperMerchantLimits>() {
    @Override
    public DeveloperMerchantLimits create(org.json.JSONObject jsonObject) {
      return new DeveloperMerchantLimits(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean REQUESTLIMIT_IS_REQUIRED = false;
    public static final boolean MERCHANTREQUESTLIMIT_IS_REQUIRED = false;
    public static final boolean CONCURRENTREQUESTLIMIT_IS_REQUIRED = false;
    public static final boolean CONCURRENTMERCHANTREQUESTLIMIT_IS_REQUIRED = false;

  }

}
