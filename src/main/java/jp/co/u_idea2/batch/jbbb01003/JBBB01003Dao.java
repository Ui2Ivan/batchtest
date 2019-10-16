package jp.co.u_idea2.batch.jbbb01003;

import java.util.List;

/**
 * 運賃種別搭乗者情報集計ジョブで使用するDAOインターフェース。
 * 
 * @author NTT 電電次郎
 */
public interface JBBB01003Dao {

    /**
     * 運賃種別搭乗者情報を取得する。
     * 
     * @param object パラメータ
     */
    List<FareTypeAggregationResultDto> findFareTypeAggregationByDepartureDateList(Object object);

}
