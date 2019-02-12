/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.alm.responsesubscriber.converters;

/**
 * Description
 *
 * @author amit26si00, created 31-Jan-2019
 */
public interface Converter<S, T> {

	public T convert(S responseEvent) throws Exception;
}
