package org.dev.xoobackend.rest;

import jakarta.transaction.Transactional;
import org.dev.xoobackend.dao.xoo_1Dao;
import org.dev.xoobackend.pojo.exceptionHandle;
import org.dev.xoobackend.pojo.playedMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class postMethods {

    final xoo_1Dao xoo_1dao;

    public postMethods(xoo_1Dao xoo_1dao) {
        this.xoo_1dao = xoo_1dao;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/postmove")
    public String move(@RequestParam String sessionId, @RequestParam Integer X, @RequestParam Integer Y) {
        return xoo_1dao.Xmove(sessionId, X, Y);
    }

    @PostMapping("/createsession")
    public String createSession(@RequestParam String creator_name) {
        return xoo_1dao.CreateNewSession(creator_name);
    }

    @PostMapping("/joinsession")
    public String joinSession(@RequestParam String opponent_name, @RequestParam String sessionId) {
        return xoo_1dao.JoinSession(opponent_name, sessionId);
    }

    @PostMapping("/getmove")
    public playedMove getMove(@RequestParam String sessionId) {
        return xoo_1dao.currentMove(sessionId);
    }

    @PostMapping("/postwinner")
    public String postWinner(@RequestParam String winner_name, @RequestParam String sessionId) {
        return xoo_1dao.postWinnerOfGame(sessionId,winner_name);
    }

    @PostMapping("/getwinner")
    public String getWinner(@RequestParam String sessionId) {
        return xoo_1dao.winnerOfGame(sessionId);
    }

    @PostMapping("/getopponentname")
    public String getOpponentname(@RequestParam String sessionId) {
        return xoo_1dao.getOpponentName(sessionId);
    }


    @ExceptionHandler
    public ResponseEntity<exceptionHandle> handleException(Exception e) {
        // "Internal server error or Wrong session id"
        exceptionHandle exceptionHandle = new exceptionHandle(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionHandle);
    }



}
