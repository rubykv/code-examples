package examples;

import java.util.function.Consumer;

import io.reactivex.rxjava3.core.Observable;

public class AddSubtract {
	public static void main(String[] args) {

		//create Observable using just()
		Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

		Consumer<Integer> addValues = (x) -> System.out.println("Adding " + x + " ::" + (x + 2));
		Consumer<Integer> subValues = (x) -> System.out.println("Subtracting " + x + " :: " + (x - 1));

		observable.filter(x -> x > 1).subscribe(x -> addValues.accept(x));
		observable.filter(x -> x < 2).subscribe(x -> subValues.accept(x));
	}

}
