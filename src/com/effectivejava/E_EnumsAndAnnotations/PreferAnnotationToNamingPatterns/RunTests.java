package com.effectivejava.E_EnumsAndAnnotations.PreferAnnotationToNamingPatterns;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class RunTests {

    /**
     * The test runner tool takes a fully qualified class name on the command line
     * and runs all of the class’s Test-annotated methods reflectively, by calling
     * Method.invoke. The isAnnotationPresent method tells the tool which methods
     * to run. If a test method throws an exception, the reflection facility wraps it in an
     * InvocationTargetException. The tool catches this exception and prints a failure
     * report containing the original exception thrown by the test method, which is
     * extracted from the InvocationTargetException with the getCause method.
     */


    public static void main(String[] args) throws ClassNotFoundException {
        int tests=0;
        int passed=0;

        Class<?> testClass= Class.forName(args[0]);
        for(Method m : testClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(MyTest.class)){
                tests++;
                try{
                    m.invoke(null);
                    passed++;
                }catch (InvocationTargetException wrappedExp){
                    Throwable exc=wrappedExp.getCause();
                    System.out.println(m +" failed : "+exc);
                }catch (Exception e){
                    System.out.println("Invalid @MyTest: "+m);
                }
            }
        }

        System.out.println("Passed : "+passed + " ,Failed: "+ (tests-passed));
    }
}
