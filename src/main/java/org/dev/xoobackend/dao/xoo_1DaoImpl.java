package org.dev.xoobackend.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.dev.xoobackend.entities.xoo_1;
import org.dev.xoobackend.pojo.playedMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class xoo_1DaoImpl implements xoo_1Dao{

    private final EntityManager entityManager;

    public xoo_1DaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    String Session_id_gen (){
        int leftLimit = 33;
        int rightLimit = 125;
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    @Transactional
    public String CreateNewSession(String creator_name) {
        xoo_1 session = new xoo_1();
        session.setCreatorName(creator_name);
        entityManager.persist(session);
        return session.getSessionId();
    }

    @Override
    @Transactional
    public String JoinSession(String opponent_name, String session_id) {
        Query query = entityManager.createQuery("FROM xoo_1 where sessionId = :sessioId", xoo_1.class);
        query.setParameter("sessioId", session_id);
        xoo_1 session =  (xoo_1) query.getSingleResult();
        session.setOpponentName(opponent_name);
        entityManager.merge(session);
        return session.getCreatorName();
    }

    @Override
    @Transactional
    public String Xmove(String sessionId, int x, int y) {
        Query query = entityManager.createQuery("FROM xoo_1 where sessionId = :sessioId", xoo_1.class);
        query.setParameter("sessioId", sessionId);
        xoo_1 session =  (xoo_1) query.getSingleResult();
        session.setCurrentMoveRow(x);
        session.setCurrentMoveColumn(y);
        entityManager.merge(session);
        return "success";
    }

    @Override
    @Transactional
    public playedMove currentMove(String sessionId) {
        Query query = entityManager.createQuery("FROM xoo_1 where sessionId = :sessioId", xoo_1.class);
        query.setParameter("sessioId", sessionId);
        xoo_1 session =  (xoo_1) query.getSingleResult();

        return new playedMove(session.getCurrentMoveRow(),session.getCurrentMoveColumn());
    }

    @Override
    @Transactional
    public String winnerOfGame(String sessionId) {
        Query query = entityManager.createQuery("FROM xoo_1 where sessionId = :sessioId", xoo_1.class);
        query.setParameter("sessioId", sessionId);
        xoo_1 session =  (xoo_1) query.getSingleResult();
        return session.getWinnerName();
    }

    @Override
    @Transactional
    public String postWinnerOfGame(String sessionId, String winner) {
        Query query = entityManager.createQuery("FROM xoo_1 where sessionId = :sessioId", xoo_1.class);
        query.setParameter("sessioId", sessionId);
        xoo_1 session =  (xoo_1) query.getSingleResult();
        session.setWinnerName(winner);
        entityManager.merge(session);
        return "success";
    }

    @Override
    @Transactional
    public String getOpponentName(String sessionId) {
        String name="";
        Query query = entityManager.createQuery("FROM xoo_1 where sessionId = :sessioId", xoo_1.class);
        query.setParameter("sessioId", sessionId);
        xoo_1 session =  (xoo_1) query.getSingleResult();

        if (session.getOpponentName() == null) {
            name ="none";
        }
        else {
            name = session.getOpponentName();
        }

        return name;
    }

}
