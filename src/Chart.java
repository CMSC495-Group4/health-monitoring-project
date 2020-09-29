import java.util.Arrays;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 * Chart Class.
 * This class creates a chart to track user progress. 
 * 
 * @author Todd Weber
 *
 */
public class Chart{
	
	private String X_Axis = null;
	private String Y_Axis = null;
	private String chartTitle = null;
	private String [] dataset_array = null;
	private int goal = 0;
	private String set_label = "Weight history";

	/**
	 * Class Constructor.
	 * 
	 * @param chartTitle	a string title for the chart.
	 * @param X_Axis		a sting title for the x axis.
	 * @param Y_Axis		a string title for the y axis.
	 * @param bios			a string array of biometric data. Array length of 20. Uses indices 6 - 19.
	 *
	 */
	public Chart(String chartTitle, String X_Axis, String Y_Axis, String[] bios) {
		
		this.X_Axis = X_Axis;
		this.Y_Axis = Y_Axis;
		this.chartTitle = chartTitle;
		dataset_array = Arrays.copyOfRange(bios, 6, 20);
		goal = Integer.parseInt(bios[5]);
	}
	/**
	 * Creates and returns the JFreeChart based on the class variables.
	 *
	 * @return	JFreeChart
	 */
	public JFreeChart createchart() {
		
		 JFreeChart lineChart = ChartFactory.createLineChart(
		         chartTitle, X_Axis, Y_Axis, createDataset(),
		         PlotOrientation.VERTICAL,true,true,false);	
		
		return lineChart;
		
	}

	/**
	 * Creates a DefaultCategoryDataset that is used to create the JFreeChart.
	 * 
	 * @return DefaultCategoryDataset representing user and goal data. 
	 */
	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		for (int i=0; i<dataset_array.length; i++){
			System.out.println(dataset_array[i]);
			if (!dataset_array[i].equals("null")) 
	    		  dataset.addValue(Integer.parseInt(dataset_array[i]), set_label,""+(14-i));
	    	  dataset.addValue(goal, "Goal", ""+(14-i));
	      }	    	  
	      return dataset;
	}
}
