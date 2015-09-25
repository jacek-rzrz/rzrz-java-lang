package rzrz.java.lang;

import rzrz.java.lang.Exceptions.UnsupportedOperation;
import rzrz.java.lang.Functions.*;

import java.util.Objects;
import java.util.Optional;

/**
 * Java implementation of Scala's Try:
 * http://www.scala-lang.org/api/current/#scala.util.Try
 * <p>
 * <p>{@code Try<T>} wraps an object of type {@code T} ({@code{Success<T>})
 * or an exception thrown during computation ({@code Failure<T>}).
 * <p>
 * <p>{@code Try<T>} operators (e.g. {@link #map(Func1ThrowsE)}
 * or {@link #flatMap(Func1ThrowsE)}) help to chain operations and
 * focus on the "happy path" - exceptions are propagated to
 * the end of chain so that they can be handled in one place.
 * <p>
 * <p>Only {@link Exception}s and subclasses are caught by Try operators
 * - any other {@link Throwable}s propagate up the call stack.
 */
public abstract class Try<T> {

	/**
	 * Cast to another type.
	 *
	 * @param cls class to cast to
	 * @param <U> target type
	 * @return a cast {@code Try}
	 * @throws ClassCastException when the value is not assignable to {@code cls}
	 */
	public abstract <U> Try<U> as(Class<? extends U> cls);

	/**
	 * Gets the exception.
	 *
	 * @return exception
	 * @throws UnsupportedOperation if this is a {@code Success}
	 * @see #isSuccess()
	 * @see #isFailure()
	 */
	public abstract Exception error();

	/**
	 * Converts to a {@code Failure} if the predicate is not satisfied.
	 *
	 * @param filter predicate
	 * @return {@code Success} if this is a {@code Success} and the value
	 * satisfies the predicate, otherwise a {@code Failure}.
	 */
	public abstract Try<T> filter(Func1ThrowsE<T, Boolean> filter);

	/**
	 * Converts to a {@code Failure} if the action throws an exception.
	 *
	 * @param filter action
	 * @return {@code Success} if this is a {@code Success} and the action
	 * does not throw an exception having consumed the value
	 */
	public abstract Try<T> filter(Action1ThrowsE<T> filter);

	public abstract <U> Try<U> flatMap(Func1ThrowsE<T, Try<U>> mapper);

	/**
	 * Gets the value or throws an exception.
	 *
	 * @return {@code value} when this is a {@code Success}, otherwise throws an exception
	 * @throws UnsupportedOperation if this is a {@code Failure}
	 * @see #isSuccess()
	 * @see #isFailure()
	 */
	public abstract T get();

	/**
	 * Gets the value, falls back to {@code defaultValue}.
	 *
	 * @param defaultValue default value
	 * @return {@code value} when this is a {@code Success}, otherwise {@code defaultValue}
	 */
	public abstract T getOrElse(T defaultValue);

	/**
	 * Gets the value, falls back to an object obtained from {@code defaultSupplier}.
	 *
	 * @param defaultSupplier supplies a value if this is a {@code Failure}.
	 * @return {@code value} when this is a {@code Success}, otherwise an object obtained from
	 * {@code defaultSupplier}
	 * @throws NullPointerException when this is a {@code Failure} and
	 *                              {@code defaultSupplier} is {@code null}
	 */
	public abstract T getOrElse(Func0<T> defaultSupplier);

	public abstract Try<T> inspect(Action1<T> ifSuccess, Action1<Exception> ifError);

	/**
	 * Inverts this object:
	 * <p><ul>
	 * <li>if this object is a {@code Success}, a {@code Failure} containing
	 * an {@link UnsupportedOperation} is returned
	 * <li>if this object is a {@code Failure}, a {@code Success} containing
	 * the error is returned
	 * </ul></p>
	 *
	 * @return
	 */
	public abstract Try<Exception> invert();

	/**
	 * Determines whether this is a {@code Failure}.
	 *
	 * @return {@code true} if this is a {@code Failure}, otherwise {@code false}
	 */
	public abstract boolean isFailure();

	/**
	 * Determines whether this is a {@code Success}.
	 *
	 * @return {@code true} if this is a {@code Success}, otherwise {@code false}
	 */
	public abstract boolean isSuccess();

