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

package com.clover.sdk.v3.tables2;

import com.clover.sdk.GenericClient;
import com.clover.sdk.GenericParcelable;

/**
 * This is an auto-generated Clover data object.
 * <p>
 * <h3>Fields</h3>
 * <ul>
 * <li>{@link #getId id}</li>
 * <li>{@link #getNumber number}</li>
 * <li>{@link #getTableOrder tableOrder}</li>
 * <li>{@link #getMerchant merchant}</li>
 * <li>{@link #getName name}</li>
 * <li>{@link #getTable table}</li>
 * <li>{@link #getOrder order}</li>
 * <li>{@link #getCreatedTime createdTime}</li>
 * <li>{@link #getModifiedTime modifiedTime}</li>
 * <li>{@link #getDeletedTime deletedTime}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class Guest extends GenericParcelable implements com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  /**
   * Unique identifier
   */
  public java.lang.String getId() {
    return genClient.cacheGet(CacheKey.id);
  }

  /**
   * This guest's number at the current Table Order
   */
  public java.lang.Integer getNumber() {
    return genClient.cacheGet(CacheKey.number);
  }

  /**
   * Table Order the guest belongs to
   */
  public com.clover.sdk.v3.tables2.TableOrder getTableOrder() {
    return genClient.cacheGet(CacheKey.tableOrder);
  }

  /**
   * The merchant the guest belongs to
   */
  public com.clover.sdk.v3.merchant.Merchant getMerchant() {
    return genClient.cacheGet(CacheKey.merchant);
  }

  /**
   * Name of the guest
   */
  public java.lang.String getName() {
    return genClient.cacheGet(CacheKey.name);
  }

  /**
   * Reference to the table the guest belongs to
   */
  public com.clover.sdk.v3.tables2.Table getTable() {
    return genClient.cacheGet(CacheKey.table);
  }

  /**
   * Reference to the order with which the guest is associated.
   */
  public com.clover.sdk.v3.order.Order getOrder() {
    return genClient.cacheGet(CacheKey.order);
  }

  /**
   * Timestamp when the table was created
   */
  public java.lang.Long getCreatedTime() {
    return genClient.cacheGet(CacheKey.createdTime);
  }

  /**
   * Timestamp when the table was last modified
   */
  public java.lang.Long getModifiedTime() {
    return genClient.cacheGet(CacheKey.modifiedTime);
  }

  /**
   * Timestamp when table was last deleted
   */
  public java.lang.Long getDeletedTime() {
    return genClient.cacheGet(CacheKey.deletedTime);
  }




  private enum CacheKey implements com.clover.sdk.ExtractionStrategyEnum {
    id
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    number
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Integer.class)),
    tableOrder
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.tables2.TableOrder.JSON_CREATOR)),
    merchant
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.merchant.Merchant.JSON_CREATOR)),
    name
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    table
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.tables2.Table.JSON_CREATOR)),
    order
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.order.Order.JSON_CREATOR)),
    createdTime
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Long.class)),
    modifiedTime
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Long.class)),
    deletedTime
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

  private final GenericClient<Guest> genClient;

  /**
   * Constructs a new empty instance.
   */
  public Guest() {
    genClient = new GenericClient<Guest>(this);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
   * Constructs a new empty instance.
   */
  protected Guest(boolean noInit) {
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public Guest(String json) throws IllegalArgumentException {
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
  public Guest(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public Guest(Guest src) {
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

    genClient.validateLength(getName(), 127);
  }

  /** Checks whether the 'id' field is set and is not null */
  public boolean isNotNullId() {
    return genClient.cacheValueIsNotNull(CacheKey.id);
  }

  /** Checks whether the 'number' field is set and is not null */
  public boolean isNotNullNumber() {
    return genClient.cacheValueIsNotNull(CacheKey.number);
  }

  /** Checks whether the 'tableOrder' field is set and is not null */
  public boolean isNotNullTableOrder() {
    return genClient.cacheValueIsNotNull(CacheKey.tableOrder);
  }

  /** Checks whether the 'merchant' field is set and is not null */
  public boolean isNotNullMerchant() {
    return genClient.cacheValueIsNotNull(CacheKey.merchant);
  }

  /** Checks whether the 'name' field is set and is not null */
  public boolean isNotNullName() {
    return genClient.cacheValueIsNotNull(CacheKey.name);
  }

  /** Checks whether the 'table' field is set and is not null */
  public boolean isNotNullTable() {
    return genClient.cacheValueIsNotNull(CacheKey.table);
  }

  /** Checks whether the 'order' field is set and is not null */
  public boolean isNotNullOrder() {
    return genClient.cacheValueIsNotNull(CacheKey.order);
  }

  /** Checks whether the 'createdTime' field is set and is not null */
  public boolean isNotNullCreatedTime() {
    return genClient.cacheValueIsNotNull(CacheKey.createdTime);
  }

  /** Checks whether the 'modifiedTime' field is set and is not null */
  public boolean isNotNullModifiedTime() {
    return genClient.cacheValueIsNotNull(CacheKey.modifiedTime);
  }

  /** Checks whether the 'deletedTime' field is set and is not null */
  public boolean isNotNullDeletedTime() {
    return genClient.cacheValueIsNotNull(CacheKey.deletedTime);
  }



  /** Checks whether the 'id' field has been set, however the value could be null */
  public boolean hasId() {
    return genClient.cacheHasKey(CacheKey.id);
  }

  /** Checks whether the 'number' field has been set, however the value could be null */
  public boolean hasNumber() {
    return genClient.cacheHasKey(CacheKey.number);
  }

  /** Checks whether the 'tableOrder' field has been set, however the value could be null */
  public boolean hasTableOrder() {
    return genClient.cacheHasKey(CacheKey.tableOrder);
  }

  /** Checks whether the 'merchant' field has been set, however the value could be null */
  public boolean hasMerchant() {
    return genClient.cacheHasKey(CacheKey.merchant);
  }

  /** Checks whether the 'name' field has been set, however the value could be null */
  public boolean hasName() {
    return genClient.cacheHasKey(CacheKey.name);
  }

  /** Checks whether the 'table' field has been set, however the value could be null */
  public boolean hasTable() {
    return genClient.cacheHasKey(CacheKey.table);
  }

  /** Checks whether the 'order' field has been set, however the value could be null */
  public boolean hasOrder() {
    return genClient.cacheHasKey(CacheKey.order);
  }

  /** Checks whether the 'createdTime' field has been set, however the value could be null */
  public boolean hasCreatedTime() {
    return genClient.cacheHasKey(CacheKey.createdTime);
  }

  /** Checks whether the 'modifiedTime' field has been set, however the value could be null */
  public boolean hasModifiedTime() {
    return genClient.cacheHasKey(CacheKey.modifiedTime);
  }

  /** Checks whether the 'deletedTime' field has been set, however the value could be null */
  public boolean hasDeletedTime() {
    return genClient.cacheHasKey(CacheKey.deletedTime);
  }


  /**
   * Sets the field 'id'.
   */
  public Guest setId(java.lang.String id) {
    return genClient.setOther(id, CacheKey.id);
  }

  /**
   * Sets the field 'number'.
   */
  public Guest setNumber(java.lang.Integer number) {
    return genClient.setOther(number, CacheKey.number);
  }

  /**
   * Sets the field 'tableOrder'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public Guest setTableOrder(com.clover.sdk.v3.tables2.TableOrder tableOrder) {
    return genClient.setRecord(tableOrder, CacheKey.tableOrder);
  }

  /**
   * Sets the field 'merchant'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public Guest setMerchant(com.clover.sdk.v3.merchant.Merchant merchant) {
    return genClient.setRecord(merchant, CacheKey.merchant);
  }

  /**
   * Sets the field 'name'.
   */
  public Guest setName(java.lang.String name) {
    return genClient.setOther(name, CacheKey.name);
  }

  /**
   * Sets the field 'table'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public Guest setTable(com.clover.sdk.v3.tables2.Table table) {
    return genClient.setRecord(table, CacheKey.table);
  }

  /**
   * Sets the field 'order'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public Guest setOrder(com.clover.sdk.v3.order.Order order) {
    return genClient.setRecord(order, CacheKey.order);
  }

  /**
   * Sets the field 'createdTime'.
   */
  public Guest setCreatedTime(java.lang.Long createdTime) {
    return genClient.setOther(createdTime, CacheKey.createdTime);
  }

  /**
   * Sets the field 'modifiedTime'.
   */
  public Guest setModifiedTime(java.lang.Long modifiedTime) {
    return genClient.setOther(modifiedTime, CacheKey.modifiedTime);
  }

  /**
   * Sets the field 'deletedTime'.
   */
  public Guest setDeletedTime(java.lang.Long deletedTime) {
    return genClient.setOther(deletedTime, CacheKey.deletedTime);
  }


  /** Clears the 'id' field, the 'has' method for this field will now return false */
  public void clearId() {
    genClient.clear(CacheKey.id);
  }
  /** Clears the 'number' field, the 'has' method for this field will now return false */
  public void clearNumber() {
    genClient.clear(CacheKey.number);
  }
  /** Clears the 'tableOrder' field, the 'has' method for this field will now return false */
  public void clearTableOrder() {
    genClient.clear(CacheKey.tableOrder);
  }
  /** Clears the 'merchant' field, the 'has' method for this field will now return false */
  public void clearMerchant() {
    genClient.clear(CacheKey.merchant);
  }
  /** Clears the 'name' field, the 'has' method for this field will now return false */
  public void clearName() {
    genClient.clear(CacheKey.name);
  }
  /** Clears the 'table' field, the 'has' method for this field will now return false */
  public void clearTable() {
    genClient.clear(CacheKey.table);
  }
  /** Clears the 'order' field, the 'has' method for this field will now return false */
  public void clearOrder() {
    genClient.clear(CacheKey.order);
  }
  /** Clears the 'createdTime' field, the 'has' method for this field will now return false */
  public void clearCreatedTime() {
    genClient.clear(CacheKey.createdTime);
  }
  /** Clears the 'modifiedTime' field, the 'has' method for this field will now return false */
  public void clearModifiedTime() {
    genClient.clear(CacheKey.modifiedTime);
  }
  /** Clears the 'deletedTime' field, the 'has' method for this field will now return false */
  public void clearDeletedTime() {
    genClient.clear(CacheKey.deletedTime);
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
  public Guest copyChanges() {
    Guest copy = new Guest();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(Guest src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new Guest(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<Guest> CREATOR = new android.os.Parcelable.Creator<Guest>() {
    @Override
    public Guest createFromParcel(android.os.Parcel in) {
      Guest instance = new Guest(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public Guest[] newArray(int size) {
      return new Guest[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<Guest> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<Guest>() {
    @Override
    public Guest create(org.json.JSONObject jsonObject) {
      return new Guest(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean ID_IS_REQUIRED = false;
    public static final long ID_MAX_LEN = 13;
    public static final boolean NUMBER_IS_REQUIRED = false;
    public static final boolean TABLEORDER_IS_REQUIRED = false;
    public static final boolean MERCHANT_IS_REQUIRED = false;
    public static final boolean NAME_IS_REQUIRED = false;
    public static final long NAME_MAX_LEN = 127;
    public static final boolean TABLE_IS_REQUIRED = false;
    public static final boolean ORDER_IS_REQUIRED = false;
    public static final boolean CREATEDTIME_IS_REQUIRED = false;
    public static final boolean MODIFIEDTIME_IS_REQUIRED = false;
    public static final boolean DELETEDTIME_IS_REQUIRED = false;

  }

}
