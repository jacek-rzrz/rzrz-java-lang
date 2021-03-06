package rzrz.java.lang;

import java.lang.RuntimeException;

/**
 *  AUTOGENERATED FILE: DO NOT MODIFY
 *  @see src-gen/generate.js
 *  @author Jacek Rzeniewicz
 */
public final class Functions {


	/*
	 * 0-argument functions
	 */


	public interface Func0ThrowsT<TResult, TError extends Throwable> {

		TResult call() throws TError;
	}

	public interface Func0ThrowsE<TResult>
		extends Func0ThrowsT<TResult, Exception>
	{

	}

	public interface Func0<TResult>
		extends Func0ThrowsT<TResult, RuntimeException>
	{

	}

	public interface Action0ThrowsT<TError extends Throwable> {

		void call() throws TError;
	}

	public interface Action0ThrowsE
		extends Action0ThrowsT<Exception>
	{

	}

	public interface Action0
		extends Action0ThrowsT<RuntimeException>
	{

	}

	public interface Predicate0ThrowsT<TError extends Throwable> {

		boolean call() throws TError;
	}

	public interface Predicate0ThrowsE
		extends Predicate0ThrowsT<Exception>
	{

	}

	public interface Predicate0
		extends Predicate0ThrowsT<RuntimeException>
	{

	}

	/*
	 * 1-argument functions
	 */


	public interface Func1ThrowsT<T1, TResult, TError extends Throwable> {

		TResult call(T1 $1) throws TError;
	}

	public interface Func1ThrowsE<T1, TResult>
		extends Func1ThrowsT<T1, TResult, Exception>
	{

	}

	public interface Func1<T1, TResult>
		extends Func1ThrowsT<T1, TResult, RuntimeException>
	{

	}

	public interface Action1ThrowsT<T1, TError extends Throwable> {

		void call(T1 $1) throws TError;
	}

	public interface Action1ThrowsE<T1>
		extends Action1ThrowsT<T1, Exception>
	{

	}

	public interface Action1<T1>
		extends Action1ThrowsT<T1, RuntimeException>
	{

	}

	public interface Predicate1ThrowsT<T1, TError extends Throwable> {

		boolean call(T1 $1) throws TError;
	}

	public interface Predicate1ThrowsE<T1>
		extends Predicate1ThrowsT<T1, Exception>
	{

	}

	public interface Predicate1<T1>
		extends Predicate1ThrowsT<T1, RuntimeException>
	{

	}

	/*
	 * 2-argument functions
	 */


	public interface Func2ThrowsT<T1, T2, TResult, TError extends Throwable> {

		TResult call(T1 $1, T2 $2) throws TError;
	}

	public interface Func2ThrowsE<T1, T2, TResult>
		extends Func2ThrowsT<T1, T2, TResult, Exception>
	{

	}

	public interface Func2<T1, T2, TResult>
		extends Func2ThrowsT<T1, T2, TResult, RuntimeException>
	{

	}

	public interface Action2ThrowsT<T1, T2, TError extends Throwable> {

		void call(T1 $1, T2 $2) throws TError;
	}

	public interface Action2ThrowsE<T1, T2>
		extends Action2ThrowsT<T1, T2, Exception>
	{

	}

	public interface Action2<T1, T2>
		extends Action2ThrowsT<T1, T2, RuntimeException>
	{

	}

	public interface Predicate2ThrowsT<T1, T2, TError extends Throwable> {

		boolean call(T1 $1, T2 $2) throws TError;
	}

	public interface Predicate2ThrowsE<T1, T2>
		extends Predicate2ThrowsT<T1, T2, Exception>
	{

	}

	public interface Predicate2<T1, T2>
		extends Predicate2ThrowsT<T1, T2, RuntimeException>
	{

	}

	/*
	 * 3-argument functions
	 */


	public interface Func3ThrowsT<T1, T2, T3, TResult, TError extends Throwable> {

