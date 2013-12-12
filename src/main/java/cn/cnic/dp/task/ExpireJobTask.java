package cn.cnic.dp.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("superJob")
public class ExpireJobTask {
    /** Logger */
	private static final Logger logger = LoggerFactory.getLogger(ExpireJobTask.class);
 
    /**
     * 业务逻辑处理
     */
    public void doBiz() {
    	System.out.println("i am running !");
    	logger.info("I am running");
    }
}
