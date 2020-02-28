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

package com.clover.sdk.v3.apps;

import com.clover.sdk.GenericClient;
import com.clover.sdk.GenericParcelable;

/**
 * This is an auto-generated Clover data object.
 * <p>
 * <h3>Fields</h3>
 * <ul>
 * <li>{@link #getId id}</li>
 * <li>{@link #getName name}</li>
 * <li>{@link #getDisplayName displayName}</li>
 * <li>{@link #getSdkVersion sdkVersion}</li>
 * <li>{@link #getModels models}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class DeviceType extends GenericParcelable implements com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  /**
   * Unique identifier
   */
  public java.lang.String getId() {
    return genClient.cacheGet(CacheKey.id);
  }

  public java.lang.String getName() {
    return genClient.cacheGet(CacheKey.name);
  }

  public java.lang.String getDisplayName() {
    return genClient.cacheGet(CacheKey.displayName);
  }

  /**
   * SDK version supported by device
   */
  public java.lang.Integer getSdkVersion() {
    return genClient.cacheGet(CacheKey.sdkVersion);
  }

  public java.lang.String getModels() {
    return genClient.cacheGet(CacheKey.models);
  }




  private enum CacheKey implements com.clover.sdk.ExtractionStrategyEnum {
    id
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    name
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    displayName
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    sdkVersion
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Integer.class)),
    models
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
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

  private final GenericClient<DeviceType> genClient;

  /**
   * Constructs a new empty instance.
   */
  public DeviceType() {
    genClient = new GenericClient<DeviceType>(this);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
   * Constructs a new empty instance.
   */
  protected DeviceType(boolean noInit) {
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public DeviceType(String json) throws IllegalArgumentException {
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
  public DeviceType(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public DeviceType(DeviceType src) {
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
    genClient.validateLength(getId(), 13);

    genClient.validateLength(getName(), 255);

    genClient.validateLength(getDisplayName(), 255);

    genClient.validateLength(getModels(), 255);
  }

  /** Checks whether the 'id' field is set and is not null */
  public boolean isNotNullId() {
    return genClient.cacheValueIsNotNull(CacheKey.id);
  }

  /** Checks whether the 'name' field is set and is not null */
  public boolean isNotNullName() {
    return genClient.cacheValueIsNotNull(CacheKey.name);
  }

  /** Checks whether the 'displayName' field is set and is not null */
  public boolean isNotNullDisplayName() {
    return genClient.cacheValueIsNotNull(CacheKey.displayName);
  }

  /** Checks whether the 'sdkVersion' field is set and is not null */
  public boolean isNotNullSdkVersion() {
    return genClient.cacheValueIsNotNull(CacheKey.sdkVersion);
  }

  /** Checks whether the 'models' field is set and is not null */
  public boolean isNotNullModels() {
    return genClient.cacheValueIsNotNull(CacheKey.models);
  }



  /** Checks whether the 'id' field has been set, however the value could be null */
  public boolean hasId() {
    return genClient.cacheHasKey(CacheKey.id);
  }

  /** Checks whether the 'name' field has been set, however the value could be null */
  public boolean hasName() {
    return genClient.cacheHasKey(CacheKey.name);
  }

  /** Checks whether the 'displayName' field has been set, however the value could be null */
  public boolean hasDisplayName() {
    return genClient.cacheHasKey(CacheKey.displayName);
  }

  /** Checks whether the 'sdkVersion' field has been set, however the value could be null */
  public boolean hasSdkVersion() {
    return genClient.cacheHasKey(CacheKey.sdkVersion);
  }

  /** Checks whether the 'models' field has been set, however the value could be null */
  public boolean hasModels() {
    return genClient.cacheHasKey(CacheKey.models);
  }


  /**
   * Sets the field 'id'.
   */
  public DeviceType setId(java.lang.String id) {
    return genClient.setOther(id, CacheKey.id);
  }

  /**
   * Sets the field 'name'.
   */
  public DeviceType setName(java.lang.String name) {
    return genClient.setOther(name, CacheKey.name);
  }

  /**
   * Sets the field 'displayName'.
   */
  public DeviceType setDisplayName(java.lang.String displayName) {
    return genClient.setOther(displayName, CacheKey.displayName);
  }

  /**
   * Sets the field 'sdkVersion'.
   */
  public DeviceType setSdkVersion(java.lang.Integer sdkVersion) {
    return genClient.setOther(sdkVersion, CacheKey.sdkVersion);
  }

  /**
   * Sets the field 'models'.
   */
  public DeviceType setModels(java.lang.String models) {
    return genClient.setOther(models, CacheKey.models);
  }


  /** Clears the 'id' field, the 'has' method for this field will now return false */
  public void clearId() {
    genClient.clear(CacheKey.id);
  }
  /** Clears the 'name' field, the 'has' method for this field will now return false */
  public void clearName() {
    genClient.clear(CacheKey.name);
  }
  /** Clears the 'displayName' field, the 'has' method for this field will now return false */
  public void clearDisplayName() {
    genClient.clear(CacheKey.displayName);
  }
  /** Clears the 'sdkVersion' field, the 'has' method for this field will now return false */
  public void clearSdkVersion() {
    genClient.clear(CacheKey.sdkVersion);
  }
  /** Clears the 'models' field, the 'has' method for this field will now return false */
  public void clearModels() {
    genClient.clear(CacheKey.models);
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
  public DeviceType copyChanges() {
    DeviceType copy = new DeviceType();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(DeviceType src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new DeviceType(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<DeviceType> CREATOR = new android.os.Parcelable.Creator<DeviceType>() {
    @Override
    public DeviceType createFromParcel(android.os.Parcel in) {
      DeviceType instance = new DeviceType(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public DeviceType[] newArray(int size) {
      return new DeviceType[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<DeviceType> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<DeviceType>() {
    @Override
    public DeviceType create(org.json.JSONObject jsonObject) {
      return new DeviceType(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean ID_IS_REQUIRED = false;
    public static final long ID_MAX_LEN = 13;
    public static final boolean NAME_IS_REQUIRED = false;
    public static final long NAME_MAX_LEN = 255;
    public static final boolean DISPLAYNAME_IS_REQUIRED = false;
    public static final long DISPLAYNAME_MAX_LEN = 255;
    public static final boolean SDKVERSION_IS_REQUIRED = false;
    public static final boolean MODELS_IS_REQUIRED = false;
    public static final long MODELS_MAX_LEN = 255;

  }

}