	public abstract <U> Try<U> map(Func1ThrowsE<T, U> mapper);

	public abstract Try<T> mapError(Func1<Exception, Exception> errorMapper);

	/**
	 * Replaces this instance with another {@code Try} object when this is a {@code Failure}.
	 *
	 * @param defaultValue returned when this is a {@code Failure}
	 * @return current instance if this is a {@code Success}, otherwise {@code defaultValue}
	 */
	public abstract Try<T> orElse(Try<T> defaultValue);

	/**
	 * Replaces this instance with a {@code Try} object obtained from {@code defaultSupplier}
	 * when this is a {@code Failure}.
	 *
	 * @param defaultSupplier supplies a new object when this is a {@code Failure}
	 * @return current instance if this is a {@code Success}, otherwise an object
	 * supplied by {@code defaultSupplier}
	 * @throws NullPointerException when this is a {@code Failure} and
	 *                              {@code defaultSupplier} is {@code null}
	 */
	public abstract Try<T> orElse(Func0<Try<T>> defaultSupplier);

	public abstract <E extends Exception> T orElseThrow(Func1<Exception, E> errorMapper) throws E;

	public abstract Try<T> recover(Func1<Exception, T> recover);

	public abstract Try<T> recoverWith(Func1<Exception, Try<T>> recover);

	/**
	 * Converts to {@link Optional}.
	 *
	 * @return Optional containing a value if this is a {@code Success}, otherwise an empty {@code Optional}
	 * @see Optional
	 */
	public abstract Optional<T> toOptional();

	public abstract <U> Try<U> transform(Func1ThrowsE<T, U> ifSuccess, Func1ThrowsE<Exception, U> ifFailure);

	/**
	 * Zips two {@code Try} instances.
	 *
	 * @param t      first instance
	 * @param u      second instance
	 * @param zipper zips inputs' values into a new object
	 * @param <T>    first {@code Try} type parameter
	 * @param <U>    second {@code Try} type parameter
	 * @param <V>    result {@code Try} type parameter
	 * @return a {@code Success} containing the value returned by {@code zipper} when both
	 * {@code t} and {@code u} are instances of {@code Success}, a {@code Failure otherwise}
	 */
	public static <T, U, V> Try<V> zip(Try<T> t, Try<U> u, Func2ThrowsE<T, U, V> zipper) {

		Try<?> failed = null;

		if (t.isFailure()) {
			failed = t;
		}

		if (u.isFailure()) {
			failed = u;
		}

		if (failed != null) {
			@SuppressWarnings("unchecked")
			Try<V> f = (Try<V>) failed;
			return f;
		}

		return Try.from(() -> zipper.call(t.get(), u.get()));
	}

	public static <T> Try<T> from(Functions.Func0ThrowsE<T> f) {

		return exec(() -> new Success<>(f.call()));
	}

	public static <T> Try<T> of(T t) {

		return new Success<>(t);
	}

	private static <U> Try<U> exec(Func0ThrowsE<Try<U>> f) {

		try {
			return f.call();
		} catch (Exception e) {
			return new Failure<>(e);
		}
	}

	private static <T, U> Try<U> exec(Func1ThrowsE<T, Try<U>> f, T value) {

		return exec(() -> f.call(value));
	}


	public static final class Success<T> extends Try<T> {

		private final T value;

		public Success(T value) {
			this.value = value;
		}

		/**
		 * Cast to another type
		 *
		 * @param cls class to cast to
		 * @param <U> target type
		 * @return a {@code Success} of type {@code U} containing the same value
		 * @throws ClassCastException when the value is not assignable to {@code cls}
		 */
		@Override
		public <U> Try<U> as(Class<? extends U> cls) {
			return new Success<>(cls.cast(value));
		}

		/**
		 * Throws an exception.
		 *
		 * @return nothing
		 * @throws UnsupportedOperation always
		 */
		@Override
		public Exception error() {
			throw new UnsupportedOperation("Success.error()");
		}

		/**
		 * Converts to a {@code Failure} if the predicate is not satisfied.
		 *
		 * @param filter predicate
		 * @return current instance if the value satisfies the predicate,
		 * otherwise a {@code Failure}.
		 */
		@Override
		public Try<T> filter(Func1ThrowsE<T, Boolean> filter) {

			return exec(() ->
							filter.call(value) ? this : new Failure<>("Filtered to failure")
			);
		}

