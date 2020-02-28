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
 * <li>{@link #getId id}</li>
 * <li>{@link #getName name}</li>
 * <li>{@link #getRate rate}</li>
 * <li>{@link #getIsDefault isDefault}</li>
 * <li>{@link #getTaxableAmount taxableAmount}</li>
 * <li>{@link #getIsVat isVat}</li>
 * <li>{@link #getTaxAmount taxAmount}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class PaymentTaxRate extends GenericParcelable implements com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  /**
   * Tax rate id.
   */
  public java.lang.String getId() {
    return genClient.cacheGet(CacheKey.id);
  }

  /**
   * Tax rate name. This field is optional.
   */
  public java.lang.String getName() {
    return genClient.cacheGet(CacheKey.name);
  }

  /**
   * The tax rate. 100% = 1e7.
   */
  public java.lang.Long getRate() {
    return genClient.cacheGet(CacheKey.rate);
  }

  /**
   * Whether the tax rate was configued as a default tax rate at the time that the payment was created.
   */
  public java.lang.Boolean getIsDefault() {
    return genClient.cacheGet(CacheKey.isDefault);
  }

  /**
   * The sub-total of line items that the tax was based on. For VAT, this amount includes tax. For all others, this amount does not include tax.
   */
  public java.lang.Long getTaxableAmount() {
    return genClient.cacheGet(CacheKey.taxableAmount);
  }

  /**
   * Whether merchant is configured as VAT
   */
  public java.lang.Boolean getIsVat() {
    return genClient.cacheGet(CacheKey.isVat);
  }

  /**
   * The amount of tax collected. In cases where there are multiple payments for an order then it may be necessary to add an extra cent of tax to the last payment.
   */
  public java.lang.Long getTaxAmount() {
    return genClient.cacheGet(CacheKey.taxAmount);
  }




  private enum CacheKey implements com.clover.sdk.ExtractionStrategyEnum {
    id
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    name
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.String.class)),
    rate
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Long.class)),
    isDefault
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Boolean.class)),
    taxableAmount
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Long.class)),
    isVat
        (com.clover.sdk.extractors.BasicExtractionStrategy.instance(java.lang.Boolean.class)),
    taxAmount
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

  private final GenericClient<PaymentTaxRate> genClient;

  /**
   * Constructs a new empty instance.
   */
  public PaymentTaxRate() {
    genClient = new GenericClient<PaymentTaxRate>(this);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
   * Constructs a new empty instance.
   */
  protected PaymentTaxRate(boolean noInit) {
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public PaymentTaxRate(String json) throws IllegalArgumentException {
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
  public PaymentTaxRate(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public PaymentTaxRate(PaymentTaxRate src) {
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

    genClient.validateNull(getName(), "name");
    genClient.validateLength(getName(), 127);

    genClient.validateNull(getRate(), "rate");
    if (getRate() != null && ( getRate() < 0)) throw new IllegalArgumentException("Invalid value for 'getRate()'");

    genClient.validateNull(getTaxableAmount(), "taxableAmount");
  }

  /** Checks whether the 'id' field is set and is not null */
  public boolean isNotNullId() {
    return genClient.cacheValueIsNotNull(CacheKey.id);
  }

  /** Checks whether the 'name' field is set and is not null */
  public boolean isNotNullName() {
    return genClient.cacheValueIsNotNull(CacheKey.name);
  }

  /** Checks whether the 'rate' field is set and is not null */
  public boolean isNotNullRate() {
    return genClient.cacheValueIsNotNull(CacheKey.rate);
  }

  /** Checks whether the 'isDefault' field is set and is not null */
  public boolean isNotNullIsDefault() {
    return genClient.cacheValueIsNotNull(CacheKey.isDefault);
  }

  /** Checks whether the 'taxableAmount' field is set and is not null */
  public boolean isNotNullTaxableAmount() {
    return genClient.cacheValueIsNotNull(CacheKey.taxableAmount);
  }

  /** Checks whether the 'isVat' field is set and is not null */
  public boolean isNotNullIsVat() {
    return genClient.cacheValueIsNotNull(CacheKey.isVat);
  }

  /** Checks whether the 'taxAmount' field is set and is not null */
  public boolean isNotNullTaxAmount() {
    return genClient.cacheValueIsNotNull(CacheKey.taxAmount);
  }



  /** Checks whether the 'id' field has been set, however the value could be null */
  public boolean hasId() {
    return genClient.cacheHasKey(CacheKey.id);
  }

  /** Checks whether the 'name' field has been set, however the value could be null */
  public boolean hasName() {
    return genClient.cacheHasKey(CacheKey.name);
  }

  /** Checks whether the 'rate' field has been set, however the value could be null */
  public boolean hasRate() {
    return genClient.cacheHasKey(CacheKey.rate);
  }

  /** Checks whether the 'isDefault' field has been set, however the value could be null */
  public boolean hasIsDefault() {
    return genClient.cacheHasKey(CacheKey.isDefault);
  }

  /** Checks whether the 'taxableAmount' field has been set, however the value could be null */
  public boolean hasTaxableAmount() {
    return genClient.cacheHasKey(CacheKey.taxableAmount);
  }

  /** Checks whether the 'isVat' field has been set, however the value could be null */
  public boolean hasIsVat() {
    return genClient.cacheHasKey(CacheKey.isVat);
  }

  /** Checks whether the 'taxAmount' field has been set, however the value could be null */
  public boolean hasTaxAmount() {
    return genClient.cacheHasKey(CacheKey.taxAmount);
  }


  /**
   * Sets the field 'id'.
   */
  public PaymentTaxRate setId(java.lang.String id) {
    return genClient.setOther(id, CacheKey.id);
  }

  /**
   * Sets the field 'name'.
   */
  public PaymentTaxRate setName(java.lang.String name) {
    return genClient.setOther(name, CacheKey.name);
  }

  /**
   * Sets the field 'rate'.
   */
  public PaymentTaxRate setRate(java.lang.Long rate) {
    return genClient.setOther(rate, CacheKey.rate);
  }

  /**
   * Sets the field 'isDefault'.
   */
  public PaymentTaxRate setIsDefault(java.lang.Boolean isDefault) {
    return genClient.setOther(isDefault, CacheKey.isDefault);
  }

  /**
   * Sets the field 'taxableAmount'.
   */
  public PaymentTaxRate setTaxableAmount(java.lang.Long taxableAmount) {
    return genClient.setOther(taxableAmount, CacheKey.taxableAmount);
  }

  /**
   * Sets the field 'isVat'.
   */
  public PaymentTaxRate setIsVat(java.lang.Boolean isVat) {
    return genClient.setOther(isVat, CacheKey.isVat);
  }

  /**
   * Sets the field 'taxAmount'.
   */
  public PaymentTaxRate setTaxAmount(java.lang.Long taxAmount) {
    return genClient.setOther(taxAmount, CacheKey.taxAmount);
  }


  /** Clears the 'id' field, the 'has' method for this field will now return false */
  public void clearId() {
    genClient.clear(CacheKey.id);
  }
  /** Clears the 'name' field, the 'has' method for this field will now return false */
  public void clearName() {
    genClient.clear(CacheKey.name);
  }
  /** Clears the 'rate' field, the 'has' method for this field will now return false */
  public void clearRate() {
    genClient.clear(CacheKey.rate);
  }
  /** Clears the 'isDefault' field, the 'has' method for this field will now return false */
  public void clearIsDefault() {
    genClient.clear(CacheKey.isDefault);
  }
  /** Clears the 'taxableAmount' field, the 'has' method for this field will now return false */
  public void clearTaxableAmount() {
    genClient.clear(CacheKey.taxableAmount);
  }
  /** Clears the 'isVat' field, the 'has' method for this field will now return false */
  public void clearIsVat() {
    genClient.clear(CacheKey.isVat);
  }
  /** Clears the 'taxAmount' field, the 'has' method for this field will now return false */
  public void clearTaxAmount() {
    genClient.clear(CacheKey.taxAmount);
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
  public PaymentTaxRate copyChanges() {
    PaymentTaxRate copy = new PaymentTaxRate();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(PaymentTaxRate src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new PaymentTaxRate(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<PaymentTaxRate> CREATOR = new android.os.Parcelable.Creator<PaymentTaxRate>() {
    @Override
    public PaymentTaxRate createFromParcel(android.os.Parcel in) {
      PaymentTaxRate instance = new PaymentTaxRate(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public PaymentTaxRate[] newArray(int size) {
      return new PaymentTaxRate[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<PaymentTaxRate> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<PaymentTaxRate>() {
    @Override
    public PaymentTaxRate create(org.json.JSONObject jsonObject) {
      return new PaymentTaxRate(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean ID_IS_REQUIRED = false;
    public static final long ID_MAX_LEN = 13;
    public static final boolean NAME_IS_REQUIRED = true;
    public static final long NAME_MAX_LEN = 127;
    public static final boolean RATE_IS_REQUIRED = true;
    public static final long RATE_MIN = 0;
    public static final boolean ISDEFAULT_IS_REQUIRED = false;
    public static final boolean TAXABLEAMOUNT_IS_REQUIRED = true;
    public static final boolean ISVAT_IS_REQUIRED = false;
    public static final boolean TAXAMOUNT_IS_REQUIRED = false;

  }

}
