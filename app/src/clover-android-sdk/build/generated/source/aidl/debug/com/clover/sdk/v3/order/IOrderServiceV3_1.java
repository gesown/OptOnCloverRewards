/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\src\\clover-android-sdk\\clover-android-sdk\\src\\main\\aidl\\com\\clover\\sdk\\v3\\order\\IOrderServiceV3_1.aidl
 */
package com.clover.sdk.v3.order;
/**
 * This service mirrors the functionality of {@link IOrderService} but uses a different
 * mechanism for trasferring Clover SDK objects. Specifically, as can be seen from
 * the interface definition below, CloverSDK objects are transferred wrapped by a
 * {@link FdParcelable}. This includes SDK objects passed to the service and objects
 * returned from the server.
 * <p/>
 * For example, to create an FD parcelablable input for an {@link Order} argument,
 * <pre>
 *   {@code
 *   OrderFdParcelable fdo = new OrderFdParcelable(order);
 *   service.updateOrder(fdo, ...);
 *   }
 * </pre>
 * <p/>
 * To obtain an Order object return value from an FD parcelable,
 * <pre>
 *   {@code
 *   OrderFdParcelable fdo = service.getOrder(...);
 *   Order order = fdo.getValue();
 *   }
 * </pre>
 */
public interface IOrderServiceV3_1 extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.order.IOrderServiceV3_1
{
private static final java.lang.String DESCRIPTOR = "com.clover.sdk.v3.order.IOrderServiceV3_1";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.order.IOrderServiceV3_1 interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.order.IOrderServiceV3_1 asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.order.IOrderServiceV3_1))) {
return ((com.clover.sdk.v3.order.IOrderServiceV3_1)iin);
}
return new com.clover.sdk.v3.order.IOrderServiceV3_1.Stub.Proxy(obj);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.getOrder(_arg0, _arg1);
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
com.clover.sdk.v3.order.OrderListFdParcelable _result = this.getOrders(_arg0, _arg1);
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
case TRANSACTION_createOrder:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.order.OrderFdParcelable _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.createOrder(_arg0, _arg1);
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
com.clover.sdk.v3.order.OrderFdParcelable _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.updateOrder(_arg0, _arg1);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addServiceCharge(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.deleteServiceCharge(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.LineItemFdParcelable _result = this.addFixedPriceLineItem(_arg0, _arg1, _arg2, _arg3, _arg4);
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
com.clover.sdk.v3.order.LineItemFdParcelable _result = this.addPerUnitLineItem(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
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
com.clover.sdk.v3.order.LineItemFdParcelable _result = this.addVariablePriceLineItem(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
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
com.clover.sdk.v3.order.LineItemFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.LineItemFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _arg2;
_arg2 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItemFdParcelable _result = this.addCustomLineItem(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.order.LineItemListFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.LineItemListFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItemListFdParcelable _result = this.updateLineItems(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteLineItems:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<java.lang.String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.deleteLineItems(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.LineItemListFdParcelable _result = this.copyLineItems(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.setLineItemNote(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.inventory.ModifierFdParcelable _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.inventory.ModifierFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addLineItemModification(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.deleteLineItemModifications(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.order.LineItemFdParcelable _result = this.exchangeItem(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
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
com.clover.sdk.v3.order.DiscountFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.DiscountFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addDiscount(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.deleteDiscounts(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.DiscountFdParcelable _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.order.DiscountFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addLineItemDiscount(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.deleteLineItemDiscounts(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addTip(_arg0, _arg1, _arg2, _arg3, _arg4);
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
com.clover.sdk.v3.pay.PaymentRequestFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.pay.PaymentRequestFdParcelable.CREATOR.createFromParcel(data);
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
com.clover.sdk.v3.payments.PaymentFdParcelable _result = this.pay(_arg0, _arg1, _arg2, _arg3, _arg4);
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
com.clover.sdk.v3.payments.PaymentFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.PaymentFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v3.order.LineItemListFdParcelable _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.order.LineItemListFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addPayment(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.voidPayment(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.payments.CreditFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.CreditFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.CreditFdParcelable _result = this.addCredit(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.deleteCredit(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.payments.RefundFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.RefundFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.RefundFdParcelable _result = this.addRefund(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.deleteRefund(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.inventory.ModifierFdParcelable _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.inventory.ModifierFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _arg3;
_arg3 = data.readInt();
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addBatchLineItemModifications(_arg0, _arg1, _arg2, _arg3, _arg4);
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
com.clover.sdk.v3.order.DiscountListFdParcelable _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.order.DiscountListFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addBatchLineItemDiscounts(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.order.LineItemMapFdParcelable _result = this.createLineItemsFrom(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.payments.PaymentFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.PaymentFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.PaymentFdParcelable _result = this.updatePayment(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.voidPayment2(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.removePayment(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.payments.RefundFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.RefundFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.RefundFdParcelable _result = this.addRefundOffline(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.payments.RefundFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.RefundFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.RefundFdParcelable _result = this.refund(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.DiscountFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.DiscountFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.DiscountFdParcelable _result = this.addDiscount2(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.DiscountFdParcelable _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.order.DiscountFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.DiscountFdParcelable _result = this.addLineItemDiscount2(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.payments.PaymentFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.PaymentFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v3.order.LineItemListFdParcelable _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.order.LineItemListFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addPayment2(_arg0, _arg1, _arg2, _arg3);
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
com.clover.sdk.v3.order.LineItemMapFdParcelable _result = this.createLineItemsFrom2(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
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
com.clover.sdk.v3.payments.PaymentListFdParcelable _result = this.getPendingPayments(_arg0);
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
case TRANSACTION_addCreditRefund:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.CreditRefundFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.CreditRefundFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.CreditRefundFdParcelable _result = this.addCreditRefund(_arg0, _arg1, _arg2);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.deleteCreditRefund(_arg0, _arg1, _arg2);
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
case TRANSACTION_addPreAuth:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.PaymentFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.PaymentFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addPreAuth(_arg0, _arg1, _arg2);
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
case TRANSACTION_capturePreAuth:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.PaymentFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.PaymentFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v3.order.LineItemListFdParcelable _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.order.LineItemListFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.capturePreAuth(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_voidPreAuth:
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.voidPreAuth(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
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
case TRANSACTION_voidPreAuthOnline:
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.voidPreAuthOnline(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
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
case TRANSACTION_deleteLineItemsWithReason:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<java.lang.String> _arg1;
_arg1 = data.createStringArrayList();
java.lang.String _arg2;
_arg2 = data.readString();
com.clover.sdk.v3.order.ClientEventType _arg3;
if ((0!=data.readInt())) {
_arg3 = com.clover.sdk.v3.order.ClientEventType.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.deleteLineItemsWithReason(_arg0, _arg1, _arg2, _arg3, _arg4);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.voidPaymentWithCard(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
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
case TRANSACTION_addFixedPriceLineItems:
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
int _arg4;
_arg4 = data.readInt();
com.clover.sdk.v1.ResultStatus _arg5;
_arg5 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItemListFdParcelable _result = this.addFixedPriceLineItems(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
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
case TRANSACTION_addPerUnitLineItems:
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
int _arg5;
_arg5 = data.readInt();
com.clover.sdk.v1.ResultStatus _arg6;
_arg6 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItemListFdParcelable _result = this.addPerUnitLineItems(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
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
case TRANSACTION_addVariablePriceLineItems:
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
int _arg5;
_arg5 = data.readInt();
com.clover.sdk.v1.ResultStatus _arg6;
_arg6 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItemListFdParcelable _result = this.addVariablePriceLineItems(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.voidPaymentCardPresent(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
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
case TRANSACTION_voidPayment3:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.util.Map _arg3;
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_arg3 = data.readHashMap(cl);
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
com.clover.sdk.v3.order.OrderFdParcelable _result = this.voidPayment3(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
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
case TRANSACTION_voidPaymentCardPresent2:
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
java.util.Map _arg5;
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_arg5 = data.readHashMap(cl);
com.clover.sdk.v3.order.VoidReason _arg6;
if ((0!=data.readInt())) {
_arg6 = com.clover.sdk.v3.order.VoidReason.CREATOR.createFromParcel(data);
}
else {
_arg6 = null;
}
java.lang.String _arg7;
_arg7 = data.readString();
com.clover.sdk.v1.ResultStatus _arg8;
_arg8 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.voidPaymentCardPresent2(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg8!=null)) {
reply.writeInt(1);
_arg8.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_refund2:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.RefundFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.RefundFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.util.Map _arg2;
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_arg2 = data.readHashMap(cl);
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.RefundFdParcelable _result = this.refund2(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_cleanUpPreAuthAfterTransaction:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.order.VoidReason _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.VoidReason.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.cleanUpPreAuthAfterTransaction(_arg0, _arg1, _arg2);
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
case TRANSACTION_splitLineItems:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<java.lang.String> _arg1;
_arg1 = data.createStringArrayList();
java.util.List<java.lang.String> _arg2;
_arg2 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItemListFdParcelable _result = this.splitLineItems(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_updateOnlineOrderState:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.onlineorder.OrderState _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.onlineorder.OrderState.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v3.onlineorder.Reason _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.onlineorder.Reason.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
this.updateOnlineOrderState(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addPrintGroup:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.order.PrintGroupFdParcelable _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.PrintGroupFdParcelable.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.OrderFdParcelable _result = this.addPrintGroup(_arg0, _arg1, _arg2);
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
private static class Proxy implements com.clover.sdk.v3.order.IOrderServiceV3_1
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable getOrder(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_getOrder, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderListFdParcelable getOrders(java.util.List<java.lang.String> orderIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderListFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringList(orderIds);
mRemote.transact(Stub.TRANSACTION_getOrders, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderListFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable createOrder(com.clover.sdk.v3.order.OrderFdParcelable fdOrder, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((fdOrder!=null)) {
_data.writeInt(1);
fdOrder.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createOrder, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable updateOrder(com.clover.sdk.v3.order.OrderFdParcelable fdOrder, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((fdOrder!=null)) {
_data.writeInt(1);
fdOrder.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateOrder, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable addServiceCharge(java.lang.String orderId, java.lang.String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(serviceChargeId);
mRemote.transact(Stub.TRANSACTION_addServiceCharge, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable deleteServiceCharge(java.lang.String orderId, java.lang.String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(serviceChargeId);
mRemote.transact(Stub.TRANSACTION_deleteServiceCharge, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItemFdParcelable addFixedPriceLineItem(java.lang.String orderId, java.lang.String itemId, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(itemId);
_data.writeString(binName);
_data.writeString(userData);
mRemote.transact(Stub.TRANSACTION_addFixedPriceLineItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItemFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItemFdParcelable addPerUnitLineItem(java.lang.String orderId, java.lang.String itemId, int unitQuantity, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemFdParcelable _result;
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
_result = com.clover.sdk.v3.order.LineItemFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItemFdParcelable addVariablePriceLineItem(java.lang.String orderId, java.lang.String itemId, long price, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemFdParcelable _result;
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
_result = com.clover.sdk.v3.order.LineItemFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItemFdParcelable addCustomLineItem(java.lang.String orderId, com.clover.sdk.v3.order.LineItemFdParcelable fdLineItem, boolean isTaxable, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdLineItem!=null)) {
_data.writeInt(1);
fdLineItem.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((isTaxable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_addCustomLineItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItemFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItemListFdParcelable updateLineItems(java.lang.String orderId, com.clover.sdk.v3.order.LineItemListFdParcelable fdLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemListFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdLineItems!=null)) {
_data.writeInt(1);
fdLineItems.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateLineItems, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItemListFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable deleteLineItems(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_deleteLineItems, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItemListFdParcelable copyLineItems(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemListFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderId);
_data.writeString(destinationOrderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_copyLineItems, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItemListFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable setLineItemNote(java.lang.String orderId, java.lang.String lineItemId, java.lang.String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
_data.writeString(note);
mRemote.transact(Stub.TRANSACTION_setLineItemNote, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable addLineItemModification(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.inventory.ModifierFdParcelable fdModifier, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
if ((fdModifier!=null)) {
_data.writeInt(1);
fdModifier.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addLineItemModification, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable deleteLineItemModifications(java.lang.String orderId, java.lang.String lineItemId, java.util.List<java.lang.String> modificationIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
_data.writeStringList(modificationIds);
mRemote.transact(Stub.TRANSACTION_deleteLineItemModifications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItemFdParcelable exchangeItem(java.lang.String orderId, java.lang.String oldLineItemId, java.lang.String itemId, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemFdParcelable _result;
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
_result = com.clover.sdk.v3.order.LineItemFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable addDiscount(java.lang.String orderId, com.clover.sdk.v3.order.DiscountFdParcelable fdDiscount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdDiscount!=null)) {
_data.writeInt(1);
fdDiscount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addDiscount, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable deleteDiscounts(java.lang.String orderId, java.util.List<java.lang.String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(discountIds);
mRemote.transact(Stub.TRANSACTION_deleteDiscounts, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable addLineItemDiscount(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.order.DiscountFdParcelable fdDiscount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
if ((fdDiscount!=null)) {
_data.writeInt(1);
fdDiscount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addLineItemDiscount, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable deleteLineItemDiscounts(java.lang.String orderId, java.lang.String lineItemId, java.util.List<java.lang.String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
_data.writeStringList(discountIds);
mRemote.transact(Stub.TRANSACTION_deleteLineItemDiscounts, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable addTip(java.lang.String orderId, java.lang.String paymentId, long amount, boolean online, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
_data.writeLong(amount);
_data.writeInt(((online)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_addTip, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.PaymentFdParcelable pay(java.lang.String orderId, com.clover.sdk.v3.pay.PaymentRequestFdParcelable fdPaymentRequest, boolean isAllowOffline, java.lang.String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.PaymentFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdPaymentRequest!=null)) {
_data.writeInt(1);
fdPaymentRequest.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((isAllowOffline)?(1):(0)));
_data.writeString(note);
mRemote.transact(Stub.TRANSACTION_pay, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.PaymentFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable addPayment(java.lang.String orderId, com.clover.sdk.v3.payments.PaymentFdParcelable fdPayment, com.clover.sdk.v3.order.LineItemListFdParcelable fdLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdPayment!=null)) {
_data.writeInt(1);
fdPayment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((fdLineItems!=null)) {
_data.writeInt(1);
fdLineItems.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addPayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable voidPayment(java.lang.String orderId, java.lang.String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
mRemote.transact(Stub.TRANSACTION_voidPayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.CreditFdParcelable addCredit(java.lang.String orderId, com.clover.sdk.v3.payments.CreditFdParcelable fdCredit, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.CreditFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdCredit!=null)) {
_data.writeInt(1);
fdCredit.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addCredit, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.CreditFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable deleteCredit(java.lang.String orderId, java.lang.String creditId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(creditId);
mRemote.transact(Stub.TRANSACTION_deleteCredit, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.RefundFdParcelable addRefund(java.lang.String orderId, com.clover.sdk.v3.payments.RefundFdParcelable refund, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.RefundFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((refund!=null)) {
_data.writeInt(1);
refund.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addRefund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.RefundFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable deleteRefund(java.lang.String orderId, java.lang.String refundId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(refundId);
mRemote.transact(Stub.TRANSACTION_deleteRefund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable addBatchLineItemModifications(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v3.inventory.ModifierFdParcelable fdModifier, int quantity, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
if ((fdModifier!=null)) {
_data.writeInt(1);
fdModifier.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(quantity);
mRemote.transact(Stub.TRANSACTION_addBatchLineItemModifications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable addBatchLineItemDiscounts(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v3.order.DiscountListFdParcelable discounts, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
if ((discounts!=null)) {
_data.writeInt(1);
discounts.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addBatchLineItemDiscounts, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItemMapFdParcelable createLineItemsFrom(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemMapFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderId);
_data.writeString(destinationOrderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_createLineItemsFrom, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItemMapFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.PaymentFdParcelable updatePayment(java.lang.String orderId, com.clover.sdk.v3.payments.PaymentFdParcelable fdPayment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.PaymentFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdPayment!=null)) {
_data.writeInt(1);
fdPayment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updatePayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.PaymentFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable voidPayment2(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
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
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable removePayment(java.lang.String orderId, java.lang.String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
mRemote.transact(Stub.TRANSACTION_removePayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.RefundFdParcelable addRefundOffline(java.lang.String orderId, com.clover.sdk.v3.payments.RefundFdParcelable fdRefund, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.RefundFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdRefund!=null)) {
_data.writeInt(1);
fdRefund.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addRefundOffline, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.RefundFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.RefundFdParcelable refund(java.lang.String orderId, com.clover.sdk.v3.payments.RefundFdParcelable fdRefund, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.RefundFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdRefund!=null)) {
_data.writeInt(1);
fdRefund.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_refund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.RefundFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.DiscountFdParcelable addDiscount2(java.lang.String orderId, com.clover.sdk.v3.order.DiscountFdParcelable fdDiscount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.DiscountFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdDiscount!=null)) {
_data.writeInt(1);
fdDiscount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addDiscount2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.DiscountFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.DiscountFdParcelable addLineItemDiscount2(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.order.DiscountFdParcelable fdDiscount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.DiscountFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
if ((fdDiscount!=null)) {
_data.writeInt(1);
fdDiscount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addLineItemDiscount2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.DiscountFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable addPayment2(java.lang.String orderId, com.clover.sdk.v3.payments.PaymentFdParcelable fdPayment, com.clover.sdk.v3.order.LineItemListFdParcelable fdLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdPayment!=null)) {
_data.writeInt(1);
fdPayment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((fdLineItems!=null)) {
_data.writeInt(1);
fdLineItems.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addPayment2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItemMapFdParcelable createLineItemsFrom2(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, boolean copyPrinted, boolean broadcastLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemMapFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderId);
_data.writeString(destinationOrderId);
_data.writeStringList(lineItemIds);
_data.writeInt(((copyPrinted)?(1):(0)));
_data.writeInt(((broadcastLineItems)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_createLineItemsFrom2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItemMapFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.PaymentListFdParcelable getPendingPayments(com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.PaymentListFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPendingPayments, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.PaymentListFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.CreditRefundFdParcelable addCreditRefund(java.lang.String orderId, com.clover.sdk.v3.payments.CreditRefundFdParcelable creditRefund, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.CreditRefundFdParcelable _result;
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
_result = com.clover.sdk.v3.payments.CreditRefundFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable deleteCreditRefund(java.lang.String orderId, java.lang.String creditRefundId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(creditRefundId);
mRemote.transact(Stub.TRANSACTION_deleteCreditRefund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable addPreAuth(java.lang.String orderId, com.clover.sdk.v3.payments.PaymentFdParcelable preAuth, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((preAuth!=null)) {
_data.writeInt(1);
preAuth.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addPreAuth, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable capturePreAuth(java.lang.String orderId, com.clover.sdk.v3.payments.PaymentFdParcelable preAuth, com.clover.sdk.v3.order.LineItemListFdParcelable fdLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((preAuth!=null)) {
_data.writeInt(1);
preAuth.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((fdLineItems!=null)) {
_data.writeInt(1);
fdLineItems.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_capturePreAuth, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable voidPreAuth(java.lang.String orderId, java.lang.String preAuthId, java.lang.String iccContainer, com.clover.sdk.v3.order.VoidReason voidReason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(preAuthId);
_data.writeString(iccContainer);
if ((voidReason!=null)) {
_data.writeInt(1);
voidReason.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(source);
mRemote.transact(Stub.TRANSACTION_voidPreAuth, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable voidPreAuthOnline(java.lang.String orderId, java.lang.String preAuthId, java.lang.String iccContainer, com.clover.sdk.v3.order.VoidReason voidReason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(preAuthId);
_data.writeString(iccContainer);
if ((voidReason!=null)) {
_data.writeInt(1);
voidReason.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(source);
mRemote.transact(Stub.TRANSACTION_voidPreAuthOnline, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
   * Delete {@link LineItem}s from an {@link Order}.
   *
   * @param orderId The ID of the {@link Order} from which to delete the line items.
   * @param lineItemIds The {@link LineItem} IDs to delete.
   * @param reason optional. Why was the line item removed?
   * @param clientEventType optional. What app did the delete come from?
   * @return The updated {@link Order}.
   */
@Override public com.clover.sdk.v3.order.OrderFdParcelable deleteLineItemsWithReason(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, java.lang.String reason, com.clover.sdk.v3.order.ClientEventType clientEventType, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
_data.writeString(reason);
if ((clientEventType!=null)) {
_data.writeInt(1);
clientEventType.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_deleteLineItemsWithReason, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable voidPaymentWithCard(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.pay.PaymentRequestCardDetails card, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
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
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
   * @param orderId The ID of the {@link Order} from which to delete the line items.
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
   * @param orderId The ID of the {@link Order} from which to delete the line items.
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
   * Add 1 or more fixed-price line item to an order. A fixed price line item is priced per item.
   *
   * {@link LineItem}s are linked to {@link com.clover.sdk.v3.inventory.Item}s with an item ID. Think of the
   * {@link com.clover.sdk.v3.inventory.Item} as a template for creating a {@link LineItem}, and a
   * {@link LineItem} as the order's copy of an {@link com.clover.sdk.v3.inventory.Item}.
   *
   * @param orderId The ID of the order to which to add the line item.
   * @param itemId The item ID from which to create the line item to be added to the order.
   * @param binName The BIN name for the line item. May be {@link null}.
   * @param userData Meta-data to attach to the line item. May be {@link null}.
   * @param numItems number of {@link LineItem}s to create
   * @return The newly created {@link LineItem}.
   */
@Override public com.clover.sdk.v3.order.LineItemListFdParcelable addFixedPriceLineItems(java.lang.String orderId, java.lang.String itemId, java.lang.String binName, java.lang.String userData, int numItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemListFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(itemId);
_data.writeString(binName);
_data.writeString(userData);
_data.writeInt(numItems);
mRemote.transact(Stub.TRANSACTION_addFixedPriceLineItems, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItemListFdParcelable.CREATOR.createFromParcel(_reply);
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
   * Add 1 or more per-unit line item to an order. A per unit line item is priced per unit, not per item. A good example
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
   * @param numItems number of {@link LineItem}s to create
   * @return The newly created {@link LineItem}.
   */
@Override public com.clover.sdk.v3.order.LineItemListFdParcelable addPerUnitLineItems(java.lang.String orderId, java.lang.String itemId, int unitQuantity, java.lang.String binName, java.lang.String userData, int numItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemListFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(itemId);
_data.writeInt(unitQuantity);
_data.writeString(binName);
_data.writeString(userData);
_data.writeInt(numItems);
mRemote.transact(Stub.TRANSACTION_addPerUnitLineItems, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItemListFdParcelable.CREATOR.createFromParcel(_reply);
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
   * Add 1 or more variably-priced line item to the order. A variably priced line item's price is determined at the time of
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
   * @param numItems number of {@link LineItem}s to create
   * @return The newly created {@link LineItem}.
   */
@Override public com.clover.sdk.v3.order.LineItemListFdParcelable addVariablePriceLineItems(java.lang.String orderId, java.lang.String itemId, long price, java.lang.String binName, java.lang.String userData, int numItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemListFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(itemId);
_data.writeLong(price);
_data.writeString(binName);
_data.writeString(userData);
_data.writeInt(numItems);
mRemote.transact(Stub.TRANSACTION_addVariablePriceLineItems, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItemListFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable voidPaymentCardPresent(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.pay.PaymentRequestCardDetails card, com.clover.sdk.v3.payments.TransactionInfo transactionInfo, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
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
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
   * Card not present void with passthrough data
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.OrderFdParcelable voidPayment3(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, java.util.Map passThroughExtras, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
_data.writeString(iccContainer);
_data.writeMap(passThroughExtras);
if ((reason!=null)) {
_data.writeInt(1);
reason.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(source);
mRemote.transact(Stub.TRANSACTION_voidPayment3, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
   * Card present void with passthrough data
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.order.OrderFdParcelable voidPaymentCardPresent2(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.pay.PaymentRequestCardDetails card, com.clover.sdk.v3.payments.TransactionInfo transactionInfo, java.util.Map passThroughExtras, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
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
_data.writeMap(passThroughExtras);
if ((reason!=null)) {
_data.writeInt(1);
reason.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(source);
mRemote.transact(Stub.TRANSACTION_voidPaymentCardPresent2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
   * Refund with passthrough data
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
@Override public com.clover.sdk.v3.payments.RefundFdParcelable refund2(java.lang.String orderId, com.clover.sdk.v3.payments.RefundFdParcelable fdRefund, java.util.Map passThroughExtras, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.RefundFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdRefund!=null)) {
_data.writeInt(1);
fdRefund.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeMap(passThroughExtras);
mRemote.transact(Stub.TRANSACTION_refund2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.RefundFdParcelable.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.OrderFdParcelable cleanUpPreAuthAfterTransaction(java.lang.String orderId, com.clover.sdk.v3.order.VoidReason voidReason, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((voidReason!=null)) {
_data.writeInt(1);
voidReason.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_cleanUpPreAuthAfterTransaction, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
   * Splits line items without taking a payment. Each {@link LineItem} in {@code lineItemIds} is
   * equally split across all bins in {@code binNames}.
   *
   * For example, given a single line item ID and bin names "a" and "b", then two new line items are
   * created. One for bin "a" and another for bin "b". The original line item is then deleted. Each
   * new line item represents an equal fraction of the original by using a fraction of the
   * original's unit quantity.
   *
   * Using this method allows for items to be shared without locking the order.
   *
   * <p>Restrictions
   *
   * A line item may not be split more than once. If a line item cannot be split, it is skipped.
   *
   * @param orderId the ID of the order to modify.
   * @param lineItemIds the line items to split.
   * @param binNames the bin names to split {@code lineItemIds} across.
   *
   * @return the newly created {@link LineItem}s.
   */
@Override public com.clover.sdk.v3.order.LineItemListFdParcelable splitLineItems(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, java.util.List<java.lang.String> binNames, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItemListFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
_data.writeStringList(binNames);
mRemote.transact(Stub.TRANSACTION_splitLineItems, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItemListFdParcelable.CREATOR.createFromParcel(_reply);
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
/**
   * Update the online order state.
   *
   * @Param orderId The ID of the order to be updated
   * @Param orderState The new orderstate of the online order
   * @Param reason A reason if the order is calcelled or declined.
   *
  */
@Override public void updateOnlineOrderState(java.lang.String orderId, com.clover.sdk.v3.onlineorder.OrderState orderState, com.clover.sdk.v3.onlineorder.Reason reason, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((orderState!=null)) {
_data.writeInt(1);
orderState.writeToParcel(_data, 0);
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
mRemote.transact(Stub.TRANSACTION_updateOnlineOrderState, _data, _reply, 0);
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
   * Add new {@link PrintGroup} on order object.
   *
   * @param orderId The ID of the order to be updated
   * @param fdPrintGroup PrintGroup to be added to an Order
   * @return the updated order
   *
  */
@Override public com.clover.sdk.v3.order.OrderFdParcelable addPrintGroup(java.lang.String orderId, com.clover.sdk.v3.order.PrintGroupFdParcelable fdPrintGroup, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.OrderFdParcelable _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((fdPrintGroup!=null)) {
_data.writeInt(1);
fdPrintGroup.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addPrintGroup, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.OrderFdParcelable.CREATOR.createFromParcel(_reply);
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
static final int TRANSACTION_addPreAuth = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
static final int TRANSACTION_capturePreAuth = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
static final int TRANSACTION_voidPreAuth = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
static final int TRANSACTION_voidPreAuthOnline = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
static final int TRANSACTION_deleteLineItemsWithReason = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
static final int TRANSACTION_voidPaymentWithCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
static final int TRANSACTION_getLineItemsToFire = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
static final int TRANSACTION_refire = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
static final int TRANSACTION_addFixedPriceLineItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
static final int TRANSACTION_addPerUnitLineItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
static final int TRANSACTION_addVariablePriceLineItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
static final int TRANSACTION_deleteOrderOnline2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
static final int TRANSACTION_deleteOrder3 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
static final int TRANSACTION_voidPaymentCardPresent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
static final int TRANSACTION_voidPayment3 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
static final int TRANSACTION_voidPaymentCardPresent2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 68);
static final int TRANSACTION_refund2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 69);
static final int TRANSACTION_cleanUpPreAuthAfterTransaction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
static final int TRANSACTION_splitLineItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 71);
static final int TRANSACTION_vaultedCreditRefund = (android.os.IBinder.FIRST_CALL_TRANSACTION + 72);
static final int TRANSACTION_updateOnlineOrderState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 73);
static final int TRANSACTION_addPrintGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 74);
}
public void addOnOrderUpdatedListener(com.clover.sdk.v3.order.IOnOrderUpdateListener listener) throws android.os.RemoteException;
public void removeOnOrderUpdatedListener(com.clover.sdk.v3.order.IOnOrderUpdateListener listener) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable getOrder(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderListFdParcelable getOrders(java.util.List<java.lang.String> orderIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable createOrder(com.clover.sdk.v3.order.OrderFdParcelable fdOrder, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable updateOrder(com.clover.sdk.v3.order.OrderFdParcelable fdOrder, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public boolean deleteOrder(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable addServiceCharge(java.lang.String orderId, java.lang.String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable deleteServiceCharge(java.lang.String orderId, java.lang.String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItemFdParcelable addFixedPriceLineItem(java.lang.String orderId, java.lang.String itemId, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItemFdParcelable addPerUnitLineItem(java.lang.String orderId, java.lang.String itemId, int unitQuantity, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItemFdParcelable addVariablePriceLineItem(java.lang.String orderId, java.lang.String itemId, long price, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItemFdParcelable addCustomLineItem(java.lang.String orderId, com.clover.sdk.v3.order.LineItemFdParcelable fdLineItem, boolean isTaxable, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItemListFdParcelable updateLineItems(java.lang.String orderId, com.clover.sdk.v3.order.LineItemListFdParcelable fdLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable deleteLineItems(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItemListFdParcelable copyLineItems(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable setLineItemNote(java.lang.String orderId, java.lang.String lineItemId, java.lang.String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable addLineItemModification(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.inventory.ModifierFdParcelable fdModifier, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable deleteLineItemModifications(java.lang.String orderId, java.lang.String lineItemId, java.util.List<java.lang.String> modificationIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItemFdParcelable exchangeItem(java.lang.String orderId, java.lang.String oldLineItemId, java.lang.String itemId, java.lang.String binName, java.lang.String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable addDiscount(java.lang.String orderId, com.clover.sdk.v3.order.DiscountFdParcelable fdDiscount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable deleteDiscounts(java.lang.String orderId, java.util.List<java.lang.String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable addLineItemDiscount(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.order.DiscountFdParcelable fdDiscount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable deleteLineItemDiscounts(java.lang.String orderId, java.lang.String lineItemId, java.util.List<java.lang.String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable addTip(java.lang.String orderId, java.lang.String paymentId, long amount, boolean online, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.PaymentFdParcelable pay(java.lang.String orderId, com.clover.sdk.v3.pay.PaymentRequestFdParcelable fdPaymentRequest, boolean isAllowOffline, java.lang.String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable addPayment(java.lang.String orderId, com.clover.sdk.v3.payments.PaymentFdParcelable fdPayment, com.clover.sdk.v3.order.LineItemListFdParcelable fdLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable voidPayment(java.lang.String orderId, java.lang.String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.CreditFdParcelable addCredit(java.lang.String orderId, com.clover.sdk.v3.payments.CreditFdParcelable fdCredit, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable deleteCredit(java.lang.String orderId, java.lang.String creditId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.RefundFdParcelable addRefund(java.lang.String orderId, com.clover.sdk.v3.payments.RefundFdParcelable refund, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable deleteRefund(java.lang.String orderId, java.lang.String refundId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public boolean deleteOrderOnline(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable addBatchLineItemModifications(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v3.inventory.ModifierFdParcelable fdModifier, int quantity, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable addBatchLineItemDiscounts(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v3.order.DiscountListFdParcelable discounts, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItemMapFdParcelable createLineItemsFrom(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public boolean fire(java.lang.String sourceOrderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.PaymentFdParcelable updatePayment(java.lang.String orderId, com.clover.sdk.v3.payments.PaymentFdParcelable fdPayment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable voidPayment2(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable removePayment(java.lang.String orderId, java.lang.String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.RefundFdParcelable addRefundOffline(java.lang.String orderId, com.clover.sdk.v3.payments.RefundFdParcelable fdRefund, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.RefundFdParcelable refund(java.lang.String orderId, com.clover.sdk.v3.payments.RefundFdParcelable fdRefund, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public void addOnOrderUpdatedListener2(com.clover.sdk.v3.order.IOnOrderUpdateListener2 listener) throws android.os.RemoteException;
public void removeOnOrderUpdatedListener2(com.clover.sdk.v3.order.IOnOrderUpdateListener2 listener) throws android.os.RemoteException;
public com.clover.sdk.v3.order.DiscountFdParcelable addDiscount2(java.lang.String orderId, com.clover.sdk.v3.order.DiscountFdParcelable fdDiscount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.DiscountFdParcelable addLineItemDiscount2(java.lang.String orderId, java.lang.String lineItemId, com.clover.sdk.v3.order.DiscountFdParcelable fdDiscount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable addPayment2(java.lang.String orderId, com.clover.sdk.v3.payments.PaymentFdParcelable fdPayment, com.clover.sdk.v3.order.LineItemListFdParcelable fdLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public boolean fire2(java.lang.String sourceOrderid, boolean requireAllItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItemMapFdParcelable createLineItemsFrom2(java.lang.String sourceOrderId, java.lang.String destinationOrderId, java.util.List<java.lang.String> lineItemIds, boolean copyPrinted, boolean broadcastLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public boolean deleteOrder2(java.lang.String orderId, boolean allowDeleteIfLineItemPrinted, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.PaymentListFdParcelable getPendingPayments(com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.CreditRefundFdParcelable addCreditRefund(java.lang.String orderId, com.clover.sdk.v3.payments.CreditRefundFdParcelable creditRefund, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable deleteCreditRefund(java.lang.String orderId, java.lang.String creditRefundId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable addPreAuth(java.lang.String orderId, com.clover.sdk.v3.payments.PaymentFdParcelable preAuth, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable capturePreAuth(java.lang.String orderId, com.clover.sdk.v3.payments.PaymentFdParcelable preAuth, com.clover.sdk.v3.order.LineItemListFdParcelable fdLineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable voidPreAuth(java.lang.String orderId, java.lang.String preAuthId, java.lang.String iccContainer, com.clover.sdk.v3.order.VoidReason voidReason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable voidPreAuthOnline(java.lang.String orderId, java.lang.String preAuthId, java.lang.String iccContainer, com.clover.sdk.v3.order.VoidReason voidReason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Delete {@link LineItem}s from an {@link Order}.
   *
   * @param orderId The ID of the {@link Order} from which to delete the line items.
   * @param lineItemIds The {@link LineItem} IDs to delete.
   * @param reason optional. Why was the line item removed?
   * @param clientEventType optional. What app did the delete come from?
   * @return The updated {@link Order}.
   */
public com.clover.sdk.v3.order.OrderFdParcelable deleteLineItemsWithReason(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, java.lang.String reason, com.clover.sdk.v3.order.ClientEventType clientEventType, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable voidPaymentWithCard(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.pay.PaymentRequestCardDetails card, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Get list of lineitem ids for the order that has printtag to print.
   * The items that are already printed are not part of the list
   *
   * @param orderId The ID of the {@link Order} from which to delete the line items.
   */
public java.util.List<java.lang.String> getLineItemsToFire(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Reprint all lineitems that has a printtag even if they are printed.
   *
   * @param orderId The ID of the {@link Order} from which to delete the line items.
   */
public boolean refire(java.lang.String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Add 1 or more fixed-price line item to an order. A fixed price line item is priced per item.
   *
   * {@link LineItem}s are linked to {@link com.clover.sdk.v3.inventory.Item}s with an item ID. Think of the
   * {@link com.clover.sdk.v3.inventory.Item} as a template for creating a {@link LineItem}, and a
   * {@link LineItem} as the order's copy of an {@link com.clover.sdk.v3.inventory.Item}.
   *
   * @param orderId The ID of the order to which to add the line item.
   * @param itemId The item ID from which to create the line item to be added to the order.
   * @param binName The BIN name for the line item. May be {@link null}.
   * @param userData Meta-data to attach to the line item. May be {@link null}.
   * @param numItems number of {@link LineItem}s to create
   * @return The newly created {@link LineItem}.
   */
public com.clover.sdk.v3.order.LineItemListFdParcelable addFixedPriceLineItems(java.lang.String orderId, java.lang.String itemId, java.lang.String binName, java.lang.String userData, int numItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Add 1 or more per-unit line item to an order. A per unit line item is priced per unit, not per item. A good example
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
   * @param numItems number of {@link LineItem}s to create
   * @return The newly created {@link LineItem}.
   */
public com.clover.sdk.v3.order.LineItemListFdParcelable addPerUnitLineItems(java.lang.String orderId, java.lang.String itemId, int unitQuantity, java.lang.String binName, java.lang.String userData, int numItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Add 1 or more variably-priced line item to the order. A variably priced line item's price is determined at the time of
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
   * @param numItems number of {@link LineItem}s to create
   * @return The newly created {@link LineItem}.
   */
public com.clover.sdk.v3.order.LineItemListFdParcelable addVariablePriceLineItems(java.lang.String orderId, java.lang.String itemId, long price, java.lang.String binName, java.lang.String userData, int numItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
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
public com.clover.sdk.v3.order.OrderFdParcelable voidPaymentCardPresent(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.pay.PaymentRequestCardDetails card, com.clover.sdk.v3.payments.TransactionInfo transactionInfo, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Card not present void with passthrough data
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.order.OrderFdParcelable voidPayment3(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, java.util.Map passThroughExtras, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Card present void with passthrough data
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.order.OrderFdParcelable voidPaymentCardPresent2(java.lang.String orderId, java.lang.String paymentId, java.lang.String iccContainer, com.clover.sdk.v3.pay.PaymentRequestCardDetails card, com.clover.sdk.v3.payments.TransactionInfo transactionInfo, java.util.Map passThroughExtras, com.clover.sdk.v3.order.VoidReason reason, java.lang.String source, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Refund with passthrough data
   *
   * Not available to non-Clover apps.
   * @y.exclude
   */
public com.clover.sdk.v3.payments.RefundFdParcelable refund2(java.lang.String orderId, com.clover.sdk.v3.payments.RefundFdParcelable fdRefund, java.util.Map passThroughExtras, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v3.order.OrderFdParcelable cleanUpPreAuthAfterTransaction(java.lang.String orderId, com.clover.sdk.v3.order.VoidReason voidReason, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Splits line items without taking a payment. Each {@link LineItem} in {@code lineItemIds} is
   * equally split across all bins in {@code binNames}.
   *
   * For example, given a single line item ID and bin names "a" and "b", then two new line items are
   * created. One for bin "a" and another for bin "b". The original line item is then deleted. Each
   * new line item represents an equal fraction of the original by using a fraction of the
   * original's unit quantity.
   *
   * Using this method allows for items to be shared without locking the order.
   *
   * <p>Restrictions
   *
   * A line item may not be split more than once. If a line item cannot be split, it is skipped.
   *
   * @param orderId the ID of the order to modify.
   * @param lineItemIds the line items to split.
   * @param binNames the bin names to split {@code lineItemIds} across.
   *
   * @return the newly created {@link LineItem}s.
   */
public com.clover.sdk.v3.order.LineItemListFdParcelable splitLineItems(java.lang.String orderId, java.util.List<java.lang.String> lineItemIds, java.util.List<java.lang.String> binNames, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * @param orderId The ID of the order to be updated.
   * @param creditId The ID of the credit to be refunded.
   * @return the CreditRefund object constructed using the RefundResponse the serverf returns
   * Not available to non-Clover apps.
   * @y.exclude
  */
public com.clover.sdk.v3.payments.CreditRefund vaultedCreditRefund(java.lang.String orderId, java.lang.String creditId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Update the online order state.
   *
   * @Param orderId The ID of the order to be updated
   * @Param orderState The new orderstate of the online order
   * @Param reason A reason if the order is calcelled or declined.
   *
  */
public void updateOnlineOrderState(java.lang.String orderId, com.clover.sdk.v3.onlineorder.OrderState orderState, com.clover.sdk.v3.onlineorder.Reason reason, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Add new {@link PrintGroup} on order object.
   *
   * @param orderId The ID of the order to be updated
   * @param fdPrintGroup PrintGroup to be added to an Order
   * @return the updated order
   *
  */
public com.clover.sdk.v3.order.OrderFdParcelable addPrintGroup(java.lang.String orderId, com.clover.sdk.v3.order.PrintGroupFdParcelable fdPrintGroup, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
}
