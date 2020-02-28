/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\src\\clover-android-sdk\\clover-android-sdk\\src\\main\\aidl\\com\\clover\\sdk\\v3\\order\\IOrderService.aidl
 */
package com.clover.sdk.v3.order;
/**
 * An interface for interacting with the Clover order service. The order
 * service is a bound AIDL service. Bind to this service as follows:
 * <pre>
 * <code>
 * Intent serviceIntent = new Intent(OrderIntent.ACTION_ORDER_SERVICE_V3);
 * serviceIntent.putExtra(Intents.EXTRA_ACCOUNT, CloverAccount.getAccount(context));
 * serviceIntent.putExtra(Intents.EXTRA_VERSION, 3);
 * context.bindService(serviceIntent);
 * </code>
 * </pre>
 * For more information about bound services, refer to
 * the Android documentation:
 * <a href="http://developer.android.com/guide/components/bound-services.html#Binding">
 * Bound Services
 * </a>.
 * <p>
 * You may also interact with this service through the
 * {@link OrderConnector} class, which handles binding and
 * asynchronous invocation of service methods.
 * <p>
 * This service is backed by a local database which is synced to cloud. Thus changes made
 * by calling methods here will be reflected on all of a merchant's devices and on the web.
 * <p>
 * Most methods require ORDERS_R and/or ORDERS_W permission.
 */
