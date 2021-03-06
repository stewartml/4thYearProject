package fastmatrices;


public class TestFast
{
	public static void main(String[] args)
	{
		Matrix data = Utilities.csvread("../agent/logs/BLINKY.txt");
		Matrix x = data.part(1, -1, 1, -5);
		Matrix y = data.part(1, -1, -4, -1);
		
		long time = System.currentTimeMillis();
		
		NeuralNetwork net = new NeuralNetwork(x.columns, 10, 4);
		net.train(x, y, 0.2, 1000);
		
		System.out.println("time: " + (System.currentTimeMillis() - time));
		
		Matrix predicted = new Matrix(net.bulkPredict(x));
		double err = Utilities.confusion(y, predicted);
		System.out.println(err);
	}
}
