/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\src\\clover-android-sdk\\clover-android-sdk\\src\\main\\aidl\\com\\clover\\sdk\\v1\\tender\\ITenderService.aidl
 */
package com.clover.sdk.v1.tender;
/**
 * An interface for interacting with the Clover tender service. The tender
 * service is a bound AIDL service. Bind to this service as follows,
 * <pre>
 * <code>
 * Intent serviceIntent = new Intent(TenderIntent.ACTION_TENDER_SERVICE);
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
 * You may also interact with the service through the
 * {@link com.clover.sdk.v1.tender.TenderConnector} class, which handles binding and
 * asynchronous invocation of service methods.
 * <p>
 * A tender is a method of payment allowed by the Merchant such as Credit Card, Cash or Check.
 * Merchants may support custom tenders to allow customers to pay via special reward programs for
 * example. Some tenders are built-in and cannot be deleted or modified, these are called system
 * tenders.
 * <p>
 * @see com.clover.sdk.v1.tender.TenderIntent
 * @see com.clover.sdk.util.CloverAccount
 * @see com.clover.sdk.v1.tender.TenderConnector
 */
public interface ITenderService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v1.tender.ITenderService
{
private static final java.lang.String DESCRIPTOR = "com.clover.sdk.v1.tender.ITenderService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v1.tender.ITenderService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v1.tender.ITenderService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v1.tender.ITenderService))) {
return ((com.clover.sdk.v1.tender.ITenderService)iin);
}
return new com.clover.sdk.v1.tender.ITenderService.Stub.Proxy(obj);
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
case TRANSACTION_getTenders:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v1.tender.Tender> _result = this.getTenders(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_checkAndCreateTender:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _arg3;
_arg3 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.tender.Tender _result = this.checkAndCreateTender(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg4!=null)) {
reply.writeInt(1);
_arg4.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setEnabled:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.tender.Tender _result = this.setEnabled(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_delete:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.delete(_arg0, _arg1);
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
case TRANSACTION_setOpensCashDrawer:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.setOpensCashDrawer(_arg0, _arg1, _arg2);
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
case TRANSACTION_setLabel:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.setLabel(_arg0, _arg1, _arg2);
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
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements com.clover.sdk.v1.tender.ITenderService
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
   * Get all the tenders for this merchant. Note that some tenders may not be enabled.
   */
@Override public java.util.List<com.clover.sdk.v1.tender.Tender> getTenders(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v1.tender.Tender> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTenders, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v1.tender.Tender.CREATOR);
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
   * Create a new tender with the given label and seetings. The label key must be the package name
   * of your application.
   *
   * @param label String shown to merchant for this Tender
   * @param labelKey The package name of your application, unless you are {@code com.clover.*}
   * @param enabled true if you want the Tender to appear to the Merchant
   * @param opensCashDrawer true if you want the cash drawer to open when a payment with this tender
   *                        is taken
   * @return null if the tender could not be created
   */
@Override public com.clover.sdk.v1.tender.Tender checkAndCreateTender(java.lang.String label, java.lang.String labelKey, boolean enabled, boolean opensCashDrawer, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.tender.Tender _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(label);
_data.writeString(labelKey);
_data.writeInt(((enabled)?(1):(0)));
_data.writeInt(((opensCashDrawer)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_checkAndCreateTender, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.tender.Tender.CREATOR.createFromParcel(_reply);
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
   * Enabling or disabling a tender causes the tender to either be shown in or hidden by the Clover
   * Register and Sale apps.
   */
@Override public com.clover.sdk.v1.tender.Tender setEnabled(java.lang.String tenderId, boolean enabled, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.tender.Tender _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tenderId);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setEnabled, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.tender.Tender.CREATOR.createFromParcel(_reply);
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
   * Delete the tender for the given id.
   */
@Override public void delete(java.lang.String tenderId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tenderId);
mRemote.transact(Stub.TRANSACTION_delete, _data, _reply, 0);
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
   * When a payment is made with this tender the cash drawer can be made to automatically open or
   * not.
   */
@Override public void setOpensCashDrawer(java.lang.String tenderId, boolean opensCashDrawer, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tenderId);
_data.writeInt(((opensCashDrawer)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setOpensCashDrawer, _data, _reply, 0);
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
   * Change the label for the given tender id.
   */
@Override public void setLabel(java.lang.String tenderId, java.lang.String tenderLable, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tenderId);
_data.writeString(tenderLable);
mRemote.transact(Stub.TRANSACTION_setLabel, _data, _reply, 0);
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
static final int TRANSACTION_getTenders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_checkAndCreateTender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_setEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_delete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_setOpensCashDrawer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setLabel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
}
/**
   * Get all the tenders for this merchant. Note that some tenders may not be enabled.
   */
public java.util.List<com.clover.sdk.v1.tender.Tender> getTenders(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Create a new tender with the given label and seetings. The label key must be the package name
   * of your application.
   *
   * @param label String shown to merchant for this Tender
   * @param labelKey The package name of your application, unless you are {@code com.clover.*}
   * @param enabled true if you want the Tender to appear to the Merchant
   * @param opensCashDrawer true if you want the cash drawer to open when a payment with this tender
   *                        is taken
   * @return null if the tender could not be created
   */
public com.clover.sdk.v1.tender.Tender checkAndCreateTender(java.lang.String label, java.lang.String labelKey, boolean enabled, boolean opensCashDrawer, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Enabling or disabling a tender causes the tender to either be shown in or hidden by the Clover
   * Register and Sale apps.
   */
public com.clover.sdk.v1.tender.Tender setEnabled(java.lang.String tenderId, boolean enabled, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Delete the tender for the given id.
   */
public void delete(java.lang.String tenderId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * When a payment is made with this tender the cash drawer can be made to automatically open or
   * not.
   */
public void setOpensCashDrawer(java.lang.String tenderId, boolean opensCashDrawer, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Change the label for the given tender id.
   */
public void setLabel(java.lang.String tenderId, java.lang.String tenderLable, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
