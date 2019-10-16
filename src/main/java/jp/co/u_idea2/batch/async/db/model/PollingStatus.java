package jp.co.u_idea2.batch.async.db.model;

/**
 * Represent Polling Status.
 * <p>
 * Represent the simple progress of the job request and its job.
 * </p>
 * 
 * @since 5.0.0
 */
public enum PollingStatus {
    /**
     * Initial status.
     * <p>
     * Job request is not picked up, and no job is executed.
     * </p>
     */
    INIT,

    /**
     * Job request is picked up, and job is scheduled and executing.
     */
    POLLED,

    /**
     * Job request is picked up, and job is executed.
     */
    EXECUTED
}
