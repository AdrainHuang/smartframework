package org.smart4j.framework.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作工具类
 * Created by AdrainHuang on 2017/2/12.
 */
public final class FileUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * 获取真实文件名（自动去掉文件路径）
	 */
	public static String getReadFileName(String fileName){
		return FilenameUtils.getName(fileName);
	}

	/**
	 * 创建文件
	 */
	public static File createFile(String filePath){
		File file;
		file = new File(filePath);
		File parentDir = file.getParentFile();
		if (!parentDir.exists()){
			try {
				FileUtils.forceMkdir(parentDir);
			} catch (IOException e) {
				LOGGER.error("create file failure",e);
				throw new RuntimeException(e);
			}
		}
		return file;
	}
}
