package org.dev.xoobackend.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.dev.xoobackend.dao.*;

import java.util.Random;

@Entity
@Table(name = "xoo_1")
public class xoo_1 {


    @Id
    private String sessionId;
    

    @Column(name = "creator_name")
    private String creatorName;

    @Column(name = "opponrnt_name")
    private String opponentName;

    @Column(name = "current_move_row")
    private int currentMoveRow;

    @Column(name = "current_move_column")
    private int currentMoveColumn;

    @Column(name = "result")
    private String winnerName;

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public xoo_1(String sessionId, String creatorName, String opponentName, int currentMoveRow, int currentMoveColumn, String winnerName) {
        this.sessionId = sessionId;
        this.creatorName = creatorName;
        this.opponentName = opponentName;
        this.currentMoveRow = currentMoveRow;
        this.currentMoveColumn = currentMoveColumn;
        this.winnerName = winnerName;
    }

    public xoo_1() {
        sessionId = Session_id_gen();
    }

    private String Session_id_gen() {
        int leftLimit = 48;
        int rightLimit = 57;
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public int getCurrentMoveRow() {
        return currentMoveRow;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public void setCurrentMoveRow(int currentMoveRow) {
        this.currentMoveRow = currentMoveRow;
    }

    public void setCurrentMoveColumn(int currentMoveColumn) {
        this.currentMoveColumn = currentMoveColumn;
    }

    public int getCurrentMoveColumn() {
        return currentMoveColumn;
    }
}
