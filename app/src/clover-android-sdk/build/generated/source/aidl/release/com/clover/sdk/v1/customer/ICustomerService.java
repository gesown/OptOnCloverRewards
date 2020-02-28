/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\src\\clover-android-sdk\\clover-android-sdk\\src\\main\\aidl\\com\\clover\\sdk\\v1\\customer\\ICustomerService.aidl
 */
package com.clover.sdk.v1.customer;
public interface ICustomerService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v1.customer.ICustomerService
{
private static final java.lang.String DESCRIPTOR = "com.clover.sdk.v1.customer.ICustomerService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v1.customer.ICustomerService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v1.customer.ICustomerService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v1.customer.ICustomerService))) {
return ((com.clover.sdk.v1.customer.ICustomerService)iin);
}
return new com.clover.sdk.v1.customer.ICustomerService.Stub.Proxy(obj);
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
case TRANSACTION_getCustomers:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v1.customer.Customer> _result = this.getCustomers(_arg0, _arg1);
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
case TRANSACTION_getCustomer:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.Customer _result = this.getCustomer(_arg0, _arg1);
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
case TRANSACTION_createCustomer:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.Customer _result = this.createCustomer(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_setName:
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
this.setName(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_setMarketingAllowed:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.setMarketingAllowed(_arg0, _arg1, _arg2);
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
case TRANSACTION_addPhoneNumber:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.PhoneNumber _result = this.addPhoneNumber(_arg0, _arg1, _arg2);
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
case TRANSACTION_setPhoneNumber:
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
this.setPhoneNumber(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_deletePhoneNumber:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.deletePhoneNumber(_arg0, _arg1, _arg2);
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
case TRANSACTION_addEmailAddress:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.EmailAddress _result = this.addEmailAddress(_arg0, _arg1, _arg2);
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
case TRANSACTION_setEmailAddress:
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
this.setEmailAddress(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_deleteEmailAddress:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.deleteEmailAddress(_arg0, _arg1, _arg2);
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
case TRANSACTION_addAddress:
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
java.lang.String _arg5;
_arg5 = data.readString();
java.lang.String _arg6;
_arg6 = data.readString();
com.clover.sdk.v1.ResultStatus _arg7;
_arg7 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.Address _result = this.addAddress(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
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
case TRANSACTION_setAddress:
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
java.lang.String _arg5;
_arg5 = data.readString();
java.lang.String _arg6;
_arg6 = data.readString();
java.lang.String _arg7;
_arg7 = data.readString();
com.clover.sdk.v1.ResultStatus _arg8;
_arg8 = new com.clover.sdk.v1.ResultStatus();
this.setAddress(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
reply.writeNoException();
if ((_arg8!=null)) {
reply.writeInt(1);
_arg8.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deleteAddress:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.deleteAddress(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteCustomer:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteCustomer(_arg0, _arg1);
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
case TRANSACTION_addCard:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.customer.Card _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v1.customer.Card.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.Card _result = this.addCard(_arg0, _arg1, _arg2);
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
case TRANSACTION_setCard:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.customer.Card _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v1.customer.Card.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
this.setCard(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_deleteCard:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.deleteCard(_arg0, _arg1, _arg2);
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
private static class Proxy implements com.clover.sdk.v1.customer.ICustomerService
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
@Override public java.util.List<com.clover.sdk.v1.customer.Customer> getCustomers(java.lang.String query, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v1.customer.Customer> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(query);
mRemote.transact(Stub.TRANSACTION_getCustomers, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v1.customer.Customer.CREATOR);
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
@Override public com.clover.sdk.v1.customer.Customer getCustomer(java.lang.String customerId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.Customer _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
mRemote.transact(Stub.TRANSACTION_getCustomer, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.Customer.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v1.customer.Customer createCustomer(java.lang.String firstName, java.lang.String lastName, boolean marketingAllowed, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.Customer _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(firstName);
_data.writeString(lastName);
_data.writeInt(((marketingAllowed)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_createCustomer, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.Customer.CREATOR.createFromParcel(_reply);
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
@Override public void setName(java.lang.String customerId, java.lang.String firstName, java.lang.String lastName, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(firstName);
_data.writeString(lastName);
mRemote.transact(Stub.TRANSACTION_setName, _data, _reply, 0);
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
@Override public void setMarketingAllowed(java.lang.String customerId, boolean marketingAllowed, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeInt(((marketingAllowed)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setMarketingAllowed, _data, _reply, 0);
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
@Override public com.clover.sdk.v1.customer.PhoneNumber addPhoneNumber(java.lang.String customerId, java.lang.String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.PhoneNumber _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(phoneNumber);
mRemote.transact(Stub.TRANSACTION_addPhoneNumber, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.PhoneNumber.CREATOR.createFromParcel(_reply);
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
@Override public void setPhoneNumber(java.lang.String customerId, java.lang.String phoneNumberId, java.lang.String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(phoneNumberId);
_data.writeString(phoneNumber);
mRemote.transact(Stub.TRANSACTION_setPhoneNumber, _data, _reply, 0);
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
@Override public void deletePhoneNumber(java.lang.String customerId, java.lang.String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(phoneNumber);
mRemote.transact(Stub.TRANSACTION_deletePhoneNumber, _data, _reply, 0);
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
@Override public com.clover.sdk.v1.customer.EmailAddress addEmailAddress(java.lang.String customerId, java.lang.String emailAddress, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.EmailAddress _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(emailAddress);
mRemote.transact(Stub.TRANSACTION_addEmailAddress, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.EmailAddress.CREATOR.createFromParcel(_reply);
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
@Override public void setEmailAddress(java.lang.String customerId, java.lang.String emailAddressId, java.lang.String emailAddress, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(emailAddressId);
_data.writeString(emailAddress);
mRemote.transact(Stub.TRANSACTION_setEmailAddress, _data, _reply, 0);
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
@Override public void deleteEmailAddress(java.lang.String customerId, java.lang.String emailAddressId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(emailAddressId);
mRemote.transact(Stub.TRANSACTION_deleteEmailAddress, _data, _reply, 0);
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
@Override public com.clover.sdk.v1.customer.Address addAddress(java.lang.String customerId, java.lang.String address1, java.lang.String address2, java.lang.String address3, java.lang.String city, java.lang.String state, java.lang.String zip, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.Address _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(address1);
_data.writeString(address2);
_data.writeString(address3);
_data.writeString(city);
_data.writeString(state);
_data.writeString(zip);
mRemote.transact(Stub.TRANSACTION_addAddress, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.Address.CREATOR.createFromParcel(_reply);
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
@Override public void setAddress(java.lang.String customerId, java.lang.String addressId, java.lang.String address1, java.lang.String address2, java.lang.String address3, java.lang.String city, java.lang.String state, java.lang.String zip, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(addressId);
_data.writeString(address1);
_data.writeString(address2);
_data.writeString(address3);
_data.writeString(city);
_data.writeString(state);
_data.writeString(zip);
mRemote.transact(Stub.TRANSACTION_setAddress, _data, _reply, 0);
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
@Override public void deleteAddress(java.lang.String customerId, java.lang.String addressId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(addressId);
mRemote.transact(Stub.TRANSACTION_deleteAddress, _data, _reply, 0);
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
@Override public void deleteCustomer(java.lang.String customerId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
mRemote.transact(Stub.TRANSACTION_deleteCustomer, _data, _reply, 0);
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
@Override public com.clover.sdk.v1.customer.Card addCard(java.lang.String customerId, com.clover.sdk.v1.customer.Card card, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.Card _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
if ((card!=null)) {
_data.writeInt(1);
card.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addCard, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.Card.CREATOR.createFromParcel(_reply);
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
@Override public void setCard(java.lang.String customerId, java.lang.String cardId, com.clover.sdk.v1.customer.Card card, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(cardId);
if ((card!=null)) {
_data.writeInt(1);
card.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setCard, _data, _reply, 0);
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
@Override public void deleteCard(java.lang.String customerId, java.lang.String cardId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(cardId);
mRemote.transact(Stub.TRANSACTION_deleteCard, _data, _reply, 0);
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
static final int TRANSACTION_getCustomers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getCustomer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_createCustomer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_setName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_setMarketingAllowed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_addPhoneNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_setPhoneNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_deletePhoneNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_addEmailAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_setEmailAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_deleteEmailAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_addAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_setAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_deleteAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_deleteCustomer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_addCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_setCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_deleteCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
}
public java.util.List<com.clover.sdk.v1.customer.Customer> getCustomers(java.lang.String query, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.Customer getCustomer(java.lang.String customerId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.Customer createCustomer(java.lang.String firstName, java.lang.String lastName, boolean marketingAllowed, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setName(java.lang.String customerId, java.lang.String firstName, java.lang.String lastName, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setMarketingAllowed(java.lang.String customerId, boolean marketingAllowed, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.PhoneNumber addPhoneNumber(java.lang.String customerId, java.lang.String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setPhoneNumber(java.lang.String customerId, java.lang.String phoneNumberId, java.lang.String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void deletePhoneNumber(java.lang.String customerId, java.lang.String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.EmailAddress addEmailAddress(java.lang.String customerId, java.lang.String emailAddress, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setEmailAddress(java.lang.String customerId, java.lang.String emailAddressId, java.lang.String emailAddress, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void deleteEmailAddress(java.lang.String customerId, java.lang.String emailAddressId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.Address addAddress(java.lang.String customerId, java.lang.String address1, java.lang.String address2, java.lang.String address3, java.lang.String city, java.lang.String state, java.lang.String zip, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setAddress(java.lang.String customerId, java.lang.String addressId, java.lang.String address1, java.lang.String address2, java.lang.String address3, java.lang.String city, java.lang.String state, java.lang.String zip, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void deleteAddress(java.lang.String customerId, java.lang.String addressId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void deleteCustomer(java.lang.String customerId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.Card addCard(java.lang.String customerId, com.clover.sdk.v1.customer.Card card, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setCard(java.lang.String customerId, java.lang.String cardId, com.clover.sdk.v1.customer.Card card, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void deleteCard(java.lang.String customerId, java.lang.String cardId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
