package swen221.lambda.exceptionHandler2;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;


public class ReflectionHelperTest {
	@Test
	public void testSuccess() {
		Class<String> s=String.class;
		int res = ReflectionHelper.tryCatch(() -> (Integer)s.getMethod("length").invoke("hi"));
		assertEquals(2, res);
	}
	@Test
	public void testIllegalAccess(){
		Class<String> s=String.class;
		try {
			ReflectionHelper.tryCatch(() -> s.getDeclaredMethod("indexOfNonWhitespace").invoke("hi",0,2));
			fail("");
		} catch (Error e) {
			assertEquals(IllegalAccessException.class, e.getCause().getClass());
		}
	}
	@Test
	public void testNoSuchMethodException(){
		Class<String> s=String.class;
		try {
			ReflectionHelper.tryCatch(() -> s.getMethod("mispelledMethodName").invoke("hi"));
			fail("");
		} catch (Error e) {
			assertEquals(NoSuchMethodException.class, e.getCause().getClass());
		}
	}
	@Test
	public void testInvocationTargetExceptionUnchecked(){
		Class<String> s=String.class;
		try {
			ReflectionHelper.tryCatch(() -> s.getMethod("charAt",int.class).invoke("hi",7));
			fail("");
		} catch (StringIndexOutOfBoundsException e) {/*success*/}
	}
	@Test
	public void testInvocationTargetExceptionChecked(){
		Class<?> s=Class.class;
		try {
			ReflectionHelper.tryCatch(() ->{
				Method m=s.getMethod("getMethod",String.class,Class[].class);
				return m.invoke(s,"mispelledMethodName",new Class[]{});
			});
			fail("");
		} catch (Error e) {
			assertEquals(e.getMessage(),"Unexpected checked exception");
			assertEquals(NoSuchMethodException.class, e.getCause().getClass());
		}

	}
}