/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\src\\clover-android-sdk\\clover-android-sdk\\src\\main\\aidl\\com\\clover\\sdk\\v3\\payments\\IVasProvider.aidl
 */
package com.clover.sdk.v3.payments;
/**
 *   Implement this interface in your application to participate in the exchange of Value Added Services data with
 *   mobile devices.  Your application must define an exported service that includes
 *   clover.intent.action.VAS_PROVIDER in its intent filter.
 */
public interface IVasProvider extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.payments.IVasProvider
{
private static final java.lang.String DESCRIPTOR = "com.clover.sdk.v3.payments.IVasProvider";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.payments.IVasProvider interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.payments.IVasProvider asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.payments.IVasProvider))) {
return ((com.clover.sdk.v3.payments.IVasProvider)iin);
}
return new com.clover.sdk.v3.payments.IVasProvider.Stub.Proxy(obj);
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
case TRANSACTION_handlePayload:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.payments.VasPayload _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.payments.VasPayload.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v3.payments.VasMode _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.VasMode.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.content.Intent _arg2;
if ((0!=data.readInt())) {
_arg2 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v3.payments.VasPayloadResponse _result = this.handlePayload(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getVasProviders:
{
data.enforceInterface(descriptor);
java.util.List<com.clover.sdk.v3.payments.VasServiceProvider> _result = this.getVasProviders();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements com.clover.sdk.v3.payments.IVasProvider
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
   *  Called when an applicable VasPayload is retrieved from the mobile device.  Note implementors may NOT block
   *  while handling the payload - the VasPayloadResponse must be returned immediately and the payload handled out-of-band
   *
   *  Parameters:
   *  payload: the actual payload from the mobile device
   *  vasMode: the VasMode relevant to the payload (may help receiver make workflow decisions)
   *  extras: intent contains string key/value mappings only.  Non-string values are not supported.
   *          additional information about the transaction IF AVAILABLE (may not be present in some use cases)
   *          possible values include EXTRA_ORDER_ID (with the Clover Order UUID) and EXTRA_PAYMENT_ID (if a payment
   *          was completed at the same time as reading the VAS data).
   *
   *  Returns:
   *  VasPayloadResponse with ResponseType of ACCEPTED (to indicate the data has been received), TXN_UPDATE (to indicate
   *  that the data was received and an update to the Order or Amount is pending, to inclue partial payments)
   */
@Override public com.clover.sdk.v3.payments.VasPayloadResponse handlePayload(com.clover.sdk.v3.payments.VasPayload payload, com.clover.sdk.v3.payments.VasMode vasMode, android.content.Intent extras) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.VasPayloadResponse _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((payload!=null)) {
_data.writeInt(1);
payload.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((vasMode!=null)) {
_data.writeInt(1);
vasMode.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((extras!=null)) {
_data.writeInt(1);
extras.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_handlePayload, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.VasPayloadResponse.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   *  Called to load available providers before starting a txn
   */
@Override public java.util.List<com.clover.sdk.v3.payments.VasServiceProvider> getVasProviders() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.payments.VasServiceProvider> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVasProviders, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.payments.VasServiceProvider.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_handlePayload = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getVasProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
   *  Called when an applicable VasPayload is retrieved from the mobile device.  Note implementors may NOT block
   *  while handling the payload - the VasPayloadResponse must be returned immediately and the payload handled out-of-band
   *
   *  Parameters:
   *  payload: the actual payload from the mobile device
   *  vasMode: the VasMode relevant to the payload (may help receiver make workflow decisions)
   *  extras: intent contains string key/value mappings only.  Non-string values are not supported.
   *          additional information about the transaction IF AVAILABLE (may not be present in some use cases)
   *          possible values include EXTRA_ORDER_ID (with the Clover Order UUID) and EXTRA_PAYMENT_ID (if a payment
   *          was completed at the same time as reading the VAS data).
   *
   *  Returns:
   *  VasPayloadResponse with ResponseType of ACCEPTED (to indicate the data has been received), TXN_UPDATE (to indicate
   *  that the data was received and an update to the Order or Amount is pending, to inclue partial payments)
   */
public com.clover.sdk.v3.payments.VasPayloadResponse handlePayload(com.clover.sdk.v3.payments.VasPayload payload, com.clover.sdk.v3.payments.VasMode vasMode, android.content.Intent extras) throws android.os.RemoteException;
/**
   *  Called to load available providers before starting a txn
   */
public java.util.List<com.clover.sdk.v3.payments.VasServiceProvider> getVasProviders() throws android.os.RemoteException;
}
