package com.solarwindsmsp.chess;

import com.solarwindsmsp.chess.action.impl.PawnCaptureAction;
import com.solarwindsmsp.chess.action.impl.PawnMoveAction;
import com.solarwindsmsp.chess.action.PawnMovementAction;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;
    private PawnMovementAction pawnMovementAction;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    public void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void Move(MovementType movementType, int newX, int newY) {
        this.setPawnMovementAction(movementType);
        pawnMovementAction.doAction(this, newX, newY);
    }

    public void setPawnMovementAction(MovementType movementType) {
        if (MovementType.MOVE.equals(movementType)) {
            pawnMovementAction = new PawnMoveAction();
        } else if (MovementType.CAPTURE.equals(movementType)) {
            pawnMovementAction = new PawnCaptureAction();
        }
    }

    public void setCoordinates(int outCoordinate, int outCoordinate2) {
        this.setXCoordinate(outCoordinate);
        this.setYCoordinate(outCoordinate2);
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
