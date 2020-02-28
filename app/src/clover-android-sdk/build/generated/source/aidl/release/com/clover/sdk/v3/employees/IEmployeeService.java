/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\src\\clover-android-sdk\\clover-android-sdk\\src\\main\\aidl\\com\\clover\\sdk\\v3\\employees\\IEmployeeService.aidl
 */
package com.clover.sdk.v3.employees;
/**
 * An interface for interacting with the Clover employee service. The employee
 * service is a bound AIDL service. Bind to this service as follows,
 * <pre>
 * <code>
 * Intent serviceIntent = new Intent(EmployeeIntent.ACTION_EMPLOYEE_SERVICE_V3);
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
 * You may also interact with the employee service through the
 * {@link com.clover.sdk.v3.employee.EmployeeConnector} class, which handles binding and
 * asynchronous invocation of service methods.
 *
 * @see com.clover.sdk.util.CloverAccount
 * @see com.clover.sdk.v3.employee.EmployeeIntent
 * @see com.clover.sdk.v3.employee.EmployeeConnector
 * @see com.clover.sdk.Lockscreen
 */
public interface IEmployeeService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.employees.IEmployeeService
{
private static final java.lang.String DESCRIPTOR = "com.clover.sdk.v3.employees.IEmployeeService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.employees.IEmployeeService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.employees.IEmployeeService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.employees.IEmployeeService))) {
return ((com.clover.sdk.v3.employees.IEmployeeService)iin);
}
return new com.clover.sdk.v3.employees.IEmployeeService.Stub.Proxy(obj);
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
case TRANSACTION_getActiveEmployee:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.getActiveEmployee(_arg0);
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
case TRANSACTION_getEmployee:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.getEmployee(_arg0, _arg1);
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
case TRANSACTION_getEmployees:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.employees.Employee> _result = this.getEmployees(_arg0);
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
case TRANSACTION_createEmployee:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.employees.Employee _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.createEmployee(_arg0, _arg1);
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
case TRANSACTION_updateEmployee:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.employees.Employee _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.updateEmployee(_arg0, _arg1);
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
case TRANSACTION_setEmployeePin:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.setEmployeePin(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteEmployee:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteEmployee(_arg0, _arg1);
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
case TRANSACTION_logout:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
this.logout(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_login:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
this.login(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addListener:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.employees.IEmployeeListener _arg0;
_arg0 = com.clover.sdk.v3.employees.IEmployeeListener.Stub.asInterface(data.readStrongBinder());
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.addListener(_arg0, _arg1);
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
case TRANSACTION_removeListener:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.employees.IEmployeeListener _arg0;
_arg0 = com.clover.sdk.v3.employees.IEmployeeListener.Stub.asInterface(data.readStrongBinder());
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.removeListener(_arg0, _arg1);
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
case TRANSACTION_addEmployeeCard:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.employees.EmployeeCard _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.employees.EmployeeCard.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.EmployeeCard _result = this.addEmployeeCard(_arg0, _arg1);
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
case TRANSACTION_deleteEmployeeCard:
{
data.enforceInterface(descriptor);
com.clover.sdk.v3.employees.EmployeeCard _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.employees.EmployeeCard.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteEmployeeCard(_arg0, _arg1);
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
case TRANSACTION_getEmployeeCards:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.employees.EmployeeCard> _result = this.getEmployeeCards(_arg0, _arg1);
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
case TRANSACTION_getEmployeeForCard:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.getEmployeeForCard(_arg0, _arg1);
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
case TRANSACTION_setFingerprintId:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.setFingerprintId(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteFingerprintId:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteFingerprintId(_arg0, _arg1);
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
case TRANSACTION_getFingerprintId:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
int _result = this.getFingerprintId(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getEnrolledFingerprints:
{
data.enforceInterface(descriptor);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
int[] _result = this.getEnrolledFingerprints(_arg0);
reply.writeNoException();
reply.writeIntArray(_result);
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getEmployeeId:
{
data.enforceInterface(descriptor);
int _arg0;
_arg0 = data.readInt();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.lang.String _result = this.getEmployeeId(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
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
private static class Proxy implements com.clover.sdk.v3.employees.IEmployeeService
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
   * Return the employee currently logged in to this device. If the device is
   * locked this returns null.
   * <p/>
   * Requires EMPLOYEES_R permission.
   */
@Override public com.clover.sdk.v3.employees.Employee getActiveEmployee(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getActiveEmployee, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
   * Return the employee for the particular UUID.
   * <p/>
   * Requires EMPLOYEES_R permission.
   */
@Override public com.clover.sdk.v3.employees.Employee getEmployee(java.lang.String id, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_getEmployee, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
   * Return a list of all employees.
   * <p/>
   * Requires EMPLOYEES_R permission.
   */
@Override public java.util.List<com.clover.sdk.v3.employees.Employee> getEmployees(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.employees.Employee> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getEmployees, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.employees.Employee.CREATOR);
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
   * Create a new employee. You must set at least a name, pin and role. Do not
   * set the id, one will be generated and available in the return value.
   * Device must have network connectivity to succeed.
   * <p/>
   * Requires EMPLOYEES_W permission.
   */
@Override public com.clover.sdk.v3.employees.Employee createEmployee(com.clover.sdk.v3.employees.Employee employee, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((employee!=null)) {
_data.writeInt(1);
employee.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createEmployee, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
   * Update an existing employee. Device must have network connectivity to
   * succeed. Check result status to ensure the call succeeded.
   * <p/>
   * Requires EMPLOYEES_W permission.
   */
@Override public com.clover.sdk.v3.employees.Employee updateEmployee(com.clover.sdk.v3.employees.Employee employee, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((employee!=null)) {
_data.writeInt(1);
employee.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateEmployee, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
   * Deprecated. Use {@link #updateEmployee(Employee, ResultStatus)} instead.
   */
@Override public com.clover.sdk.v3.employees.Employee setEmployeePin(java.lang.String id, java.lang.String pin, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
_data.writeString(pin);
mRemote.transact(Stub.TRANSACTION_setEmployeePin, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
   * Delete an existing employee. Device must have network connectivity to
   * succeed. Check result status to ensure the call succeeded.
   * <p/>
   * Requires EMPLOYEES_W permission.
   */
@Override public void deleteEmployee(java.lang.String id, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_deleteEmployee, _data, _reply, 0);
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
   * @deprecated Please use {@link Lockscreen#lock()}.
   */
@Override public void logout(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_logout, _data, _reply, 0);
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
   * @deprecated Please use {@link Lockscreen#unlock()}, {@link Lockscreen#unlock(String)},
   * or {@link Lockscreen#unlockDefault()}.
   */
@Override public void login(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_login, _data, _reply, 0);
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
   * Register a listener to be called when the active employee changes, which
   * coincides with the lockscreen being shown or dismissed.
   */
@Override public void addListener(com.clover.sdk.v3.employees.IEmployeeListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addListener, _data, _reply, 0);
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
   * Unregister a previously registered employee changed listener.
   */
@Override public void removeListener(com.clover.sdk.v3.employees.IEmployeeListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeListener, _data, _reply, 0);
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
   * Not available to non-Clover apps.
   *
   * @y.exclude
   */
@Override public com.clover.sdk.v3.employees.EmployeeCard addEmployeeCard(com.clover.sdk.v3.employees.EmployeeCard employeeCard, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.EmployeeCard _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((employeeCard!=null)) {
_data.writeInt(1);
employeeCard.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addEmployeeCard, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.EmployeeCard.CREATOR.createFromParcel(_reply);
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
   * Not available to non-Clover apps.
   *
   * @y.exclude
   */
@Override public void deleteEmployeeCard(com.clover.sdk.v3.employees.EmployeeCard employeeCard, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((employeeCard!=null)) {
_data.writeInt(1);
employeeCard.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_deleteEmployeeCard, _data, _reply, 0);
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
   * Not available to non-Clover apps.
   *
   * @y.exclude
   */
@Override public java.util.List<com.clover.sdk.v3.employees.EmployeeCard> getEmployeeCards(java.lang.String employeeId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.employees.EmployeeCard> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(employeeId);
mRemote.transact(Stub.TRANSACTION_getEmployeeCards, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.employees.EmployeeCard.CREATOR);
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
   * Not available to non-Clover apps.
   *
   * @y.exclude
   */
@Override public com.clover.sdk.v3.employees.Employee getEmployeeForCard(java.lang.String cardNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(cardNumber);
mRemote.transact(Stub.TRANSACTION_getEmployeeForCard, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
   * Not available to non-Clover apps.
   *
   * Set a fingerprint for an employee.
   *
   * @param employeeId, the employee's ID for whom this fingerprint is set.
   * @param fingerprintId, the fingerprint ID.
   * @param resultStatus, Possible status results from calling Clover services. Most Clover service calls accept an instance of the ResultStatus class as an "out" parameter
   * @y.exclude
   *
   * The method sets the fiungerprintId and assosciates it to the EmployeeId. It throws a client exception for incorrect employeeId.
   * In this case resutStatus is between 400 and 499 or is equal to 999
   */
@Override public void setFingerprintId(java.lang.String employeeId, java.lang.String fingerprintId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(employeeId);
_data.writeString(fingerprintId);
mRemote.transact(Stub.TRANSACTION_setFingerprintId, _data, _reply, 0);
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
   * Not available to non-Clover apps.
   *
   * Delete the fingerprint of an employee.
   *
   * @param employeeId, the employee's ID for whom this fingerprint is set.
   * @param resultStatus, Possible status results from calling Clover services. Most Clover service calls accept an instance of the ResultStatus class as an "out" parameter
   * @y.exclude
   *
   * The method deletes the fiungerprintId assosciated to the EmployeeId (input parameter). It throws a client exception for incorrect employeeId.
   * In this case resutStatus is between 400 and 499 or is equal to 999
   */
@Override public void deleteFingerprintId(java.lang.String employeeId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(employeeId);
mRemote.transact(Stub.TRANSACTION_deleteFingerprintId, _data, _reply, 0);
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
@Override public int getFingerprintId(java.lang.String employeeId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(employeeId);
mRemote.transact(Stub.TRANSACTION_getFingerprintId, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
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
@Override public int[] getEnrolledFingerprints(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getEnrolledFingerprints, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
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
@Override public java.lang.String getEmployeeId(int fingerprintId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(fingerprintId);
mRemote.transact(Stub.TRANSACTION_getEmployeeId, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
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
static final int TRANSACTION_getActiveEmployee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getEmployee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getEmployees = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_createEmployee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_updateEmployee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setEmployeePin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_deleteEmployee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_logout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_login = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_addListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_removeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_addEmployeeCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_deleteEmployeeCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_getEmployeeCards = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_getEmployeeForCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_setFingerprintId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_deleteFingerprintId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_getFingerprintId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_getEnrolledFingerprints = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_getEmployeeId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
}
/**
   * Return the employee currently logged in to this device. If the device is
   * locked this returns null.
   * <p/>
   * Requires EMPLOYEES_R permission.
   */
public com.clover.sdk.v3.employees.Employee getActiveEmployee(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Return the employee for the particular UUID.
   * <p/>
   * Requires EMPLOYEES_R permission.
   */
public com.clover.sdk.v3.employees.Employee getEmployee(java.lang.String id, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Return a list of all employees.
   * <p/>
   * Requires EMPLOYEES_R permission.
   */
public java.util.List<com.clover.sdk.v3.employees.Employee> getEmployees(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Create a new employee. You must set at least a name, pin and role. Do not
   * set the id, one will be generated and available in the return value.
   * Device must have network connectivity to succeed.
   * <p/>
   * Requires EMPLOYEES_W permission.
   */
public com.clover.sdk.v3.employees.Employee createEmployee(com.clover.sdk.v3.employees.Employee employee, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Update an existing employee. Device must have network connectivity to
   * succeed. Check result status to ensure the call succeeded.
   * <p/>
   * Requires EMPLOYEES_W permission.
   */
public com.clover.sdk.v3.employees.Employee updateEmployee(com.clover.sdk.v3.employees.Employee employee, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Deprecated. Use {@link #updateEmployee(Employee, ResultStatus)} instead.
   */
public com.clover.sdk.v3.employees.Employee setEmployeePin(java.lang.String id, java.lang.String pin, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Delete an existing employee. Device must have network connectivity to
   * succeed. Check result status to ensure the call succeeded.
   * <p/>
   * Requires EMPLOYEES_W permission.
   */
public void deleteEmployee(java.lang.String id, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * @deprecated Please use {@link Lockscreen#lock()}.
   */
public void logout(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * @deprecated Please use {@link Lockscreen#unlock()}, {@link Lockscreen#unlock(String)},
   * or {@link Lockscreen#unlockDefault()}.
   */
public void login(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Register a listener to be called when the active employee changes, which
   * coincides with the lockscreen being shown or dismissed.
   */
public void addListener(com.clover.sdk.v3.employees.IEmployeeListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Unregister a previously registered employee changed listener.
   */
public void removeListener(com.clover.sdk.v3.employees.IEmployeeListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   *
   * @y.exclude
   */
public com.clover.sdk.v3.employees.EmployeeCard addEmployeeCard(com.clover.sdk.v3.employees.EmployeeCard employeeCard, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   *
   * @y.exclude
   */
public void deleteEmployeeCard(com.clover.sdk.v3.employees.EmployeeCard employeeCard, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   *
   * @y.exclude
   */
public java.util.List<com.clover.sdk.v3.employees.EmployeeCard> getEmployeeCards(java.lang.String employeeId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   *
   * @y.exclude
   */
public com.clover.sdk.v3.employees.Employee getEmployeeForCard(java.lang.String cardNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   *
   * Set a fingerprint for an employee.
   *
   * @param employeeId, the employee's ID for whom this fingerprint is set.
   * @param fingerprintId, the fingerprint ID.
   * @param resultStatus, Possible status results from calling Clover services. Most Clover service calls accept an instance of the ResultStatus class as an "out" parameter
   * @y.exclude
   *
   * The method sets the fiungerprintId and assosciates it to the EmployeeId. It throws a client exception for incorrect employeeId.
   * In this case resutStatus is between 400 and 499 or is equal to 999
   */
public void setFingerprintId(java.lang.String employeeId, java.lang.String fingerprintId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Not available to non-Clover apps.
   *
   * Delete the fingerprint of an employee.
   *
   * @param employeeId, the employee's ID for whom this fingerprint is set.
   * @param resultStatus, Possible status results from calling Clover services. Most Clover service calls accept an instance of the ResultStatus class as an "out" parameter
   * @y.exclude
   *
   * The method deletes the fiungerprintId assosciated to the EmployeeId (input parameter). It throws a client exception for incorrect employeeId.
   * In this case resutStatus is between 400 and 499 or is equal to 999
   */
public void deleteFingerprintId(java.lang.String employeeId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public int getFingerprintId(java.lang.String employeeId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public int[] getEnrolledFingerprints(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public java.lang.String getEmployeeId(int fingerprintId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
