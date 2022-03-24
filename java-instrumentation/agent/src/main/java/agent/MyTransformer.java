package agent;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class MyTransformer implements ClassFileTransformer {

	public byte[] transform(ClassLoader loader, String className, Class classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		byte[] byteCode = classfileBuffer;

		//Add instrumentation to Sample class alone
		if (className.equals("myapp/Sample")) {
			try {
				ClassPool classPool = ClassPool.getDefault();
				CtClass ctClass = classPool.makeClass(new ByteArrayInputStream(classfileBuffer));
				CtMethod[] methods = ctClass.getDeclaredMethods();
				for (CtMethod method : methods) {
					method.insertAfter("System.out.println(\"adding end line..\");");
				}
				byteCode = ctClass.toBytecode();
				ctClass.detach();
			} catch (Throwable ex) {
				System.out.println("Exception: " + ex);
				ex.printStackTrace();
			}
		}
		return byteCode;
	}
}
