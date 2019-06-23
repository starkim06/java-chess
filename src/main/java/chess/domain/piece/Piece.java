package chess.domain.piece;

import chess.domain.Spot;
import chess.domain.Team;

public abstract class Piece {
    private Team team;

    Piece(Team team) {
        this.team = team;
    }

    public boolean empty() {
        return team.isEmpty();
    }

    public boolean sameTeam(Piece piece) {
        return team.isSameTeam(piece.team);
    }

    public abstract boolean isMovable(Spot startSpot, Spot endSpot);

    public abstract boolean isAttackable(Spot startSpot, Spot endSpot);

}
