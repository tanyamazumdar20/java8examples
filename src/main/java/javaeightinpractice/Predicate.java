package javaeightinpractice;

@FunctionalInterface
public interface Predicate<T> {

  public  boolean test(T t);

  /*a functional interface can have only one abstract method,
  * More than one abstract method will show compiler error,
  * so changing and method to default method and it should have implementation*/
  public default Predicate<T> and(Predicate<T> other){
    return t -> test(t) && other.test(t);
  }

  public default Predicate<T> or(Predicate<T> other){
    return t -> test(t) || other.test(t);
  }

  /*public static Predicate<String> isEqualsTo(String string){
    return s -> s.equals(string);
  }*/
  //or
  public static <U> Predicate<U> isEqualsTo(U u){
    return s -> s.equals(u);
  }
}
