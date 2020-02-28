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

package com.clover.sdk.v3.report;

import com.clover.sdk.GenericClient;
import com.clover.sdk.GenericParcelable;

/**
 * This is an auto-generated Clover data object.
 * <p>
 * Holds summaries of payments, credits, refunds and non-revenue item sales grouped by a configurable time period, like by hour
 * <p>
 * <h3>Fields</h3>
 * <ul>
 * <li>{@link #getSalesSummaries salesSummaries}</li>
 * <li>{@link #getPayments payments}</li>
 * <li>{@link #getNonRevenue nonRevenue}</li>
 * <li>{@link #getCredits credits}</li>
 * <li>{@link #getRefunds refunds}</li>
 * <li>{@link #getAuthorizations authorizations}</li>
 * <li>{@link #getDiscounts discounts}</li>
 * <li>{@link #getOpenOrders openOrders}</li>
 * <li>{@link #getTop5Items top5Items}</li>
 * <li>{@link #getTop5Category top5Category}</li>
 * <li>{@link #getTop5RevenueClasses top5RevenueClasses}</li>
 * <li>{@link #getPeriod period}</li>
 * <li>{@link #getTendersSection tendersSection}</li>
 * <li>{@link #getRevenueClasses revenueClasses}</li>
 * <li>{@link #getCardTypesSection cardTypesSection}</li>
 * <li>{@link #getCashDepositSection cashDepositSection}</li>
 * <li>{@link #getDeclinedOfflinePaymentsSection declinedOfflinePaymentsSection}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class PaymentsAndNonRevenueGroupedOverTime extends GenericParcelable implements com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  /**
   * Summaries grouped over time of Gross Sales, Net Sales, Amount Collected and the other figures that contribute to their calculation like total Taxes, Discounts, Refunds, Service Charges, Tips, Non-revenue Items and Gift Card Activations.
   */
  public com.clover.sdk.v3.report.SalesSummarySection getSalesSummaries() {
    return genClient.cacheGet(CacheKey.salesSummaries);
  }

  /**
   * Summaries grouped over time of payments. Does not include items marked non-revenue
   */
  public com.clover.sdk.v3.report.SummarySection getPayments() {
    return genClient.cacheGet(CacheKey.payments);
  }

  /**
   * Summaries grouped over time of sales of items marked non-revenue including modifiers and discounts
   */
  public com.clover.sdk.v3.report.SummarySection getNonRevenue() {
    return genClient.cacheGet(CacheKey.nonRevenue);
  }

  /**
   * Summaries grouped over time of credits, also known as manual or naked refunds
   */
  public com.clover.sdk.v3.report.SummarySection getCredits() {
    return genClient.cacheGet(CacheKey.credits);
  }

  /**
   * Summaries grouped over time of refunds
   */
  public com.clover.sdk.v3.report.SummarySection getRefunds() {
    return genClient.cacheGet(CacheKey.refunds);
  }

  /**
   * Summaries grouped over time of authorizations. In this context authorizations are entities stored in the payment table with the payment result of 'auth'.
   */
  public com.clover.sdk.v3.report.SummarySection getAuthorizations() {
    return genClient.cacheGet(CacheKey.authorizations);
  }

  /**
   * Summaries grouped over time of discounts
   */
  public com.clover.sdk.v3.report.SummarySection getDiscounts() {
    return genClient.cacheGet(CacheKey.discounts);
  }

  /**
   * Summaries grouped over time of open orders. Open orders are orders that still require more payments.
   */
  public com.clover.sdk.v3.report.SummarySection getOpenOrders() {
    return genClient.cacheGet(CacheKey.openOrders);
  }

  /**
   * Summaries grouped over time showing top 5 line items in terms of revenue
   */
  public com.clover.sdk.v3.report.SummarySection getTop5Items() {
    return genClient.cacheGet(CacheKey.top5Items);
  }

  /**
   * Summaries grouped by category, showing top 5 category of line items sold in terms of revenue
   */
  public com.clover.sdk.v3.report.SummarySection getTop5Category() {
    return genClient.cacheGet(CacheKey.top5Category);
  }

  /**
   * Summaries grouped by revenue class, AKA labels, showing top 5 revenue class of items sold in terms of revenue
   */
  public com.clover.sdk.v3.report.SummarySection getTop5RevenueClasses() {
    return genClient.cacheGet(CacheKey.top5RevenueClasses);
  }

  /**
   * The time period that defines the size of the groups: hour, day, week, month, ungrouped
   */
  public com.clover.sdk.v3.report.TimePeriod getPeriod() {
    return genClient.cacheGet(CacheKey.period);
  }

  /**
   * Summary of payments and refunds by tender
   */
  public com.clover.sdk.v3.report.ReportPaymentsV2Section getTendersSection() {
    return genClient.cacheGet(CacheKey.tendersSection);
  }

  /**
   * Full report of revenue items sold based on revenue classes AKA labels summary
   */
  public com.clover.sdk.v3.report.LabelSummarySection getRevenueClasses() {
    return genClient.cacheGet(CacheKey.revenueClasses);
  }

  /**
   * Summary of payments and refunds by card type
   */
  public com.clover.sdk.v3.report.ReportPaymentsV2Section getCardTypesSection() {
    return genClient.cacheGet(CacheKey.cardTypesSection);
  }

  /**
   * Summary and further details on cash transactions
   */
  public com.clover.sdk.v3.report.DeviceCashSummaryRow getCashDepositSection() {
    return genClient.cacheGet(CacheKey.cashDepositSection);
  }

  /**
   * Summary of declined offline payments
   */
  public com.clover.sdk.v3.report.ReportPaymentsV2Row getDeclinedOfflinePaymentsSection() {
    return genClient.cacheGet(CacheKey.declinedOfflinePaymentsSection);
  }




  private enum CacheKey implements com.clover.sdk.ExtractionStrategyEnum {
    salesSummaries
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SalesSummarySection.JSON_CREATOR)),
    payments
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SummarySection.JSON_CREATOR)),
    nonRevenue
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SummarySection.JSON_CREATOR)),
    credits
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SummarySection.JSON_CREATOR)),
    refunds
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SummarySection.JSON_CREATOR)),
    authorizations
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SummarySection.JSON_CREATOR)),
    discounts
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SummarySection.JSON_CREATOR)),
    openOrders
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SummarySection.JSON_CREATOR)),
    top5Items
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SummarySection.JSON_CREATOR)),
    top5Category
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SummarySection.JSON_CREATOR)),
    top5RevenueClasses
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.SummarySection.JSON_CREATOR)),
    period
        (com.clover.sdk.extractors.EnumExtractionStrategy.instance(com.clover.sdk.v3.report.TimePeriod.class)),
    tendersSection
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.ReportPaymentsV2Section.JSON_CREATOR)),
    revenueClasses
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.LabelSummarySection.JSON_CREATOR)),
    cardTypesSection
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.ReportPaymentsV2Section.JSON_CREATOR)),
    cashDepositSection
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.DeviceCashSummaryRow.JSON_CREATOR)),
    declinedOfflinePaymentsSection
        (com.clover.sdk.extractors.RecordExtractionStrategy.instance(com.clover.sdk.v3.report.ReportPaymentsV2Row.JSON_CREATOR)),
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

  private final GenericClient<PaymentsAndNonRevenueGroupedOverTime> genClient;

  /**
   * Constructs a new empty instance.
   */
  public PaymentsAndNonRevenueGroupedOverTime() {
    genClient = new GenericClient<PaymentsAndNonRevenueGroupedOverTime>(this);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
   * Constructs a new empty instance.
   */
  protected PaymentsAndNonRevenueGroupedOverTime(boolean noInit) {
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public PaymentsAndNonRevenueGroupedOverTime(String json) throws IllegalArgumentException {
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
  public PaymentsAndNonRevenueGroupedOverTime(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public PaymentsAndNonRevenueGroupedOverTime(PaymentsAndNonRevenueGroupedOverTime src) {
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

  /** Checks whether the 'salesSummaries' field is set and is not null */
  public boolean isNotNullSalesSummaries() {
    return genClient.cacheValueIsNotNull(CacheKey.salesSummaries);
  }

  /** Checks whether the 'payments' field is set and is not null */
  public boolean isNotNullPayments() {
    return genClient.cacheValueIsNotNull(CacheKey.payments);
  }

  /** Checks whether the 'nonRevenue' field is set and is not null */
  public boolean isNotNullNonRevenue() {
    return genClient.cacheValueIsNotNull(CacheKey.nonRevenue);
  }

  /** Checks whether the 'credits' field is set and is not null */
  public boolean isNotNullCredits() {
    return genClient.cacheValueIsNotNull(CacheKey.credits);
  }

  /** Checks whether the 'refunds' field is set and is not null */
  public boolean isNotNullRefunds() {
    return genClient.cacheValueIsNotNull(CacheKey.refunds);
  }

  /** Checks whether the 'authorizations' field is set and is not null */
  public boolean isNotNullAuthorizations() {
    return genClient.cacheValueIsNotNull(CacheKey.authorizations);
  }

  /** Checks whether the 'discounts' field is set and is not null */
  public boolean isNotNullDiscounts() {
    return genClient.cacheValueIsNotNull(CacheKey.discounts);
  }

  /** Checks whether the 'openOrders' field is set and is not null */
  public boolean isNotNullOpenOrders() {
    return genClient.cacheValueIsNotNull(CacheKey.openOrders);
  }

  /** Checks whether the 'top5Items' field is set and is not null */
  public boolean isNotNullTop5Items() {
    return genClient.cacheValueIsNotNull(CacheKey.top5Items);
  }

  /** Checks whether the 'top5Category' field is set and is not null */
  public boolean isNotNullTop5Category() {
    return genClient.cacheValueIsNotNull(CacheKey.top5Category);
  }

  /** Checks whether the 'top5RevenueClasses' field is set and is not null */
  public boolean isNotNullTop5RevenueClasses() {
    return genClient.cacheValueIsNotNull(CacheKey.top5RevenueClasses);
  }

  /** Checks whether the 'period' field is set and is not null */
  public boolean isNotNullPeriod() {
    return genClient.cacheValueIsNotNull(CacheKey.period);
  }

  /** Checks whether the 'tendersSection' field is set and is not null */
  public boolean isNotNullTendersSection() {
    return genClient.cacheValueIsNotNull(CacheKey.tendersSection);
  }

  /** Checks whether the 'revenueClasses' field is set and is not null */
  public boolean isNotNullRevenueClasses() {
    return genClient.cacheValueIsNotNull(CacheKey.revenueClasses);
  }

  /** Checks whether the 'cardTypesSection' field is set and is not null */
  public boolean isNotNullCardTypesSection() {
    return genClient.cacheValueIsNotNull(CacheKey.cardTypesSection);
  }

  /** Checks whether the 'cashDepositSection' field is set and is not null */
  public boolean isNotNullCashDepositSection() {
    return genClient.cacheValueIsNotNull(CacheKey.cashDepositSection);
  }

  /** Checks whether the 'declinedOfflinePaymentsSection' field is set and is not null */
  public boolean isNotNullDeclinedOfflinePaymentsSection() {
    return genClient.cacheValueIsNotNull(CacheKey.declinedOfflinePaymentsSection);
  }



  /** Checks whether the 'salesSummaries' field has been set, however the value could be null */
  public boolean hasSalesSummaries() {
    return genClient.cacheHasKey(CacheKey.salesSummaries);
  }

  /** Checks whether the 'payments' field has been set, however the value could be null */
  public boolean hasPayments() {
    return genClient.cacheHasKey(CacheKey.payments);
  }

  /** Checks whether the 'nonRevenue' field has been set, however the value could be null */
  public boolean hasNonRevenue() {
    return genClient.cacheHasKey(CacheKey.nonRevenue);
  }

  /** Checks whether the 'credits' field has been set, however the value could be null */
  public boolean hasCredits() {
    return genClient.cacheHasKey(CacheKey.credits);
  }

  /** Checks whether the 'refunds' field has been set, however the value could be null */
  public boolean hasRefunds() {
    return genClient.cacheHasKey(CacheKey.refunds);
  }

  /** Checks whether the 'authorizations' field has been set, however the value could be null */
  public boolean hasAuthorizations() {
    return genClient.cacheHasKey(CacheKey.authorizations);
  }

  /** Checks whether the 'discounts' field has been set, however the value could be null */
  public boolean hasDiscounts() {
    return genClient.cacheHasKey(CacheKey.discounts);
  }

  /** Checks whether the 'openOrders' field has been set, however the value could be null */
  public boolean hasOpenOrders() {
    return genClient.cacheHasKey(CacheKey.openOrders);
  }

  /** Checks whether the 'top5Items' field has been set, however the value could be null */
  public boolean hasTop5Items() {
    return genClient.cacheHasKey(CacheKey.top5Items);
  }

  /** Checks whether the 'top5Category' field has been set, however the value could be null */
  public boolean hasTop5Category() {
    return genClient.cacheHasKey(CacheKey.top5Category);
  }

  /** Checks whether the 'top5RevenueClasses' field has been set, however the value could be null */
  public boolean hasTop5RevenueClasses() {
    return genClient.cacheHasKey(CacheKey.top5RevenueClasses);
  }

  /** Checks whether the 'period' field has been set, however the value could be null */
  public boolean hasPeriod() {
    return genClient.cacheHasKey(CacheKey.period);
  }

  /** Checks whether the 'tendersSection' field has been set, however the value could be null */
  public boolean hasTendersSection() {
    return genClient.cacheHasKey(CacheKey.tendersSection);
  }

  /** Checks whether the 'revenueClasses' field has been set, however the value could be null */
  public boolean hasRevenueClasses() {
    return genClient.cacheHasKey(CacheKey.revenueClasses);
  }

  /** Checks whether the 'cardTypesSection' field has been set, however the value could be null */
  public boolean hasCardTypesSection() {
    return genClient.cacheHasKey(CacheKey.cardTypesSection);
  }

  /** Checks whether the 'cashDepositSection' field has been set, however the value could be null */
  public boolean hasCashDepositSection() {
    return genClient.cacheHasKey(CacheKey.cashDepositSection);
  }

  /** Checks whether the 'declinedOfflinePaymentsSection' field has been set, however the value could be null */
  public boolean hasDeclinedOfflinePaymentsSection() {
    return genClient.cacheHasKey(CacheKey.declinedOfflinePaymentsSection);
  }


  /**
   * Sets the field 'salesSummaries'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setSalesSummaries(com.clover.sdk.v3.report.SalesSummarySection salesSummaries) {
    return genClient.setRecord(salesSummaries, CacheKey.salesSummaries);
  }

  /**
   * Sets the field 'payments'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setPayments(com.clover.sdk.v3.report.SummarySection payments) {
    return genClient.setRecord(payments, CacheKey.payments);
  }

  /**
   * Sets the field 'nonRevenue'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setNonRevenue(com.clover.sdk.v3.report.SummarySection nonRevenue) {
    return genClient.setRecord(nonRevenue, CacheKey.nonRevenue);
  }

  /**
   * Sets the field 'credits'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setCredits(com.clover.sdk.v3.report.SummarySection credits) {
    return genClient.setRecord(credits, CacheKey.credits);
  }

  /**
   * Sets the field 'refunds'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setRefunds(com.clover.sdk.v3.report.SummarySection refunds) {
    return genClient.setRecord(refunds, CacheKey.refunds);
  }

  /**
   * Sets the field 'authorizations'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setAuthorizations(com.clover.sdk.v3.report.SummarySection authorizations) {
    return genClient.setRecord(authorizations, CacheKey.authorizations);
  }

  /**
   * Sets the field 'discounts'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setDiscounts(com.clover.sdk.v3.report.SummarySection discounts) {
    return genClient.setRecord(discounts, CacheKey.discounts);
  }

  /**
   * Sets the field 'openOrders'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setOpenOrders(com.clover.sdk.v3.report.SummarySection openOrders) {
    return genClient.setRecord(openOrders, CacheKey.openOrders);
  }

  /**
   * Sets the field 'top5Items'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setTop5Items(com.clover.sdk.v3.report.SummarySection top5Items) {
    return genClient.setRecord(top5Items, CacheKey.top5Items);
  }

  /**
   * Sets the field 'top5Category'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setTop5Category(com.clover.sdk.v3.report.SummarySection top5Category) {
    return genClient.setRecord(top5Category, CacheKey.top5Category);
  }

  /**
   * Sets the field 'top5RevenueClasses'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setTop5RevenueClasses(com.clover.sdk.v3.report.SummarySection top5RevenueClasses) {
    return genClient.setRecord(top5RevenueClasses, CacheKey.top5RevenueClasses);
  }

  /**
   * Sets the field 'period'.
   */
  public PaymentsAndNonRevenueGroupedOverTime setPeriod(com.clover.sdk.v3.report.TimePeriod period) {
    return genClient.setOther(period, CacheKey.period);
  }

  /**
   * Sets the field 'tendersSection'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setTendersSection(com.clover.sdk.v3.report.ReportPaymentsV2Section tendersSection) {
    return genClient.setRecord(tendersSection, CacheKey.tendersSection);
  }

  /**
   * Sets the field 'revenueClasses'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setRevenueClasses(com.clover.sdk.v3.report.LabelSummarySection revenueClasses) {
    return genClient.setRecord(revenueClasses, CacheKey.revenueClasses);
  }

  /**
   * Sets the field 'cardTypesSection'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setCardTypesSection(com.clover.sdk.v3.report.ReportPaymentsV2Section cardTypesSection) {
    return genClient.setRecord(cardTypesSection, CacheKey.cardTypesSection);
  }

  /**
   * Sets the field 'cashDepositSection'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setCashDepositSection(com.clover.sdk.v3.report.DeviceCashSummaryRow cashDepositSection) {
    return genClient.setRecord(cashDepositSection, CacheKey.cashDepositSection);
  }

  /**
   * Sets the field 'declinedOfflinePaymentsSection'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public PaymentsAndNonRevenueGroupedOverTime setDeclinedOfflinePaymentsSection(com.clover.sdk.v3.report.ReportPaymentsV2Row declinedOfflinePaymentsSection) {
    return genClient.setRecord(declinedOfflinePaymentsSection, CacheKey.declinedOfflinePaymentsSection);
  }


  /** Clears the 'salesSummaries' field, the 'has' method for this field will now return false */
  public void clearSalesSummaries() {
    genClient.clear(CacheKey.salesSummaries);
  }
  /** Clears the 'payments' field, the 'has' method for this field will now return false */
  public void clearPayments() {
    genClient.clear(CacheKey.payments);
  }
  /** Clears the 'nonRevenue' field, the 'has' method for this field will now return false */
  public void clearNonRevenue() {
    genClient.clear(CacheKey.nonRevenue);
  }
  /** Clears the 'credits' field, the 'has' method for this field will now return false */
  public void clearCredits() {
    genClient.clear(CacheKey.credits);
  }
  /** Clears the 'refunds' field, the 'has' method for this field will now return false */
  public void clearRefunds() {
    genClient.clear(CacheKey.refunds);
  }
  /** Clears the 'authorizations' field, the 'has' method for this field will now return false */
  public void clearAuthorizations() {
    genClient.clear(CacheKey.authorizations);
  }
  /** Clears the 'discounts' field, the 'has' method for this field will now return false */
  public void clearDiscounts() {
    genClient.clear(CacheKey.discounts);
  }
  /** Clears the 'openOrders' field, the 'has' method for this field will now return false */
  public void clearOpenOrders() {
    genClient.clear(CacheKey.openOrders);
  }
  /** Clears the 'top5Items' field, the 'has' method for this field will now return false */
  public void clearTop5Items() {
    genClient.clear(CacheKey.top5Items);
  }
  /** Clears the 'top5Category' field, the 'has' method for this field will now return false */
  public void clearTop5Category() {
    genClient.clear(CacheKey.top5Category);
  }
  /** Clears the 'top5RevenueClasses' field, the 'has' method for this field will now return false */
  public void clearTop5RevenueClasses() {
    genClient.clear(CacheKey.top5RevenueClasses);
  }
  /** Clears the 'period' field, the 'has' method for this field will now return false */
  public void clearPeriod() {
    genClient.clear(CacheKey.period);
  }
  /** Clears the 'tendersSection' field, the 'has' method for this field will now return false */
  public void clearTendersSection() {
    genClient.clear(CacheKey.tendersSection);
  }
  /** Clears the 'revenueClasses' field, the 'has' method for this field will now return false */
  public void clearRevenueClasses() {
    genClient.clear(CacheKey.revenueClasses);
  }
  /** Clears the 'cardTypesSection' field, the 'has' method for this field will now return false */
  public void clearCardTypesSection() {
    genClient.clear(CacheKey.cardTypesSection);
  }
  /** Clears the 'cashDepositSection' field, the 'has' method for this field will now return false */
  public void clearCashDepositSection() {
    genClient.clear(CacheKey.cashDepositSection);
  }
  /** Clears the 'declinedOfflinePaymentsSection' field, the 'has' method for this field will now return false */
  public void clearDeclinedOfflinePaymentsSection() {
    genClient.clear(CacheKey.declinedOfflinePaymentsSection);
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
  public PaymentsAndNonRevenueGroupedOverTime copyChanges() {
    PaymentsAndNonRevenueGroupedOverTime copy = new PaymentsAndNonRevenueGroupedOverTime();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(PaymentsAndNonRevenueGroupedOverTime src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new PaymentsAndNonRevenueGroupedOverTime(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<PaymentsAndNonRevenueGroupedOverTime> CREATOR = new android.os.Parcelable.Creator<PaymentsAndNonRevenueGroupedOverTime>() {
    @Override
    public PaymentsAndNonRevenueGroupedOverTime createFromParcel(android.os.Parcel in) {
      PaymentsAndNonRevenueGroupedOverTime instance = new PaymentsAndNonRevenueGroupedOverTime(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public PaymentsAndNonRevenueGroupedOverTime[] newArray(int size) {
      return new PaymentsAndNonRevenueGroupedOverTime[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<PaymentsAndNonRevenueGroupedOverTime> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<PaymentsAndNonRevenueGroupedOverTime>() {
    @Override
    public PaymentsAndNonRevenueGroupedOverTime create(org.json.JSONObject jsonObject) {
      return new PaymentsAndNonRevenueGroupedOverTime(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean SALESSUMMARIES_IS_REQUIRED = false;
    public static final boolean PAYMENTS_IS_REQUIRED = false;
    public static final boolean NONREVENUE_IS_REQUIRED = false;
    public static final boolean CREDITS_IS_REQUIRED = false;
    public static final boolean REFUNDS_IS_REQUIRED = false;
    public static final boolean AUTHORIZATIONS_IS_REQUIRED = false;
    public static final boolean DISCOUNTS_IS_REQUIRED = false;
    public static final boolean OPENORDERS_IS_REQUIRED = false;
    public static final boolean TOP5ITEMS_IS_REQUIRED = false;
    public static final boolean TOP5CATEGORY_IS_REQUIRED = false;
    public static final boolean TOP5REVENUECLASSES_IS_REQUIRED = false;
    public static final boolean PERIOD_IS_REQUIRED = false;
    public static final boolean TENDERSSECTION_IS_REQUIRED = false;
    public static final boolean REVENUECLASSES_IS_REQUIRED = false;
    public static final boolean CARDTYPESSECTION_IS_REQUIRED = false;
    public static final boolean CASHDEPOSITSECTION_IS_REQUIRED = false;
    public static final boolean DECLINEDOFFLINEPAYMENTSSECTION_IS_REQUIRED = false;

  }

}
