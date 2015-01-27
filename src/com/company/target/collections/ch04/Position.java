package com.company.target.collections.ch04;

/**
 * Œª÷√
 */
public class Position {

	private int row, column;

	public Position() {
		row = 0;
		column = 0;
	} // default constructor

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	} // method set

	public int row() {

		return row;

	} // method row

	public int column() {

		return column;

	} // method column

}