		TResult call(T1 $1, T2 $2, T3 $3) throws TError;
	}

	public interface Func3ThrowsE<T1, T2, T3, TResult>
		extends Func3ThrowsT<T1, T2, T3, TResult, Exception>
	{

	}

	public interface Func3<T1, T2, T3, TResult>
		extends Func3ThrowsT<T1, T2, T3, TResult, RuntimeException>
	{

	}

	public interface Action3ThrowsT<T1, T2, T3, TError extends Throwable> {

		void call(T1 $1, T2 $2, T3 $3) throws TError;
	}

	public interface Action3ThrowsE<T1, T2, T3>
		extends Action3ThrowsT<T1, T2, T3, Exception>
	{

	}

	public interface Action3<T1, T2, T3>
		extends Action3ThrowsT<T1, T2, T3, RuntimeException>
	{

	}

	public interface Predicate3ThrowsT<T1, T2, T3, TError extends Throwable> {

		boolean call(T1 $1, T2 $2, T3 $3) throws TError;
	}

	public interface Predicate3ThrowsE<T1, T2, T3>
		extends Predicate3ThrowsT<T1, T2, T3, Exception>
	{

	}

	public interface Predicate3<T1, T2, T3>
		extends Predicate3ThrowsT<T1, T2, T3, RuntimeException>
	{

	}

	/*
	 * 4-argument functions
	 */


	public interface Func4ThrowsT<T1, T2, T3, T4, TResult, TError extends Throwable> {

		TResult call(T1 $1, T2 $2, T3 $3, T4 $4) throws TError;
	}

	public interface Func4ThrowsE<T1, T2, T3, T4, TResult>
		extends Func4ThrowsT<T1, T2, T3, T4, TResult, Exception>
	{

	}

	public interface Func4<T1, T2, T3, T4, TResult>
		extends Func4ThrowsT<T1, T2, T3, T4, TResult, RuntimeException>
	{

	}

	public interface Action4ThrowsT<T1, T2, T3, T4, TError extends Throwable> {

		void call(T1 $1, T2 $2, T3 $3, T4 $4) throws TError;
	}

	public interface Action4ThrowsE<T1, T2, T3, T4>
		extends Action4ThrowsT<T1, T2, T3, T4, Exception>
	{

	}

	public interface Action4<T1, T2, T3, T4>
		extends Action4ThrowsT<T1, T2, T3, T4, RuntimeException>
	{

	}

	public interface Predicate4ThrowsT<T1, T2, T3, T4, TError extends Throwable> {

		boolean call(T1 $1, T2 $2, T3 $3, T4 $4) throws TError;
	}

	public interface Predicate4ThrowsE<T1, T2, T3, T4>
		extends Predicate4ThrowsT<T1, T2, T3, T4, Exception>
	{

	}

	public interface Predicate4<T1, T2, T3, T4>
		extends Predicate4ThrowsT<T1, T2, T3, T4, RuntimeException>
	{

	}

	/*
	 * 5-argument functions
	 */


	public interface Func5ThrowsT<T1, T2, T3, T4, T5, TResult, TError extends Throwable> {

