package swen221.lambda.exceptionHandler2;

public class ReflectionHelper {
	public static interface SupplierWithException<T> {
		/*FIXME you may want to change code here*/
		T get() throws Throwable;
	}

	public static <T> T tryCatch(SupplierWithException<T> s) {
		/*FIXME add here the try-catching logic as from the text*/ return null;
	}
}
