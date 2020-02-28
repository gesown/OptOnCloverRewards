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

package com.clover.sdk.v3.employees;

import com.clover.sdk.GenericClient;
import com.clover.sdk.GenericParcelable;

/**
 * This is an auto-generated Clover data object.
 * <p>
 * <h3>Fields</h3>
 * <ul>
 * <li>{@link #getId id}</li>
 * <li>{@link #getMerchant merchant}</li>
 * <li>{@link #getEmployee employee}</li>
 * <li>{@link #getUpdater updater}</li>
 * <li>{@link #getNumber number}</li>
 * <li>{@link #getStatus status}</li>
 * <li>{@link #getCreatedTime createdTime}</li>
 * <li>{@link #getModifiedTime modifiedTime}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class EmployeeCard extends GenericParcelable implements com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  /**
   * Unique identifier
   */
  public java.lang.String getId() {
    return genClient.cacheGet(CacheKey.id);
  }

  /**
   * The merchant the card belongs to
   */
  public com.clover.sdk.v3.base.Reference getMerchant() {
    return genClient.cacheGet(CacheKey.merchant);
  }

  /**
   * The employee who the card is currently assigned to
   */
  public com.clover.sdk.v3.base.Reference getEmployee() {
    return genClient.cacheGet(CacheKey.employee);
  }

  /**
   * The employee who last updated the card's state
   */
  public com.clover.sdk.v3.base.Reference getUpdater() {
    return genClient.cacheGet(CacheKey.updater);
  }

  /**
   * Unique number on the employee card.
   */
  public java.lang.String getNumber() {
    return genClient.cacheGet(CacheKey.number);
  }

  /**
   * Current status of the employee card
   */
  public com.clover.sdk.v3.employees.EmployeeCardStatus getStatus() {
    return genClient.cacheGet(CacheKey.status);
  }

  /**
   * Timestamp of when this employee card was created
   */
  public java.lang.Long getCreatedTime() {
    return genClient.cacheGet(CacheKey.createdTime);
  }

  /**
   * Timestamp of when this employee card was last updated
   */
  public java.lang.Long getModifiedTime() {
    return genClient.cacheGet(CacheKey.modifiedTime);
  }




  private enum CacheKey implements com.clover.sdk.ExtractionStrategyEnum {
    id
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    merchant
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.base.Reference.JSON_CREATOR)),
    employee
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.base.Reference.JSON_CREATOR)),
    updater
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.base.Reference.JSON_CREATOR)),
    number
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    status
        (com.clover.sdk.extractors.EnumExtractionStrategy.instance(com.clover.sdk.v3.employees.EmployeeCardStatus.class)),
    createdTime
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Long.class)),
    modifiedTime
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Long.class)),
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

  private final GenericClient<EmployeeCard> genClient;

  /**
   * Constructs a new empty instance.
   */
  public EmployeeCard() {
    genClient = new GenericClient<EmployeeCard>(this);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
   * Constructs a new empty instance.
   */
  protected EmployeeCard(boolean noInit) {
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public EmployeeCard(String json) throws IllegalArgumentException {
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
  public EmployeeCard(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public EmployeeCard(EmployeeCard src) {
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

    genClient.validateLength(getNumber(), 16);
  }

  /** Checks whether the 'id' field is set and is not null */
  public boolean isNotNullId() {
    return genClient.cacheValueIsNotNull(CacheKey.id);
  }

  /** Checks whether the 'merchant' field is set and is not null */
  public boolean isNotNullMerchant() {
    return genClient.cacheValueIsNotNull(CacheKey.merchant);
  }

  /** Checks whether the 'employee' field is set and is not null */
  public boolean isNotNullEmployee() {
    return genClient.cacheValueIsNotNull(CacheKey.employee);
  }

  /** Checks whether the 'updater' field is set and is not null */
  public boolean isNotNullUpdater() {
    return genClient.cacheValueIsNotNull(CacheKey.updater);
  }

  /** Checks whether the 'number' field is set and is not null */
  public boolean isNotNullNumber() {
    return genClient.cacheValueIsNotNull(CacheKey.number);
  }

  /** Checks whether the 'status' field is set and is not null */
  public boolean isNotNullStatus() {
    return genClient.cacheValueIsNotNull(CacheKey.status);
  }

  /** Checks whether the 'createdTime' field is set and is not null */
  public boolean isNotNullCreatedTime() {
    return genClient.cacheValueIsNotNull(CacheKey.createdTime);
  }

  /** Checks whether the 'modifiedTime' field is set and is not null */
  public boolean isNotNullModifiedTime() {
    return genClient.cacheValueIsNotNull(CacheKey.modifiedTime);
  }



  /** Checks whether the 'id' field has been set, however the value could be null */
  public boolean hasId() {
    return genClient.cacheHasKey(CacheKey.id);
  }

  /** Checks whether the 'merchant' field has been set, however the value could be null */
  public boolean hasMerchant() {
    return genClient.cacheHasKey(CacheKey.merchant);
  }

  /** Checks whether the 'employee' field has been set, however the value could be null */
  public boolean hasEmployee() {
    return genClient.cacheHasKey(CacheKey.employee);
  }

  /** Checks whether the 'updater' field has been set, however the value could be null */
  public boolean hasUpdater() {
    return genClient.cacheHasKey(CacheKey.updater);
  }

  /** Checks whether the 'number' field has been set, however the value could be null */
  public boolean hasNumber() {
    return genClient.cacheHasKey(CacheKey.number);
  }

  /** Checks whether the 'status' field has been set, however the value could be null */
  public boolean hasStatus() {
    return genClient.cacheHasKey(CacheKey.status);
  }

  /** Checks whether the 'createdTime' field has been set, however the value could be null */
  public boolean hasCreatedTime() {
    return genClient.cacheHasKey(CacheKey.createdTime);
  }

  /** Checks whether the 'modifiedTime' field has been set, however the value could be null */
  public boolean hasModifiedTime() {
    return genClient.cacheHasKey(CacheKey.modifiedTime);
  }


  /**
   * Sets the field 'id'.
   */
  public EmployeeCard setId(java.lang.String id) {
    return genClient.setOther(id, CacheKey.id);
  }

  /**
   * Sets the field 'merchant'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public EmployeeCard setMerchant(com.clover.sdk.v3.base.Reference merchant) {
    return genClient.setRecord(merchant, CacheKey.merchant);
  }

  /**
   * Sets the field 'employee'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public EmployeeCard setEmployee(com.clover.sdk.v3.base.Reference employee) {
    return genClient.setRecord(employee, CacheKey.employee);
  }

  /**
   * Sets the field 'updater'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public EmployeeCard setUpdater(com.clover.sdk.v3.base.Reference updater) {
    return genClient.setRecord(updater, CacheKey.updater);
  }

  /**
   * Sets the field 'number'.
   */
  public EmployeeCard setNumber(java.lang.String number) {
    return genClient.setOther(number, CacheKey.number);
  }

  /**
   * Sets the field 'status'.
   */
  public EmployeeCard setStatus(com.clover.sdk.v3.employees.EmployeeCardStatus status) {
    return genClient.setOther(status, CacheKey.status);
  }

  /**
   * Sets the field 'createdTime'.
   */
  public EmployeeCard setCreatedTime(java.lang.Long createdTime) {
    return genClient.setOther(createdTime, CacheKey.createdTime);
  }

  /**
   * Sets the field 'modifiedTime'.
   */
  public EmployeeCard setModifiedTime(java.lang.Long modifiedTime) {
    return genClient.setOther(modifiedTime, CacheKey.modifiedTime);
  }


  /** Clears the 'id' field, the 'has' method for this field will now return false */
  public void clearId() {
    genClient.clear(CacheKey.id);
  }
  /** Clears the 'merchant' field, the 'has' method for this field will now return false */
  public void clearMerchant() {
    genClient.clear(CacheKey.merchant);
  }
  /** Clears the 'employee' field, the 'has' method for this field will now return false */
  public void clearEmployee() {
    genClient.clear(CacheKey.employee);
  }
  /** Clears the 'updater' field, the 'has' method for this field will now return false */
  public void clearUpdater() {
    genClient.clear(CacheKey.updater);
  }
  /** Clears the 'number' field, the 'has' method for this field will now return false */
  public void clearNumber() {
    genClient.clear(CacheKey.number);
  }
  /** Clears the 'status' field, the 'has' method for this field will now return false */
  public void clearStatus() {
    genClient.clear(CacheKey.status);
  }
  /** Clears the 'createdTime' field, the 'has' method for this field will now return false */
  public void clearCreatedTime() {
    genClient.clear(CacheKey.createdTime);
  }
  /** Clears the 'modifiedTime' field, the 'has' method for this field will now return false */
  public void clearModifiedTime() {
    genClient.clear(CacheKey.modifiedTime);
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
  public EmployeeCard copyChanges() {
    EmployeeCard copy = new EmployeeCard();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(EmployeeCard src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new EmployeeCard(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<EmployeeCard> CREATOR = new android.os.Parcelable.Creator<EmployeeCard>() {
    @Override
    public EmployeeCard createFromParcel(android.os.Parcel in) {
      EmployeeCard instance = new EmployeeCard(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public EmployeeCard[] newArray(int size) {
      return new EmployeeCard[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<EmployeeCard> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<EmployeeCard>() {
    @Override
    public EmployeeCard create(org.json.JSONObject jsonObject) {
      return new EmployeeCard(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean ID_IS_REQUIRED = false;
    public static final long ID_MAX_LEN = 13;
    public static final boolean MERCHANT_IS_REQUIRED = false;
    public static final boolean EMPLOYEE_IS_REQUIRED = false;
    public static final boolean UPDATER_IS_REQUIRED = false;
    public static final boolean NUMBER_IS_REQUIRED = false;
    public static final long NUMBER_MAX_LEN = 16;
    public static final boolean STATUS_IS_REQUIRED = false;
    public static final boolean CREATEDTIME_IS_REQUIRED = false;
    public static final boolean MODIFIEDTIME_IS_REQUIRED = false;

  }

}
