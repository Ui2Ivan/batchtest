package jp.co.u_idea2.batch.common.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 *  終了コードの管理
 *　監視レベルチェックできるようにする。
 *
 */
@Component
public class JobExitCodeChangeListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        // do nothing.
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        Collection<StepExecution> stepExecutions = jobExecution.getStepExecutions();
        for (StepExecution stepExecution : stepExecutions) {
            String exitCode = stepExecution.getExitStatus().getExitCode();

            if (exitCode != null && !exitCode.isEmpty()) {
                switch (exitCode) {
                    case "NORMAL":
                    case "NORMAL_NONE_TARGET":
                    case "WARNING":
                    case "BUSINESS_ERROR":
                    case "SYSTEM_ERROR":
                        jobExecution.setExitStatus(new ExitStatus(exitCode));
                        break;
                    default:
                        // do nothing.
                }
            }
        }
    }
}
