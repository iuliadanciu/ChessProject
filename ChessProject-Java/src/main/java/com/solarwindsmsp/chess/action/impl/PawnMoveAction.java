package com.solarwindsmsp.chess.action.impl;

import com.solarwindsmsp.chess.Pawn;
import com.solarwindsmsp.chess.action.PawnMovementAction;

public class PawnMoveAction implements PawnMovementAction {

    @Override
    public boolean isMovementAction(Pawn pawn, int newX, int newY) {
        return pawn.getChesssBoard().IsLegalBoardPosition(newX, newY) &&
                this.isPawnMovingUpOrDown(pawn, newX, newY);
    }

    @Override
    public void doAction(Pawn pawn, int newX, int newY) {
        if(isMovementAction(pawn, newX, newY)) {
            pawn.setCoordinates(newX, newY);
        }
    }
}
