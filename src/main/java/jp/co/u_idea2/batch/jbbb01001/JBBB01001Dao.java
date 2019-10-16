package jp.co.u_idea2.batch.jbbb01001;

import java.util.List;

/**
 * 予約情報集計ジョブで使用するDAOインターフェース。
 * 
 * @author NTT 電電次郎
 */
public interface JBBB01001Dao {

    /**
     * 予約集計情報を取得する。
     * 
     */
    List<ReservationResultDto> findReservationByReserveDateList();

}
