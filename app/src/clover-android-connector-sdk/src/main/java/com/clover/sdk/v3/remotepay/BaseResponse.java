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

package com.clover.sdk.v3.remotepay;

import com.clover.sdk.GenericClient;
import com.clover.sdk.GenericParcelable;

/**
 * This is an auto-generated Clover data object.
 * <p>
 * The base for responses
 * <p>
 * <h3>Fields</h3>
 * <ul>
 * <li>{@link #getSuccess success}</li>
 * <li>{@link #getResult result}</li>
 * <li>{@link #getReason reason}</li>
 * <li>{@link #getMessage message}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class BaseResponse extends GenericParcelable implements com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  /**
   * If true then the requested operation succeeded
   */
  public java.lang.Boolean getSuccess() {
    return genClient.cacheGet(CacheKey.success);
  }

  /**
   * The result of the requested operation.
   */
  public com.clover.sdk.v3.remotepay.ResponseCode getResult() {
    return genClient.cacheGet(CacheKey.result);
  }

  /**
   * Optional information about result.
   */
  public java.lang.String getReason() {
    return genClient.cacheGet(CacheKey.reason);
  }

  /**
   * Detailed information about result.
   */
  public java.lang.String getMessage() {
    return genClient.cacheGet(CacheKey.message);
  }




  private enum CacheKey implements com.clover.sdk.ExtractionStrategyEnum {
    success
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Boolean.class)),
    result
        (com.clover.sdk.extractors.EnumExtractionStrategy.instance(com.clover.sdk.v3.remotepay.ResponseCode.class)),
    reason
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    message
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

  private final GenericClient<BaseResponse> genClient;

  /**
   * Constructs a new empty instance.
   */
  public BaseResponse() {
    genClient = new GenericClient<BaseResponse>(this);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
   * Constructs a new empty instance.
   */
  protected BaseResponse(boolean noInit) {
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public BaseResponse(String json) throws IllegalArgumentException {
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
  public BaseResponse(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public BaseResponse(BaseResponse src) {
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

  /** Checks whether the 'success' field is set and is not null */
  public boolean isNotNullSuccess() {
    return genClient.cacheValueIsNotNull(CacheKey.success);
  }

  /** Checks whether the 'result' field is set and is not null */
  public boolean isNotNullResult() {
    return genClient.cacheValueIsNotNull(CacheKey.result);
  }

  /** Checks whether the 'reason' field is set and is not null */
  public boolean isNotNullReason() {
    return genClient.cacheValueIsNotNull(CacheKey.reason);
  }

  /** Checks whether the 'message' field is set and is not null */
  public boolean isNotNullMessage() {
    return genClient.cacheValueIsNotNull(CacheKey.message);
  }



  /** Checks whether the 'success' field has been set, however the value could be null */
  public boolean hasSuccess() {
    return genClient.cacheHasKey(CacheKey.success);
  }

  /** Checks whether the 'result' field has been set, however the value could be null */
  public boolean hasResult() {
    return genClient.cacheHasKey(CacheKey.result);
  }

  /** Checks whether the 'reason' field has been set, however the value could be null */
  public boolean hasReason() {
    return genClient.cacheHasKey(CacheKey.reason);
  }

  /** Checks whether the 'message' field has been set, however the value could be null */
  public boolean hasMessage() {
    return genClient.cacheHasKey(CacheKey.message);
  }


  /**
   * Sets the field 'success'.
   */
  public BaseResponse setSuccess(java.lang.Boolean success) {
    return genClient.setOther(success, CacheKey.success);
  }

  /**
   * Sets the field 'result'.
   */
  public BaseResponse setResult(com.clover.sdk.v3.remotepay.ResponseCode result) {
    return genClient.setOther(result, CacheKey.result);
  }

  /**
   * Sets the field 'reason'.
   */
  public BaseResponse setReason(java.lang.String reason) {
    return genClient.setOther(reason, CacheKey.reason);
  }

  /**
   * Sets the field 'message'.
   */
  public BaseResponse setMessage(java.lang.String message) {
    return genClient.setOther(message, CacheKey.message);
  }


  /** Clears the 'success' field, the 'has' method for this field will now return false */
  public void clearSuccess() {
    genClient.clear(CacheKey.success);
  }
  /** Clears the 'result' field, the 'has' method for this field will now return false */
  public void clearResult() {
    genClient.clear(CacheKey.result);
  }
  /** Clears the 'reason' field, the 'has' method for this field will now return false */
  public void clearReason() {
    genClient.clear(CacheKey.reason);
  }
  /** Clears the 'message' field, the 'has' method for this field will now return false */
  public void clearMessage() {
    genClient.clear(CacheKey.message);
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
  public BaseResponse copyChanges() {
    BaseResponse copy = new BaseResponse();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(BaseResponse src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new BaseResponse(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<BaseResponse> CREATOR = new android.os.Parcelable.Creator<BaseResponse>() {
    @Override
    public BaseResponse createFromParcel(android.os.Parcel in) {
      BaseResponse instance = new BaseResponse(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public BaseResponse[] newArray(int size) {
      return new BaseResponse[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<BaseResponse> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<BaseResponse>() {
    @Override
    public BaseResponse create(org.json.JSONObject jsonObject) {
      return new BaseResponse(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean SUCCESS_IS_REQUIRED = false;
    public static final boolean RESULT_IS_REQUIRED = false;
    public static final boolean REASON_IS_REQUIRED = false;
    public static final boolean MESSAGE_IS_REQUIRED = false;

  }

}