package org.dc.riot.lol.rx.service;

import java.util.concurrent.Callable;

import rx.Observable;
import rx.Subscriber;

/**
 * Factory helper to create functional {@link Observable} instances.
 * Typical use case for this class is to help in creating the first
 * {@link Observable} in a chain.
 * <pre>
 * {@code}
	RiotApi.Champion champInterface = factory.newChampionInterface(region, true);
	ObservableFactory.create(() -> {
		return champInterface.getChampions(true);
	})
	.subscribe((ChampionListDto dto) -> {
		... Process champions ...
	},
	(Throwable e) -> {
		e.printStackTrace();
	},
	() -> {
		System.out.println("Done");
	});
 * </pre>
 * 
 * @author Dc
 * @since 1.0
 *
 * @param <T>
 */
public class ObservableFactory<T> {

	private ObservableFactory() { }

	/**
	 * 
	 * @param callable {@link Callable} that should make a single API call
	 * and return the result
	 * @return an {@link Observable} that will emit the object returned by callable
	 */
	public static <T> Observable<T> create(final Callable<T> callable) {
		return Observable.create((Subscriber<? super T> s) -> {
			try {
				T t = callable.call();
				s.onNext(t);
				s.onCompleted();
			} catch (Exception e) {
				s.onError(e);
			}
		});
	}

}
