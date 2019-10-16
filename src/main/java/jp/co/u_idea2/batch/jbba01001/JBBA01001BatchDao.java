package jp.co.u_idea2.batch.jbba01001;

import jp.co.u_idea2.batch.jbba00.FlightDto;

/**
 * フライト情報更新ジョブで使用するDAOインターフェース。
 * 
 * @author NTT 電電太郎
 */
public interface  JBBA01001BatchDao {

    /**
     * フライト情報を登録する。
     * 
     * @param flightDto フライト情報テーブルオブジェクト
     * @return フライト情報登録件数
     */
    int insertFlight(FlightDto flightDto);

}
