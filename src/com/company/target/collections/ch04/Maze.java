package com.company.target.collections.ch04;

import java.util.Iterator;

/**
 * 迷宫
 */
public class Maze implements Application {

	private static final byte WALL = 0;
	private static final byte CORRIDOR = 1;
	private static final byte PATH = 9;
	private static final byte TRIED = 2;

	protected Position finish;
	protected byte[][] grid;

	// Postcondition: this Maze has been initialized from grid and finish.
	public Maze(byte[][] grid, Position finish) {
		this.finish = finish;
		this.grid = grid;
	} // 2-parameter constructor

	/**
	 * 校验当前路径
	 */
	@Override
	public boolean valid(Position pos) {
		if (pos.row() >= 0 && pos.row() < grid.length && pos.column() >= 0
				&& pos.column() < grid[0].length
				&& grid[pos.row()][pos.column()] == CORRIDOR) {
			return true;
		}
		return false;
	}

	/**
	 * 标记成功的路径
	 */
	@Override
	public void record(Position pos) {
		grid[pos.row()][pos.column()] = PATH;
	}

	/**
	 * 
	 */
	@Override
	public boolean done(Position pos) {
		return pos.row() == finish.row() && pos.column() == finish.column();
	}

	@Override
	public void undo(Position pos) {
		grid[pos.row()][pos.column()] = TRIED;
	}

	@Override
	public Iterator<Position> iterator(Position pos) {
		return new MazeIterator(pos);
	}

	@Override
	public String toString() {
		String result = "\n";

		for (int row = 0; row < grid.length; row++) {

			for (int column = 0; column < grid[0].length; column++)
				result += String.valueOf(grid[row][column]) + ' ';
			result += "\n";
		}
		return result;
	}

	/**
	 * 迭代器：内部类
	 * 		作用：获取可行路径
	 */
	private class MazeIterator implements Iterator<Position> {

		int row, column, count = 0;

		public MazeIterator(Position pos) {
			row = pos.row();
			column = pos.column();
		}

		@Override
		public boolean hasNext() {
			return count < 4;
		}

		@Override
		public Position next() {
			Position nextPosition = new Position();
			switch (count++) {
			case 0:
				nextPosition = new Position(row - 1, column); // north
				break;
			case 1:
				nextPosition = new Position(row, column + 1); // east
				break;
			case 2:
				nextPosition = new Position(row + 1, column); // south
				break;
			case 3:
				nextPosition = new Position(row, column - 1); // west
			}
			return nextPosition;
		}

		@Override
		public void remove() {}
	}

}
