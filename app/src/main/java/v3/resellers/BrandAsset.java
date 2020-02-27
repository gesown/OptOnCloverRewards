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

package com.clover.sdk.v3.resellers;

import com.clover.sdk.GenericClient;
import com.clover.sdk.GenericParcelable;

/**
 * This is an auto-generated Clover data object.
 * <p>
 * <h3>Fields</h3>
 * <ul>
 * <li>{@link #getId id}</li>
 * <li>{@link #getType type}</li>
 * <li>{@link #getFilename filename}</li>
 * <li>{@link #getMimeType mimeType}</li>
 * <li>{@link #getUrl url}</li>
 * <li>{@link #getReseller reseller}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class BrandAsset extends GenericParcelable implements com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  /**
   * Unique identifier
   */
  public java.lang.String getId() {
    return genClient.cacheGet(CacheKey.id);
  }

  public java.lang.String getType() {
    return genClient.cacheGet(CacheKey.type);
  }

  public java.lang.String getFilename() {
    return genClient.cacheGet(CacheKey.filename);
  }

  public java.lang.String getMimeType() {
    return genClient.cacheGet(CacheKey.mimeType);
  }

  public java.lang.String getUrl() {
    return genClient.cacheGet(CacheKey.url);
  }

  public com.clover.sdk.v3.base.Reference getReseller() {
    return genClient.cacheGet(CacheKey.reseller);
  }




  private enum CacheKey implements com.clover.sdk.ExtractionStrategyEnum {
    id
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    type
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    filename
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    mimeType
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    url
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    reseller
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.base.Reference.JSON_CREATOR)),
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

  private final GenericClient<BrandAsset> genClient;

  /**
   * Constructs a new empty instance.
   */
  public BrandAsset() {
    genClient = new GenericClient<BrandAsset>(this);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
   * Constructs a new empty instance.
   */
  protected BrandAsset(boolean noInit) {
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public BrandAsset(String json) throws IllegalArgumentException {
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
  public BrandAsset(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public BrandAsset(BrandAsset src) {
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
  }

  /** Checks whether the 'id' field is set and is not null */
  public boolean isNotNullId() {
    return genClient.cacheValueIsNotNull(CacheKey.id);
  }

  /** Checks whether the 'type' field is set and is not null */
  public boolean isNotNullType() {
    return genClient.cacheValueIsNotNull(CacheKey.type);
  }

  /** Checks whether the 'filename' field is set and is not null */
  public boolean isNotNullFilename() {
    return genClient.cacheValueIsNotNull(CacheKey.filename);
  }

  /** Checks whether the 'mimeType' field is set and is not null */
  public boolean isNotNullMimeType() {
    return genClient.cacheValueIsNotNull(CacheKey.mimeType);
  }

  /** Checks whether the 'url' field is set and is not null */
  public boolean isNotNullUrl() {
    return genClient.cacheValueIsNotNull(CacheKey.url);
  }

  /** Checks whether the 'reseller' field is set and is not null */
  public boolean isNotNullReseller() {
    return genClient.cacheValueIsNotNull(CacheKey.reseller);
  }



  /** Checks whether the 'id' field has been set, however the value could be null */
  public boolean hasId() {
    return genClient.cacheHasKey(CacheKey.id);
  }

  /** Checks whether the 'type' field has been set, however the value could be null */
  public boolean hasType() {
    return genClient.cacheHasKey(CacheKey.type);
  }

  /** Checks whether the 'filename' field has been set, however the value could be null */
  public boolean hasFilename() {
    return genClient.cacheHasKey(CacheKey.filename);
  }

  /** Checks whether the 'mimeType' field has been set, however the value could be null */
  public boolean hasMimeType() {
    return genClient.cacheHasKey(CacheKey.mimeType);
  }

  /** Checks whether the 'url' field has been set, however the value could be null */
  public boolean hasUrl() {
    return genClient.cacheHasKey(CacheKey.url);
  }

  /** Checks whether the 'reseller' field has been set, however the value could be null */
  public boolean hasReseller() {
    return genClient.cacheHasKey(CacheKey.reseller);
  }


  /**
   * Sets the field 'id'.
   */
  public BrandAsset setId(java.lang.String id) {
    return genClient.setOther(id, CacheKey.id);
  }

  /**
   * Sets the field 'type'.
   */
  public BrandAsset setType(java.lang.String type) {
    return genClient.setOther(type, CacheKey.type);
  }

  /**
   * Sets the field 'filename'.
   */
  public BrandAsset setFilename(java.lang.String filename) {
    return genClient.setOther(filename, CacheKey.filename);
  }

  /**
   * Sets the field 'mimeType'.
   */
  public BrandAsset setMimeType(java.lang.String mimeType) {
    return genClient.setOther(mimeType, CacheKey.mimeType);
  }

  /**
   * Sets the field 'url'.
   */
  public BrandAsset setUrl(java.lang.String url) {
    return genClient.setOther(url, CacheKey.url);
  }

  /**
   * Sets the field 'reseller'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public BrandAsset setReseller(com.clover.sdk.v3.base.Reference reseller) {
    return genClient.setRecord(reseller, CacheKey.reseller);
  }


  /** Clears the 'id' field, the 'has' method for this field will now return false */
  public void clearId() {
    genClient.clear(CacheKey.id);
  }
  /** Clears the 'type' field, the 'has' method for this field will now return false */
  public void clearType() {
    genClient.clear(CacheKey.type);
  }
  /** Clears the 'filename' field, the 'has' method for this field will now return false */
  public void clearFilename() {
    genClient.clear(CacheKey.filename);
  }
  /** Clears the 'mimeType' field, the 'has' method for this field will now return false */
  public void clearMimeType() {
    genClient.clear(CacheKey.mimeType);
  }
  /** Clears the 'url' field, the 'has' method for this field will now return false */
  public void clearUrl() {
    genClient.clear(CacheKey.url);
  }
  /** Clears the 'reseller' field, the 'has' method for this field will now return false */
  public void clearReseller() {
    genClient.clear(CacheKey.reseller);
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
  public BrandAsset copyChanges() {
    BrandAsset copy = new BrandAsset();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(BrandAsset src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new BrandAsset(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<BrandAsset> CREATOR = new android.os.Parcelable.Creator<BrandAsset>() {
    @Override
    public BrandAsset createFromParcel(android.os.Parcel in) {
      BrandAsset instance = new BrandAsset(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public BrandAsset[] newArray(int size) {
      return new BrandAsset[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<BrandAsset> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<BrandAsset>() {
    @Override
    public BrandAsset create(org.json.JSONObject jsonObject) {
      return new BrandAsset(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean ID_IS_REQUIRED = false;
    public static final long ID_MAX_LEN = 13;
    public static final boolean TYPE_IS_REQUIRED = false;
    public static final boolean FILENAME_IS_REQUIRED = false;
    public static final boolean MIMETYPE_IS_REQUIRED = false;
    public static final boolean URL_IS_REQUIRED = false;
    public static final boolean RESELLER_IS_REQUIRED = false;

  }

}
