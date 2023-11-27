package gov.omsb.mobile.sdk.headless.client.function;

import javax.annotation.Generated;

/**
 * @author Niddhi Thacker
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}