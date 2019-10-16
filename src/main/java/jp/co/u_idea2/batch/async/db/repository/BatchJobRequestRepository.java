package jp.co.u_idea2.batch.async.db.repository;

import jp.co.u_idea2.batch.async.db.model.BatchJobRequest;
import jp.co.u_idea2.batch.async.db.model.PollingStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Batch Job Request Table Repository.
 * <p>
 * Batch Job Request Table access interface with MyBatis. Bean is created by {@code <mybatis:scan>} in xml application context
 * file.
 * </p>
 * 
 * @since 5.0.0
 */
public interface BatchJobRequestRepository {

    /**
     * Retrieve Batch Job Request Table by any parameters.
     * 
     * @param parameters Query parameters.
     * @return List of job requests that match the conditions. When data not found, return empty list.
     */
    List<BatchJobRequest> find(Map<String, Object> parameters);

    /**
     * Update Batch Job Request Table polling status.
     *
     * @param batchJobRequest Updated data.
     * @param pollingStatus Update condition of polling status.
     * @return Updated record number.
     */
    int updateStatus(@Param("batchJobRequest") BatchJobRequest batchJobRequest,
                     @Param("pollingStatus") PollingStatus pollingStatus);

}
