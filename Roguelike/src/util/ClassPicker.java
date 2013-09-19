package util;

import java.util.List;

import roguelike.Roguelike;


public class ClassPicker {
	private List<Class<?>> list;
	private int[] weights;
	
	public ClassPicker(){} 
	
	public ClassPicker(List<Class<?>> list) {
		this.list = list;
		
		this.weights = new int[list.size()];
		for(int i = 0; i < this.list.size(); i++) {
			this.weights[i] = 1;
		}
	}
	
	public ClassPicker(List<Class<?>> list, int[] weights) {
		this(list);
		
		this.weights = weights;
	}
	
	public Class<?> pickRandomClass() {
		int sum = 0;
		int rand, pick;

		// sum of weights
		for(int i = 0; i < this.list.size(); i++) {
			sum += this.weights[i];
		}
		
		// get random value
		rand = Roguelike.getRNG().nextInt(sum) + 1;
		
		// pick value
		sum = 0;
		pick = -1;
		
		do {
			pick++;
			sum += this.weights[pick];
		} while(sum < rand);
		
		return this.list.get(pick);
		
	};
}
