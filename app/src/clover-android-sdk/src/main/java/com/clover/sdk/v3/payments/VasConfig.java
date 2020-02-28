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

package com.clover.sdk.v3.payments;

import com.clover.sdk.GenericClient;
import com.clover.sdk.GenericParcelable;

/**
 * This is an auto-generated Clover data object.
 * <p>
 * <h3>Fields</h3>
 * <ul>
 * <li>{@link #getVasProviders vasProviders}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class VasConfig extends GenericParcelable implements com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  /**
   * List of vas service providers who are interested in receiving vas data
   */
  public java.util.List<com.clover.sdk.v3.payments.VasServiceProvider> getVasProviders() {
    return genClient.cacheGet(CacheKey.vasProviders);
  }




  private enum CacheKey implements com.clover.sdk.ExtractionStrategyEnum {
    vasProviders
        (com.clover.sdk.extractors.RecordListExtractionStrategy.instance(com.clover.sdk.v3.payments.VasServiceProvider.JSON_CREATOR)),
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

  private final GenericClient<VasConfig> genClient;

  /**
   * Constructs a new empty instance.
   */
  public VasConfig() {
    genClient = new GenericClient<VasConfig>(this);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
   * Constructs a new empty instance.
   */
  protected VasConfig(boolean noInit) {
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public VasConfig(String json) throws IllegalArgumentException {
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
  public VasConfig(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public VasConfig(VasConfig src) {
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

  /** Checks whether the 'vasProviders' field is set and is not null */
  public boolean isNotNullVasProviders() {
    return genClient.cacheValueIsNotNull(CacheKey.vasProviders);
  }

  /** Checks whether the 'vasProviders' field is set and is not null and is not empty */
  public boolean isNotEmptyVasProviders() { return isNotNullVasProviders() && !getVasProviders().isEmpty(); }



  /** Checks whether the 'vasProviders' field has been set, however the value could be null */
  public boolean hasVasProviders() {
    return genClient.cacheHasKey(CacheKey.vasProviders);
  }


  /**
   * Sets the field 'vasProviders'.
   *
   * Nulls in the given List are skipped. List parameter is copied, so it will not reflect any changes, but objects inside it will.
   */
  public VasConfig setVasProviders(java.util.List<com.clover.sdk.v3.payments.VasServiceProvider> vasProviders) {
    return genClient.setArrayRecord(vasProviders, CacheKey.vasProviders);
  }


  /** Clears the 'vasProviders' field, the 'has' method for this field will now return false */
  public void clearVasProviders() {
    genClient.clear(CacheKey.vasProviders);
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
  public VasConfig copyChanges() {
    VasConfig copy = new VasConfig();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(VasConfig src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new VasConfig(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<VasConfig> CREATOR = new android.os.Parcelable.Creator<VasConfig>() {
    @Override
    public VasConfig createFromParcel(android.os.Parcel in) {
      VasConfig instance = new VasConfig(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public VasConfig[] newArray(int size) {
      return new VasConfig[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<VasConfig> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<VasConfig>() {
    @Override
    public VasConfig create(org.json.JSONObject jsonObject) {
      return new VasConfig(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean VASPROVIDERS_IS_REQUIRED = false;

  }

}
