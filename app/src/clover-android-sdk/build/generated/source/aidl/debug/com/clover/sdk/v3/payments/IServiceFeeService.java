/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\src\\clover-android-sdk\\clover-android-sdk\\src\\main\\aidl\\com\\clover\\sdk\\v3\\payments\\IServiceFeeService.aidl
 */
package com.clover.sdk.v3.payments;
/**
* Manages billing service fees to an alternative MID.  The general use case applies to government agencies
* who collect fees via credit card plus a service fee that goes to a third party.  Your merchant has to be
* specifically configured to use this service - it is not generically available.
*/
public interface IServiceFeeService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.payments.IServiceFeeService
{
private static final java.lang.String DESCRIPTOR = "com.clover.sdk.v3.payments.IServiceFeeService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.payments.IServiceFeeService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.payments.IServiceFeeService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.payments.IServiceFeeService))) {
return ((com.clover.sdk.v3.payments.IServiceFeeService)iin);
}
return new com.clover.sdk.v3.payments.IServiceFeeService.Stub.Proxy(obj);
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
case TRANSACTION_payServiceFee:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.payments.ServiceFeeRequest _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.payments.ServiceFeeRequest.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.PaymentResponse _result = this.payServiceFee(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_refundServiceFee:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.payments.ServiceFeeRefundRequest _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.payments.ServiceFeeRefundRequest.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.RefundResponse _result = this.refundServiceFee(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
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
private static class Proxy implements com.clover.sdk.v3.payments.IServiceFeeService
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
   *  Calling this method will result in a payment being submitted on behalf of the associated MID that collects
   *  the service fees for your merchant.  The request object must contain the amount, the source payment id (that
   *  the service fee is related to), and the populated vaulted card object including the token
   *
   *  The orderId will be populated internal to the implementation
   *
   *  The PaymentResponse will indicate if the request was successful or no.  If successful, it will contain a payment
   *  object, if not, it should include an error message
   */
@Override public com.clover.sdk.v3.payments.PaymentResponse payServiceFee(com.clover.sdk.v3.payments.ServiceFeeRequest request, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.PaymentResponse _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((request!=null)) {
_data.writeInt(1);
request.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_payServiceFee, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.PaymentResponse.CREATOR.createFromParcel(_reply);
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
   *  Calling this method will refund the service fee previously charged
   *
   *  The ServiceFeeRefundRequest.refund object must be populated as below:
   *
   *  refund.amount : must match the amount of the original service charge
   *  refund.payment : populated with the original payment
   *
   *  The RefundResponse object will indicate success or failure.  In the case of failure
   *  there will be an error message set.  In the case of success the refund object will
   *  be echo'ed back with additional attributes (e.g id) populated
   *
   */
@Override public com.clover.sdk.v3.payments.RefundResponse refundServiceFee(com.clover.sdk.v3.payments.ServiceFeeRefundRequest request, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.RefundResponse _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((request!=null)) {
_data.writeInt(1);
request.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_refundServiceFee, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.RefundResponse.CREATOR.createFromParcel(_reply);
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
}
static final int TRANSACTION_payServiceFee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_refundServiceFee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
   *  Calling this method will result in a payment being submitted on behalf of the associated MID that collects
   *  the service fees for your merchant.  The request object must contain the amount, the source payment id (that
   *  the service fee is related to), and the populated vaulted card object including the token
   *
   *  The orderId will be populated internal to the implementation
   *
   *  The PaymentResponse will indicate if the request was successful or no.  If successful, it will contain a payment
   *  object, if not, it should include an error message
   */
public com.clover.sdk.v3.payments.PaymentResponse payServiceFee(com.clover.sdk.v3.payments.ServiceFeeRequest request, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   *  Calling this method will refund the service fee previously charged
   *
   *  The ServiceFeeRefundRequest.refund object must be populated as below:
   *
   *  refund.amount : must match the amount of the original service charge
   *  refund.payment : populated with the original payment
   *
   *  The RefundResponse object will indicate success or failure.  In the case of failure
   *  there will be an error message set.  In the case of success the refund object will
   *  be echo'ed back with additional attributes (e.g id) populated
   *
   */
public com.clover.sdk.v3.payments.RefundResponse refundServiceFee(com.clover.sdk.v3.payments.ServiceFeeRefundRequest request, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
