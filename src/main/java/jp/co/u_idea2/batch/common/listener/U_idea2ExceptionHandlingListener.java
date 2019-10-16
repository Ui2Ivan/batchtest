package jp.co.u_idea2.batch.common.listener;

import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

import jp.co.u_idea2.batch.common.exception.U_idea2BatchException;

@Component
public class U_idea2ExceptionHandlingListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        // do nothing.
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        // stepExecutionからエラー情報を取得する。
        List<Throwable> exceptions = stepExecution.getFailureExceptions();

        // エラー情報がない場合は、正常終了とする。
        if (exceptions.isEmpty()) {
            return new ExitStatus("NORMAL");
        }

        // エラー情報がある場合は、例外ハンドリングを行う。
        for (Throwable th : exceptions) {
            if (th instanceof U_idea2BatchException) {
                // 業務上で想定内のエラーの場合のジョブ終了コード
                return new ExitStatus("BUSINESS_ERROR");
            }
        }

        // 業務上で想定外のエラーの場合のジョブ終了コード
        return new ExitStatus("SYSTEM_ERROR");
    }
}
