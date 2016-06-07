package com.phly.common.base.action.upload;

import java.io.File;

public class UploadConstants {
	//文件保存路径
	public static String UPLOAD_FILE_PATH = File.separator + "upload" + File.separator +"user"+File.separator;
	//临时文件保存路径
	public static String UPLOAD_TEMP_FILE_PATH = File.separator + "upload_temp" + File.separator +"user"+File.separator;
	//md5file
	public static String MD5_FILE_SUFFIX = ".cfg";
	//上中的临时文件后缀
	public static String UPLOADING_TEMP_FILE_SUFFIX = ".parttmp";
	//上传后的临时文件后缀
	public static String UPLOAD_TEMP_FILE_SUFFIX = ".part";
	
	
	//供应商上传营业执照路径
	public static String UPLOAD_IMG_PATH_GONGYINGSHANG = "/upload/gongyingshang/";
}
