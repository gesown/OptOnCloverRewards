/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\src\\clover-android-sdk\\clover-android-sdk\\src\\main\\aidl\\com\\clover\\sdk\\v3\\apps\\IAppsService.aidl
 */
package com.clover.sdk.v3.apps;
/**
 * An interface for interacting with the v3 Clover apps service. The apps
 * service is a bound AIDL service. Bind to this service as follows:
 * <pre>
 * <code>
 * Intent serviceIntent = new Intent(AppsIntent.ACTION_APPS_SERVICE);
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
 * <p>
 * You may also interact with the merchant service through the
 * {@link AppsConnector} class, which handles binding and
 * asynchronous invocation of service methods.
 * <p>
 * @see com.clover.sdk.v1.app.IAppService
 * @see com.clover.sdk.v3.apps.AppsConnector
 */
public interface IAppsService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.apps.IAppsService
{
private static final java.lang.String DESCRIPTOR = "com.clover.sdk.v3.apps.IAppsService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.apps.IAppsService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.apps.IAppsService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.apps.IAppsService))) {
return ((com.clover.sdk.v3.apps.IAppsService)iin);
}
return new com.clover.sdk.v3.apps.IAppsService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
java.lang.String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_getApp:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.apps.App _result = this.getApp(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_logMetered:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.logMetered(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getAppBillingInfo:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.apps.AppBillingInfo _result = this.getAppBillingInfo(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setSmartReceiptText:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.setSmartReceiptText(_arg0, _arg1);
reply.writeNoException();
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setSmartReceiptUrl:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.setSmartReceiptUrl(_arg0, _arg1);
reply.writeNoException();
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements com.clover.sdk.v3.apps.IAppsService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
   * Get App object with information about this app.
   *
   * @param resultStatus an output parameter with the result of the operation
   */
@Override public com.clover.sdk.v3.apps.App getApp(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.apps.App _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getApp, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.apps.App.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
resultStatus.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Log a metered event occurance. The merchant will be billed for this number of events.
   *
   * @param meteredId the id of the meter option to log
   * @param numberOfEvent the count of how many events occured
   * @param resultStatus an output parameter with the result of the operation
   */
@Override public void logMetered(java.lang.String meteredId, int numberOfEvent, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(meteredId);
_data.writeInt(numberOfEvent);
mRemote.transact(Stub.TRANSACTION_logMetered, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
resultStatus.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
   * Get AppBillingInfo object with billing information for the merchant running this app.
   *
   * @param resultStatus an output parameter with the result of the operation
   */
@Override public com.clover.sdk.v3.apps.AppBillingInfo getAppBillingInfo(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.apps.AppBillingInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAppBillingInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.apps.AppBillingInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
resultStatus.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Update the Smart Receipt text for this app. See the
   * <a href="https://docs.clover.com/build/smart-reciepts/" target="_blank">Clover developer site
   * for more information about Smart Receipts.</a>
   *
   * @param text the text to display on the receipt
   * @param resultStatus an output parameter with the result of the operation
   */
@Override public void setSmartReceiptText(java.lang.String text, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
mRemote.transact(Stub.TRANSACTION_setSmartReceiptText, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
resultStatus.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
   * Update the Smart Receipt URL for this app. See the
   * <a href="https://docs.clover.com/build/smart-reciepts/" target="_blank">Clover developer site
   * for more information about Smart Receipts.</a>
   *
   * @param text the URL to be used on the receipt
   * @param resultStatus an output parameter with the result of the operation
   */
@Override public void setSmartReceiptUrl(java.lang.String url, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_setSmartReceiptUrl, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
resultStatus.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_logMetered = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getAppBillingInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_setSmartReceiptText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_setSmartReceiptUrl = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
}
/**
   * Get App object with information about this app.
   *
   * @param resultStatus an output parameter with the result of the operation
   */
public com.clover.sdk.v3.apps.App getApp(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Log a metered event occurance. The merchant will be billed for this number of events.
   *
   * @param meteredId the id of the meter option to log
   * @param numberOfEvent the count of how many events occured
   * @param resultStatus an output parameter with the result of the operation
   */
public void logMetered(java.lang.String meteredId, int numberOfEvent, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Get AppBillingInfo object with billing information for the merchant running this app.
   *
   * @param resultStatus an output parameter with the result of the operation
   */
public com.clover.sdk.v3.apps.AppBillingInfo getAppBillingInfo(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Update the Smart Receipt text for this app. See the
   * <a href="https://docs.clover.com/build/smart-reciepts/" target="_blank">Clover developer site
   * for more information about Smart Receipts.</a>
   *
   * @param text the text to display on the receipt
   * @param resultStatus an output parameter with the result of the operation
   */
public void setSmartReceiptText(java.lang.String text, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Update the Smart Receipt URL for this app. See the
   * <a href="https://docs.clover.com/build/smart-reciepts/" target="_blank">Clover developer site
   * for more information about Smart Receipts.</a>
   *
   * @param text the URL to be used on the receipt
   * @param resultStatus an output parameter with the result of the operation
   */
public void setSmartReceiptUrl(java.lang.String url, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
