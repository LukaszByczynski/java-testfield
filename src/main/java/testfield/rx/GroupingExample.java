package testfield.rx;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import io.reactivex.Flowable;

class GroupingExample {
  public static void main(String[] args) {

    Random random = new Random();

    Flowable.interval(10, TimeUnit.MILLISECONDS).take(100000000).map(e -> random.nextInt(100))
        .groupBy(e -> e % 10).flatMap(e -> e.window(10)).blockingSubscribe(e -> {
          System.out.println(e.toList().blockingGet());
        });
  }
}
