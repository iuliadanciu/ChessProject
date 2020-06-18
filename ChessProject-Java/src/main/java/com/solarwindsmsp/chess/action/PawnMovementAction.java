package com.solarwindsmsp.chess.action;

import com.solarwindsmsp.chess.Pawn;

public interface PawnMovementAction {

    boolean isMovementAction(Pawn pawn, int newX, int newY);

    void doAction(Pawn pawn, int newX, int newY);

    default boolean isPawnMovingUpOrDown(Pawn pawn, int newX, int newY) {
        return ((pawn.getYCoordinate() - newY) == 1)
                || (newY - pawn.getYCoordinate() == 1)
                && pawn.getXCoordinate() == newX;
    }

    default boolean isPawnMovingDiagonally(Pawn pawn, int newX, int newY) {
        return (pawn.getYCoordinate() - newY) == 1 || (newY - pawn.getYCoordinate() == 1) &&
                newX - pawn.getXCoordinate() == 1;
    }
}