		/**
		 * Converts to a {@code Failure} if the action throws an exception.
		 *
		 * @param filter action
		 * @return {@code Success} if the action does not throw an exception having consumed the value
		 */
		@Override
		public Try<T> filter(Action1ThrowsE<T> filter) {

			return exec(() -> {
				filter.call(value);
				return this;
			});
		}

		@Override
		public <U> Try<U> flatMap(Func1ThrowsE<T, Try<U>> mapper) {
			return exec(mapper::call, value);
		}

		/**
		 * Gets the value
		 *
		 * @return value
		 */
		@Override
		public T get() {
			return value;
		}

		/**
		 * Gets the value
		 *
		 * @param defaultValue ignored
		 * @return value
		 */
		@Override
		public T getOrElse(T defaultValue) {
			return value;
		}

		/**
		 * Gets value
		 *
		 * @param defaultSupplier ignored
		 * @return value
		 */
		@Override
		public T getOrElse(Func0<T> defaultSupplier) {
			return value;
		}

		@Override
		public Try<T> inspect(Action1<T> ifSuccess, Action1<Exception> ifError) {
			ifSuccess.call(value);
			return this;
		}

		/**
		 * Returns a {@code Failure} containing
		 * an {@link UnsupportedOperation}.
		 *
		 * @return a {@code Failure}
		 */
		@Override
		public Try<Exception> invert() {
			return new Success<>(new UnsupportedOperation("Success.invert()"));
		}

		/**
		 * Returns {@code false}.
		 *
		 * @return {@code false}
		 */
		@Override
		public boolean isFailure() {
			return false;
		}

		/**
		 * Returns {@code true}.
		 *
		 * @return {@code true}
		 */
		@Override
		public boolean isSuccess() {
			return true;
		}

		@Override
		public <U> Try<U> map(Func1ThrowsE<T, U> mapper) {
			return Try.from(() -> mapper.call(value));
		}

		@Override
		public Try<T> mapError(Func1<Exception, Exception> errorMapper) {
			return this;
		}

		/**
		 * Returns this instance.
		 *
		 * @param defaultValue ignored
		 * @return this instance
		 */
		@Override
		public Try<T> orElse(Try<T> defaultValue) {
			return this;
		}

		/**
		 * Returns this instance.
		 *
		 * @param defaultSupplier ignored
		 * @return this instance
		 */
		@Override
		public Try<T> orElse(Func0<Try<T>> defaultSupplier) {
			return this;
		}

		@Override
		public <E extends Exception> T orElseThrow(Func1<Exception, E> errorMapper) throws E {
			return value;
		}

		@Override
		public Try<T> recover(Func1<Exception, T> recover) {
			return this;
		}

		@Override
		public Try<T> recoverWith(Func1<Exception, Try<T>> recover) {
			return this;
		}

		/**
		 * Converts to an {@link Optional} containing the value
		 *
		 * @return an {@link Optional} containing the value
		 */
		@Override
		public Optional<T> toOptional() {
			return Optional.ofNullable(value);
		}

		@Override
		public <U> Try<U> transform(Func1ThrowsE<T, U> ifSuccess, Func1ThrowsE<Exception, U> ifFailure) {
			return map(ifSuccess);
		}

		@Override
		public String toString() {
			return String.format("Success(%s)", value);
		}

		@Override
		public int hashCode() {
			return value != null ? value.hashCode() : 0;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (!(obj instanceof Success)) return false;
			Success<?> other = (Success<?>) obj;
			return Objects.equals(value, other.value);
		}

	}

	public static final class Failure<T> extends Try<T> {

		private final Exception error;

		public Failure(Exception error) {
			this.error = error;
		}

		public Failure(String errorMessage) {
			this.error = new Exception(errorMessage);
		}

		/**
		 * Returns this instance
		 *
		 * @param cls class to cast to
		 * @param <U> target type
		 * @return this instance
		 */
		@Override
		public <U> Try<U> as(Class<? extends U> cls) {
			return (Try<U>) this;
		}

		/**
		 * Gets exception.
		 *
		 * @return exception
		 */
		@Override
		public Exception error() {
			return error;
		}

