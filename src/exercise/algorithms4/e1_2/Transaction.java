package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.Date;

public class Transaction implements Comparable<Transaction>{

	private String who;
	private Date when;
	private double amount;
	
	public Transaction(String who, Date when, double amount){
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	
	public Transaction(String transaction){
		String[] fields = transaction.split(";");
        if (fields.length != 3) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.who = fields[0];
        this.when = new Date(fields[1]);
        this.amount = Double.parseDouble(fields[2]);
	}
	
	public String who(){
		return who;
	}
	public Date when(){
		return when;
	}
	public double amount(){
		return amount;
	}
	
	
	@Override
	public int compareTo(Transaction o) {
		if(this.amount > o.amount) return 1;
		if(this.amount < o.amount) return -1;
		return 0;
	}

	@Override
	public int hashCode() {
		return who.hashCode() + when.hashCode() + new Double(amount).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		Transaction transaction = (Transaction) obj;
		return (this.who.equals(transaction.who) 
				&& this.when.equals(transaction.when) 
				&& this.amount == transaction.amount);
	}

	@Override
	public String toString() {
		return who + " had a " + amount + " transaction on " + when;
	}
	

}