public interface IOrderService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.order.IOrderService
{
private static final java.lang.String DESCRIPTOR = "com.clover.sdk.v3.order.IOrderService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.order.IOrderService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.order.IOrderService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.order.IOrderService))) {
return ((com.clover.sdk.v3.order.IOrderService)iin);
}
return new com.clover.sdk.v3.order.IOrderService.Stub.Proxy(obj);
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
case TRANSACTION_addOnOrderUpdatedListener:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.order.IOnOrderUpdateListener _arg0;
_arg0 = com.clover.sdk.v3.order.IOnOrderUpdateListener.Stub.asInterface(data.readStrongBinder());
this.addOnOrderUpdatedListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeOnOrderUpdatedListener:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.order.IOnOrderUpdateListener _arg0;
_arg0 = com.clover.sdk.v3.order.IOnOrderUpdateListener.Stub.asInterface(data.readStrongBinder());
this.removeOnOrderUpdatedListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getOrder:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.getOrder(_arg0, _arg1);
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
case TRANSACTION_getOrders:
{
data.enforceInterface(descriptor);
java.util.List<java.lang.String> _arg0;
_arg0 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.order.Order> _result = this.getOrders(_arg0, _arg1);
reply.writeNoException();
reply.writeTypedList(_result);
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_createOrder:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.order.Order _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.createOrder(_arg0, _arg1);
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
case TRANSACTION_updateOrder:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.order.Order _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.updateOrder(_arg0, _arg1);
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
case TRANSACTION_deleteOrder:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.deleteOrder(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addServiceCharge:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addServiceCharge(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteServiceCharge:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteServiceCharge(_arg0, _arg1, _arg2);
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
case TRANSACTION_addFixedPriceLineItem:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItem _result = this.addFixedPriceLineItem(_arg0, _arg1, _arg2, _arg3, _arg4);
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
case TRANSACTION_addPerUnitLineItem:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
java.lang.String _arg3;
_arg3 = data.readString();
java.lang.String _arg4;
_arg4 = data.readString();
com.clover.sdk.v1.ResultStatus _arg5;
_arg5 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItem _result = this.addPerUnitLineItem(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg5!=null)) {
reply.writeInt(1);
_arg5.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addVariablePriceLineItem:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
long _arg2;
_arg2 = data.readLong();
java.lang.String _arg3;
_arg3 = data.readString();
java.lang.String _arg4;
_arg4 = data.readString();
com.clover.sdk.v1.ResultStatus _arg5;
_arg5 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItem _result = this.addVariablePriceLineItem(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg5!=null)) {
reply.writeInt(1);
_arg5.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addCustomLineItem:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.order.LineItem _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _arg2;
_arg2 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItem _result = this.addCustomLineItem(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_updateLineItems:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<com.clover.sdk.v3.order.LineItem> _arg1;
_arg1 = data.createTypedArrayList(com.clover.sdk.v3.order.LineItem.CREATOR);
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.order.LineItem> _result = this.updateLineItems(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeTypedList(_result);
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deleteLineItems:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<java.lang.String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteLineItems(_arg0, _arg1, _arg2);
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
case TRANSACTION_copyLineItems:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.util.List<java.lang.String> _arg2;
_arg2 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.order.LineItem> _result = this.copyLineItems(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeTypedList(_result);
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setLineItemNote:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.setLineItemNote(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addLineItemModification:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v3.inventory.Modifier _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.inventory.Modifier.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addLineItemModification(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deleteLineItemModifications:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.util.List<java.lang.String> _arg2;
_arg2 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteLineItemModifications(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_exchangeItem:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
java.lang.String _arg4;
_arg4 = data.readString();
com.clover.sdk.v1.ResultStatus _arg5;
_arg5 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItem _result = this.exchangeItem(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg5!=null)) {
reply.writeInt(1);
_arg5.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addDiscount:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.order.Discount _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.Discount.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addDiscount(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteDiscounts:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<java.lang.String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteDiscounts(_arg0, _arg1, _arg2);
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
case TRANSACTION_addLineItemDiscount:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v3.order.Discount _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.order.Discount.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addLineItemDiscount(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deleteLineItemDiscounts:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.util.List<java.lang.String> _arg2;
_arg2 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteLineItemDiscounts(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addTip:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
long _arg2;
_arg2 = data.readLong();
boolean _arg3;
_arg3 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addTip(_arg0, _arg1, _arg2, _arg3, _arg4);
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
case TRANSACTION_pay:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.pay.PaymentRequest _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.pay.PaymentRequest.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _arg2;
_arg2 = (0!=data.readInt());
java.lang.String _arg3;
_arg3 = data.readString();
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Payment _result = this.pay(_arg0, _arg1, _arg2, _arg3, _arg4);
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
case TRANSACTION_addPayment:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Payment _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Payment.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.util.List<com.clover.sdk.v3.order.LineItem> _arg2;
_arg2 = data.createTypedArrayList(com.clover.sdk.v3.order.LineItem.CREATOR);
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addPayment(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_voidPayment:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.voidPayment(_arg0, _arg1, _arg2);
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
case TRANSACTION_addCredit:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Credit _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Credit.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Credit _result = this.addCredit(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteCredit:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteCredit(_arg0, _arg1, _arg2);
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
case TRANSACTION_addRefund:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Refund _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Refund _result = this.addRefund(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteRefund:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteRefund(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteOrderOnline:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.deleteOrderOnline(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addBatchLineItemModifications:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<java.lang.String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v3.inventory.Modifier _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.inventory.Modifier.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _arg3;
_arg3 = data.readInt();
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addBatchLineItemModifications(_arg0, _arg1, _arg2, _arg3, _arg4);
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
case TRANSACTION_addBatchLineItemDiscounts:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<java.lang.String> _arg1;
_arg1 = data.createStringArrayList();
java.util.List<com.clover.sdk.v3.order.Discount> _arg2;
_arg2 = data.createTypedArrayList(com.clover.sdk.v3.order.Discount.CREATOR);
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addBatchLineItemDiscounts(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_createLineItemsFrom:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.util.List<java.lang.String> _arg2;
_arg2 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
java.util.Map _result = this.createLineItemsFrom(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeMap(_result);
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_fire:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.fire(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_updatePayment:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Payment _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Payment.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Payment _result = this.updatePayment(_arg0, _arg1, _arg2);
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
case TRANSACTION_voidPayment2:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
com.clover.sdk.v3.order.VoidReason _arg3;
if ((0!=data.readInt())) {
_arg3 = com.clover.sdk.v3.order.VoidReason.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
java.lang.String _arg4;
_arg4 = data.readString();
com.clover.sdk.v1.ResultStatus _arg5;
_arg5 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.voidPayment2(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg5!=null)) {
reply.writeInt(1);
_arg5.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_removePayment:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.removePayment(_arg0, _arg1, _arg2);
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
case TRANSACTION_addRefundOffline:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Refund _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Refund _result = this.addRefundOffline(_arg0, _arg1, _arg2);
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
case TRANSACTION_refund:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Refund _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Refund _result = this.refund(_arg0, _arg1, _arg2);
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
case TRANSACTION_addOnOrderUpdatedListener2:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.order.IOnOrderUpdateListener2 _arg0;
_arg0 = com.clover.sdk.v3.order.IOnOrderUpdateListener2.Stub.asInterface(data.readStrongBinder());
this.addOnOrderUpdatedListener2(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeOnOrderUpdatedListener2:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.order.IOnOrderUpdateListener2 _arg0;
_arg0 = com.clover.sdk.v3.order.IOnOrderUpdateListener2.Stub.asInterface(data.readStrongBinder());
this.removeOnOrderUpdatedListener2(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_addDiscount2:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.order.Discount _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.Discount.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Discount _result = this.addDiscount2(_arg0, _arg1, _arg2);
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
case TRANSACTION_addLineItemDiscount2:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v3.order.Discount _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.order.Discount.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Discount _result = this.addLineItemDiscount2(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addPayment2:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Payment _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Payment.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.util.List<com.clover.sdk.v3.order.LineItem> _arg2;
_arg2 = data.createTypedArrayList(com.clover.sdk.v3.order.LineItem.CREATOR);
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addPayment2(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_fire2:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.fire2(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_createLineItemsFrom2:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.util.List<java.lang.String> _arg2;
_arg2 = data.createStringArrayList();
boolean _arg3;
_arg3 = (0!=data.readInt());
boolean _arg4;
_arg4 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg5;
_arg5 = new com.clover.sdk.v1.ResultStatus();
java.util.Map _result = this.createLineItemsFrom2(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeMap(_result);
if ((_arg5!=null)) {
reply.writeInt(1);
_arg5.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deleteOrder2:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.deleteOrder2(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getPendingPayments:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.payments.Payment> _result = this.getPendingPayments(_arg0);
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
case TRANSACTION_addCreditRefund:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.CreditRefund _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.CreditRefund.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.CreditRefund _result = this.addCreditRefund(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteCreditRefund:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteCreditRefund(_arg0, _arg1, _arg2);
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
case TRANSACTION_voidPaymentWithCard:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
com.clover.sdk.v3.pay.PaymentRequestCardDetails _arg3;
if ((0!=data.readInt())) {
_arg3 = com.clover.sdk.v3.pay.PaymentRequestCardDetails.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
com.clover.sdk.v3.order.VoidReason _arg4;
if ((0!=data.readInt())) {
_arg4 = com.clover.sdk.v3.order.VoidReason.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
java.lang.String _arg5;
_arg5 = data.readString();
com.clover.sdk.v1.ResultStatus _arg6;
_arg6 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.voidPaymentWithCard(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg6!=null)) {
reply.writeInt(1);
_arg6.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getLineItemsToFire:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<java.lang.String> _result = this.getLineItemsToFire(_arg0, _arg1);
reply.writeNoException();
reply.writeStringList(_result);
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_refire:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.refire(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deleteOrderOnline2:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.deleteOrderOnline2(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deleteOrder3:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _arg3;
_arg3 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.deleteOrder3(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
if ((_arg4!=null)) {
reply.writeInt(1);
_arg4.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_voidPaymentCardPresent:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
com.clover.sdk.v3.pay.PaymentRequestCardDetails _arg3;
if ((0!=data.readInt())) {
_arg3 = com.clover.sdk.v3.pay.PaymentRequestCardDetails.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
com.clover.sdk.v3.payments.TransactionInfo _arg4;
if ((0!=data.readInt())) {
_arg4 = com.clover.sdk.v3.payments.TransactionInfo.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
com.clover.sdk.v3.order.VoidReason _arg5;
if ((0!=data.readInt())) {
_arg5 = com.clover.sdk.v3.order.VoidReason.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
java.lang.String _arg6;
_arg6 = data.readString();
com.clover.sdk.v1.ResultStatus _arg7;
_arg7 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.voidPaymentCardPresent(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg7!=null)) {
reply.writeInt(1);
_arg7.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_vaultedCreditRefund:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.CreditRefund _result = this.vaultedCreditRefund(_arg0, _arg1, _arg2);
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
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements com.clover.sdk.v3.order.IOrderService
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
@Override public void addOnOrderUpdatedListener(com.clover.sdk.v3.order.IOnOrderUpdateListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addOnOrderUpdatedListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeOnOrderUpdatedListener(com.clover.sdk.v3.order.IOnOrderUpdateListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeOnOrderUpdatedListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
   * Get the {@link Order} for the given ID. If the order is not synchronized on this device, the order is fetched
   * from the server.
   *
   * @param orderId The ID of the {@link Order} to retrieve.
   * @return The {@link Order}s corresponding to the provided ID, or {@link null} if the order does not exists locally
   * and it cannot be fetched from the server. Note that this may be because the server is not reachable or because
   * the order for the given ID does not exist.
   */
@Override public com.clover.sdk.v3.order.Order getOrder(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_getOrder, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<com.clover.sdk.v3.order.Order> getOrders(java.util.List<java.lang.String> orderIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.order.Order> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringList(orderIds);
mRemote.transact(Stub.TRANSACTION_getOrders, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.order.Order.CREATOR);
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Create a new {@link Order}. Only the order title is used for creation; all other fields are ignored. The following
   * fields are set automatically:
   * <ul>
   *   <li>id</li>
   *   <li>device - set the this device.</li>
   *   <li>currency - set to the merchant's currency.</li>
   *   <li>vat - set according to the merchant's setting.</li>
   *   <li>groupLineItems - set according to the merchant's setting.</li>
   *   <li>testMode - set according to the merchant's setting.</li>
   *   <li>createdTime - set to this device's current time.</li>
   *   <li>taxRemoved - set to false.</li>
   *   <li>total - set to 0.</li>
   *   <li>employee - set to the current employee logged into this device.</li>
   * </ul>
   *
   * This method requires ORDERS_W permission.
   *
   * @param order The order to create.
   */
@Override public com.clover.sdk.v3.order.Order createOrder(com.clover.sdk.v3.order.Order order, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((order!=null)) {
_data.writeInt(1);
order.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createOrder, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Update an {@link Order}. The following fields may be updated,
   * <ul>
   *   <li>total</li>
   *   <li>title</li>
   *   <li>note</li>
   *   <li>state</li>
   *   <li>taxRemoved</li>
   *   <li>groupLineItems</li>
   *   <li>manualTransactions</li>
   *   <li>testMode</li>
   *   <li>orderType.id</li>
   *   <li>customerId</li>
   *   <li>payType</li>
   *   <li>createdTime</li>
   *   <li>employee.id</li>
   * </ul>
   * All other fields are ignored.
   *
   * This method requires ORDERS_W permission.
   *
   * @param order The {@link Order} to updated.
   */
@Override public com.clover.sdk.v3.order.Order updateOrder(com.clover.sdk.v3.order.Order order, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((order!=null)) {
_data.writeInt(1);
order.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateOrder, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Delete an {@link Order}.
   *
   * @param orderId The ID of the {@link Order} to be deleted.
   * @return true if the {@link Order} was deleted successfully, otherwise false.
   * @see #deleteOrderOnline
   */
@Override public boolean deleteOrder(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_deleteOrder, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Add a {@link com.clover.sdk.v3.base.ServiceCharge} to an order.
   *
   * @param orderId The order ID on which to add the service charge.
   * @param serviceChargeId The ID of the service charge to be added to the order.
   * @return The updated order with the service charge added.
   */
@Override public com.clover.sdk.v3.order.Order addServiceCharge(java.lang.String orderId, java.lang.String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(serviceChargeId);
mRemote.transact(Stub.TRANSACTION_addServiceCharge, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Add a {@link com.clover.sdk.v3.base.ServiceCharge} to an order.
   *
   * @param orderId The order ID on which to add the service charge.
   * @param serviceChargeId The ID of the service charge to be added to the order.
   * @return The updated order with the service charge removed.
   */
@Override public com.clover.sdk.v3.order.Order deleteServiceCharge(java.lang.String orderId, java.lang.String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(serviceChargeId);
mRemote.transact(Stub.TRANSACTION_deleteServiceCharge, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Add a fixed-price line item to an order. A fixed price line item is priced per item.
   *
   * {@link LineItem}s are linked to {@link com.clover.sdk.v3.inventory.Item}s with an item ID. Think of the
   * {@link com.clover.sdk.v3.inventory.Item} as a template for creating a {@link LineItem}, and a
   * {@link LineItem} as the order's copy of an {@link com.clover.sdk.v3.inventory.Item}.
   *
   * @param orderId The ID of the order to which to add the line item.
   * @param itemId The item ID from which to create the line item to be added to the order.
   * @param binName The BIN name for the line item. May be {@link null}.
   * @param userData Meta-data to attach to the line item. May be {@link null}.
   * @return The newly created {@link LineItem}.
   */
@Override public com.clover.sdk.v3.order.LineItem addFixedPriceLineItem(java.lang.String orderId, java.lang.String itemId, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(itemId);
_data.writeString(binName);
_data.writeString(userData);
mRemote.transact(Stub.TRANSACTION_addFixedPriceLineItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Add a per-unit line item to an order. A per unit line item is priced per unit, not per item. A good example
   * is items that are sold by weight (e.g., per ounce).
   *
   * {@link LineItem}s are linked to {@link com.clover.sdk.v3.inventory.Item}s with an item ID. Think of the
   * {@link com.clover.sdk.v3.inventory.Item} as a template for creating a {@link LineItem}, and a
   * {@link LineItem} as the order's copy of an {@link com.clover.sdk.v3.inventory.Item}.
   *
   * @param orderId The ID of the order to which to add the line item.
   * @param itemId The item ID from which to create the line item to be added to the order.
   * @param unitQuantity The unit quantity for the line item (e.g., "10 ounces").
   * @param binName The BIN name for the line item. May be {@link null}.
   * @param userData Meta-data to attach to the line item. May be {@link null}.
   * @return The newly created {@link LineItem}.
   */
@Override public com.clover.sdk.v3.order.LineItem addPerUnitLineItem(java.lang.String orderId, java.lang.String itemId, int unitQuantity, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(itemId);
_data.writeInt(unitQuantity);
_data.writeString(binName);
_data.writeString(userData);
mRemote.transact(Stub.TRANSACTION_addPerUnitLineItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Add a variably-priced line item to the order. A variably priced line item's price is determined at the time of
   * sale.
   *
   * Note that this method is not consistent with others in this interface as it returns a {@link LineItem}. All other
   * methods return the complete, updated {@link Order}.
   *
   * @param orderId The ID of the order to which to add the line item.
   * @param itemId The item ID from which to create the line item to be added to the order.
   * @param price The price of the line item.
   * @param binName The BIN name for the line item. May be {@link null}.
   * @param userData Meta-data to attach to the line item. May be {@link null}.
   */
@Override public com.clover.sdk.v3.order.LineItem addVariablePriceLineItem(java.lang.String orderId, java.lang.String itemId, long price, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(itemId);
_data.writeLong(price);
_data.writeString(binName);
_data.writeString(userData);
mRemote.transact(Stub.TRANSACTION_addVariablePriceLineItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Add a custom line item to an order. Custom line items are not associated with an inventory item.
   *
   * Note that this method is not consistent with others in this interface as it returns a {@link LineItem}. All other
   * methods return the complete, updated {@link Order}.

   * @param orderId The ID of the order to which to add the line item.
   * @param lineItem The line item to add to the order.
   * @param isTaxable true if this line item is taxable, otherwise false.
   */
@Override public com.clover.sdk.v3.order.LineItem addCustomLineItem(java.lang.String orderId, com.clover.sdk.v3.order.LineItem lineItem, boolean isTaxable, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((lineItem!=null)) {
_data.writeInt(1);
lineItem.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((isTaxable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_addCustomLineItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Update {@link LineItem}s on an {@link Order}. Only the following fields may be updated,
   * <ul>
   *   <li>binName</li>
   *   <li>printed</li>
   *   <li>note</li>
   *   <li>userData</li>
   * </ul>
   * All other fields are ignored.
   *
   * @param orderId The ID of the order on which to update the line items.
   * @param lineItemIds The {@link LineItem}s to update on the order.
   * @return The updated {@link LineItem}s.
   */
@Override public java.util.List<com.clover.sdk.v3.order.LineItem> updateLineItems(java.lang.String orderId, java.util.List<com.clover.sdk.v3.order.LineItem> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.order.LineItem> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeTypedList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_updateLineItems, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.order.LineItem.CREATOR);
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Delete {@link LineItem}s from an {@link Order}.
   *
   * @param orderId The ID of the {@link Order} from which to delete the line items.
   * @param lineItemIds The {@link LineItem} IDs to delete.
   * @return The updated {@link Order}.
   */
@Override public com.clover.sdk.v3.order.Order deleteLineItems(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_deleteLineItems, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<com.clover.sdk.v3.order.LineItem> copyLineItems(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.order.LineItem> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderId);
_data.writeString(destinationOrderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_copyLineItems, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.order.LineItem.CREATOR);
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v3.order.Order setLineItemNote(java.lang.String orderId, java.lang.String lineItemId, java.lang.String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
_data.writeString(note);
mRemote.transact(Stub.TRANSACTION_setLineItemNote, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v3.order.Order addLineItemModification(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.inventory.Modifier modifier, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
if ((modifier!=null)) {
_data.writeInt(1);
modifier.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addLineItemModification, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v3.order.Order deleteLineItemModifications(java.lang.String orderId, java.lang.String lineItemId, java.util.List<java.lang.String> modificationIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
_data.writeStringList(modificationIds);
mRemote.transact(Stub.TRANSACTION_deleteLineItemModifications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v3.order.LineItem exchangeItem(java.lang.String orderId, java.lang.String oldLineItemId, java.lang.String itemId, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(oldLineItemId);
_data.writeString(itemId);
_data.writeString(binName);
_data.writeString(userData);
mRemote.transact(Stub.TRANSACTION_exchangeItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v3.order.Order addDiscount(java.lang.String orderId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((discount!=null)) {
_data.writeInt(1);
discount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addDiscount, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v3.order.Order deleteDiscounts(java.lang.String orderId, java.util.List<java.lang.String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(discountIds);
mRemote.transact(Stub.TRANSACTION_deleteDiscounts, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v3.order.Order addLineItemDiscount(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
if ((discount!=null)) {
_data.writeInt(1);
discount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addLineItemDiscount, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v3.order.Order deleteLineItemDiscounts(java.lang.String orderId, java.lang.String lineItemId, java.util.List<java.lang.String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
_data.writeStringList(discountIds);
mRemote.transact(Stub.TRANSACTION_deleteLineItemDiscounts, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.Order addTip(java.lang.String orderId, java.lang.String paymentId, long amount, boolean online, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
_data.writeLong(amount);
_data.writeInt(((online)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_addTip, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.payments.Payment pay(java.lang.String orderId, com.clover.sdk.v3.pay.PaymentRequest paymentRequest, boolean isAllowOffline, java.lang.String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Payment _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((paymentRequest!=null)) {
_data.writeInt(1);
paymentRequest.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((isAllowOffline)?(1):(0)));
_data.writeString(note);
mRemote.transact(Stub.TRANSACTION_pay, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Payment.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * @deprecated Use {@link #addPayment2}.
   * If necessary, use other methods to open the cash drawer and log cash events.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.Order addPayment(java.lang.String orderId, com.clover.sdk.v3.payments.Payment payment, java.util.List<com.clover.sdk.v3.order.LineItem> lineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeTypedList(lineItems);
mRemote.transact(Stub.TRANSACTION_addPayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @deprecated Use {@link #voidPayment2}.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.Order voidPayment(java.lang.String orderId, java.lang.String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
mRemote.transact(Stub.TRANSACTION_voidPayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.payments.Credit addCredit(java.lang.String orderId, com.clover.sdk.v3.payments.Credit payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Credit _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addCredit, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Credit.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not implemented.
   */
@Override public com.clover.sdk.v3.order.Order deleteCredit(java.lang.String orderId, java.lang.String creditId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(creditId);
mRemote.transact(Stub.TRANSACTION_deleteCredit, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.payments.Refund addRefund(java.lang.String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Refund _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addRefund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not implemented.
   */
@Override public com.clover.sdk.v3.order.Order deleteRefund(java.lang.String orderId, java.lang.String refundId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(refundId);
mRemote.transact(Stub.TRANSACTION_deleteRefund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Delete an {@link Order} synchronously on the server. Differing from {@link #deleteOrder(String)}, this method only
   * completes successfully if this device can reach the server and retrieve confirmation that the order was deleted.
   *
   * @param orderId The ID of the order to be deleted.
   * @return true if the order was deleted successfully, otherwise false.
   * @see #deleteOrder
   */
@Override public boolean deleteOrderOnline(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_deleteOrderOnline, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v3.order.Order addBatchLineItemModifications(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v3.inventory.Modifier modifier, int quantity, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
if ((modifier!=null)) {
_data.writeInt(1);
modifier.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(quantity);
mRemote.transact(Stub.TRANSACTION_addBatchLineItemModifications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v3.order.Order addBatchLineItemDiscounts(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, java.util.List<com.clover.sdk.v3.order.Discount> discounts, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
_data.writeTypedList(discounts);
mRemote.transact(Stub.TRANSACTION_addBatchLineItemDiscounts, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.Map createLineItemsFrom(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.Map _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderId);
_data.writeString(destinationOrderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_createLineItemsFrom, _data, _reply, 0);
_reply.readException();
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_result = _reply.readHashMap(cl);
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Print line items to the kitchen or order printer quickly. Only prints inventory items that are
   * associated with a printer. The association is done by linking an item and a printer with a tag.
   * It will only print line items once, subsequent invocations will not cause additional prints,
   * but the method will still return true.
   *
   * @return true, unless the order has no line items in it that can be fired to a printer, will
   * return true but not print anything if all items have been already printed
   */
@Override public boolean fire(java.lang.String sourceOrderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderId);
mRemote.transact(Stub.TRANSACTION_fire, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.payments.Payment updatePayment(java.lang.String orderId, com.clover.sdk.v3.payments.Payment payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Payment _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updatePayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Payment.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.Order voidPayment2(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
_data.writeString(iccContainer);
if ((reason!=null)) {
_data.writeInt(1);
reason.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(source);
mRemote.transact(Stub.TRANSACTION_voidPayment2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.Order removePayment(java.lang.String orderId, java.lang.String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
mRemote.transact(Stub.TRANSACTION_removePayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.payments.Refund addRefundOffline(java.lang.String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Refund _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addRefundOffline, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.payments.Refund refund(java.lang.String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Refund _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_refund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void addOnOrderUpdatedListener2(com.clover.sdk.v3.order.IOnOrderUpdateListener2 listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addOnOrderUpdatedListener2, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeOnOrderUpdatedListener2(com.clover.sdk.v3.order.IOnOrderUpdateListener2 listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeOnOrderUpdatedListener2, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
   * Just like {@link #addDiscount} but returns a {@link Discount} instead of an {@link Order}.
   */
@Override public com.clover.sdk.v3.order.Discount addDiscount2(java.lang.String orderId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Discount _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((discount!=null)) {
_data.writeInt(1);
discount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addDiscount2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Discount.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Just like {@link #addLineItemDiscount} but returns a {@link Discount} instead of an {@link Order}.
   */
@Override public com.clover.sdk.v3.order.Discount addLineItemDiscount2(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Discount _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
if ((discount!=null)) {
_data.writeInt(1);
discount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addLineItemDiscount2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Discount.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   *
   * Add a payment to an order. The payment is only added to the local DB: the change is not persisted on the server.
   * This method differs from {@link #addPayment} in that it does not add cash events or
   * open the cash drawer. Not available to non-Clover apps.
   *
   * @param orderId, the order ID.
   * @param payment, the payment.
   * @param lineItems, the line items that were paid by this payment.

   * @return the updated order.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.Order addPayment2(java.lang.String orderId, com.clover.sdk.v3.payments.Payment payment, java.util.List<com.clover.sdk.v3.order.LineItem> lineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeTypedList(lineItems);
mRemote.transact(Stub.TRANSACTION_addPayment2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Just like {@link #fire} but additionally when requireAllItems is set to true it will not print
   * and return false if some items on the order haven't been printed yet and would not be printed
   * because they are not associated with an order printer.
   *
   * @return just like {@link #fire}, but additionally returns false if there are unprinted items
   *         without a printer associated.
   */
@Override public boolean fire2(java.lang.String sourceOrderid, boolean requireAllItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderid);
_data.writeInt(((requireAllItems)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_fire2, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Just like {@link #createLineItemsFrom} but additionally when copyPrinted is set to true it will copy print flags on
   * line items (normally did not), and when broadcastLineItems is set to true it will 
   * broadcastLineItems (normally did).
   */
@Override public java.util.Map createLineItemsFrom2(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, boolean copyPrinted, boolean broadcastLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.Map _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderId);
_data.writeString(destinationOrderId);
_data.writeStringList(lineItemIds);
_data.writeInt(((copyPrinted)?(1):(0)));
_data.writeInt(((broadcastLineItems)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_createLineItemsFrom2, _data, _reply, 0);
_reply.readException();
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_result = _reply.readHashMap(cl);
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Just like {@link #deleteOrder} but additionally when allowDeleteIfLineItemPrinted is true it will delete the order
   * when line items are printed (normally did not).
   */
@Override public boolean deleteOrder2(java.lang.String orderId, boolean allowDeleteIfLineItemPrinted, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeInt(((allowDeleteIfLineItemPrinted)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_deleteOrder2, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * This pulls pending payments from the local device db
   */
@Override public java.util.List<com.clover.sdk.v3.payments.Payment> getPendingPayments(com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.payments.Payment> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPendingPayments, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.payments.Payment.CREATOR);
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.payments.CreditRefund addCreditRefund(java.lang.String orderId, com.clover.sdk.v3.payments.CreditRefund creditRefund, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.CreditRefund _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((creditRefund!=null)) {
_data.writeInt(1);
creditRefund.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addCreditRefund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.CreditRefund.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.Order deleteCreditRefund(java.lang.String orderId, java.lang.String creditRefundId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(creditRefundId);
mRemote.transact(Stub.TRANSACTION_deleteCreditRefund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.Order voidPaymentWithCard(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.pay.PaymentRequestCardDetails card, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
_data.writeString(iccContainer);
if ((card!=null)) {
_data.writeInt(1);
card.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((reason!=null)) {
_data.writeInt(1);
reason.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(source);
mRemote.transact(Stub.TRANSACTION_voidPaymentWithCard, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Get list of lineitem ids for the order that has printtag to print.
   * The items that are already printed are not part of the list
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public java.util.List<java.lang.String> getLineItemsToFire(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<java.lang.String> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_getLineItemsToFire, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArrayList();
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Reprint all lineitems that has a printtag even if they are printed.
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public boolean refire(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_refire, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Not available to non-Clover apps.
   * @deprecated Use {@link #deleteOrder3}.
   * @y.exclude
   */
@Override public boolean deleteOrderOnline2(java.lang.String orderId, boolean usePermissionForOrderDeletions, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeInt(((usePermissionForOrderDeletions)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_deleteOrderOnline2, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Delete an {@link Order}. This method allows switching between online deletion like {@link #deleteOrderOnline(String)}
   * and offline (deleting loaclly and adding message to server queue) like {@link #deleteOrder(String)}
   * This method allows an override toggle for the employee permissions and printed line items checks.
   *
   * @param orderId The ID of the order to be deleted.
   * @param deleteOnline true to delete an order synchronously on the server @see #deleteOrderOnline
   * @param allowDeleteIfLineItemPrinted true to allow deleting order if it has printed line items
   * @param allowDeleteIfNoEmployeePermission true to allow deletion regardless of employee permission.
   * @return true if the order was deleted successfully, otherwise false.
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public boolean deleteOrder3(java.lang.String orderId, boolean deleteOnline, boolean allowDeleteIfLineItemPrinted, boolean allowDeleteIfNoEmployeePermission, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeInt(((deleteOnline)?(1):(0)));
_data.writeInt(((allowDeleteIfLineItemPrinted)?(1):(0)));
_data.writeInt(((allowDeleteIfNoEmployeePermission)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_deleteOrder3, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * Card present void
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.Order voidPaymentCardPresent(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.pay.PaymentRequestCardDetails card, com.clover.sdk.v3.payments.TransactionInfo transactionInfo, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
_data.writeString(iccContainer);
if ((card!=null)) {
_data.writeInt(1);
card.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((transactionInfo!=null)) {
_data.writeInt(1);
transactionInfo.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((reason!=null)) {
_data.writeInt(1);
reason.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(source);
mRemote.transact(Stub.TRANSACTION_voidPaymentCardPresent, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
   * @param orderId The ID of the order to be updated.
   * @param creditId The ID of the credit to be refunded.
   * @return the CreditRefund object constructed using the RefundResponse the serverf returns
   * Not available to non-Clover apps.
   * @y.exclude
  */
@Override public com.clover.sdk.v3.payments.CreditRefund vaultedCreditRefund(java.lang.String orderId, java.lang.String creditId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.CreditRefund _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(creditId);
mRemote.transact(Stub.TRANSACTION_vaultedCreditRefund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.CreditRefund.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_addOnOrderUpdatedListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_removeOnOrderUpdatedListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getOrder = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getOrders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_createOrder = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_updateOrder = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_deleteOrder = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_addServiceCharge = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_deleteServiceCharge = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_addFixedPriceLineItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_addPerUnitLineItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_addVariablePriceLineItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_addCustomLineItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_updateLineItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_deleteLineItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_copyLineItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_setLineItemNote = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_addLineItemModification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_deleteLineItemModifications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_exchangeItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_addDiscount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_deleteDiscounts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_addLineItemDiscount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_deleteLineItemDiscounts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_addTip = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_pay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_addPayment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_voidPayment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_addCredit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_deleteCredit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_addRefund = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_deleteRefund = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
static final int TRANSACTION_deleteOrderOnline = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
static final int TRANSACTION_addBatchLineItemModifications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
static final int TRANSACTION_addBatchLineItemDiscounts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
static final int TRANSACTION_createLineItemsFrom = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
static final int TRANSACTION_fire = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
static final int TRANSACTION_updatePayment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
static final int TRANSACTION_voidPayment2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
static final int TRANSACTION_removePayment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
static final int TRANSACTION_addRefundOffline = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
static final int TRANSACTION_refund = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
static final int TRANSACTION_addOnOrderUpdatedListener2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
static final int TRANSACTION_removeOnOrderUpdatedListener2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
static final int TRANSACTION_addDiscount2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
static final int TRANSACTION_addLineItemDiscount2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
static final int TRANSACTION_addPayment2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
static final int TRANSACTION_fire2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
static final int TRANSACTION_createLineItemsFrom2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
static final int TRANSACTION_deleteOrder2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
static final int TRANSACTION_getPendingPayments = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
static final int TRANSACTION_addCreditRefund = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
static final int TRANSACTION_deleteCreditRefund = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
static final int TRANSACTION_voidPaymentWithCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
static final int TRANSACTION_getLineItemsToFire = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
static final int TRANSACTION_refire = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
static final int TRANSACTION_deleteOrderOnline2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
static final int TRANSACTION_deleteOrder3 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
static final int TRANSACTION_voidPaymentCardPresent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
static final int TRANSACTION_vaultedCreditRefund = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
}
public void addOnOrderUpdatedListener(com.clover.sdk.v3.order.IOnOrderUpdateListener listener) throws android.os.RemoteException;
public void removeOnOrderUpdatedListener(com.clover.sdk.v3.order.IOnOrderUpdateListener listener) throws android.os.RemoteException;
/**
   * Get the {@link Order} for the given ID. If the order is not synchronized on this device, the order is fetched
   * from the server.
   *
   * @param orderId The ID of the {@link Order} to retrieve.
   * @return The {@link Order}s corresponding to the provided ID, or {@link null} if the order does not exists locally
   * and it cannot be fetched from the server. Note that this may be because the server is not reachable or because
   * the order for the given ID does not exist.
   */
public com.clover.sdk.v3.order.Order getOrder(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public java.util.List<com.clover.sdk.v3.order.Order> getOrders(java.util.List<java.lang.String> orderIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Create a new {@link Order}. Only the order title is used for creation; all other fields are ignored. The following
   * fields are set automatically:
   * <ul>
   *   <li>id</li>
   *   <li>device - set the this device.</li>
   *   <li>currency - set to the merchant's currency.</li>
   *   <li>vat - set according to the merchant's setting.</li>
   *   <li>groupLineItems - set according to the merchant's setting.</li>
   *   <li>testMode - set according to the merchant's setting.</li>
   *   <li>createdTime - set to this device's current time.</li>
   *   <li>taxRemoved - set to false.</li>
   *   <li>total - set to 0.</li>
   *   <li>employee - set to the current employee logged into this device.</li>
   * </ul>
   *
   * This method requires ORDERS_W permission.
   *
   * @param order The order to create.
   */
public com.clover.sdk.v3.order.Order createOrder(com.clover.sdk.v3.order.Order order, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Update an {@link Order}. The following fields may be updated,
   * <ul>
   *   <li>total</li>
   *   <li>title</li>
   *   <li>note</li>
   *   <li>state</li>
   *   <li>taxRemoved</li>
   *   <li>groupLineItems</li>
   *   <li>manualTransactions</li>
   *   <li>testMode</li>
   *   <li>orderType.id</li>
   *   <li>customerId</li>
   *   <li>payType</li>
   *   <li>createdTime</li>
   *   <li>employee.id</li>
   * </ul>
   * All other fields are ignored.
   *
   * This method requires ORDERS_W permission.
   *
   * @param order The {@link Order} to updated.
   */
public com.clover.sdk.v3.order.Order updateOrder(com.clover.sdk.v3.order.Order order, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Delete an {@link Order}.
   *
   * @param orderId The ID of the {@link Order} to be deleted.
   * @return true if the {@link Order} was deleted successfully, otherwise false.
   * @see #deleteOrderOnline
   */
public boolean deleteOrder(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Add a {@link com.clover.sdk.v3.base.ServiceCharge} to an order.
   *
   * @param orderId The order ID on which to add the service charge.
   * @param serviceChargeId The ID of the service charge to be added to the order.
   * @return The updated order with the service charge added.
   */
public com.clover.sdk.v3.order.Order addServiceCharge(java.lang.String orderId, java.lang.String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Add a {@link com.clover.sdk.v3.base.ServiceCharge} to an order.
   *
   * @param orderId The order ID on which to add the service charge.
   * @param serviceChargeId The ID of the service charge to be added to the order.
   * @return The updated order with the service charge removed.
   */
public com.clover.sdk.v3.order.Order deleteServiceCharge(java.lang.String orderId, java.lang.String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Add a fixed-price line item to an order. A fixed price line item is priced per item.
   *
   * {@link LineItem}s are linked to {@link com.clover.sdk.v3.inventory.Item}s with an item ID. Think of the
   * {@link com.clover.sdk.v3.inventory.Item} as a template for creating a {@link LineItem}, and a
   * {@link LineItem} as the order's copy of an {@link com.clover.sdk.v3.inventory.Item}.
   *
   * @param orderId The ID of the order to which to add the line item.
   * @param itemId The item ID from which to create the line item to be added to the order.
   * @param binName The BIN name for the line item. May be {@link null}.
   * @param userData Meta-data to attach to the line item. May be {@link null}.
   * @return The newly created {@link LineItem}.
   */
public com.clover.sdk.v3.order.LineItem addFixedPriceLineItem(java.lang.String orderId, java.lang.String itemId, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Add a per-unit line item to an order. A per unit line item is priced per unit, not per item. A good example
   * is items that are sold by weight (e.g., per ounce).
   *
   * {@link LineItem}s are linked to {@link com.clover.sdk.v3.inventory.Item}s with an item ID. Think of the
   * {@link com.clover.sdk.v3.inventory.Item} as a template for creating a {@link LineItem}, and a
   * {@link LineItem} as the order's copy of an {@link com.clover.sdk.v3.inventory.Item}.
   *
   * @param orderId The ID of the order to which to add the line item.
   * @param itemId The item ID from which to create the line item to be added to the order.
   * @param unitQuantity The unit quantity for the line item (e.g., "10 ounces").
   * @param binName The BIN name for the line item. May be {@link null}.
   * @param userData Meta-data to attach to the line item. May be {@link null}.
   * @return The newly created {@link LineItem}.
   */
public com.clover.sdk.v3.order.LineItem addPerUnitLineItem(java.lang.String orderId, java.lang.String itemId, int unitQuantity, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Add a variably-priced line item to the order. A variably priced line item's price is determined at the time of
   * sale.
   *
   * Note that this method is not consistent with others in this interface as it returns a {@link LineItem}. All other
   * methods return the complete, updated {@link Order}.
   *
   * @param orderId The ID of the order to which to add the line item.
   * @param itemId The item ID from which to create the line item to be added to the order.
   * @param price The price of the line item.
   * @param binName The BIN name for the line item. May be {@link null}.
   * @param userData Meta-data to attach to the line item. May be {@link null}.
   */
public com.clover.sdk.v3.order.LineItem addVariablePriceLineItem(java.lang.String orderId, java.lang.String itemId, long price, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Add a custom line item to an order. Custom line items are not associated with an inventory item.
   *
   * Note that this method is not consistent with others in this interface as it returns a {@link LineItem}. All other
   * methods return the complete, updated {@link Order}.

   * @param orderId The ID of the order to which to add the line item.
   * @param lineItem The line item to add to the order.
   * @param isTaxable true if this line item is taxable, otherwise false.
   */
public com.clover.sdk.v3.order.LineItem addCustomLineItem(java.lang.String orderId, com.clover.sdk.v3.order.LineItem lineItem, boolean isTaxable, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Update {@link LineItem}s on an {@link Order}. Only the following fields may be updated,
   * <ul>
   *   <li>binName</li>
   *   <li>printed</li>
   *   <li>note</li>
   *   <li>userData</li>
   * </ul>
   * All other fields are ignored.
   *
   * @param orderId The ID of the order on which to update the line items.
   * @param lineItemIds The {@link LineItem}s to update on the order.
   * @return The updated {@link LineItem}s.
   */
public java.util.List<com.clover.sdk.v3.order.LineItem> updateLineItems(java.lang.String orderId, java.util.List<com.clover.sdk.v3.order.LineItem> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Delete {@link LineItem}s from an {@link Order}.
   *
   * @param orderId The ID of the {@link Order} from which to delete the line items.
   * @param lineItemIds The {@link LineItem} IDs to delete.
   * @return The updated {@link Order}.
   */
public com.clover.sdk.v3.order.Order deleteLineItems(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public java.util.List<com.clover.sdk.v3.order.LineItem> copyLineItems(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order setLineItemNote(java.lang.String orderId, java.lang.String lineItemId, java.lang.String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addLineItemModification(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.inventory.Modifier modifier, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order deleteLineItemModifications(java.lang.String orderId, java.lang.String lineItemId, java.util.List<java.lang.String> modificationIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItem exchangeItem(java.lang.String orderId, java.lang.String oldLineItemId, java.lang.String itemId, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addDiscount(java.lang.String orderId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order deleteDiscounts(java.lang.String orderId, java.util.List<java.lang.String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addLineItemDiscount(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order deleteLineItemDiscounts(java.lang.String orderId, java.lang.String lineItemId, java.util.List<java.lang.String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.order.Order addTip(java.lang.String orderId, java.lang.String paymentId, long amount, boolean online, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.payments.Payment pay(java.lang.String orderId, com.clover.sdk.v3.pay.PaymentRequest paymentRequest, boolean isAllowOffline, java.lang.String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * @deprecated Use {@link #addPayment2}.
   * If necessary, use other methods to open the cash drawer and log cash events.
   * @y.exclude
   */
public com.clover.sdk.v3.order.Order addPayment(java.lang.String orderId, com.clover.sdk.v3.payments.Payment payment, java.util.List<com.clover.sdk.v3.order.LineItem> lineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @deprecated Use {@link #voidPayment2}.
   * @y.exclude
   */
public com.clover.sdk.v3.order.Order voidPayment(java.lang.String orderId, java.lang.String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.payments.Credit addCredit(java.lang.String orderId, com.clover.sdk.v3.payments.Credit payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not implemented.
   */
public com.clover.sdk.v3.order.Order deleteCredit(java.lang.String orderId, java.lang.String creditId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.payments.Refund addRefund(java.lang.String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not implemented.
   */
public com.clover.sdk.v3.order.Order deleteRefund(java.lang.String orderId, java.lang.String refundId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Delete an {@link Order} synchronously on the server. Differing from {@link #deleteOrder(String)}, this method only
   * completes successfully if this device can reach the server and retrieve confirmation that the order was deleted.
   *
   * @param orderId The ID of the order to be deleted.
   * @return true if the order was deleted successfully, otherwise false.
   * @see #deleteOrder
   */
public boolean deleteOrderOnline(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addBatchLineItemModifications(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v3.inventory.Modifier modifier, int quantity, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addBatchLineItemDiscounts(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, java.util.List<com.clover.sdk.v3.order.Discount> discounts, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public java.util.Map createLineItemsFrom(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Print line items to the kitchen or order printer quickly. Only prints inventory items that are
   * associated with a printer. The association is done by linking an item and a printer with a tag.
   * It will only print line items once, subsequent invocations will not cause additional prints,
   * but the method will still return true.
   *
   * @return true, unless the order has no line items in it that can be fired to a printer, will
   * return true but not print anything if all items have been already printed
   */
public boolean fire(java.lang.String sourceOrderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.payments.Payment updatePayment(java.lang.String orderId, com.clover.sdk.v3.payments.Payment payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.order.Order voidPayment2(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.order.Order removePayment(java.lang.String orderId, java.lang.String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.payments.Refund addRefundOffline(java.lang.String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.payments.Refund refund(java.lang.String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public void addOnOrderUpdatedListener2(com.clover.sdk.v3.order.IOnOrderUpdateListener2 listener) throws android.os.RemoteException;
public void removeOnOrderUpdatedListener2(com.clover.sdk.v3.order.IOnOrderUpdateListener2 listener) throws android.os.RemoteException;
/**
   * Just like {@link #addDiscount} but returns a {@link Discount} instead of an {@link Order}.
   */
public com.clover.sdk.v3.order.Discount addDiscount2(java.lang.String orderId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Just like {@link #addLineItemDiscount} but returns a {@link Discount} instead of an {@link Order}.
   */
public com.clover.sdk.v3.order.Discount addLineItemDiscount2(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   *
   * Add a payment to an order. The payment is only added to the local DB: the change is not persisted on the server.
   * This method differs from {@link #addPayment} in that it does not add cash events or
   * open the cash drawer. Not available to non-Clover apps.
   *
   * @param orderId, the order ID.
   * @param payment, the payment.
   * @param lineItems, the line items that were paid by this payment.

   * @return the updated order.
   * @y.exclude
   */
public com.clover.sdk.v3.order.Order addPayment2(java.lang.String orderId, com.clover.sdk.v3.payments.Payment payment, java.util.List<com.clover.sdk.v3.order.LineItem> lineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Just like {@link #fire} but additionally when requireAllItems is set to true it will not print
   * and return false if some items on the order haven't been printed yet and would not be printed
   * because they are not associated with an order printer.
   *
   * @return just like {@link #fire}, but additionally returns false if there are unprinted items
   *         without a printer associated.
   */
public boolean fire2(java.lang.String sourceOrderid, boolean requireAllItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Just like {@link #createLineItemsFrom} but additionally when copyPrinted is set to true it will copy print flags on
   * line items (normally did not), and when broadcastLineItems is set to true it will 
   * broadcastLineItems (normally did).
   */
public java.util.Map createLineItemsFrom2(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, boolean copyPrinted, boolean broadcastLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Just like {@link #deleteOrder} but additionally when allowDeleteIfLineItemPrinted is true it will delete the order
   * when line items are printed (normally did not).
   */
public boolean deleteOrder2(java.lang.String orderId, boolean allowDeleteIfLineItemPrinted, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * This pulls pending payments from the local device db
   */
public java.util.List<com.clover.sdk.v3.payments.Payment> getPendingPayments(com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.payments.CreditRefund addCreditRefund(java.lang.String orderId, com.clover.sdk.v3.payments.CreditRefund creditRefund, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.order.Order deleteCreditRefund(java.lang.String orderId, java.lang.String creditRefundId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.order.Order voidPaymentWithCard(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.pay.PaymentRequestCardDetails card, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Get list of lineitem ids for the order that has printtag to print.
   * The items that are already printed are not part of the list
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
public java.util.List<java.lang.String> getLineItemsToFire(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Reprint all lineitems that has a printtag even if they are printed.
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
public boolean refire(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   * @deprecated Use {@link #deleteOrder3}.
   * @y.exclude
   */
public boolean deleteOrderOnline2(java.lang.String orderId, boolean usePermissionForOrderDeletions, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Delete an {@link Order}. This method allows switching between online deletion like {@link #deleteOrderOnline(String)}
   * and offline (deleting loaclly and adding message to server queue) like {@link #deleteOrder(String)}
   * This method allows an override toggle for the employee permissions and printed line items checks.
   *
   * @param orderId The ID of the order to be deleted.
   * @param deleteOnline true to delete an order synchronously on the server @see #deleteOrderOnline
   * @param allowDeleteIfLineItemPrinted true to allow deleting order if it has printed line items
   * @param allowDeleteIfNoEmployeePermission true to allow deletion regardless of employee permission.
   * @return true if the order was deleted successfully, otherwise false.
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
public boolean deleteOrder3(java.lang.String orderId, boolean deleteOnline, boolean allowDeleteIfLineItemPrinted, boolean allowDeleteIfNoEmployeePermission, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Card present void
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.order.Order voidPaymentCardPresent(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.pay.PaymentRequestCardDetails card, com.clover.sdk.v3.payments.TransactionInfo transactionInfo, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * @param orderId The ID of the order to be updated.
   * @param creditId The ID of the credit to be refunded.
   * @return the CreditRefund object constructed using the RefundResponse the serverf returns
   * Not available to non-Clover apps.
   * @y.exclude
  */
public com.clover.sdk.v3.payments.CreditRefund vaultedCreditRefund(java.lang.String orderId, java.lang.String creditId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
}
