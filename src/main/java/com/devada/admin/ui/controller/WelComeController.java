package com.devada.admin.ui.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.devada.EmailServiceImpl;
import com.devada.admin.api.entity.DBFile;
import com.devada.admin.api.entity.MainCategory;
import com.devada.admin.api.entity.PersonInformation;
import com.devada.admin.api.entity.SubCategory;
import com.devada.admin.api.repository.AdminRepository;
import com.devada.admin.ui.dto.LoginUiDto;
import com.google.gson.Gson;

@Controller
public class WelComeController {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private EmailServiceImpl emailServiceImpl;

	@RequestMapping("/")
	public ModelAndView welcomePage() {
		ModelAndView modelAndView = new ModelAndView();
		List<DBFile> dbFileList;
		try {
			dbFileList = adminRepository.getDBFileList();
			for (DBFile db : dbFileList) {
				String str = Base64.encodeBase64String(db.getData());
				db.setImageInStr(str);
			}
			List<SubCategory> subCategoryList = adminRepository.getSubCategoryList();
			List<MainCategory> mainCategoryList = adminRepository.getMainCategoryList();
			modelAndView.addObject("mainCategoryList", mainCategoryList);
			modelAndView.addObject("subCategoryList", subCategoryList);
			modelAndView.addObject("dbFileList", dbFileList);
			modelAndView.setViewName("jsp/frontend/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/registration")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("jsp/registration");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("jsp/admin/login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("/forgotpassword")
	public ModelAndView forgotpassword(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("jsp/admin/forgotpassword");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/resetpassword")
	public ModelAndView resetpassword(@RequestBody LoginUiDto loginUiDto, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			PersonInformation pInf = adminRepository.findEmailId(loginUiDto.getEmailid());
			if (null != pInf && null != pInf.getEmail() && !"".equals(pInf.getEmail())) {
				emailServiceImpl.sendSimpleMessage(pInf.getEmail(), "password retrive", "" + pInf.getPassword());
			}
			modelAndView.setViewName("jsp/admin/forgotpassword");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/marrigereg")
	public ModelAndView marrigeregistration() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("jsp/marrigereg");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/changePassword")
	public ModelAndView changePasswordScreen(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("jsp/admin/changepassword");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/changPwd")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody String changePassword(@RequestBody LoginUiDto loginUiDto, HttpSession httpSession) {
		PersonInformation pInf = null;
		String returnStr = "";
		try {
			String emailId = (String) httpSession.getAttribute("loginUsrEmailId");
			if (null != emailId && !"".equals(emailId)) {
				pInf = adminRepository.findEmailId(emailId);
				if (null != pInf && !"".equals(loginUiDto.getPassword())
						&& loginUiDto.getPassword().equals(pInf.getPassword())) {
					pInf.setPassword(loginUiDto.getNewPassword());
					adminRepository.updatePasword(pInf);
					returnStr = pInf.getRole();
				} else {
					returnStr = "error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Gson().toJson(returnStr);
	}

}
