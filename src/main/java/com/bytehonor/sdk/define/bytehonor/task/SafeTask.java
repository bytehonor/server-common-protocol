package com.bytehonor.sdk.define.bytehonor.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lijianqiang
 *
 */
public abstract class SafeTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(SafeTask.class);

    @Override
    public void run() {
        if (LOG.isDebugEnabled()) {
        	LOG.debug("{} run", this.getClass().getSimpleName());
        }
        try {
            runInSafe();
        } catch (Exception e) {
            LOG.error("SafeTask error", e);
        }
    }

    public abstract void runInSafe();
}
