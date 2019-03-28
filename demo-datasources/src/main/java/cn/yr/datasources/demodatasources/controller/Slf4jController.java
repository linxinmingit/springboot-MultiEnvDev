package cn.yr.datasources.demodatasources.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author
 * @since
 */
public class Slf4jController {
 
    private static final Logger logger = LoggerFactory.getLogger(Slf4jController.class);
 
    public static void main(String [] args) {
        logger.trace("log4j2 trace level");
        logger.debug("exit app");
        logger.info("out information");
    }
 
}