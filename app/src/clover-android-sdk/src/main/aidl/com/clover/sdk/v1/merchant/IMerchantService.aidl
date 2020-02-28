package com.clover.sdk.v1.merchant;

import com.clover.sdk.v1.merchant.Merchant;
import com.clover.sdk.v1.merchant.MerchantAddress;
import com.clover.sdk.v1.merchant.IMerchantListener;
import com.clover.sdk.v1.ResultStatus;

/**
 * An interface for interacting with the Clover merchant service. The merchant
 * service is a bound AIDL service. Bind to this service as follows:
 * <pre>
 * <code>
 * Intent serviceIntent = new Intent(MerchantIntent.ACTION_MERCHANT_SERVICE);
 * serviceIntent.putExtra(Intents.EXTRA_ACCOUNT, CloverAccount.getAccount(context));
 * serviceIntent.putExtra(Intents.EXTRA_VERSION, 1);
 * context.bindService(serviceIntent);
 * </code>
 * </pre>
 * For more information about bound services, refer to
 * the Android documentation:
 * <a href="http://developer.android.com/guide/components/bound-services.html#Binding">
 * Bound Services
 * </a>.
 * <br/><br/>
 * You may also interact with the merchant service through the
 * {@link com.clover.sdk.v1.merchant.MerchantConnector} class, which handles binding and
 * asynchronous invocation of service methods.
 * <p>
 * @see com.clover.sdk.v1.merchant.MerchantIntent
 * @see com.clover.sdk.util.CloverAccount
 * @see com.clover.sdk.v1.merchant.MerchantConnector
 */
 interface IMerchantService {

  /**
   * Get the Merchant object for this device's merchant.
   */
  Merchant getMerchant(out ResultStatus resultStatus);

  void setAddress(in MerchantAddress address, out ResultStatus resultStatus);

  void setPhoneNumber(in String phoneNumber, out ResultStatus resultStatus);

  void addListener(IMerchantListener listener, out ResultStatus resultStatus);

  void removeListener(IMerchantListener listener, out ResultStatus resultStatus);

  /**
   * Set to true if this merchant wants Clover to decrement the stock count when an item is sold.
   * This requires {@link setTrackStock} be enabled. This should be false if a merchant is using a
   * third party app to update their stock counts.
   *
   * @see #setTrackStock
   */
  void setUpdateStock(in boolean updateStock, out ResultStatus resultStatus);

  /**
   * Set to true if this merchant desires to keep track of stock. This will show stock counts and
   * allow the counts to be updated and modified in arious apps such as Clover Inventory app and on
   * the web.
   *
   * @see #setUpdateStock
   */
  void setTrackStock(in boolean trackStock, out ResultStatus resultStatus);

}
