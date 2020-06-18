package com.solarwindsmsp.chess.action.impl;

import com.solarwindsmsp.chess.ChessBoard;
import com.solarwindsmsp.chess.Pawn;
import com.solarwindsmsp.chess.action.PawnMovementAction;

public class PawnCaptureAction implements PawnMovementAction {

    @Override
    public boolean isMovementAction(Pawn pawn, int newX, int newY) {
        ChessBoard chessBoard = pawn.getChesssBoard();
        return (this.isPawnMovingUpOrDown(pawn, newX, newY) || this.isPawnMovingDiagonally(pawn, newX, newY)) &&
                chessBoard.IsLegalBoardPosition(newX, newY) &&
                !chessBoard.isPositionFree(newX, newY);
    }

    @Override
    public void doAction(Pawn pawn, int newX, int newY) {
        if(this.isMovementAction(pawn, newX, newY)) {
            ChessBoard chessBoard = pawn.getChesssBoard();
            Pawn removablePawn = chessBoard.getPawn(newX, newY);
            removablePawn.setCoordinates(ChessBoard.OUT_COORDINATE, ChessBoard.OUT_COORDINATE);
            pawn.setCoordinates(newX, newY);
            chessBoard.setPawn(pawn);
        }
    }


}
