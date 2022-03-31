package examples;

import io.reactivex.rxjava3.core.Observable;

public class Add {

	public static void main(String[] args) {

		//create Observable using fromCallable()
		Observable<Integer> observable = Observable.fromCallable(() -> {
			return 1;
		});

		observable.subscribe((x) -> {
			System.out.println("Result " + (x + 2));
		});
	}
}
