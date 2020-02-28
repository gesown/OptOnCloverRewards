/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\src\\clover-android-sdk\\clover-android-sdk\\src\\main\\aidl\\com\\clover\\sdk\\v1\\printer\\IPrinterService.aidl
 */
package com.clover.sdk.v1.printer;
/**
 * An interface for adding, listing, and removing Clover printers. To print to a Clover printer,
 * use the classes in the {@link com.clover.sdk.v1.printer.job} package. To open a cash
 * drawer connected to a Clover printer, use the {@link com.clover.sdk.v1.printer.CashDrawer} class.
 * To interact with the Clover print queue, use the {@link com.clover.sdk.v1.printer.PrintQueue}
 * class.
 * <br/><br/>
 * The Printer
 * service is a bound AIDL service. Bind to this service as follows,
 * <pre>
 * <code>
 * Intent serviceIntent = new Intent(PrinterIntent.ACTION_PRINTER_SERVICE);
 * serviceIntent.putExtra(PrinterIntent.EXTRA_ACCOUNT, CloverAccount.getAccount(context));
 * serviceIntent.putExtra(PrinterIntent.EXTRA_VERSION, 1);
 * context.bindService(serviceIntent);
 * </code>
 * </pre>
 * For more information about bound services, refer to
 * the Android documentation:
 * <a href="http://developer.android.com/guide/components/bound-services.html#Binding">
 * Bound Services
 * </a>.
 * <br/>
 * You may also interact with the printer service through the
 * {@link com.clover.sdk.v1.printer.PrinterConnector} class, which handles binding and
 * asynchronous invocation of service methods.
 *
 * @see com.clover.sdk.v1.printer.PrinterIntent
 * @see com.clover.sdk.util.CloverAccount
 * @see com.clover.sdk.v1.printer.PrinterConnector
 */
public interface IPrinterService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v1.printer.IPrinterService
{
private static final java.lang.String DESCRIPTOR = "com.clover.sdk.v1.printer.IPrinterService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v1.printer.IPrinterService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v1.printer.IPrinterService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v1.printer.IPrinterService))) {
return ((com.clover.sdk.v1.printer.IPrinterService)iin);
}
return new com.clover.sdk.v1.printer.IPrinterService.Stub.Proxy(obj);
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
case TRANSACTION_getPrinters:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v1.printer.Printer> _result = this.getPrinters(_arg0);
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
case TRANSACTION_getPrintersByCategory:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.printer.Category _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.printer.Category.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v1.printer.Printer> _result = this.getPrintersByCategory(_arg0, _arg1);
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
case TRANSACTION_isPrinterSet:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.printer.Category _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.printer.Category.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.isPrinterSet(_arg0, _arg1);
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
case TRANSACTION_getPrinterById:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.printer.Printer _result = this.getPrinterById(_arg0, _arg1);
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
case TRANSACTION_removePrinter:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.printer.Printer _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.printer.Printer.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.removePrinter(_arg0, _arg1);
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
case TRANSACTION_setPrinter:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.printer.Printer _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.printer.Printer.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.printer.Printer _result = this.setPrinter(_arg0, _arg1);
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
case TRANSACTION_getPrinterTypeDetails:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.printer.Printer _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.printer.Printer.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.printer.TypeDetails _result = this.getPrinterTypeDetails(_arg0, _arg1);
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
private static class Proxy implements com.clover.sdk.v1.printer.IPrinterService
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
   * Get all configured printers for this merchant. A printer must be associated to at least one
   * category to be considered configured. The same printer may be configured for more than one
   * category and if so will appear multiple times in the returned list.
   */
@Override public java.util.List<com.clover.sdk.v1.printer.Printer> getPrinters(com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v1.printer.Printer> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrinters, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v1.printer.Printer.CREATOR);
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
   * Get all printers configured by this merchant for the given category.
   */
@Override public java.util.List<com.clover.sdk.v1.printer.Printer> getPrintersByCategory(com.clover.sdk.v1.printer.Category category, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v1.printer.Printer> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((category!=null)) {
_data.writeInt(1);
category.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPrintersByCategory, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v1.printer.Printer.CREATOR);
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
   * Returns true if there is any configured printer in the given category.
   */
@Override public boolean isPrinterSet(com.clover.sdk.v1.printer.Category category, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((category!=null)) {
_data.writeInt(1);
category.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_isPrinterSet, _data, _reply, 0);
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
   * Returns the printer which matches the {@link Printer#getUuid()} if any, or null if none.
   * This may return a printer which has not been configured.
   */
@Override public com.clover.sdk.v1.printer.Printer getPrinterById(java.lang.String id, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.printer.Printer _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_getPrinterById, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.printer.Printer.CREATOR.createFromParcel(_reply);
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
   * Removes a printer from being configured. If a category is supplied then the printer has only
   * the configuration for that category removed. If no category is supplied then the printer is
   * completely removed.
   */
@Override public void removePrinter(com.clover.sdk.v1.printer.Printer p, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((p!=null)) {
_data.writeInt(1);
p.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_removePrinter, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
   * Adds a printer optionally with a category. If a new printer is added without a category it
   * is unconfigured. A new or existing printer may configured by supplying a category.
   */
@Override public com.clover.sdk.v1.printer.Printer setPrinter(com.clover.sdk.v1.printer.Printer p, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.printer.Printer _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((p!=null)) {
_data.writeInt(1);
p.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setPrinter, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.printer.Printer.CREATOR.createFromParcel(_reply);
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
   * Returns the TypeDetails for the given printer.
   */
@Override public com.clover.sdk.v1.printer.TypeDetails getPrinterTypeDetails(com.clover.sdk.v1.printer.Printer p, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.printer.TypeDetails _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((p!=null)) {
_data.writeInt(1);
p.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPrinterTypeDetails, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.printer.TypeDetails.CREATOR.createFromParcel(_reply);
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
static final int TRANSACTION_getPrinters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getPrintersByCategory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_isPrinterSet = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getPrinterById = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_removePrinter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setPrinter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_getPrinterTypeDetails = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
}
/**
   * Get all configured printers for this merchant. A printer must be associated to at least one
   * category to be considered configured. The same printer may be configured for more than one
   * category and if so will appear multiple times in the returned list.
   */
public java.util.List<com.clover.sdk.v1.printer.Printer> getPrinters(com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Get all printers configured by this merchant for the given category.
   */
public java.util.List<com.clover.sdk.v1.printer.Printer> getPrintersByCategory(com.clover.sdk.v1.printer.Category category, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Returns true if there is any configured printer in the given category.
   */
public boolean isPrinterSet(com.clover.sdk.v1.printer.Category category, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Returns the printer which matches the {@link Printer#getUuid()} if any, or null if none.
   * This may return a printer which has not been configured.
   */
public com.clover.sdk.v1.printer.Printer getPrinterById(java.lang.String id, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Removes a printer from being configured. If a category is supplied then the printer has only
   * the configuration for that category removed. If no category is supplied then the printer is
   * completely removed.
   */
public void removePrinter(com.clover.sdk.v1.printer.Printer p, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Adds a printer optionally with a category. If a new printer is added without a category it
   * is unconfigured. A new or existing printer may configured by supplying a category.
   */
public com.clover.sdk.v1.printer.Printer setPrinter(com.clover.sdk.v1.printer.Printer p, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
/**
   * Returns the TypeDetails for the given printer.
   */
public com.clover.sdk.v1.printer.TypeDetails getPrinterTypeDetails(com.clover.sdk.v1.printer.Printer p, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
}