		/**
		 * Returns this instance.
		 *
		 * @param filter predicate
		 * @return this instance
		 */
		@Override
		public Try<T> filter(Func1ThrowsE<T, Boolean> filter) {
			return this;
		}

		/**
		 * Returns this instance.
		 *
		 * @param filter predicate
		 * @return this instance
		 */
		@Override
		public Try<T> filter(Action1ThrowsE<T> filter) {
			return this;
		}

		@Override
		public <U> Try<U> flatMap(Func1ThrowsE<T, Try<U>> mapper) {
			return this.<U>map(null);
		}

		/**
		 * Throws an exception
		 *
		 * @return nothing
		 * @throws UnsupportedOperation always
		 */
		@Override
		public T get() {
			throw new UnsupportedOperation(error, "Failure.get()");
		}

		/**
		 * Returns default value
		 *
		 * @param defaultValue default value
		 * @return default value
		 */
		@Override
		public T getOrElse(T defaultValue) {
			return defaultValue;
		}

		/**
		 * Returns an object obtained from {@code defaultSupplier}.
		 *
		 * @param defaultSupplier supplies a value
		 * @return an object obtained from {@code defaultSupplier}
		 * @throws NullPointerException when {@code defaultSupplier} is {@code null}
		 */
		@Override
		public T getOrElse(Func0<T> defaultSupplier) {
			return defaultSupplier.call();
		}

		@Override
		public Try<T> inspect(Action1<T> ifSuccess, Action1<Exception> ifError) {
			ifError.call(error);
			return this;
		}

		/**
		 * Returns a {@code Success} containing the error.
		 *
		 * @return {@code Success}
		 */
		@Override
		public Try<Exception> invert() {
			return new Success<>(error);
		}

		/**
		 * Returns {@code true}.
		 *
		 * @return {@code true}
		 */
		@Override
		public boolean isFailure() {
			return true;
		}

		/**
		 * Returns {@code false}.
		 *
		 * @return {@code false}
		 */
		@Override
		public boolean isSuccess() {
			return false;
		}

		@Override
		public <U> Try<U> map(Func1ThrowsE<T, U> mapper) {
			// no point creating a new object:
			@SuppressWarnings("unchecked")
			Failure<U> other = (Failure<U>) this;
			return other;
		}

		@Override
		public Try<T> mapError(Func1<Exception, Exception> errorMapper) {
			return new Failure<>(errorMapper.call(error));
		}

		/**
		 * Returns {@code defaultValue}
		 *
		 * @param defaultValue returned value
		 * @return {@code defaultValue}
		 */
		@Override
		public Try<T> orElse(Try<T> defaultValue) {
			return defaultValue;
		}

		/**
		 * Returns an instance obtained from {@code defaultSupplier}
		 *
		 * @param defaultSupplier supplies a new object
		 * @return instance obtained from {@code defaultSupplier}
		 * @throws NullPointerException when {@code defaultSupplier} is null
		 */
		@Override
		public Try<T> orElse(Func0<Try<T>> defaultSupplier) {
			return defaultSupplier.call();
		}

		@Override
		public <E extends Exception> T orElseThrow(Func1<Exception, E> errorMapper) throws E {
			throw errorMapper.call(error);
		}

		@Override
		public Try<T> recover(Func1<Exception, T> recover) {
			return Try.from(() -> recover.call(error));
		}

		@Override
		public Try<T> recoverWith(Func1<Exception, Try<T>> recover) {
			return recover.call(error);
		}

		/**
		 * Returns an empty {@link Optional}
		 *
		 * @return empty {@link Optional}
		 */
		@Override
		public Optional<T> toOptional() {
			return Optional.empty();
		}

		@Override
		public <U> Try<U> transform(Func1ThrowsE<T, U> ifSuccess, Func1ThrowsE<Exception, U> ifFailure) {
			return Try.from(() -> ifFailure.call(error));
		}

		@Override
		public String toString() {
			return String.format("Failure(%s)", Optional.ofNullable(error).map(Exception::getMessage).orElse("?"));
		}

		@Override
		public int hashCode() {
			return error != null ? error.hashCode() : 0;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (!(obj instanceof Failure)) return false;
			Failure<?> other = (Failure<?>) obj;
			return Objects.equals(error, other.error);
		}

	}
}
