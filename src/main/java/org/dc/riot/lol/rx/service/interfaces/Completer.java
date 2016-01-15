package org.dc.riot.lol.rx.service.interfaces;

/**
 * Some fields come back empty from the server,
 * this interface allows for some obvious fields to be
 * filled out.
 * 
 * @author Dc
 * @since 1.0.0
 *
 * @param <T>
 */
interface Completer<T> {
	T fill(T t);
}
