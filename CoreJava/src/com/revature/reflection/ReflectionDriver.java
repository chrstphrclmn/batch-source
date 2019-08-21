package com.revature.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.revature.shapes.Rectangle;

public class ReflectionDriver {

	public static void main(String[] args) {
		try {
			Class<?> class1 = Class.forName("com.revature.shapes.Rectangle");
			System.out.println("Class name: " + class1.getName());
			System.out.println("Superclass: " + class1.getSuperclass());
			
			Class<?>[] interfaces = class1.getSuperclass().getInterfaces();
			for(Class<?> inter:interfaces) {
				System.out.println(inter);
			}
			
			System.out.println("methods: ");
			Method[] methods= class1.getDeclaredMethods();
			for(Method method:methods) {
				System.out.println(method);
			}
			
			System.out.println("fields: ");
			Field[] fields= class1.getFields();
			for(Field field:fields) {
				System.out.println(field);
			}
			Rectangle rectangle = (Rectangle)class1.newInstance();
			System.out.println(rectangle);
			
			Field widthField = class1.getDeclaredField("width");
			widthField.setAccessible(true);
			widthField.set(rectangle, 20);
			System.out.println(rectangle);
			
			Method setHeightMethod = class1.getDeclaredMethod("setHeight", int.class);
			setHeightMethod.invoke(rectangle, 5);
			System.out.println(rectangle.getHeight());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
