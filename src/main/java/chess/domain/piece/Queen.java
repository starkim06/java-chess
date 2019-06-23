package chess.domain.piece;

import chess.domain.MovementUnit;
import chess.domain.Spot;
import chess.domain.Team;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {
    private final Set<MovementUnit> movementUnits;

    public Queen(Team team) {
        super(team);
        movementUnits = new HashSet<>();
        movementUnits.add(MovementUnit.RIGHT);
        movementUnits.add(MovementUnit.UP);
        movementUnits.add(MovementUnit.DIAGNOAL);
    }

    @Override
    public boolean isMovable(Spot startSpot, Spot endSpot) {
        int distanceX = startSpot.getX(endSpot);
        int distanceY = startSpot.getY(endSpot);

        return movementUnits.contains(MovementUnit.direction(distanceX, distanceY));
    }

    @Override
    public boolean isAttackable(Spot startSpot, Spot endSpot) {
        return isMovable(startSpot, endSpot);
    }
}
