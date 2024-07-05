package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.cell.Cell;
import cleancode.minesweeper.tobe.cell.EmptyCell;
import cleancode.minesweeper.tobe.cell.LandMineCell;
import cleancode.minesweeper.tobe.cell.NumberCell;
import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.position.CellPosition;
import cleancode.minesweeper.tobe.position.RelativePosition;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class GameBoard {

	private final Cell[][] board;
	private final int landMineCount;

	public GameBoard(GameLevel gameLevel) {
		int colSize = gameLevel.getColSize();
		int rowSize = gameLevel.getRowSize();
		board = new Cell[rowSize][colSize];

		landMineCount = gameLevel.getLandMineCount();
	}

	public void flagAt(CellPosition cellPosition) {
		Cell cell = findCell(cellPosition);
		cell.flag();
	}

	public void openAt(CellPosition cellPosition) {
		Cell cell = findCell(cellPosition);
		cell.open();
	}

	public void openSurroundedCells(CellPosition cellPosition) {
		if (isOpenedCellAt(cellPosition)) {
			return;
		}
		if (isLandMineCellAt(cellPosition)) {
			return;
		}

		openAt(cellPosition);

		if (doesCellHaveLandMineCount(cellPosition)) {
			return;
		}

		List<CellPosition> surroundedPositions = calculateSurroundedPositions(cellPosition, getRowSize(), getColSize());
		surroundedPositions.forEach(this::openSurroundedCells);
	}

	private boolean doesCellHaveLandMineCount(CellPosition cellPosition) {
		Cell cell = findCell(cellPosition);
		return cell.hasLandMineCount();
	}

	private boolean isOpenedCellAt(CellPosition cellPosition) {
		Cell cell = findCell(cellPosition);
		return cell.isOpened();
	}

	public boolean isLandMineCellAt(CellPosition cellPosition) {
		Cell cell = findCell(cellPosition);
		return cell.isLandMine();
	}

	public boolean isAllCellChecked() {
		return Arrays.stream(board)
			.flatMap(Arrays::stream)
			.allMatch(Cell::isChecked);
	}

	public boolean isInvalidCellPosition(CellPosition cellPosition) {
		int rowSize = getRowSize();
		int colSize = getColSize();

		return cellPosition.isRowIndexMoreThanOrEqual(rowSize) ||
			cellPosition.isColIndexMoreThanOrEqual(colSize);
	}

	public void initializeGame() {
		int rowSize = getRowSize();
		int colSize = getColSize();

		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				board[row][col] = new EmptyCell();
			}
		}

		for (int i = 0; i < landMineCount; i++) {
			int landMineCol = new Random().nextInt(colSize);
			int landMineRow = new Random().nextInt(rowSize);
			board[landMineRow][landMineCol] = new LandMineCell();
		}

		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				CellPosition cellPosition = CellPosition.of(row, col);

				if (isLandMineCellAt(cellPosition)) {
					continue;
				}
				int count = countNearbyLandMines(cellPosition);
				if (count == 0) {
					continue;
				}
				board[row][col] = new NumberCell(count);
			}
		}
	}

	private int countNearbyLandMines(CellPosition cellPosition) {
		int rowSize = getRowSize();
		int colSize = getColSize();

		long count = calculateSurroundedPositions(cellPosition, rowSize, colSize)
			.stream()
			.filter(this::isLandMineCellAt)
			.count();

		return (int) count;
	}

	private static List<CellPosition> calculateSurroundedPositions(CellPosition cellPosition, int rowSize, int colSize) {
		return RelativePosition.SURROUNDED_POSITIONS.stream()
			.filter(cellPosition::canCalculatePositionBy)
			.map(cellPosition::calculatePositionBy)
			.filter(position -> position.isRowIndexLessThan(rowSize))
			.filter(position -> position.isColIndexLessThan(colSize))
			.toList();
	}

	public String getSign(CellPosition cellPosition) {
		Cell cell = findCell(cellPosition);
		return cell.getSign();
	}

	private Cell findCell(CellPosition cellPosition) {
		return board[cellPosition.getRowIndex()][cellPosition.getColIndex()];
	}

	public int getRowSize() {
		return board.length;
	}

	public int getColSize() {
		return board[0].length;
	}
}