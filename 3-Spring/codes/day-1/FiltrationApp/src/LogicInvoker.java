@FunctionalInterface
public interface LogicInvoker<T> {
	boolean apply(T num);
}

/*
@FunctionalInterface
public interface Predicate<T> {
	boolean test(T value);
} 
 */

/*
@FunctionalInterface
public interface Function<T,R> {
	R apply(T value);
} 
@FunctionalInterface
public interface BiFunction<T,U,R> {
	R apply(T value1, U value2);
} 
 */
