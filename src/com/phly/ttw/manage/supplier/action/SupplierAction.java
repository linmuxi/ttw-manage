/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.supplier.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phly.common.base.action.BaseAction;
import com.phly.common.base.action.upload.UploadConstants;

import com.phly.common.exceptionhandler.annotation.ExceptionMessage;
import com.phly.ttw.manage.supplier.facade.SupplierFacade;
import com.phly.ttw.manage.supplier.model.SupplierVO;

/**
 *
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月9日 下午7:05:02
 */

@Controller
@RemoteProxy
public class SupplierAction extends BaseAction{
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private SupplierFacade sysSupplierFacade;
	


	@RequestMapping("/page/business/manage/supplier/index")
	@ResponseBody
	public ModelMap querySupplierList(HttpServletRequest request,SupplierVO supplierVO) {
		wrapDatatableParams(request, supplierVO);
		return this.sysSupplierFacade.querySupplieList(supplierVO);
	}

	/**
	 * 添加供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap addSupplier(SupplierVO supplierVO) {
		return this.sysSupplierFacade.addSupplier(supplierVO);
	}
	
	/**
	 * 根据供应商ID查询供应商
	 * @param supplierVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap getSupplier(SupplierVO supplierVO){
		return this.sysSupplierFacade.getSupplier(supplierVO);
	}

	/**
	 * 修改供应商
	 * 
	 * @param SupplierVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap updateSupplier(SupplierVO supplierVO) {
		return this.sysSupplierFacade.updateSupplier(supplierVO);
	}

	/**
	 * 删除供应商
	 * 
	 * @param delSupplier
	 * @return
	 */
	@RemoteMethod
	public ModelMap delSupplier(SupplierVO supplierVO) {
		return this.sysSupplierFacade.delSupplier(supplierVO);
	}

	/**
	 * 编辑供应商
	 * @param supplierVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap formSupplier(SupplierVO supplierVO) {
		return this.sysSupplierFacade.formSupplier(supplierVO);
	}
	
	
	/**
	 * 导出供应商信息
	 */
	@RequestMapping("/page/business/manage/supplier/supplierExportExcel")
	@ExceptionMessage("供应商导出异常")
	public ModelAndView exportSupplier(HttpServletRequest request,SupplierVO supplierVO) {
		ModelAndView mav = new ModelAndView();
		try {
			logger.info(this.getClass().getName() + "  exportSupplier  供应商导出");
			 List<SupplierVO> supplierLst = this.sysSupplierFacade.querySupplieList();
			 mav.setViewName("/page/business/manage/supplier/supplierExportExcel.jsp");
			 mav.addObject("supplier", supplierLst);
		} catch (Exception e) {
			logger.error(this.getClass().getName() + "  exportSupplier 供应商导出异常： " + e);
			e.printStackTrace();
		}
		return mav;
	}
	
	
	
	@RequestMapping("/uploadImg")
	public String uploadImg(HttpServletRequest request,
			HttpServletResponse response) {
		String newFilename = "";
		String nowTimeStr = "";
		String realpath = request.getSession().getServletContext()
				.getRealPath("/");
		String fileDir = UploadConstants.UPLOAD_IMG_PATH_GONGYINGSHANG;
		String savePath = realpath + fileDir;
		File destFile = new File(savePath);
		if (!destFile.exists()) {
			destFile.mkdirs();
		}
		SimpleDateFormat sDateFormat;
		Random r = new Random();

		int rannum = (int) (r.nextDouble() * (99999 - 1000 + 1)) + 10000;
		sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		nowTimeStr = sDateFormat.format(new Date());
		String filename = request.getHeader("X-File-Name");
		String extName = "";
		if (filename.lastIndexOf(".") >= 0) {
			extName = filename.substring(filename.lastIndexOf("."));
		}
		newFilename = nowTimeStr + rannum + extName;
		PrintWriter writer = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			writer = response.getWriter();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		try {
			is = request.getInputStream();
			File file = new File(savePath + newFilename);
			fos = new FileOutputStream(file);
			IOUtils.copy(is, fos);
			response.setStatus(HttpServletResponse.SC_OK);
			writer.print("{success:'" + fileDir + newFilename + "'}");
		} catch (FileNotFoundException ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writer.print("{'success': false}");
		} catch (IOException ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writer.print("{'success': false}");
		} finally {
			try {
				fos.close();
				is.close();
			} catch (IOException ignored) {

			}
		}
		writer.flush();
		writer.close();
		return null;
	}
}
