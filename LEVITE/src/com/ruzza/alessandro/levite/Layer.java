package com.ruzza.alessandro.levite;

import java.util.ArrayList;

public class Layer {

	private ArrayList<Neuron> neurons;
	
	public Layer(ArrayList<Float> gene, int nn)
	{
		neurons = new ArrayList<Neuron>();
		ArrayList<Float> val = new ArrayList<>();
		int d = gene.size()/nn;
		for(int i=0;i<nn;i++)
		{
			val.clear();
			for(int j=0;j<d;j++)
			{
				val.add(j, gene.get(i+j));
			}
			neurons.add(new Neuron((ArrayList<Float>) val.clone()));
		}
	}
	
	public ArrayList<Float> activate(ArrayList<Float> input)
	{
		/*
		 * Questa funzione riceve riceve in input i valori 
		 * di uscita dei neuroni del Layer precedente. Vengono quindi 
		 * dati "in pasto" alla funzione activate() di ciascun neurone.
		 * I valori di ritorno vengono immagazzinati in un Array e
		 *  ritornati dalla funzione, sarà poi la classe Rete che si
		 *  occuperà di inviarli al Layer successivo.
		 */
		
		ArrayList<Float> result = new ArrayList<>();
		for(Neuron neuron: neurons)
		{
			result.add(neuron.activate(input));
		}
		return result;
	}
}
