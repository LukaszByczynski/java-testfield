package testfield.rx;

import java.util.concurrent.TimeUnit;
import io.reactivex.Flowable;

public class FlowableExample {

  public static void main(String[] args) {
    Flowable.interval(100, TimeUnit.MILLISECONDS).take(10).blockingSubscribe(item -> {
      System.out.println(item);
    });

  }

}
