package jp.co.u_idea2.batch.jbbb01002;

import java.util.List;

/**
 * 区間搭乗者集計ジョブで使用するDAOインターフェース。
 * 
 */
public interface JBBB01002Dao {
    /**
     * 区間搭乗者情報を取得する。
     */
    List<RouteAggregationResultDto> findRouteAggregationByDepartureDateList();

}
