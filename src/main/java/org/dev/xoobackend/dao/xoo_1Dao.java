package org.dev.xoobackend.dao;

import org.dev.xoobackend.pojo.playedMove;

public interface xoo_1Dao {
    String CreateNewSession(String creator_name);
    String JoinSession(String opponent_name, String session_id);
    String Xmove (String sessionId ,int x, int y);
    playedMove currentMove (String sessionId);
    String winnerOfGame(String sessionId);
    String postWinnerOfGame(String sessionId, String winner);
    String getOpponentName(String sessionId);

}
