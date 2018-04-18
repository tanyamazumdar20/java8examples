package javaeightinpractice;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
  public int compare(T t1, T t2);

  public default Comparator<T> thenComparing(Comparator<T> cmp) {
    return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
  }

  public default Comparator<T> thenComparing(Function<T, Comparable> f) {
   //Comparator<T> cmp = comparing(f);
    //return (p1, p2) -> -1;
    //or
    //return thenComparing(cmp);
    //or
    return thenComparing(comparing(f));
  }

/*
//works only for cmpPersonAge
  public static Comparator<Person> comparing(Function<Person, Integer> f) {
    return (p1, p2) -> f.apply(p1) - f.apply(p2);
  }
*/

/*//works for cmpPersonAge, cmpPersonLastName, cmpPersonFirstName
  public static Comparator<Person> comparing(Function<Person, Comparable> f) {
    return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
  }*/

  // Or
  //works for cmpPersonAge, cmpPersonLastName, cmpPersonFirstName
  public static <U> Comparator<U> comparing(Function<U, Comparable> f) {
    return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
  }


}


