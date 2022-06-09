package com.db.aibiui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tensorflow.ConcreteFunction;
import org.tensorflow.Signature;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;
import org.tensorflow.op.Ops;
import org.tensorflow.op.core.Placeholder;
import org.tensorflow.op.math.Add;
import org.tensorflow.types.TInt32;

@SpringBootApplication
public class AiBiUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiBiUiApplication.class, args);
	}


//	public static void main(String[] args) {
//		System.out.println("Hello TensorFlow " + TensorFlow.version());
//
//		try (ConcreteFunction dbl = ConcreteFunction.create(AiBiUiApplication::dbl);
//			 TInt32 x = TInt32.scalarOf(10);
//			 Tensor dblX = dbl.call(x)) {
//			System.out.println(x.getInt() + " doubled is " + ((TInt32)dblX).getInt());
//		}
//		SpringApplication.run(AiBiUiApplication.class, args);
//	}

	private static Signature dbl(Ops tf) {
		Placeholder<TInt32> x = tf.placeholder(TInt32.class);
		Add<TInt32> dblX = tf.math.add(x, x);
		return Signature.builder().input("x", x).output("dbl", dblX).build();
	}


}