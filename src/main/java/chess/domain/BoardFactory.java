package chess.domain;

import chess.domain.piece.*;

import java.util.HashMap;
import java.util.Map;

public class BoardFactory {
    public static Board create() {
        Map<Spot, Piece> spots = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                spots.put(Spot.valueOf(i, j), Empty.getInstance());
            }
        }
        initPieces(Team.BLACK, spots);
        initPieces(Team.WHITE, spots);

        return new Board(spots);
    }

    private static void initPieces(Team team, Map<Spot, Piece> spots) {
        initPawns(team, spots);
        initOthers(team, spots);
    }

    private static void initPawns(Team team, Map<Spot, Piece> spots) {
        int column = getPawnColumn(team);
        for (int i = 0; i < 8; i++) {
            spots.replace(Spot.valueOf(i, column), new Pawn(team));
        }
    }

    private static void initOthers(Team team, Map<Spot, Piece> spots) {
        int column = getColumn(team);
        spots.replace(Spot.valueOf(0, column), new Rook(team));
        spots.replace(Spot.valueOf(1, column), new Knight(team));
        spots.replace(Spot.valueOf(2, column), new Bishop(team));
        spots.replace(Spot.valueOf(3, column), new Queen(team));
        spots.replace(Spot.valueOf(4, column), new King(team));
        spots.replace(Spot.valueOf(5, column), new Bishop(team));
        spots.replace(Spot.valueOf(6, column), new Knight(team));
        spots.replace(Spot.valueOf(7, column), new Rook(team));
    }

    private static int getColumn(Team team) {
        if (team == Team.BLACK) {
            return 0;
        }
        return 7;
    }

    private static int getPawnColumn(Team team) {
        if (team == Team.BLACK) {
            return 1;
        }
        return 6;
    }


}
