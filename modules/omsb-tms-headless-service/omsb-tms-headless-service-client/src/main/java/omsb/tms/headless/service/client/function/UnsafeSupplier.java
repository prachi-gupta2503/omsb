package omsb.tms.headless.service.client.function;

import javax.annotation.Generated;

/**
 * @author AftabA
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}