		TResult call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5) throws TError;
	}

	public interface Func5ThrowsE<T1, T2, T3, T4, T5, TResult>
		extends Func5ThrowsT<T1, T2, T3, T4, T5, TResult, Exception>
	{

	}

	public interface Func5<T1, T2, T3, T4, T5, TResult>
		extends Func5ThrowsT<T1, T2, T3, T4, T5, TResult, RuntimeException>
	{

	}

	public interface Action5ThrowsT<T1, T2, T3, T4, T5, TError extends Throwable> {

		void call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5) throws TError;
	}

	public interface Action5ThrowsE<T1, T2, T3, T4, T5>
		extends Action5ThrowsT<T1, T2, T3, T4, T5, Exception>
	{

	}

	public interface Action5<T1, T2, T3, T4, T5>
		extends Action5ThrowsT<T1, T2, T3, T4, T5, RuntimeException>
	{

	}

	public interface Predicate5ThrowsT<T1, T2, T3, T4, T5, TError extends Throwable> {

		boolean call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5) throws TError;
	}

	public interface Predicate5ThrowsE<T1, T2, T3, T4, T5>
		extends Predicate5ThrowsT<T1, T2, T3, T4, T5, Exception>
	{

	}

	public interface Predicate5<T1, T2, T3, T4, T5>
		extends Predicate5ThrowsT<T1, T2, T3, T4, T5, RuntimeException>
	{

	}

	/*
	 * 6-argument functions
	 */


	public interface Func6ThrowsT<T1, T2, T3, T4, T5, T6, TResult, TError extends Throwable> {

		TResult call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6) throws TError;
	}

	public interface Func6ThrowsE<T1, T2, T3, T4, T5, T6, TResult>
		extends Func6ThrowsT<T1, T2, T3, T4, T5, T6, TResult, Exception>
	{

	}

	public interface Func6<T1, T2, T3, T4, T5, T6, TResult>
		extends Func6ThrowsT<T1, T2, T3, T4, T5, T6, TResult, RuntimeException>
	{

	}

	public interface Action6ThrowsT<T1, T2, T3, T4, T5, T6, TError extends Throwable> {

		void call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6) throws TError;
	}

	public interface Action6ThrowsE<T1, T2, T3, T4, T5, T6>
		extends Action6ThrowsT<T1, T2, T3, T4, T5, T6, Exception>
	{

	}

	public interface Action6<T1, T2, T3, T4, T5, T6>
		extends Action6ThrowsT<T1, T2, T3, T4, T5, T6, RuntimeException>
	{

	}

	public interface Predicate6ThrowsT<T1, T2, T3, T4, T5, T6, TError extends Throwable> {

		boolean call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6) throws TError;
	}

	public interface Predicate6ThrowsE<T1, T2, T3, T4, T5, T6>
		extends Predicate6ThrowsT<T1, T2, T3, T4, T5, T6, Exception>
	{

	}

	public interface Predicate6<T1, T2, T3, T4, T5, T6>
		extends Predicate6ThrowsT<T1, T2, T3, T4, T5, T6, RuntimeException>
	{

	}

	/*
	 * 7-argument functions
	 */


	public interface Func7ThrowsT<T1, T2, T3, T4, T5, T6, T7, TResult, TError extends Throwable> {

		TResult call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7) throws TError;
	}

	public interface Func7ThrowsE<T1, T2, T3, T4, T5, T6, T7, TResult>
		extends Func7ThrowsT<T1, T2, T3, T4, T5, T6, T7, TResult, Exception>
	{

	}

	public interface Func7<T1, T2, T3, T4, T5, T6, T7, TResult>
		extends Func7ThrowsT<T1, T2, T3, T4, T5, T6, T7, TResult, RuntimeException>
	{

	}

	public interface Action7ThrowsT<T1, T2, T3, T4, T5, T6, T7, TError extends Throwable> {

		void call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7) throws TError;
	}

	public interface Action7ThrowsE<T1, T2, T3, T4, T5, T6, T7>
		extends Action7ThrowsT<T1, T2, T3, T4, T5, T6, T7, Exception>
	{

	}

	public interface Action7<T1, T2, T3, T4, T5, T6, T7>
		extends Action7ThrowsT<T1, T2, T3, T4, T5, T6, T7, RuntimeException>
	{

	}

	public interface Predicate7ThrowsT<T1, T2, T3, T4, T5, T6, T7, TError extends Throwable> {

		boolean call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7) throws TError;
	}

	public interface Predicate7ThrowsE<T1, T2, T3, T4, T5, T6, T7>
		extends Predicate7ThrowsT<T1, T2, T3, T4, T5, T6, T7, Exception>
	{

	}

	public interface Predicate7<T1, T2, T3, T4, T5, T6, T7>
		extends Predicate7ThrowsT<T1, T2, T3, T4, T5, T6, T7, RuntimeException>
	{

	}

	/*
	 * 8-argument functions
	 */


	public interface Func8ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, TResult, TError extends Throwable> {

		TResult call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7, T8 $8) throws TError;
	}

	public interface Func8ThrowsE<T1, T2, T3, T4, T5, T6, T7, T8, TResult>
		extends Func8ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, TResult, Exception>
	{

	}

	public interface Func8<T1, T2, T3, T4, T5, T6, T7, T8, TResult>
		extends Func8ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, TResult, RuntimeException>
	{

	}

	public interface Action8ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, TError extends Throwable> {

		void call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7, T8 $8) throws TError;
	}

	public interface Action8ThrowsE<T1, T2, T3, T4, T5, T6, T7, T8>
		extends Action8ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, Exception>
	{

	}

	public interface Action8<T1, T2, T3, T4, T5, T6, T7, T8>
		extends Action8ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, RuntimeException>
	{

	}

	public interface Predicate8ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, TError extends Throwable> {

		boolean call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7, T8 $8) throws TError;
	}

	public interface Predicate8ThrowsE<T1, T2, T3, T4, T5, T6, T7, T8>
		extends Predicate8ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, Exception>
	{

	}

	public interface Predicate8<T1, T2, T3, T4, T5, T6, T7, T8>
		extends Predicate8ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, RuntimeException>
	{

	}

	/*
	 * 9-argument functions
	 */


	public interface Func9ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, TResult, TError extends Throwable> {

		TResult call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7, T8 $8, T9 $9) throws TError;
	}

	public interface Func9ThrowsE<T1, T2, T3, T4, T5, T6, T7, T8, T9, TResult>
		extends Func9ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, TResult, Exception>
	{

	}

	public interface Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, TResult>
		extends Func9ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, TResult, RuntimeException>
	{

	}

	public interface Action9ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, TError extends Throwable> {

		void call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7, T8 $8, T9 $9) throws TError;
	}

	public interface Action9ThrowsE<T1, T2, T3, T4, T5, T6, T7, T8, T9>
		extends Action9ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, Exception>
	{

	}

	public interface Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9>
		extends Action9ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, RuntimeException>
	{

	}

	public interface Predicate9ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, TError extends Throwable> {

		boolean call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7, T8 $8, T9 $9) throws TError;
	}

	public interface Predicate9ThrowsE<T1, T2, T3, T4, T5, T6, T7, T8, T9>
		extends Predicate9ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, Exception>
	{

	}

	public interface Predicate9<T1, T2, T3, T4, T5, T6, T7, T8, T9>
		extends Predicate9ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, RuntimeException>
	{

	}

	/*
	 * 10-argument functions
	 */


	public interface Func10ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, TResult, TError extends Throwable> {

		TResult call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7, T8 $8, T9 $9, T10 $10) throws TError;
	}

	public interface Func10ThrowsE<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, TResult>
		extends Func10ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, TResult, Exception>
	{

	}

	public interface Func10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, TResult>
		extends Func10ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, TResult, RuntimeException>
	{

	}

	public interface Action10ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, TError extends Throwable> {

		void call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7, T8 $8, T9 $9, T10 $10) throws TError;
	}

	public interface Action10ThrowsE<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>
		extends Action10ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, Exception>
	{

	}

	public interface Action10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>
		extends Action10ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, RuntimeException>
	{

	}

	public interface Predicate10ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, TError extends Throwable> {

		boolean call(T1 $1, T2 $2, T3 $3, T4 $4, T5 $5, T6 $6, T7 $7, T8 $8, T9 $9, T10 $10) throws TError;
	}

	public interface Predicate10ThrowsE<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>
		extends Predicate10ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, Exception>
	{

	}

	public interface Predicate10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>
		extends Predicate10ThrowsT<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, RuntimeException>
	{

	}
}