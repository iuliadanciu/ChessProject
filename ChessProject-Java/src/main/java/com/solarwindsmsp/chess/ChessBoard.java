package com.solarwindsmsp.chess;

public class ChessBoard {
    public static final int MIN_BOARD_SIZE = 0;
    public static final int OUT_COORDINATE = -1;
    private static final int BLACK_BOARD_HEIGHT = 6;
    private static final int WHITE_BOARD_HEIGHT = 1;
    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[ChessBoard.MAX_BOARD_WIDTH][ChessBoard.MAX_BOARD_HEIGHT];
    }

    public Pawn getPawn(int xCoordinate, int yCoordinate) {
        return this.pieces[xCoordinate][yCoordinate];
    }

    public void setPawn(Pawn pawn) {
        this.pieces[pawn.getXCoordinate()][pawn.getYCoordinate()] = pawn;
    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (this.IsLegalBoardPosition(xCoordinate, yCoordinate ) && this.isLegalColor(xCoordinate, pieceColor)) {
            pawn.setPieceColor(pieceColor);
            pawn.setChessBoard(this);
            pawn.setCoordinates(xCoordinate, yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        } else {
            pawn.setCoordinates(ChessBoard.OUT_COORDINATE, ChessBoard.OUT_COORDINATE);
        }
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return this.areValidCoordinates(xCoordinate, yCoordinate) &&
                isPositionFree(xCoordinate, yCoordinate);
    }

    public boolean isPositionFree(int xCoordinate, int yCoordinate) {
        return this.getPawn(xCoordinate, yCoordinate) == null;
    }

    private boolean areValidCoordinates(int xCoordinate, int yCoordinate) {
        return xCoordinate >= ChessBoard.MIN_BOARD_SIZE && xCoordinate < ChessBoard.MAX_BOARD_WIDTH &&
                yCoordinate >= ChessBoard.MIN_BOARD_SIZE && yCoordinate < ChessBoard.MAX_BOARD_HEIGHT;

    }

    private boolean isLegalColor(int xCoordinate, PieceColor pieceColor) {
        return ((xCoordinate >= BLACK_BOARD_HEIGHT && xCoordinate < MAX_BOARD_HEIGHT && PieceColor.BLACK.equals(pieceColor))
                || (xCoordinate <= WHITE_BOARD_HEIGHT && xCoordinate > MIN_BOARD_SIZE && PieceColor.WHITE.equals(pieceColor)));

    }
}
